package javaBase.thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** 
 * @Description: http://blog.csdn.net/jackyechina/article/details/52931453
 * @date 2017年1月6日  上午11:38:32
 */
public class SemaphoreCase {
	
	/*Semaphore可以用于做流量控制，特别公用资源有限的应用场景，比如数据库连接。
	假如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，我们可以启动几十个线程并发的读取，
	但是如果读到内存后，还需要存储到数据库中，而数据库的连接数只有10个，
	这时我们必须控制只有十个线程同时获取数据库连接保存数据，否则会报错无法获取数据库连接。*/
	
    private static final int THREAD_COUNT = 30;  
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);  
    private static Semaphore s = new Semaphore(10);  //信号量
    public static void main(String[] args) {  
        for (int i = 0; i < THREAD_COUNT; i++) {  
            final int NO = i;
            threadPool.execute(new Runnable() {  
                @Override  
                public void run() {  
                    try {  
                        s.acquire();  //获取一个资源，semaphore.acquire(n)，获取n个资源,
                        			  //当达到semaphore 指定资源数量时就不能再访问线程处于阻塞
                        System.out.println("save data : " + NO);  
                        Thread.sleep(2000L);
                        s.release(); //每次释放一个资源，semaphore.relase(n)每次资源n个资源
                    } catch (InterruptedException e) {  
                    }  
                }  
            });  
        }  
        threadPool.shutdown();  
    }  
}
