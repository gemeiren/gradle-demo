package javaBase.util.collection.迭代器模式;

/**
 * @Description : http://www.cnblogs.com/ysw-go/p/5384516.html
 * @Date: 2017年8月6日 下午6:07:39
 */
//(3)容器角色(Aggregate):  一般是一个接口，提供一个iterator()方法，例如java中的Collection接口，List接口，Set接口等
public interface List {
	public void add(Object obj);
	public void del(int index);
    public Object get(int index);
    public Iterator iterator();  
    public int getSize();
}
