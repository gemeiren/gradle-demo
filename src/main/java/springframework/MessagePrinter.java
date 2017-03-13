package springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/** 
* url : http://projects.spring.io/spring-framework/#quick-start
*/
@Component
public class MessagePrinter {

    final private MessageService service;

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}