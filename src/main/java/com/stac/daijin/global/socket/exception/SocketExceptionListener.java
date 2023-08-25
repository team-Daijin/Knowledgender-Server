package com.stac.daijin.global.socket.exception;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ExceptionListener;
import com.stac.daijin.global.exception.BusinessException;
import com.stac.daijin.global.exception.response.ExceptionResponse;
import com.stac.daijin.global.socket.config.property.SocketEventProperty;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SocketExceptionListener implements ExceptionListener {
    @Override
    public void onEventException(Exception e, List<Object> args, SocketIOClient client) {
        runExceptionHandling(e, client);
    }

    @Override
    public void onDisconnectException(Exception e, SocketIOClient client) {
        runExceptionHandling(e, client);
    }

    @Override
    public void onConnectException(Exception e, SocketIOClient client) {
        runExceptionHandling(e, client);
        client.disconnect();
    }

    @Override
    public void onPingException(Exception e, SocketIOClient client) {
        runExceptionHandling(e, client);
    }

    @Override
    public boolean exceptionCaught(ChannelHandlerContext ctx, Throwable e) {
        return false;
    }

    private void runExceptionHandling(Exception e, SocketIOClient client) {
        final ExceptionResponse message;

        if (e instanceof BusinessException) {
            BusinessException ex = (BusinessException) e;
            message = new ExceptionResponse(ex.getMessage());
        } else if (e.getCause() instanceof BusinessException) {
            BusinessException ex = (BusinessException) e.getCause();
            message = new ExceptionResponse(ex.getMessage());
        } else {
            e.printStackTrace();
            message = new ExceptionResponse("INTERNAL_SERVER_ERROR");
        }
        client.sendEvent(SocketEventProperty.ERROR_KEY, message);
    }
}
