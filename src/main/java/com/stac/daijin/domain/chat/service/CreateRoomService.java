package com.stac.daijin.domain.chat.service;

import com.stac.daijin.domain.chat.Room;
import com.stac.daijin.domain.chat.presentation.dto.request.CreateRoomRequest;
import com.stac.daijin.domain.chat.repository.RoomRepository;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CreateRoomService {
    private final RoomRepository roomRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createRoom(
            String accoutId
    ){
        User user = userFacade.getUserByAccountId(accoutId);
        Room room = Room.builder().name("").participants(new ArrayList<>()).build();
        room.addParticipants(user.getAccountId());
        roomRepository.save(room);
    }
}
