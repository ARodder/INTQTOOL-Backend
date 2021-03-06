package dev.roder.intqtoolbackend.Services;

import dev.roder.intqtoolbackend.Entities.Notification;
import dev.roder.intqtoolbackend.MessageWrapper.MessageContent;
import dev.roder.intqtoolbackend.Repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

/**
 * Service class containing most of the functionality
 * for any connection over websockets
 */
@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserService userservice;

    /**
     * Sends message to specified subscription path
     *
     * @param message message to send to the socket subscribers
     * @param socketPath path of the socket.
     */
    public void updateWebSocketSubscribers(String message,String socketPath){
        MessageContent content = new MessageContent();
        content.setContent(message);
        template.convertAndSend(socketPath,content);
    }

    /**
     * Retrieves the notifications of the current user.
     *
     * @return list of notifications for the user.
     */
    public List<Notification> getUserNotification() {

        return notificationRepository.findNotificationsByUserId(userservice.getCurrentUser().getId());
    }

}
