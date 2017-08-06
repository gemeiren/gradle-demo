package javaBase.design.迭代器模式;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description : 23种设计模式（13）：迭代器模式
 * http://blog.csdn.net/zhengzhb/article/details/7610745
 * @Date: 2017年7月28日 下午3:10:32
 */
public class ConcreteIterator implements Iterator{  
    private List list = new ArrayList();  
    private int cursor =0;  
    public ConcreteIterator(List list){  
        this.list = list;  
    }  
    public boolean hasNext() {  
        if(cursor==list.size()){  
            return false;  
        }  
        return true;  
    }  
    public Object next() {  
        Object obj = null;  
        if(this.hasNext()){  
            obj = this.list.get(cursor++);  
        }  
        return obj;  
    }  
}  
