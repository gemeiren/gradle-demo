package designMode.filterChain;


/**
 * @Description : http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 * @Date: 2018年6月1日 上午12:27:59
 */
public class ChainPatternDemo {
	
	
		private static AbstractLogger getChainOfLoggers(){
			//info:1 debug:2 error:3
	      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
	      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	      errorLogger.setNextLogger(fileLogger);
	      fileLogger.setNextLogger(consoleLogger);

	      return errorLogger;    
	   }

	   public static void main(String[] args) {
		   
	      AbstractLogger loggerChain = getChainOfLoggers();

	      loggerChain.logMessage(AbstractLogger.INFO, 
	         "This is an information.");

	      System.out.println("000------------------------------------------------------------------------------------------");
	      loggerChain.logMessage(AbstractLogger.DEBUG, 
	         "This is an debug level information.");
	      
	      System.out.println("111-------------------------------------------------------------------------------------------");
	      loggerChain.logMessage(AbstractLogger.ERROR, 
	         "This is an error information.");
	   
	   }
}
