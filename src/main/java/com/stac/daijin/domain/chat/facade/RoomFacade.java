package com.stac.daijin.domain.chat.facade;

import com.stac.daijin.domain.chat.domain.Room;
import com.stac.daijin.domain.chat.exception.RoomNotFoundException;
import com.stac.daijin.domain.chat.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomRepository roomRepository;

    @Transactional
    public Room getRoomByRoomId(String roomId) {
        return roomRepository.findRoomById(roomId)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }
}
