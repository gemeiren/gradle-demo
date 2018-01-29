package jarTool.mockinterface;

import com.alibaba.fastjson.JSON;

/**  
 * ClassName: ExternalInterface 模拟外部接口服务
 * date: 2018年1月26日 上午11:05:40 <br/>  
 */
public class ExternalInterface {
	
	private StudentVo studentVo;
	
	//模拟外部接口
	public StudentVo creatStudentVo(Long stuId, String stuName, Long classId, Long teacherId){
		studentVo = new StudentVo();
		studentVo.setClassId(classId);
		studentVo.setStuId(stuId);
		studentVo.setStuName(stuName);
		studentVo.setTeacherId(teacherId);
		System.out.println("creatStudentVo : " + JSON.toJSONString(studentVo));//被mock时是不会打印的
		return studentVo;
	}
	
	
	//模拟外部接口 void
	public void creatStudentVoV2(Long stuId, String stuName, Long classId, Long teacherId){
		studentVo = new StudentVo();
		studentVo.setClassId(classId);
		studentVo.setStuId(stuId);
		studentVo.setStuName(stuName);
		studentVo.setTeacherId(teacherId);
		System.out.println("creatStudentVoV2 : " + JSON.toJSONString(studentVo));//被mock时是不会打印的
	}
	
	//模拟外部接口 异常
	public void creatStudentVoV3(Long stuId, String stuName, Long classId, Long teacherId) throws Exception {
		studentVo = new StudentVo();
		studentVo.setClassId(classId);
		studentVo.setStuId(stuId);
		studentVo.setStuName(stuName);
		studentVo.setTeacherId(teacherId);
		System.out.println("creatStudentVoV3 : " + JSON.toJSONString(studentVo));//被mock时是不会打印的
		throw new Exception("creatStudentVoV3 - Exception");
	}
	
}
