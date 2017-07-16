package javaBase.util.泛型编程.Java泛型通配符extends与super;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description : http://sharewind.iteye.com/blog/1622164
 * @Date: 2017年7月16日 下午12:26:22
 */
public class Java泛型Test {
	public static void main(String[] args) {
		System.out.println("in...");
		
		extendTest();
		superTest();
		//小结
		//extends 可用于的返回类型限定，不能用于参数类型限定。
		//super 可用于参数类型限定，不能用于返回类型限定。
		//带有super超类型限定的通配符可以向泛型对易用写入，带有extends子类型限定的通配符可以向泛型对象读取。——《Core Java》
		
	}

	private static void superTest() {
		List<? super Fruit> flist = new ArrayList<Fruit>();
		flist.add(new Fruit());
		flist.add(new Apple());
		flist.add(new RedApple());

		// compile error:
		//List<? super Fruit> flist = new ArrayList<Apple>();
		
		// compile error:
		//Fruit item = flist.get(0);
	}
	
	private static void extendTest() {
		List<? extends Fruit> flist = new ArrayList<Apple>();
		// complie error:
		// flist.add(new Apple());
		// flist.add(new Fruit());
		// flist.add(new Object());
		flist.add(null); // only work for null 
		
		Fruit fruit = flist.get(0);
		Apple apple = (Apple)flist.get(0);
		
		flist.contains(new Fruit());
		flist.contains(new Apple());
	}
	
	
	
	static class Food{}
	static class Fruit extends Food{}
	static class Apple extends Fruit{}
	static class RedApple extends Apple{}
}




