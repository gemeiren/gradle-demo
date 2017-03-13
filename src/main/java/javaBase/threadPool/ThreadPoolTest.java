package javaBase.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: http://cuisuqiang.iteye.com/blog/2019372
 * @date 2016年11月30日 上午10:36:55
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		//newCachedThreadPoolTest();
		//newCachedThreadPool();
		//newFixedThreadPool();
		//newScheduledThreadPoolV1();
		//newScheduledThreadPoolV2();
		//newSingleThreadExecutor();
	}
	
	public static void newCachedThreadPoolTest() {
		ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						while (true) {
							System.out.println(index);
							Thread.sleep(10 * 1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void printMsg() {
	      Thread t = Thread.currentThread();
	      String name = t.getName();
	      System.out.println("name=" + name);
	   } 
	
	//创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
	public static void newSingleThreadExecutor() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		printMsg();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						printMsg();
						System.out.println("单线程化的线程池执行:" + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	//表示延迟1秒后每3秒执行一次。
	public static void newScheduledThreadPoolV2() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		printMsg();
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				printMsg();
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);

	}

	//newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。  表示延迟3秒执行。
	public static void newScheduledThreadPoolV1() {
		printMsg();
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				printMsg();
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);

	}

	//newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
	public static void newFixedThreadPool() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		printMsg();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						printMsg();
						System.out.println("定长线程池 执行: "+ index);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	//newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	public static void newCachedThreadPool() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		printMsg();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					printMsg();
					System.out.println("可缓存线程池执行 : " + index);
				}
			});
		}
	}
}
