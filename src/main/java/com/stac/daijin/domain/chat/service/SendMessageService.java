package com.stac.daijin.domain.chat.service;

import com.corundumstudio.socketio.SocketIOServer;
import com.stac.daijin.domain.chat.Message;
import com.stac.daijin.domain.chat.Room;
import com.stac.daijin.domain.chat.facade.RoomFacade;
import com.stac.daijin.domain.chat.presentation.dto.request.MessageRequest;
import com.stac.daijin.domain.chat.presentation.dto.response.MessageResponse;
import com.stac.daijin.domain.chat.repository.MessageRepository;
import com.stac.daijin.global.socket.config.property.SocketEventProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SendMessageService {
    private final SocketIOServer socketIOServer;
    private final MessageRepository messageRepository;
    private final RoomFacade roomFacade;

    @Transactional
    public void sendMessage(MessageRequest request, String accountId) {
        Room room = roomFacade.getRoomByRoomId(request.getRoomId());
        Message message = messageRepository.save(
                Message.builder()
                        .message(request.getMessage())
                        .roomId(request.getRoomId())
                        .accountId(accountId)
                        .build()
        );
        socketIOServer.getRoomOperations(request.getRoomId())
                .sendEvent(SocketEventProperty.MESSAGE_KEY, MessageResponse.of(message, room.getId()));
    }

}
