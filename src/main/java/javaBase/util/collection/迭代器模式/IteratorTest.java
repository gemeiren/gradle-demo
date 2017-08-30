package javaBase.util.collection.迭代器模式;


/**
 * @Description : http://www.cnblogs.com/ysw-go/p/5384516.html
 * @Date: 2017年8月6日 下午6:07:39
 */
public class IteratorTest {
	  
    public static void main(String[] args) {

        List list=new ConcreteAggregate();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator it=list.iterator();
        it.remove(2);
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
}
