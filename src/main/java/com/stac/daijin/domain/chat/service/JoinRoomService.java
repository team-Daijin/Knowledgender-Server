package com.stac.daijin.domain.chat.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.stac.daijin.domain.chat.Room;
import com.stac.daijin.domain.chat.facade.RoomFacade;
import com.stac.daijin.domain.chat.presentation.dto.request.JoinRoomRequest;
import com.stac.daijin.domain.chat.presentation.dto.request.MessageRequest;
import com.stac.daijin.domain.user.User;
import com.stac.daijin.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class JoinRoomService {
    private final RoomFacade roomFacade;
    private final UserFacade userFacade;
    private final SendMessageService sendMessageService;

    @Transactional
    public void execute(
            SocketIOClient client,
            JoinRoomRequest request
    ) {
        Room room = roomFacade.getRoomByRoomId(request.getId());
        User user = userFacade.findUserByClient(client);

        client.joinRoom(String.valueOf(room.getId()));
        sendMessageService.sendMessage(new MessageRequest(
                user.getAccountId() + " 님이 참가했습니다.", String.valueOf(room.getId())
                ),
                user.getAccountId()
        );

        room.addParticipants(user.getAccountId());
    }

}
