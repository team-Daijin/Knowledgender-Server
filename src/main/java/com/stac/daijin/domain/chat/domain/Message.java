package com.stac.daijin.domain.chat.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Builder
public class Message {
    @Id
    private String id;

    private String roomId;

    private String accountId;

    private String message;

    @CreatedDate
    private LocalDateTime sentAt;
}
