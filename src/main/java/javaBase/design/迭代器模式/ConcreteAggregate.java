package javaBase.design.迭代器模式;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description : 23种设计模式（13）：迭代器模式
 * http://blog.csdn.net/zhengzhb/article/details/7610745
 * @Date: 2017年7月28日 下午3:10:39
 */
class ConcreteAggregate implements Aggregate {  
    private List list = new ArrayList();  
    public void add(Object obj) {  
        list.add(obj);  
    }  
  
    public Iterator iterator() {  
        return new ConcreteIterator(list);  
    }  
  
    public void remove(Object obj) {  
        list.remove(obj);  
    }  
}
