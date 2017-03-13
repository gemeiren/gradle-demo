package javaBase.thread.Lockers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: http://blog.csdn.net/vking_wang/article/details/9952063		4、线程间通信Condition
 * @date 2017年1月6日 下午6:11:39
 */
public class BoundedBuffer {
	/*final Lock lock = new ReentrantLock(); // 锁对象
	final Condition notFull = lock.newCondition(); // 写线程锁
	final Condition notEmpty = lock.newCondition(); // 读线程锁

	final Object[] items = new Object[100];// 缓存队列
	int putptr; // 写索引
	int takeptr; // 读索引
	int count; // 队列中数据数目

	// 写
	public void put(Object x) throws InterruptedException {
		lock.lock(); // 锁定
		try {
			// 如果队列满，则阻塞<写线程>
			while (count == items.length) {
				notFull.await();
			}
			// 写入队列，并更新写索引
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;

			// 唤醒<读线程>
			notEmpty.signal();
		} finally {
			lock.unlock();// 解除锁定
		}
	}

	// 读
	public Object take() throws InterruptedException {
		lock.lock(); // 锁定
		try {
			// 如果队列空，则阻塞<读线程>
			while (count == 0) {
				notEmpty.await();
			}

			// 读取队列，并更新读索引
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;

			// 唤醒<写线程>
			notFull.signal();
			return x;
		} finally {
			lock.unlock();// 解除锁定
		}
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		
		BoundedBuffer2 bb = new BoundedBuffer2();
		BoundedBuffer2 bb2 = new BoundedBuffer2();
		
		for (int i = 0; i < 156; i++) {
			bb.put(i);
		}
		
		//Thread.sleep(3000L);
		bb2.take();
		
	}
}


class BoundedBuffer2 {
	final Lock lock = new ReentrantLock(); // 锁对象
	final Condition notFull = lock.newCondition(); // 写线程锁
	final Condition notEmpty = lock.newCondition(); // 读线程锁

	final Object[] items = new Object[100];// 缓存队列
	int putptr; // 写索引
	int takeptr; // 读索引
	int count; // 队列中数据数目

	// 写
	public void put(Object x) throws InterruptedException {
		lock.lock(); // 锁定
		try {
			// 如果队列满，则阻塞<写线程>
			while (count == items.length) {
				System.out.println("notFull.await() ... ");
				notFull.await();
			}
			// 写入队列，并更新写索引
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			System.out.println("put ... " + x);
			// 唤醒<读线程>
			notEmpty.signal();
		} finally {
			lock.unlock();// 解除锁定
		}
	}

	// 读
	public Object take() throws InterruptedException {
		lock.lock(); // 锁定
		try {
			// 如果队列空，则阻塞<读线程>
			while (count == 0) {
				System.out.println("notEmpty.await() ...");
				notEmpty.await();
			}

			// 读取队列，并更新读索引
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;

			System.out.println("take ..." + x);
			// 唤醒<写线程>
			notFull.signal();
			return x;
		} finally {
			lock.unlock();// 解除锁定
		}
	}
}