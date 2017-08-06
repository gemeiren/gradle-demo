package javaBase.design.迭代器模式;


/**
 * @Description : 23种设计模式（13）：迭代器模式
 * http://blog.csdn.net/zhengzhb/article/details/7610745
 * @Date: 2017年7月28日 下午3:10:46
 */
public interface Aggregate {  
    public void add(Object obj);  
    public void remove(Object obj);  
    public Iterator iterator();  
}  
