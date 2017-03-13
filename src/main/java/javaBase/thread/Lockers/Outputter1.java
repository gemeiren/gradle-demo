package javaBase.thread.Lockers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @Description: http://blog.csdn.net/vking_wang/article/details/9952063    2、ReentrantLock
 * @date 2017年1月6日  下午5:29:44
 */
public class Outputter1 {    
    private Lock lock = new ReentrantLock();// 锁对象    
  
    public void output(String name) {           
        lock.lock();      // 得到锁    
  
        try {    
            for(int i = 0; i < name.length(); i++) {    
                System.out.print(name.charAt(i));    
            }    
        } finally {    
            lock.unlock();// 释放锁    
        }    
    }   
    
    public static void main(String[] args) {
    	Outputter2 a = new Outputter2();
    	a.output("256456");
	}
    
    
}  

class Outputter2 {    
    private Lock lock = new ReentrantLock();// 锁对象    
  
    public void output(String name) {           
        lock.lock();      // 得到锁    
  
        try {    
            for(int i = 0; i < name.length(); i++) {    
                System.out.print(name.charAt(i));    
            }    
        } finally {    
            lock.unlock();// 释放锁    
        }    
    }   
    
}  
