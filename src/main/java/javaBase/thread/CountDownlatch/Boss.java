package javaBase.thread.CountDownlatch;

import java.util.concurrent.CountDownLatch;

/** 
 * @Description: http://www.bubuko.com/infodetail-834365.html 
 * @date 2017年1月6日  上午10:56:02
 */
public class Boss implements Runnable {

	private CountDownLatch downLatch;

	public Boss(CountDownLatch downLatch) {
		this.downLatch = downLatch;
	}

	public void run() {
		System.out.println("老板正在等所有的工人干完活......");
		try {
			this.downLatch.await();
			//countDown方法对计数器做减操作，await方法等待计数器达到0。
			//所有await的线程都会阻塞直到计数器为0或者等待线程中断或者超时。
		} catch (InterruptedException e) {
		}
		System.out.println("工人活都干完了，老板开始检查了！");
	}

}