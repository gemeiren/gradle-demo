package javaBase.util.collection.迭代器模式;

/**
 * @Description : http://www.cnblogs.com/ysw-go/p/5384516.html
 * @Date: 2017年8月6日 下午6:07:39
 */
//(4)具体容器角色（ConcreteAggregate）：
//就是抽象容器的具体实现类，比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList，Set接口的哈希列表的实现HashSet等。
public class ConcreteAggregate implements List{

    private Object[] list;
    private int size=0;
    private int index=0;
    public ConcreteAggregate(){
        index=0;
        size=0;
        list=new Object[100];
    }
    @Override
    public void add(Object obj) {
        list[index++]=obj;
        size++;
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this); 				//attend
    }
    @Override
    public Object get(int index) {
        return list[index];
    }
    @Override
    public void del(int index) {
    	if (index > getSize()) {
			return;
		}
    	
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(list, index+1, list, index, numMoved);
    	
		//清空删除后最后一位
		list[--size] = null; // clear to let GC do its work
    }
    
    @Override
    public int getSize() {
        return size;
    }

}
