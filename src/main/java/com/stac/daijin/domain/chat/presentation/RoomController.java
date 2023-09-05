package com.stac.daijin.domain.chat.presentation;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.stac.daijin.domain.chat.presentation.dto.request.JoinRoomRequest;
import com.stac.daijin.domain.chat.service.CreateRoomService;
import com.stac.daijin.domain.chat.service.JoinRoomService;
import com.stac.daijin.global.socket.config.property.SocketEventProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    private final CreateRoomService createRoomService;
    private final JoinRoomService joinRoomService;

    @PostMapping("/")
    public void createRoom() {
        createRoomService.createRoom();
    }

    @OnEvent(SocketEventProperty.ROOM_JOIN_KEY)
    public void joinRoom(
            SocketIOClient client,
            @RequestBody JoinRoomRequest request
    ) {
        joinRoomService.execute(client, request);
    }
}
