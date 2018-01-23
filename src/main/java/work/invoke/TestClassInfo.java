package work.invoke;

import java.util.List;


/**  
 * ClassName: TestClassInfo  测试反射方法的结构体
 * date: 2018年1月22日 下午3:09:18 <br/>  
 * @since JDK 1.7  
 */
public class TestClassInfo {

    Long classId;

    String teacherName;

    String className;

    List<String> studentList;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<String> studentList) {
		this.studentList = studentList;
	}

}
