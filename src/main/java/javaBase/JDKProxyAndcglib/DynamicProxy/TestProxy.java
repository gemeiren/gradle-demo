package javaBase.JDKProxyAndcglib.DynamicProxy;


/**
 * http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html
 * @Description : 
 * @Date: 2017年5月7日 上午10:42:44
 */
public class TestProxy {  
	  
    public static void main(String[] args) {  
        BookFacadeProxy proxy = new BookFacadeProxy();  
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());  
        bookProxy.addBook();  
    }  
  
}  