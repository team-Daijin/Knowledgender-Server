package com.stac.daijin.domain.chat.presentation.dto.response;

import com.stac.daijin.domain.chat.domain.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@Builder @AllArgsConstructor
public class MessageResponse {
    private final String message;
    private final String username;
    private final String sentAt;
    private final String roomId;

    public static MessageResponse of(Message message, String roomId) {
        return MessageResponse.builder()
                .message(message.getMessage())
                .sentAt(message.getSentAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .roomId(roomId)
                .build();
    }
}
