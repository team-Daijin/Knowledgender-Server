package com.stac.daijin.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.stac.daijin.domain.chat.Message;
import com.stac.daijin.domain.chat.Room;
import com.stac.daijin.domain.chat.facade.RoomFacade;
import com.stac.daijin.domain.chat.presentation.dto.request.MessageRequest;
import com.stac.daijin.domain.chat.presentation.dto.response.MessageResponse;
import com.stac.daijin.domain.chat.repository.MessageRepository;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import com.stac.daijin.global.socket.config.property.SocketEventProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SendMessageService {
    private final SocketIOServer socketIOServer;
    private final MessageRepository messageRepository;
    private final RoomFacade roomFacade;
    private final UserFacade userFacade;

    @Transactional
    public void sendMessage(MessageRequest request, SocketIOClient client) {
        User user = userFacade.findUserByClient(client);
        Room room = roomFacade.getRoomByRoomId(request.getRoomId());
        Message message = messageRepository.save(
                Message.builder()
                        .message(request.getMessage())
                        .roomId(request.getRoomId())
                        .accountId(user.getAccountId())
                        .build()
        );
        socketIOServer.getRoomOperations(request.getRoomId())
                .sendEvent(SocketEventProperty.MESSAGE_KEY, MessageResponse.of(message, room.getId()));
    }

}
