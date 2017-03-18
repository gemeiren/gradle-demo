package javaBase.threadPool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/** 
 * @Description: http://blog.csdn.net/qinpeng100423/article/details/9307181#
 * @date 2016年12月12日  下午4:34:09
 */
public class SpringThreadPoolTest {
	public static void main(String[] args) {
		testThreadPoolTaskExecutor();
		
	}

	
	public static void testThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();  
		//线程池所使用的缓冲队列  
		poolTaskExecutor.setQueueCapacity(200);  
		//线程池维护线程的最少数量  
		poolTaskExecutor.setCorePoolSize(5);  
		//线程池维护线程的最大数量  
		poolTaskExecutor.setMaxPoolSize(1000);  
		//线程池维护线程所允许的空闲时间  
		poolTaskExecutor.setKeepAliveSeconds(30000);  
		poolTaskExecutor.initialize();  
		
		Thread udpThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("MyThread.run()");  
			}
		});
		Thread udpThread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("MyThread.run()");  
			}
		});
		Thread udpThread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("MyThread.run()");  
			}
		});
		Thread udpThread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("MyThread.run()");  
			}
		});
		Thread udpThread5 = new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("MyThread.run()");  
			}
		});
		poolTaskExecutor.execute(udpThread1);
		poolTaskExecutor.execute(udpThread2);
		poolTaskExecutor.execute(udpThread3);
		poolTaskExecutor.execute(udpThread4);
		poolTaskExecutor.execute(udpThread5);
		poolTaskExecutor.execute(udpThread2);
		//获取当前线程池活动的线程数：
		int count = poolTaskExecutor.getActiveCount();
		//logger.debug("[x] - now threadpool active threads totalNum : " +count);
		System.out.println("[x] - now threadpool active threads totalNum : " +count);
	}
	
}
