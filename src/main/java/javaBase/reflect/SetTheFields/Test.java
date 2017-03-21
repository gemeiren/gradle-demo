package javaBase.reflect.SetTheFields;

import java.lang.reflect.Field;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 设置字段
 * @Date: 2017年3月20日 下午11:32:07
 */
public class Test {

	//userl类有个userCode字段，private 但是没有set方法，我们如何通过反射来操作这个字段呢
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException{
		Class<?> clazz = Class.forName("javaBase.reflect.SetTheFields.Tuser");
		Object object = clazz.newInstance();
		//通过反射机制操作某个类的属性  可以直接对 private 的属性赋值
		Field field = clazz.getDeclaredField("userCode");
		field.setAccessible(true);
		field.set(object, "21131084");
		System.out.println(field.get(object));
		Tuser user = (Tuser) object;
		System.out.println(user.getUserCode());
	}
}
