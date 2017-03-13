package javaBase.thread.CountDownlatch;


import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: http://www.bubuko.com/infodetail-834365.html
 * @date 2017年1月6日  上午10:55:21
 */
public class Work implements Runnable {

	private CountDownLatch downLatch;
	private String name;

	public Work(CountDownLatch downLatch, String name) {
		this.downLatch = downLatch;
		this.name = name;
	}

	public void run() {
		this.doWork();
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException ie) {
		}
		System.out.println(this.name + "活干完了！");
		this.downLatch.countDown();//countDown方法对计数器做减操作，await方法等待计数器达到0。
									//所有await的线程都会阻塞直到计数器为0或者等待线程中断或者超时。

	}

	private void doWork() {
		System.out.println(this.name + "正在干活!");
	}

}