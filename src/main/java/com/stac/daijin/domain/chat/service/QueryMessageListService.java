package com.stac.daijin.domain.chat.service;

import com.stac.daijin.domain.chat.facade.RoomFacade;
import com.stac.daijin.domain.chat.presentation.dto.response.MessageListResponse;
import com.stac.daijin.domain.chat.presentation.dto.response.MessageResponse;
import com.stac.daijin.domain.chat.domain.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMessageListService {

    private final MessageRepository messageRepository;
    private final RoomFacade roomFacade;

    public MessageListResponse execute(
            final String roomId,
            final int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("sentAt"));
        return new MessageListResponse(
                messageRepository.findAllByRoomId(roomFacade.getRoomByRoomId(roomId).getId(), pageable)
                        .stream().map(
                                m -> MessageResponse.of(
                                        m, roomId
                                )
                        ).collect(Collectors.toList())
        );
    }
}
