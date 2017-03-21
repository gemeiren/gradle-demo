package javaBase.reflect.GetAllConstructors;

import java.util.Date;

/**
 * http://download.csdn.net/detail/u013132051/9753330
 * @Description : 获取所有构造函数
 * @Date: 2017年3月20日 下午11:30:47
 */
public class Tuser {

	private String id;
	private String userName;
	private String code;
	private Date birth;
	
	public Tuser(){
		
	}
	public Tuser(String id){}
	public Tuser(String id , String userName){}
	public Tuser(String userName,Date date){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Tuser [id=" + id + ", userName=" + userName + ", code=" + code
				+ ", birth=" + birth + "]";
	}
	
	
}
