package javaBase.reflect.factoryReflect;

/**
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 * @Description : 将反射机制应用于工厂模式
 * @Date: 2017年3月21日 下午1:00:50
 */

/**
 * 对于普通的工厂模式当我们在添加一个子类的时候，就需要对应的修改工厂类。 当我们添加很多的子类的时候，会很麻烦。
 * Java 工厂模式可以参考
 * http://baike.xsoftlab.net/view/java-factory-pattern
 * 
 * 现在我们利用反射机制实现工厂模式，可以在不修改工厂类的情况下添加任意多个子类。
 * 
 * 但是有一点仍然很麻烦，就是需要知道完整的包名和类名，这里可以使用properties配置文件来完成。
 * 
 * java 读取 properties 配置文件 的方法可以参考
 * http://baike.xsoftlab.net/view/java-read-the-properties-configuration-file
 * 
 */


public class TestReflect {
	public static void main(String[] args) throws Exception {
        fruit f = Factory.getInstance("javaBase.reflect.factoryReflect.Apple");
        if (f != null) {
            f.eat();
        }
    }
}
