package javaBase.reflect.GetTheParentClassAndAllAccesses;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 获取一个对象的父类与实现的接口
 * @Date: 2017年3月20日 下午11:27:25
 */
public class Test {

	public static void main(String[] args) throws ClassNotFoundException{
		Class<?> target=Class.forName("javaBase.reflect.GetTheParentClassAndAllAccesses.Dog");
		//获取Dog类的父类
		Class<?> parent=target.getSuperclass();
		//获取该类继承的所有类
		Class<?> intefaces[]=target.getInterfaces();
		System.out.println("Dog 父类 ： "+parent);
		System.out.println("....................................");
		System.out.println("接口：");
		for (int i = 0; i < intefaces.length; i++) {
			System.out.println(i+"@:@"+intefaces[i]);
		}
	}
}
