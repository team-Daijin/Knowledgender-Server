package com.stac.daijin.domain.chat.facade;

import com.stac.daijin.domain.chat.Room;
import com.stac.daijin.domain.chat.exception.RoomNotFoundException;
import com.stac.daijin.domain.chat.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomRepository roomRepository;

    public Room getRoomByRoomId(String roomId) {
        return roomRepository.findRoomById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }
}
