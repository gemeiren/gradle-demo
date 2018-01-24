package javaBase.streaming;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**  
 * ClassName: TestCreateClassVo 流式创建数据结构
 * date: 2018年1月24日 下午3:06:29 <br/>  
 * @since JDK 1.7  
 */
public class TestCreateClassVo {
	
	public static void main(String[] args) {
		ClassVo cVo = new ClassVo();
		TeacherVo teacherVo = new TeacherVo();
		teacherVo.setTeacherId(222L).setTeacherName("TEACHER-A");
		
		//1、流式创建vo结构体
		cVo.setClassId(11L).setClassName("Class-A").setTeacherVo(teacherVo);
		System.out.println("ClassVo=" + JSON.toJSONString(cVo));
		
		//2、流式创建数据库结构体
		IbatisRange ibatisRange = IbatisRangeFactory.newIbatisRange().greater("123").greaterEqual(Boolean.TRUE).inContent(Lists.newArrayList("AAA", "bbb")).build();
		System.out.println("ibatisRange = " + JSON.toJSONString(ibatisRange));
		
	}
}
