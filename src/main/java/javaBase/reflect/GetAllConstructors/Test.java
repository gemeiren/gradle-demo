package javaBase.reflect.GetAllConstructors;

import java.lang.reflect.Constructor;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 获取所有构造函数
 * @Date: 2017年3月20日 下午11:30:53
 */
public class Test {

	public static void main(String[] args) throws ClassNotFoundException{
		
		Class<?> controll=Class.forName("javaBase.reflect.GetAllConstructors.Tuser");
		Constructor<?> constructors[] = controll.getConstructors();
		System.out.println(controll.getName()+"的所有构造函数：");
		System.out.println("  ");
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
			//获取构造函数的参数的类型，可以自己构造
		    Class<?> type[] = constructors[i].getParameterTypes();
		    for (int j = 0; j < type.length; j++) {
				System.out.println(type[j].getName());
			}
		}
	}
}
