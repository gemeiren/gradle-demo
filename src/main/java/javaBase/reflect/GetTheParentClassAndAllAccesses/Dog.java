package javaBase.reflect.GetTheParentClassAndAllAccesses;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 获取父类和所有接口
 * @Date: 2017年3月20日 下午11:27:30
 */
public class Dog extends Annimal implements Behaviour{

	private String dogName;
	
	public void fuck(String name){
		System.out.println("fuck To : " + name);
	}
	@Override
	public void sayHello() {
		System.out.println("Dog sayHello");
	}

	@Override
	public void isAngury() {
		System.out.println("Dog isAngury");
	}

	@Override
	public void love() {
		System.out.println("Dog love");
	}

}
