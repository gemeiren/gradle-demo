package javaBase.reflect.GetAllTheAttributes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 获取某个类的全部属性
 * @Date: 2017年3月20日 下午11:26:47
 */
public class Test {

	public static void main(String[] args) throws ClassNotFoundException{
		Class<?> clazz=Class.forName("javaBase.reflect.GetTheParentClassAndAllAccesses.Dog");
		//获取本地类的属性，父类和接口的没有
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			//获取字段的修饰权限符
			System.out.println(Modifier.toString(fields[i].getModifiers())+" @@@ "+fields[i].getName());
		}
		
		System.out.println("==========实现的接口或者父类的属性==========");  //父类私有的private 子类获取不到、接口属性不可能私有，所以必须能拿到
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        System.out.println("filed1.length: " + filed1.length);
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " - " + type.getName() + " + " + filed1[j].getName() + ";");
        }
	}
}
