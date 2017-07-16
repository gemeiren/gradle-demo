package javaBase.util.泛型编程;

/**
 * @Description : http://www.cnblogs.com/iyangyuan/archive/2013/04/09/3011274.html
 * @Date: 2017年7月16日 下午12:08:00
 */
public class Generic {
	/**
	 * ���ͷ���
	 * @param <T> ����һ������T
	 * @param c �����������Ͷ���
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException{
		//�������Ͷ���
		T t = c.newInstance();
		return t;
	}
}
