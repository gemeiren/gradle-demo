package javaBase.spi;


import java.util.ServiceLoader;


/**  
 * java中的spi
 * https://www.cnblogs.com/huzi007/p/6679215.html
 * http://www.cnblogs.com/zhongkaiuu/articles/5040971.html
 * 
 * ClassName: TestSpi <br/>  
 * date: 2018年2月5日 上午11:24:41 <br/>  
 * @since JDK 1.7  
 */
public class TestSpi {
	
	public static void main(String[] args) {
		
		System.out.println("---- + ");
		System.out.println("aaa : " + TestSpi.class.getResource("")); 
		//获取当前运行的路径   存放  META-INF/services/javaBase.spi.DogService文件
		//bbb : file:/D:/Developer/CODE/github_own/20170227/gradle-demo/bin/META-INF/services/javaBase.spi.DogService 
		//内容：javaBase.spi.impl.BlackDogServiceImpl
		//javaBase.spi.impl.WhilteDogServiceImpl
		System.out.println("bbb : " + Thread.currentThread().getContextClassLoader().getResource(""));
		
		
		ServiceLoader<DogService> loaders = ServiceLoader.load(DogService.class);
		for (DogService d : loaders) {
			d.sleep();
		}
		
		System.out.println("===");
	}
	/**
---- + 
aaa : file:/D:/Developer/CODE/github_own/20170227/gradle-demo/bin/javaBase/spi/
bbb : file:/D:/Developer/CODE/github_own/20170227/gradle-demo/bin/
黑色dog。。。呼呼大睡觉...
白色dog。。。呼呼大睡觉...
===
	 */
	
	
}

