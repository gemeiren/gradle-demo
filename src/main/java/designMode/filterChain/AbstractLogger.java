package designMode.filterChain;


/**
 * @Description : http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 * @Date: 2018年6月1日 上午12:27:59
 */
public abstract class AbstractLogger {
	public static int INFO = 1;
	   public static int DEBUG = 2;
	   public static int ERROR = 3;
//info:1 debug:2 error:3
	   protected int level;

	   //责任链中的下一个元素
	   protected AbstractLogger nextLogger;

	   public void setNextLogger(AbstractLogger nextLogger){
	      this.nextLogger = nextLogger;
	   }

	   public void logMessage(int level, String message){
		   System.out.println("out this.level = " + this.level);
		   if(this.level <= level){
	    	  System.out.println("in this.level = " + this.level);
	    	  write(message);
	      }
	      if(nextLogger !=null){
	    	  System.out.println("------nextLogger !=null");
	         nextLogger.logMessage(level, message);
	      }
	   }

	   abstract protected void write(String message);
}
