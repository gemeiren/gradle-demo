package javaBase.JDKProxyAndcglib.StaticProxy;
/**
 * http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * @Description : 委托类(包含业务逻辑)
 * @Date: 2017年5月7日 上午10:34:46
 */
public class CountImpl implements Count {  
	  
    @Override  
    public void queryCount() {  
        System.out.println("查看账户方法...");  
  
    }  
  
    @Override  
    public void updateCount() {  
        System.out.println("修改账户方法...");  
  
    }  
  
} 