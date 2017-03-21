package javaBase.reflect.arrayListReflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 * 4反射机制的应用实例
 * 在泛型为Integer的ArrayList中存放一个String类型的对象。
 * @Description : 
 * @Date: 2017年3月21日 下午12:51:24
 */ 

public class TestReflect {
	 public static void main(String[] args) throws Exception {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        Method method = list.getClass().getMethod("add", Object.class);
	        method.invoke(list, "Java反射机制实例。");
	        System.out.println(list.get(0));
	    }
}
