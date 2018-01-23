package work.invoke;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;


/**
 * @Description : Invoke反射简单使用
 * @Date: 2018年1月23日 下午10:48:52
 */
public class testInvoke {
	public static void main(String[] args) {
		System.out.println("----");
	}
	
	@Test
	public void makeTheTest() {
		System.out.println("====");
		TestClassInfo testClassInfo = new TestClassInfo();
		testClassInfo.setClassId(111L);
		testClassInfo.setClassName("CLASS-1");
		testClassInfo.setTeacherName("teacherName-A");
		testClassInfo.setStudentList(Lists.newArrayList("XIAO-HONG","LIU-DONG","CHEN-LAN"));
		
		//打印被反射的方法的参数
		System.out.println("testClassInfo:" + JSON.toJSONString(testClassInfo));
		//{"classId":111,"className":"CLASS-1","studentList":["XIAO-HONG","LIU-DONG","CHEN-LAN"],"teacherName":"teacherName-A"}
		
		TestLookBakLogLevel testLookBakLogLevel= new TestLookBakLogLevel();
		testLookBakLogLevel.setLogLevel("DEBUG");
		testLookBakLogLevel.setLogPath("work.invoke");
		//打印被反射的方法的参数
		System.out.println("testLookBakLogLevel:" + JSON.toJSONString(testLookBakLogLevel));
		//{"logLevel":"DEBUG","logPath":"work.invoke"}
	}
	
	@Test
	public void makeTheInvokeTest() throws Exception {
		System.out.println("+++++");
		
		//第一个测试
		InvokeExecuteCMD invokeExecuteCMDparam = new InvokeExecuteCMD(); 
		invokeExecuteCMDparam.setMethodName("testInvokeMethodName");//方法名称
		//方法参数
		invokeExecuteCMDparam.setParameter("{\"classId\":111,\"className\":\"CLASS-1\",\"studentList\":[\"XIAO-HONG\",\"LIU-DONG\",\"CHEN-LAN\"],\"teacherName\":\"teacherName-A\"}");//classId   teacherName  className
		
		String result = doExecute(invokeExecuteCMDparam);
		System.out.println("result: " + result);
		
		
		//第二个测试
		InvokeExecuteCMD invokeExecuteCmdParam = new InvokeExecuteCMD(); 
		invokeExecuteCmdParam.setMethodName("setNewLogLevel");//方法名称
		//方法参数
		invokeExecuteCmdParam.setParameter("{\"logLevel\":\"DEBUG\",\"logPath\":\"work.invoke\"}");
		
		String setNewLogLevelResult = doExecute(invokeExecuteCmdParam);
		System.out.println("setNewLogLevelResult: " + setNewLogLevelResult);
		
	}
	
	
	/**  
	 * doExecute:反射调用某个方法入口. <br/>  
	 */
	public String doExecute(InvokeExecuteCMD invokeExecuteCmdParam) throws Exception {
        System.out.println("InvokeExecuteCMD:" + JSON.toJSONString(invokeExecuteCmdParam));

        Method method = null;
        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            System.out.println("获取本地这个类的方法:" + JSON.toJSONString(methods));
            
            //只找到匹配的方法名    todo：只是匹配到方法名称
            for(Method mtd : methods){
                if(mtd.getName().equals(invokeExecuteCmdParam.getMethodName())){
                    method = mtd;
                    break;
                }
            }
            if(method == null){
                System.out.println("method name 不存在:" + invokeExecuteCmdParam.getMethodName() );
                throw new Exception("method name error");
            }

            Class<?>[] parameterTypes = method.getParameterTypes();
            
            System.out.println("parameterTypes:" + JSON.toJSONString(parameterTypes, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNonStringKeyAsString));
            
            Class<?> clzz = parameterTypes[0];
            if(parameterTypes.length > 1){
                System.out.println("method 参数不存在:" + invokeExecuteCmdParam.getMethodName());
                throw new Exception("method param error");
            }
            System.out.println("execute method =  " + method.getName() + ", parameter is = " + clzz.getName());

            return (String) method.invoke(this, JSON.parseObject(invokeExecuteCmdParam.getParameter(), clzz));
        }catch (Exception e){
            System.out.println("调用方法:"+invokeExecuteCmdParam.getMethodName()+",出错:" + e);
            throw e;
        }
    }
	
	
	/**  
	 * testInvokeMethodName:测试被反射调用的方法. <br/>  
	 */
	public String testInvokeMethodName(TestClassInfo TestClassInfoParam) throws Exception{
		
		System.out.println(TestClassInfoParam.getClass().getName() + " -> " + JSON.toJSONString(TestClassInfoParam));

        if(TestClassInfoParam.getClassId() <= 0 || StringUtils.isBlank(TestClassInfoParam.getClassName())){
            throw new Exception("参数错误");
        }
        String res = JSON.toJSONString(TestClassInfoParam);
        System.out.println("解析方法参数成功 = " + res);
        return JSON.toJSONString(TestClassInfoParam);
    }
	
	/**  
	 * setNewLogLevel:测试被反射调用的方法.设置log级别 <br/>  
	 */
	public String setNewLogLevel(TestLookBakLogLevel logLevel){
        LoggerContext loggerContext = null;
        try{
            Level newLevel = Level.toLevel(logLevel.getLogLevel(), Level.INFO);
            loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            Logger logback = loggerContext.getLogger(logLevel.getLogPath());
            if(logback != null){
                logback.setLevel(newLevel);
                return "设置成功";
            }
        } catch (Exception e){
        	 System.out.println("设置失败,原因:"+ e);
        	 throw e;
        }
        return "设置失败";
	}
	
	
}
