package javaBase.reflect.Reflect;

/**
 * @Description : 实例化 class 对象
 * @Date: 2017年3月20日 下午11:53:37
 */
public class GetRealClass {

	public static void main(String[] args) throws ClassNotFoundException{
		Class<?> first=null;
		Class<?> second=null;
		Class<?> third=null;
		//一般采用这种形式
		first=Class.forName("javaBase.reflect.Reflect.GetRealClass");//第一种[绝对路径]
		second=new GetRealClass().getClass();//第二种
		third=GetRealClass.class;//第三种
		
		System.out.println("first Class : " +first);
		System.out.println("second Class : " + second);
		System.out.println("third Class : " + third);
	}
}
