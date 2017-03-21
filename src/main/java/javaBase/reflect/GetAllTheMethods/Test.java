package javaBase.reflect.GetAllTheMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 获取某个类的全部方法
 * @Date: 2017年3月20日 下午11:29:37
 */
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
		Class<?> clazz=Class.forName("javaBase.reflect.GetTheParentClassAndAllAccesses.Dog");
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		//java 反射机制 -   调用method方法
		Method method = clazz.getMethod("fuck",String.class);
		method.invoke(clazz.newInstance(),"zxh");
		
	}
}
