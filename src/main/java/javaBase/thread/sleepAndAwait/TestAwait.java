package javaBase.thread.sleepAndAwait;
/** 
 * @Description: http://www.cnblogs.com/hongten/p/hongten_java_sleep_wait.html
 * Java线程的5种状态及切换(透彻讲解)  http://blog.csdn.net/hangelsing/article/details/44037675
 * @date 2017年1月6日  下午2:51:40
 */
public class TestAwait {
	
	public static void main(String[] args) {
		
		//java中的sleep()和wait()的区别
		for (int i = 0; i < 5000; i++) {//启动几十w以上线程会 内存溢出
			new Thread(new Thread1()).start();
		}
		try {
			System.out.println("in sleep 10000...");
			//Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TestSleep.class.wait();");
	}

	private static class Thread1 implements Runnable {
		@Override
		public void run() {
			synchronized (TestAwait.class) {
				System.out.println("enter thread1...");
				System.out.println("thread1 is waiting...");
				try {
					// 调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池	
					TestAwait.class.wait();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("thread1 is going on ....");
				System.out.println("thread1 is over!!!");
			}
		}
	}

}
