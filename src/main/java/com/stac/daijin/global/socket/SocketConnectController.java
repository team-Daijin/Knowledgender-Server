package com.stac.daijin.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.stac.daijin.global.jwt.JwtExtract;
import com.stac.daijin.global.jwt.JwtProvider;
import com.stac.daijin.global.socket.config.property.SocketStoreKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocketConnectController {

    private final JwtProvider jwtProvider;
    private final JwtExtract jwtExtract;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String bearerToken = client.getHandshakeData().getHttpHeaders().get("Authorization");
        String token = jwtExtract.execute(bearerToken);
        client.set(SocketStoreKey.USER_KEY, jwtProvider.validateToken(token).getAccountId());
    }

}
