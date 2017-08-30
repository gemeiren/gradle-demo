package javaBase.util.collection.迭代器模式;

/**
 * @Description : http://www.cnblogs.com/ysw-go/p/5384516.html
 * @Date: 2017年8月6日 下午6:07:39
 */
//(2)具体迭代器角色（Concrete Iterator）：实现迭代器接口中定义的方法，完成集合的迭代。
public class ConcreteIterator implements Iterator {
    private List list = null;
    private int index;

    public ConcreteIterator(List list) {
        super();
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index >= list.getSize()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object object = list.get(index);
        index++;
        return object;
    }

	@Override
	public void remove(int i) {
		list.del(i);
	}

}
