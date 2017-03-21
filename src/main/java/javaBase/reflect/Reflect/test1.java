package javaBase.reflect.Reflect;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 通过一个对象获得完整的包名和类名
 * @Date: 2017年3月20日 下午11:47:06
 */
public class test1 {

	public static void main(String[] args){
		test1 test1=new test1();
		System.out.println(test1.getClass().getName());
	}
}
