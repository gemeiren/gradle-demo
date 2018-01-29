package jarTool.mockinterface;

/**  
 * ClassName: StudentVo <br/>  
 * date: 2018年1月26日 上午11:20:22 <br/>  
 * @since JDK 1.7  
 */
public class StudentVo {
	
	private Long stuId;
	private String stuName;
	private Long classId;
	private Long teacherId;
	
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
}
