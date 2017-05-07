package javaBase.JDKProxyAndcglib.DynamicProxy;


/**
 * @Description : 
 * @Date: 2017年5月7日 上午10:41:29
 */
public class BookFacadeImpl implements BookFacade {  
	  
    @Override  
    public void addBook() {  
        System.out.println("增加图书方法。。。");  
    }  
  
} 
