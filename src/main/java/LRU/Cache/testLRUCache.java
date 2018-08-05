package LRU.Cache;

import com.alibaba.fastjson.JSON;


/**
 * @Description : 如何设计实现一个LRU Cache？
 * http://yikun.github.io/2015/04/03/%E5%A6%82%E4%BD%95%E8%AE%BE%E8%AE%A1%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AALRU-Cache%EF%BC%9F/
 * @Date: 2018年8月5日 下午4:57:02
 */
public class testLRUCache {
	public static void main(String[] args) {
		System.out.println("-----");
		LRUCache ca = new LRUCache(5);
		
		ca.set(1, 111);
		ca.set(2, 222);
		ca.set(3, 333);
		ca.set(4, 444);
		ca.set(5, 555);
		ca.set(1, 111);
		ca.set(1, 111);
		ca.set(2, 222);
		ca.set(6, 666);
		System.out.println("ca = " + JSON.toJSONString(ca));
		
	}
}
