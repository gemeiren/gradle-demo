package javaBase.thread.CountDownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: http://www.bubuko.com/infodetail-834365.html 
 * @date 2017年1月6日  上午10:56:48
 */
public class TestLatch {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		CountDownLatch latch = new CountDownLatch(3);//是减计数方式，计数==0时释放所有等待的线程、线程数量一定要对的上，否则会阻塞

		Work w1 = new Work(latch, "张三");//线程1
		Work w2 = new Work(latch, "李四");//线程2
		Work w3 = new Work(latch, "王二");//线程3

		Boss boss = new Boss(latch);//await

		executor.execute(w3);
		executor.execute(w2);
		executor.execute(w1);
		executor.execute(boss);

		executor.shutdown();
	}

}