package pen.test.AlternatelyPrintParity;


/**
 * @Description : 两线程交替打印数字
 * https://blog.csdn.net/kiss_the_sun/article/details/49637935
 * @Date: 2018年8月5日 下午5:45:40
 */
public class ThreadTest {
	private static Object LOCK = new Object();
    private static int i=1;
    
    private static int aaa = 1;

    public static void main(String[] args) {
    	
    	/*
    	 * https://blog.csdn.net/xxxcyzyy/article/details/77018646
    	 * 10072---多线程交替打印奇偶数
    	 * 
    	 * Thread aa = new Thread(){
    		public void run() {
    			synchronized (this) {
    				while (aaa <= 10) {
    					if (aaa%2 != 0) {
    						try {
    							//CM.ptl(i);
    							System.out.println("奇数---" + aaa);
    							aaa++;
    							notify();
    							wait();
    						} catch (InterruptedException e) {
    							e.printStackTrace();
    						}
    					} else {
    						try {
    							//CM.ptl(i);
    							System.out.println("偶数---" + aaa);
    							aaa++;
    							notify();
    							wait();
    						} catch (InterruptedException e) {
    							e.printStackTrace();
    						}
    					}
    				}
    				notify();
    			}}

    	};*/
    	
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
