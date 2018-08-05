package pen.test.AlternatelyPrintParity;


/**
 * @Description : 两线程交替打印数字
 * https://blog.csdn.net/kiss_the_sun/article/details/49637935
 * @Date: 2018年8月5日 下午5:45:40
 */
public class ThreadTest {
	private static Object LOCK = new Object();
    private static int i=1;

    public static void main(String[] args) {
    	Thread aa = new Thread(){
    		
    	};
    	
        Thread thread1 = new Thread() {
                public void run() {
                    while(i<=10) {
                        synchronized (LOCK) {
                            if(i%2==0){
                                System.out.println("Thread1: "+i++);
                            }else{
                                LOCK.notifyAll();
                                 try {
                                        LOCK.wait(1000);
                                      } catch (InterruptedException e) {
                                               e.printStackTrace();
                                      }
                                }
                            }
                    }
                }
        };

        Thread thread2 = new Thread() {
            public void run() {
                while(i<=10) {
                    synchronized (LOCK) {
                        if(i%2 !=0){
                            System.out.println("Thread2: "+i++);
                        }else{
                            LOCK.notifyAll();
                            try {
                                    LOCK.wait(1000);
                                  } catch (InterruptedException e) {
                                           e.printStackTrace();
                                  }
                            }
                        }
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
