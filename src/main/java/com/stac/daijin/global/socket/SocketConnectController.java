package com.stac.daijin.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.stac.daijin.global.security.jwt.JwtExtract;
import com.stac.daijin.global.security.jwt.JwtProvider;
import com.stac.daijin.global.socket.constants.SocketStoreKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocketConnectController {

    private final JwtProvider jwtProvider;
    private final JwtExtract jwtExtract;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String bearerToken = client.getHandshakeData().getSingleUrlParam("authorization");
        String token = jwtExtract.execute(bearerToken);
        client.set(SocketStoreKey.USER_KEY, jwtProvider.validateToken(token).getAccountId());
    }

}
