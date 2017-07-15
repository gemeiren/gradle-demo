package jarTool.mockito.studyCsdn;

//注意：这里的所有的mock函数都需要静态导入
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
//import static org.mockito.internal.stubbing.BaseStubbing.thenAnswer;
//import static org.mockito.stubbing.OngoingStubbing.thenAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
/*import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;*/
//import static org.mockito.internal.verification.VerificationModeFactory.atMost;


/**
 * @Description : http://blog.csdn.net/sdyy321/article/details/38757135/
 * 9、使用注解来快速模拟
 * @Date: 2017年7月15日 下午11:11:43
 */
@RunWith(MockitoJUnitRunner.class)  
public class MockitoExample2 {
	@Mock  
    private List mockList;  
  
   /* public MockitoExample2(){  
        MockitoAnnotations.initMocks(this);  
    }*/  
  
    @Test  
    public void shorthand(){  
        mockList.add(1);  
        verify(mockList).add(1);  
    } 
    
    @Test(expected = RuntimeException.class)  
    public void consecutive_calls(){  
        //模拟连续调用返回期望值，如果分开，则只有最后一个有效  
        when(mockList.get(0)).thenReturn(0);  
        when(mockList.get(0)).thenReturn(1);  
        when(mockList.get(0)).thenReturn(4); // 最后一个有效
        when(mockList.get(1)).thenReturn(0).thenReturn(1).thenReturn(7).thenThrow(new RuntimeException());  // 第一个为0、第二个为1、第三个为7，第四个为异常
        assertEquals(4,mockList.get(0));  // 最后一个有效
        assertEquals(4,mockList.get(0));  // 最后一个有效 
        assertEquals(0,mockList.get(1));// 第一个为0、第二个为1、第三个为7，第四个为异常
        assertEquals(1,mockList.get(1));// 第二个为1、第三个为7，第四个为异常  
        assertEquals(7,mockList.get(1));// 第三个为7，第四个为异常
        //第四次或更多调用都会抛出异常  
        mockList.get(1);    // 第四个为异常
    }
    
    //11、使用回调生成期望值
    @Test  
    public void answer_with_callback(){  
        //使用Answer来生成我们我们期望的返回  
        when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {  
            /*@Override  
            public Object answer(InvocationOnMock invocation) throws Throwable {  
                Object[] args = invocation.getArguments();  
                return "hello world:"+args[0];  
            }*/

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();  
                return "hello world:"+args[0];  
			}  
        });  
        assertEquals("hello world:0",mockList.get(0));  
        assertEquals("hello world:999",mockList.get(999));  
        assertEquals("hello world:456",mockList.get(456));  
        
    } 
    
    //12、监控真实对象
    //使用spy来监控真实的对象，需要注意的是此时我们需要谨慎的使用when-then语句，而改用do-when语句
    @Test(expected = IndexOutOfBoundsException.class)  
    public void spy_on_real_objects(){  
        List list = new LinkedList();  
        List spy = spy(list);  
        //下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常  
        //when(spy.get(0)).thenReturn(3);  
      
        //使用doReturn-when可以避免when-thenReturn调用真实对象api  
        doReturn(999).when(spy).get(999);  
        //预设size()期望值  
        when(spy.size()).thenReturn(100);  
        //调用真实对象的api  
        spy.add(1);  
        spy.add(2);  
        assertEquals(100,spy.size());  
        assertEquals(1,spy.get(0));  
        assertEquals(2,spy.get(1));  
        verify(spy).add(1);  
        verify(spy).add(2);  
        assertEquals(999,spy.get(999));  
        spy.get(2);  
    }  
    
    //13、修改对未预设的调用返回默认期望值
    @Test  
    public void unstubbed_invocations(){  
        //mock对象使用Answer来对未预设的调用返回默认期望值  
        List mock = mock(List.class,new Answer() {  
            @Override  
            public Object answer(InvocationOnMock invocation) throws Throwable {  
                return 999;  
            }  
        });  
        //下面的get(1)没有预设，通常情况下会返回NULL，但是使用了Answer改变了默认期望值  
        assertEquals(999, mock.get(1));  
        //下面的size()没有预设，通常情况下会返回0，但是使用了Answer改变了默认期望值  
        assertEquals(999,mock.size());  
    } 
    
    //14、捕获参数来进一步断言
    @Test  
    public void capturing_args(){  
        PersonDao personDao = mock(PersonDao.class);  
        PersonService personService = new PersonService(personDao);  
      
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);  
        personService.update(1,"jack");  
        verify(personDao).update(argument.capture());  
        assertEquals(1,argument.getValue().getId());  
        assertEquals("jack",argument.getValue().getName());  
    }  
      
     class Person{  
        private int id;  
        private String name;  
      
        Person(int id, String name) {  
            this.id = id;  
            this.name = name;  
        }  
        public int getId() {  
            return id;  
        }  
        public String getName() {  
            return name;  
        }  
    }  
      
    interface PersonDao{  
        public void update(Person person);  
    }  
      
    class PersonService{  
        private PersonDao personDao;  
      
        PersonService(PersonDao personDao) {  
            this.personDao = personDao;  
        }  
        public void update(int id,String name){  
            personDao.update(new Person(id,name));  
        }  
    } 
    
    //15、真实的部分mock
    @Test  
    public void real_partial_mock(){  
        //通过spy来调用真实的api  
        List list = spy(new ArrayList());  
        assertEquals(0,list.size());  
        
        A a  = mock(A.class);  
        //通过thenCallRealMethod来调用真实的api  
        when(a.doSomething(anyInt())).thenCallRealMethod();  
        assertEquals(999,a.doSomething(999));  
    }  
      
    class A{  
        public int doSomething(int i){  
            return i;  
        }  
    } 
    
    @Test  
    public void reset_mock(){  
        List list = mock(List.class);  
        when(list.size()).thenReturn(10);  
        list.add(1);  
        assertEquals(10,list.size());  
        //重置mock，清除所有的互动和预设  
        reset(list);  
        assertEquals(0,list.size());  
    }
    
}










