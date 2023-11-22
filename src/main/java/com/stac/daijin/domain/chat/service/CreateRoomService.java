package com.stac.daijin.domain.chat.service;

import com.stac.daijin.domain.chat.domain.Room;
import com.stac.daijin.domain.chat.domain.repository.RoomRepository;
import com.stac.daijin.domain.user.domain.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CreateRoomService {
    private final RoomRepository roomRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createRoom(){
        User user = userFacade.getCurrentUser();
        Room room = Room.builder().name("").participants(new ArrayList<>()).build();
        room.addParticipants(user.getAccountId());
        roomRepository.save(room);
    }
}
