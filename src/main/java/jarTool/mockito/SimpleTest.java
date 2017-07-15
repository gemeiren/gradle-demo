package jarTool.mockito;

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
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;


/**
 * @Description : http://liuzhijun.iteye.com/blog/1512780
 *  【对应build.gradle】
 *  https://mvnrepository.com/artifact/org.mockito/mockito-all   
	compile group: 'org.mockito', name: 'mockito-all', version: '1.9.5'
 * @Date: 2017年7月9日 下午3:22:36
 */
public class SimpleTest {
	   
		@Test  
	    public void simpleTest(){  
	          
	        //创建mock对象，参数可以是类，也可以是接口  
	        List<String> list = mock(List.class);  
	          
	        //设置方法的预期返回值  
	        when(list.get(0)).thenReturn("helloworld");  
	      
	        String result = list.get(0);  
	          
	        //验证方法调用(是否调用了get(0))  
	        verify(list).get(0);  
	          
	        //junit测试  
	        Assert.assertEquals("helloworld", result); 
	        doReturn("helloworld").when(list).get(0);  
	        
	        //创建mock对象不能对final，Anonymous ，primitive类进行mock。
	        //可对方法设定返回异常
	        when(list.get(1)).thenThrow(new RuntimeException("test excpetion"));  
	        try {
	        	String resultV2 = list.get(1); 	
			} catch (Exception e) {
				Assert.assertEquals("test excpetion", e.getMessage()); 
			}
	        
	        
	    }
		
		
		@Test  
		public void argumentMatcherTest(){  
		      
		    List<String> list = mock(List.class);  
		      
		    when(list.get(anyInt())).thenReturn("hello","world","aasdsd");  
		      
		    String result = list.get(0)+list.get(1);
		    String result2 = list.get(3);
		    System.out.println("result2=" + result2);
		    
		    verify(list,times(3)).get(anyInt());  
		      
		    Assert.assertEquals("helloworld", result);  
		      
		}  
		
		@Test  
		public void argumentMatcherTest2(){  
		      
		    Map<Integer,String> map = mock(Map.class);  
		    when(map.put(anyInt(),anyString())).thenReturn("hello");//anyString()替换成"hello"就会报错  
		    map.put(1, "world");  
		    System.out.println("---map= " + JSON.toJSONString(map));
		    verify(map).put(eq(1), eq("world")); //eq("world")替换成"world"也会报错  
		
		    System.out.println("--- " + map.get(0));
		    System.out.println("--- " + map.get(1));
		    System.out.println("--- " + map.get(2));
		    
		    
		
		}  
		
		@Test  
		public void verifyInvocate(){  
		      
		    List<String> mockedList = mock(List.class);  
		    //using mock   
		     mockedList.add("once");  
		     mockedList.add("twice");  
		     mockedList.add("twice");  
		       
		     mockedList.add("three times");  
		     mockedList.add("three times");  
		     mockedList.add("three times");  
		       
		     /** 
		      * 基本的验证方法 
		      * verify方法验证mock对象是否有没有调用mockedList.add("once")方法 
		      * 不关心其是否有返回值，如果没有调用测试失败。 
		      */
		     verify(mockedList).add("once");   
		     verify(mockedList, times(1)).add("once");//默认调用一次,times(1)可以省略  
		       
		     
		     verify(mockedList, times(2)).add("twice");  
		     verify(mockedList, times(3)).add("three times");  
		       
		     //never()等同于time(0),一次也没有调用  
		     verify(mockedList, times(0)).add("never happened");  
		       
		     //atLeastOnece/atLeast()/atMost()  
		     verify(mockedList, atLeastOnce()).add("three times");  
		     verify(mockedList, atLeast(2)).add("twice");  
		     verify(mockedList, atMost(5)).add("three times");  
		  
		}
		
}
