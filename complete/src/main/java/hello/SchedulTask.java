package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.message.DateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by tettoc on 08/07/2016.
 */
@Service
public class SchedulTask {

    @Autowired
    private SimpMessagingTemplate template;

    // this will send a message to an endpoint on which a client can subscribe
    @Scheduled(fixedRate = 500)
    public void trigger() {
        // sends the message to /topic/greetings
        ObjectMapper objectMapper = new ObjectMapper();
        DateMessage dateMessage = new DateMessage();
        dateMessage.date = "Date : " + new Date();
        this.template.convertAndSend("/topic/greetings", dateMessage);
        System.out.println("Send");
    }
}
