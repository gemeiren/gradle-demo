package javaBase.JDKProxyAndcglib.StaticProxy;
/**
 * http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * @Description : 测试Count类 
 * @Date: 2017年5月7日 上午10:36:00
 */
public class TestCount {  
    public static void main(String[] args) {  
        CountImpl countImpl = new CountImpl();  
        CountProxy countProxy = new CountProxy(countImpl);  
        countProxy.updateCount();  
        countProxy.queryCount();  
  
    }  
}  