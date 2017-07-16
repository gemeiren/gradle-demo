package javaBase.util.泛型编程;

/**
 * @Description : http://www.cnblogs.com/iyangyuan/archive/2013/04/09/3011274.html
 * @Date: 2017年7月16日 下午12:08:00
 */
public class GenericTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Generic generic = new Generic();		
		//���÷��ͷ���
		Object obj = generic.getObject(Class.forName("javaBase.util.泛型编程.User"));
		//�ж�obj�������Ƿ���ָ����User����
		System.out.println(obj instanceof User);
	}
}
