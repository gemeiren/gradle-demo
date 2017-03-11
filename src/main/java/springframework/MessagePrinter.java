package springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/** 
* url : http://projects.spring.io/spring-framework/#quick-start
* @Description: TODO(������һ�仰��������������) 
* @date : 2017��3��12�� ����12:28:48 
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