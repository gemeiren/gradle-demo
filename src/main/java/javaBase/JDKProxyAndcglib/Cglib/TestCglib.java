package javaBase.JDKProxyAndcglib.Cglib;


/**
 * @Description : 
 * @Date: 2017年5月7日 上午10:45:31
 */
public class TestCglib {
	  public static void main(String[] args) {  
	        BookFacadeCglib cglib=new BookFacadeCglib();  
	        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());  
	        bookCglib.addBook();  
	    }  
}
