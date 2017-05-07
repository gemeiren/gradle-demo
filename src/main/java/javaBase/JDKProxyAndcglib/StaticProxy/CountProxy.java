package javaBase.JDKProxyAndcglib.StaticProxy;
/**
 * http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * @Description : 这是一个代理类（增强CountImpl实现类） 
 * @Date: 2017年5月7日 上午10:35:17
 */
public class CountProxy implements Count {  
    private CountImpl countImpl;  
  
    /** 
     * 覆盖默认构造器 
     *  
     * @param countImpl 
     */  
    public CountProxy(CountImpl countImpl) {  
        this.countImpl = countImpl;  
    }  
  
    @Override  
    public void queryCount() {  
        System.out.println("事务处理之前");  
        // 调用委托类的方法;  
        countImpl.queryCount();  
        System.out.println("事务处理之后");  
    }  
  
    @Override  
    public void updateCount() {  
        System.out.println("事务处理之前");  
        // 调用委托类的方法;  
        countImpl.updateCount();  
        System.out.println("事务处理之后");  
  
    }  
  
}  
