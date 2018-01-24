package javaBase.streaming;

import java.util.List;

public class IbatisRange {
	
	private List<String> inContent;//Contains the content
	
	private List<String> outContent;//Does not contain content
	
	private String greater;//greater
	
	private String less;//Less
	
	private Boolean greaterEqual;//greater or equal to
	
	private Boolean lessEqual;//Less than or equal to

	public List<String> getInContent() {
		return inContent;
	}

	public void setInContent(List<String> inContent) {
		this.inContent = inContent;
	}

	public List<String> getOutContent() {
		return outContent;
	}

	public void setOutContent(List<String> outContent) {
		this.outContent = outContent;
	}

	public String getGreater() {
		return greater;
	}

	public void setGreater(String greater) {
		this.greater = greater;
	}

	public String getLess() {
		return less;
	}

	public void setLess(String less) {
		this.less = less;
	}

	public Boolean getGreaterEqual() {
		return greaterEqual;
	}

	public void setGreaterEqual(Boolean greaterEqual) {
		this.greaterEqual = greaterEqual;
	}

	public Boolean getLessEqual() {
		return lessEqual;
	}

	public void setLessEqual(Boolean lessEqual) {
		this.lessEqual = lessEqual;
	}

}
