package jarTool.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;


/**
 * @Description :http://hotdog.iteye.com/blog/916364 
 * @Date: 2017年7月16日 下午2:48:16
 */
public class ArgumentCaptor参数捕获器 {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test  
	public void argumentCaptorTest() {  
	    List mock = mock(List.class);  
	    List mock2 = mock(List.class);  
	    mock.add("John");  
	    mock2.add("Brian");  
	    mock2.add("Jim");  
	      
	    ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);  
	      
	    //mock只有一次
	    verify(mock).add(argument.capture());  
	    assertEquals("John", argument.getValue());  
	    
	  //mock只有两次
	    verify(mock2, times(2)).add(argument.capture());  
	  
	    assertEquals("Jim", argument.getValue());  
	    
	    //mock传入所有参数的顺序要保持一致
	    assertArrayEquals(new Object[]{"John","Brian","Jim"}, argument.getAllValues().toArray());  
	} 
	
	
	
}
