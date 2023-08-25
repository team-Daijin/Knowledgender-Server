package com.stac.daijin.global.socket;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocketClose implements ApplicationListener<ContextClosedEvent> {
    private final SocketIOServer socketIOServer;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        socketIOServer.stop();
    }
}
