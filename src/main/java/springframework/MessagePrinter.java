package springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/** 
* url : http://projects.spring.io/spring-framework/#quick-start
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date : 2017年3月12日 上午12:28:48 
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