package com.stac.daijin.thirdparty.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.stac.daijin.thirdparty.s3.config.properties.S3Properties;
import com.stac.daijin.thirdparty.s3.enums.Directory;
import com.stac.daijin.thirdparty.s3.exception.S3FailedFileSaveException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadS3Service {
    private final AmazonS3Client amazonS3Client;
    private final S3Properties s3Properties;

    public String uploadImage(
            MultipartFile image,
            Directory directory
    ) {
        if (image.isEmpty() || image.equals("")) {
            return "";
        }
        String fileName = createFileName(directory, image.getOriginalFilename());
        try {
            PutObjectRequest request = new PutObjectRequest(
                    s3Properties.getBucket(),
                    fileName,
                    image.getInputStream(),
                    getObjectMetadata(image)
            );
            amazonS3Client.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (Exception e) {
            e.printStackTrace();
            throw S3FailedFileSaveException.EXCEPTION;
        }

        return amazonS3Client.getUrl(s3Properties.getBucket(), fileName).toString();
    }

    private String createFileName(Directory directory, String originalName) {
        return directory.name() + "/" + UUID.randomUUID() + "-" + originalName;
    }

    private ObjectMetadata getObjectMetadata(MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        return objectMetadata;
    }
}

