package com.stac.daijin.domain.chat.presentation.dto.response;

import com.stac.daijin.domain.chat.Message;
import lombok.Builder;
import lombok.Getter;
import org.joda.time.LocalDateTime;

@Getter
@Builder
public class MessageResponse {
    private final String message;
    private final String username;
    private final String sentAt;
    private final String roomId;

    public static MessageResponse of(Message message, String roomId) {
        return MessageResponse.builder()
                .message(message.getMessage())
                .sentAt(new LocalDateTime().toString())
                .roomId(roomId)
                .build();
    }
}
