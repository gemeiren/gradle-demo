package springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
/** 
* url : http://projects.spring.io/spring-framework/#quick-start
* @Description: TODO(这里用一句话描述这个类的作用) 
* @date : 2017年3月12日 上午12:28:48 
*/
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
