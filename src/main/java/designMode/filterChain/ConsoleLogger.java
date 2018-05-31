package designMode.filterChain;


/**
 * @Description : http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 * @Date: 2018年6月1日 上午12:27:59
 */
public class ConsoleLogger  extends AbstractLogger {
	  
	public ConsoleLogger(int level){
	      this.level = level;
	   }

	   @Override
	   protected void write(String message) {        
	      System.out.println("Console Console::Logger: " + message);
	   }
}
