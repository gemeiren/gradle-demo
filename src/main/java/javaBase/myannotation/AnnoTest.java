package javaBase.myannotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**  
 * ClassName: AnnoTest https://www.cnblogs.com/bingoidea/archive/2011/03/31/2000726.html
 * date: 2018年1月23日 上午10:52:19 <br/>  
 *  总结：
	1、Target 指定的注解类型
	2、Retention java编译器处理注释的注释类型方式相关，告诉编译器在处理自定义注释类型的几种不同的选择
	3、Documented：是一个标记注释，表示注释应该出现在类的javadoc中，因为在默认情况下注释时不包括在javadoc中的。
	
	注意事项： 
     1.所有的Annotation自动继承java.lang.annotation接口 
     2.自定义注释的成员变量访问类型只能是public、default；(所有的都能访问，源作者没用到函数：getDeclaredFields而已) 
     3.成员变量的只能使用基本类型（byte、short、int、char、long、double、float、boolean和String、Enum、Class、annotations以及该类型的数据）(没有限制，大家可以修改测试一下，就清楚) 
     4.如果只有一个成员变量，最好将参数名称设为value，赋值时不用制定名称而直接赋值 
     5.在实际应用中，还可以使用注释读取和设置Bean中的变量。 
 */
public class AnnoTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// 要使用到反射中的相关内容
		Class c = Class.forName("javaBase.myannotation.Anno");
		Method[] method = c.getMethods();
		boolean flag = c.isAnnotationPresent(FirstAnno.class);
		if (flag) {
			FirstAnno first = (FirstAnno) c.getAnnotation(FirstAnno.class);
			System.out.println("First Annotation:" + first.value() + "\n");
		}

		List<Method> list = new ArrayList<Method>();
		for (int i = 0; i < method.length; i++) {
			list.add(method[i]);
		}

		for (Method m : list) {
			SecondAnnotation anno = m.getAnnotation(SecondAnnotation.class);
			if (anno == null)
				continue;

			System.out.println("second annotation's\nname:\t" + anno.name() + "\nurl:\t" + anno.url());
		}

		List<Field> fieldList = new ArrayList<Field>();
		for (Field f : c.getDeclaredFields()) {// 访问所有字段
			Kitto k = f.getAnnotation(Kitto.class);
			System.out.println("----kitto anno: " + k.value());
		}
	}
	
}
