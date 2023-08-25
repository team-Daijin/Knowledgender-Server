package com.stac.daijin.domain.chat.presentation;

import com.stac.daijin.domain.chat.presentation.dto.request.CreateRoomRequest;
import com.stac.daijin.domain.chat.service.CreateRoomService;
import com.stac.daijin.global.annotation.AuthRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    private final CreateRoomService createRoomService;

    @PostMapping("/")
    @AuthRequired
    public void createRoomService(
            @RequestAttribute String user
    ) {
        createRoomService.createRoom(user);
    }
}
