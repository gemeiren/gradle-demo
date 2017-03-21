package javaBase.reflect.Reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javaBase.reflect.Reflect.test.pojo.Tea_Eng;


/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 
 * @Date: 2017年3月21日 下午12:46:25
 */
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		//获取指定类
		Class<?> clazz=Class.forName("javaBase.reflect.Reflect.test.pojo.Tea_Eng");
		//获取所有的构造函数
		Constructor<?> constructors[] = clazz.getConstructors();
		System.out.println("Tea_Eng下的所有的构造函数：");
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}
		//通过其中一种构造函数来实例化该对象
		Constructor<?> constructor = clazz.getConstructor(String.class);
		Tea_Eng tea = (Tea_Eng)constructor.newInstance("I Can Read Chinese Too");
		//获取父类
		Class<?> superclass = clazz.getSuperclass();
		System.out.println("Tea_Eng的父类是 ："+superclass.getName());
		//获取所有接口
		Class<?> interfaces[]=clazz.getInterfaces();
		System.out.println("Tea_Eng的所有接口：");
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println(interfaces[i].getName());
		}
		//获取所有的属性字段
		Field fields[] = clazz.getDeclaredFields();
		System.out.println("Tea_Eng下的所有属性");
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		//设置 ability字段
		Field field = clazz.getDeclaredField("ability");
		field.setAccessible(true);
		field.set(tea, "I Can Read Frech Too");
		tea.haveAbility();
		//获取所有方法
		Method[] methods = clazz.getMethods();
		System.out.println("Tea_Eng下的方法：");
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}
		//执行writeAuthor方法
		Method method = clazz.getMethod("writeAuthor", String.class);
		method.invoke(tea, "I Can say English ! !");
	}
}
