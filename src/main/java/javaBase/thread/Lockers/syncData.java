package javaBase.thread.Lockers;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: http://blog.csdn.net/vking_wang/article/details/9952063
 * @date 2017年1月6日 下午5:42:14
 */
public class syncData {
	public static void main(String[] args) {
		 final Data2 data = new Data2();//  1、我们可以用读写锁ReadWriteLock实现
		//final syncData2 data = new syncData2();//2、3、读写锁ReadWriteLock
		// final RwLockData data = new RwLockData();

		// 写入
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.set(new Random().nextInt(30));
					}
				}
			});
			t.setName("Thread-W   " + i);
			t.start();
		}
		// 读取
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						data.get();
					}
				}
			});
			t.setName("Thread-R" + i);
			t.start();
		}
	}
}


class Data2 {        
    private int data;// 共享数据    
    private ReadWriteLock rwl = new ReentrantReadWriteLock();       
    public void set(int data) {    
        rwl.writeLock().lock();// 取到写锁    
        try {    
            System.out.println(Thread.currentThread().getName() + "准备写入数据");    
            try {    
                Thread.sleep(20);    
            } catch (InterruptedException e) {    
                e.printStackTrace();    
            }    
            this.data = data;    
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);    
        } finally {    
            rwl.writeLock().unlock();// 释放写锁    
        }    
    }       
  
    public void get() {    
        rwl.readLock().lock();// 取到读锁    
        try {    
            System.out.println(Thread.currentThread().getName() + "准备读取数据");    
            try {    
                Thread.sleep(20);    
            } catch (InterruptedException e) {    
                e.printStackTrace();    
            }    
            System.out.println(Thread.currentThread().getName() + "读取" + this.data);    
        } finally {    
            rwl.readLock().unlock();// 释放读锁    
        }    
    }    
} 

class syncData2 {
	private int data;// 共享数据

	public synchronized void set(int data) {
		System.out.println(Thread.currentThread().getName() + "准备写入数据");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data = data;
		System.out.println(Thread.currentThread().getName() + "写入" + this.data);
	}

	public synchronized void get() {
		System.out.println(Thread.currentThread().getName() + "准备读取数据");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "读取" + this.data);
	}
}
