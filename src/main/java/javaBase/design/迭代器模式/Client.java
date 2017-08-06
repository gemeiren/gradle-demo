package javaBase.design.迭代器模式;


/**
 * @Description : 23种设计模式（13）：迭代器模式
 * http://blog.csdn.net/zhengzhb/article/details/7610745
 * @Date: 2017年7月28日 下午3:09:50
 */
public class Client {
    public static void main(String[] args){  
    	
    	//主要目的就是屏蔽不同数据集合的特点，统一遍历集合的接口
    	/*
    	 * 迭代器模式的真正作用是将数据结构和操作数据结构的算法分离开。我们知道在迭代器模式之前，数据结构和操作数据结构的算法是分离不开的，一定的数据结构必然有对应的算法，就算是相同的算法，如果数据结构不一样，也不能通用。可以这样讲自从有了迭代器模式数据结构和算法算是彻底分离开，两者可以独立的发展。譬如大家都知道的STL库，这个是软件组件化的先驱。而迭代器模式在STL中扮演了关键性和核心性的作用，是其他任何一个模式所不能替代的。所以深刻理解迭代器模式的精髓是很重要的！
    	 * 
    	 * */
    	
        Aggregate ag = new ConcreteAggregate();  
        ag.add("小明");  
        ag.add("小红");  
        ag.add("小刚");  
        Iterator it = ag.iterator();  
        while(it.hasNext()){  
            String str = (String)it.next();  
            System.out.println(str);  
        }  
    }  
} 
