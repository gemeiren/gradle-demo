package jarTool.powerMock.po;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/** 
 * @Description: http://susiya.iteye.com/blog/2323366 
 * http://www.cnblogs.com/jiyuqi/p/3564621.html
 * @date 2016年10月9日  下午4:11:53
 */
@RunWith(PowerMockRunner.class)  
@PrepareForTest({Kitty.class,Hello.class}) 
public class HelloTest {  
	
	//3.1 mock 非静态方法
	@Test  
	public void testMockNonStaticMethod() {  
	    Hello hello = new Hello();  
	    Kitty kitty = PowerMockito.mock(Kitty.class);  
	    hello.setKitty(kitty);  
	    PowerMockito.when(kitty.getName()).thenReturn("[test]");  
	    hello.mockNonStaticMethod();  
	}
	
	//3.2 mock 静态方法
	//首先需要PrepareForTest导入静态方法的类
	@Test  
	public void testMockStaticMethod() {  
	        Hello hello = new Hello();  
	        PowerMockito.mockStatic(Kitty.class);  
	        PowerMockito.when(Kitty.getName2()).thenReturn("{test}");  
	        hello.mockStaticMethod();  
	}  
	
	//3.3 partial mock (mock 部分方法)
	//如果只想mock一个类里面的个别方法，可以使用spy方法
	@Test  
    public void testPartialMock() {  
        Hello hello = PowerMockito.spy(new Hello());  
        try {  
           // PowerMockito.doReturn("test").when(hello, MemberMatcher.method(Hello.class, "_partialMock")).withNoArguments();
        	PowerMockito.when(hello, MemberMatcher.method(Hello.class, "_partialMock2")).withNoArguments();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        //hello.partialMock2();  
        
    } 
	
	//3.4 mock void 方法
	@Test  
	public void testMockVoidMethod() {  
	    Hello hello = new Hello();  
	    Kitty kitty = PowerMockito.mock(Kitty.class);  
	    hello.setKitty(kitty);  
	    PowerMockito.doNothing().when(kitty).say3();  
	    hello.mockVoidMethod();  
	} 
	
	// 3.5 mock parent method （父类方法）
	//使用PowerMockito.suppress()方法
	@Test  
	public void testMockParentMethod() {  
	    Hello hello = new Hello();  
	    PowerMockito.suppress(MemberMatcher.methodsDeclaredIn(Hi.class));  
	    hello.mockParentMethod();
	    testMockParentMethod();
	    //hello.testMockParentMethod();
	}
	
	@Test 
	public void testPrivateMethod() throws Exception {  
	    Hello hello = new  Hello();  
	    PowerMockito.verifyPrivate(hello).invoke("_partialMock2");  
	}
	
	
	
	
	
	
	
	
	
	
}  