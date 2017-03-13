package javaBase.thread.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: http://www.bubuko.com/infodetail-834365.html
 * @date 2017年1月6日  上午11:10:26
 */
public class CycTest {
	public static void main(String[] args) {
		ExecutorService executorpool = Executors.newFixedThreadPool(3);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		//CyclicBarrier是加计数方式，计数达到构造方法中参数指定的值时释放所有等待的线程、未达到则 阻塞
		
		CycWork work1 = new CycWork(cyclicBarrier, "张三");
		CycWork work2 = new CycWork(cyclicBarrier, "李四");
		CycWork work3 = new CycWork(cyclicBarrier, "王五");

		executorpool.execute(work1);
		executorpool.execute(work2);
		executorpool.execute(work3);

		executorpool.shutdown();

	}
}
