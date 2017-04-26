package javaBase.reflect.proxyReflect;

/**
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 * @Description :反射机制的动态代理 
 * @Date: 2017年3月21日 下午1:09:36
 */

/**
 * 在java中有三种类类加载器。
 * 
 * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
 * 
 * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
 * 
 * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
 * 
 * 如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
 * 
 */
public class TestReflect {
	// 获取类加载器的方法
	//TestReflect testReflect = new TestReflect();
	  //      System.out.println("类加载器  " + testReflect.getClass().getClassLoader().getClass().getName());
	
	 public static void main(String[] args) throws Exception {
	       MyInvocationHandler demo = new MyInvocationHandler();
	        Subject sub = (Subject) demo.bind(new RealSubject());
	        String info = sub.say("Rollen", 20);
	        System.out.println(info);
	        System.out.println("奇怪哦。。。上面的动态代理没有实现AOP,下面的这种有");
	        sub.see();
	        
		
	 }
}
