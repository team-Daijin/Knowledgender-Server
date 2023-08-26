package com.stac.daijin.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.stac.daijin.domain.chat.presentation.dto.request.MessageRequest;
import com.stac.daijin.domain.chat.service.SendMessageService;
import com.stac.daijin.global.socket.config.property.SocketEventProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/{roomId}")
@RequiredArgsConstructor
public class ChatController {
    private final SendMessageService sendMessageService;

    @OnEvent(SocketEventProperty.MESSAGE_KEY)
    public void sendMessage(
            SocketIOClient client,
            MessageRequest request,
            @RequestAttribute String user
    ) {
        sendMessageService.sendMessage(request, user);
    }
}
