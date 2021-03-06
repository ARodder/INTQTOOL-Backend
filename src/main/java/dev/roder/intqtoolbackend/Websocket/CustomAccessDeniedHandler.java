package dev.roder.intqtoolbackend.Websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    @Qualifier("clientOutboundChannel")
    private MessageChannel clientOutboundChannel;

    /**
     * Sends access denied error to the socket subscriber.
     *
     * @param request socket request.
     * @param response socket response.
     * @param accessDeniedException Exception to send to the socket.
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        Message<String> message = new Message<String>() {
            @Override
            public String getPayload() {
                return "Access denied";
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        };

        clientOutboundChannel.send(message);
    }
}