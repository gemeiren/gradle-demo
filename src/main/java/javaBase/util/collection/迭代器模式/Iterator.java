package javaBase.util.collection.迭代器模式;

/**
 * @Description : http://www.cnblogs.com/ysw-go/p/5384516.html
 * @Date: 2017年8月6日 下午6:07:39
 */

//(1)迭代器角色（Iterator）:定义遍历元素所需要的方法，一般来说会有这么三个方法：
//取得下一个元素的方法next()，判断是否遍历结束的方法hasNext()），移出当前对象的方法remove(),
public interface Iterator {
	public boolean hasNext();
	public Object next();
	public void remove(int index);
}
