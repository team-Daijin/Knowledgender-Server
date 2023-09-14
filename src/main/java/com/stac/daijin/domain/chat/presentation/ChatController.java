package com.stac.daijin.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.stac.daijin.domain.chat.presentation.dto.request.MessageRequest;
import com.stac.daijin.domain.chat.presentation.dto.response.MessageListResponse;
import com.stac.daijin.domain.chat.service.QueryMessageListService;
import com.stac.daijin.domain.chat.service.SendMessageService;
import com.stac.daijin.global.socket.constants.SocketEventProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat/{roomId}")
@RequiredArgsConstructor
public class ChatController {
    private final SendMessageService sendMessageService;
    private final QueryMessageListService queryMessageListService;

    @OnEvent(SocketEventProperty.MESSAGE_KEY)
    public void sendMessage(
            SocketIOClient client,
            MessageRequest request
    ) {
        sendMessageService.sendMessage(request, client);
    }

    @GetMapping
    public MessageListResponse getMessageList(
            @PathVariable String roomId,
            @RequestParam("page") int page
    ) {
        return queryMessageListService.execute(roomId, page);
    }
}
