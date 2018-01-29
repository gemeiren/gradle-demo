package jarTool.mockinterface;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.alibaba.fastjson.JSON;
import static org.mockito.Matchers.any;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**  
 * ClassName: TestMockTheInterface -mock外部接口
 * date: 2018年1月26日 上午11:19:10 <br/>  
 * @since JDK 1.7  
 */
public class TestMockTheInterface {
	
	@Mock 
	private ExternalInterface externalInterface;
	
	public static void main(String[] args) {
		System.out.println("=== -- ");
	}
	
	@Before 
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	//不mock,直接调用
	@Test
	public void noMockito() {
		System.out.println("111...");
		ExternalInterface externalInterfaceReadly = new ExternalInterface();
		StudentVo studentVoResult = externalInterfaceReadly.creatStudentVo(1L, "stuName", 1L, 1L);
		System.out.println("no mock studentVoResult = " + JSON.toJSONString(studentVoResult));
		
		/**
		   111...
		   creatStudentVo : {"classId":1,"stuId":1,"stuName":"stuName","teacherId":1}
		   no mock studentVoResult = {"classId":1,"stuId":1,"stuName":"stuName","teacherId":1}
		 */
		
	}
	
	//mock接口返回
	@Test
	public void mockitoDoReturn() {
		System.out.println("222...");
		
		StudentVo studentVo = new StudentVo();
		studentVo.setClassId(11L);
		studentVo.setStuId(22L);
		studentVo.setStuName("S-A");
		studentVo.setTeacherId(33L);
		Mockito.doReturn(studentVo).when(externalInterface).creatStudentVo(any(Long.class), any(String.class), any(Long.class), any(Long.class));
		
		StudentVo studentVoResult = externalInterface.creatStudentVo(1L, "stuName", 1L, 1L);
		System.out.println("after mock studentVoResult = " + JSON.toJSONString(studentVoResult));
		/**
		  	222...
			after mock studentVoResult = {"classId":11,"stuId":22,"stuName":"S-A","teacherId":33}
		 */
	}
	
	//不mock,直接调用
	@Test
	public void noMockitoDoNothing() {
		System.out.println("333...");
		ExternalInterface externalInterfaceReadly = new ExternalInterface();
		externalInterfaceReadly.creatStudentVoV2(1L, "stuName", 1L, 1L);
		System.out.println("no mock OVER ");
		
		/**
		   	333...
			creatStudentVoV2 : {"classId":1,"stuId":1,"stuName":"stuName","teacherId":1}
			no mock OVER 
		 */
	}
	
	//mock接口
	@Test
	public void mockitoDoNothing() {
		System.out.println("444...");
		
		Mockito.doNothing().when(externalInterface).creatStudentVoV2(any(Long.class), any(String.class), any(Long.class), any(Long.class));
		
		externalInterface.creatStudentVoV2(1L, "stuName", 1L, 1L);
		System.out.println("mockitoDoNothing OVER ");
		/**
		 	444...
			mockitoDoNothing OVER 
		 */
	}
	
	//不mock,直接调用
	@Test
	public void noMockitoException() {
		System.out.println("555...");
		ExternalInterface externalInterfaceReadly = new ExternalInterface();
		try {
			externalInterfaceReadly.creatStudentVoV3(1L, "stuName", 1L, 1L);
		} catch (Exception e) {
			//  Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Exception = " + e);
		}
		System.out.println("no noMockitoException OVER ");
		
		/**
		   	555...
			creatStudentVoV3 : {"classId":1,"stuId":1,"stuName":"stuName","teacherId":1}
			Exception = java.lang.Exception: creatStudentVoV3 - Exception
			no noMockitoException OVER 
			java.lang.Exception: creatStudentVoV3 - Exception
		 */
	}
	
	//mock接口 异常
	@Test(expected = Exception.class)
	public void mockitoException() throws Exception {
		System.out.println("666...");
		
		Mockito.doThrow(new java.lang.Exception("mock exception ... ")).when(externalInterface).creatStudentVoV3(any(Long.class), any(String.class), any(Long.class), any(Long.class));
		
		System.out.println("mockitoException begin... ");
		externalInterface.creatStudentVoV3(1L, "stuName", 1L, 1L);
		System.out.println("mockitoException OVER ");//mock异常中断，不输出
		/**
		 	666...
		 	mockitoException begin... 
		 */
	}
	
	//mock接口
	@Test
	public void mockitoDoAnswer() {
		System.out.println("777...");
		
		Mockito.doAnswer(new Answer<StudentVo>() {
			@Override
			public StudentVo answer(InvocationOnMock invocation) throws Throwable {
				Long stuId = (Long)invocation.getArguments()[0];
				String stuName = (String)invocation.getArguments()[1];
				Long classId = (Long)invocation.getArguments()[2];
				Long teacherId = (Long)invocation.getArguments()[3];
				
				StudentVo studentVo = new StudentVo();
				studentVo.setClassId(classId);
				studentVo.setStuId(stuId);
				studentVo.setStuName(stuName);
				studentVo.setTeacherId(teacherId);
				System.out.println("mock捕获入参 studentVo = " +JSON.toJSONString(studentVo));
				
				StudentVo studentVo2 = new StudentVo();
				studentVo2.setClassId(22L);
				studentVo2.setStuId(22L);
				studentVo2.setStuName("Mock");
				studentVo2.setTeacherId(22L);
				
				return studentVo2;
			}
			
		}).when(externalInterface).creatStudentVo(any(Long.class), any(String.class), any(Long.class), any(Long.class));
		
		StudentVo mockStudentVo = externalInterface.creatStudentVo(1L, "stuName", 1L, 1L);
		System.out.println("mockitoDoAnswer OVER mockStudentVo : " + JSON.toJSONString(mockStudentVo));
		/**
		 	777...
			mock捕获入参 studentVo = {"classId":1,"stuId":1,"stuName":"stuName","teacherId":1}
			mockitoDoAnswer OVER mockStudentVo : {"classId":22,"stuId":22,"stuName":"Mock","teacherId":22}
		 */
	}
	
	
	//mock接口 
	@Test
	public void mockitoStatic() throws NoSuchFieldException, IllegalAccessException {
		System.out.println("888...");
		
		Consts swithConsts = Mockito.mock(Consts.class);
		Mockito.when(swithConsts.getValue()).thenReturn(true);//getValue 为非静态的方法，可以mock
		
		//ConstsReflectInterface <Boolean> swithConsts = Mockito.mock(Consts.class);
		//Boolean swith = Consts.SWITH ;
		//Consts swithConsts = Mockito.mock(Consts.class);
		//Mockito.when(swithConsts.getValue()).thenReturn(true);
		//mockStaticFinal(Consts.class, "SWITH", swithConsts);
		
		System.out.println("SWITH : " + swithConsts.getValue());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mockitoStaticInterface() throws NoSuchFieldException, IllegalAccessException {
		System.out.println("999...");
		
		ConstsReflectInterface constsInterfaceConsts = Mockito.mock(ConstsInterface.class);
		Mockito.when(constsInterfaceConsts.getValue()).thenReturn(true);//getValue 为非静态的方法，可以mock
		mockStaticFinal(ConstsInterface.class, "SWITH", constsInterfaceConsts);//异常
		//java.lang.IllegalArgumentException: Can not set static java.lang.Boolean field jarTool.mockinterface.ConstsInterface.SWITH to jarTool.mockinterface.ConstsInterface$$EnhancerByMockitoWithCGLIB$$978eeb70
		//http://blog.csdn.net/hongchangfirst/article/details/46453677?%3E
		
		System.out.println("SWITH : " + constsInterfaceConsts.getValue());//上面异常、这里不打印
	}
	
	public void mockStaticFinal(Class<?> cla, String classProperty, Object mockObject)
			throws NoSuchFieldException, IllegalAccessException {
		Field field = cla.getField(classProperty);//字段
		if (field == null) {
			field = cla.getDeclaredField(classProperty);
		}
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.setAccessible(true);
		field.set(cla, mockObject);
	}
	
	
	
	
}
