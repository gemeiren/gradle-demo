package javaBase.streaming;


public class StudentVo {
	
	private Long studentId;
	private String studentName;

	public Long getStudentId() {
		return studentId;
	}
	public StudentVo setStudentId(Long studentId) {
		this.studentId = studentId;
		return this;
	}
	public String getStudentName() {
		return studentName;
	}
	public StudentVo setStudentName(String studentName) {
		this.studentName = studentName;
		return this;
	}
	
}
