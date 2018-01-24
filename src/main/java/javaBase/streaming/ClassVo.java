package javaBase.streaming;

import java.util.List;

public class ClassVo {

	private Long classId;
	private String className;
	private TeacherVo teacherVo;
	private List<StudentVo> studentVoList;
	
	public Long getClassId() {
		return classId;
	}

	public ClassVo setClassId(Long classId) {
		this.classId = classId;
		return this;
	}

	public String getClassName() {
		return className;
	}

	public ClassVo setClassName(String className) {
		this.className = className;
		return this;
	}

	public TeacherVo getTeacherVo() {
		return teacherVo;
	}

	public ClassVo setTeacherVo(TeacherVo teacherVo) {
		this.teacherVo = teacherVo;
		return this;
	}

	public List<StudentVo> getStudentVoList() {
		return studentVoList;
	}
	
	public ClassVo setStudentVoList(List<StudentVo> studentVoList) {
		this.studentVoList = studentVoList;
		return this;
	}

	/*public ClassVo(Long classId, String className, TeacherVo teacherVo, List<StudentVo> studentVoList) {
		super();
		this.classId = classId;
		this.className = className;
		this.teacherVo = teacherVo;
		this.studentVoList = studentVoList;
	}*/
	
	
}
