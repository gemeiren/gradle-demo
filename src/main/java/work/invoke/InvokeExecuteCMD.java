package work.invoke;

/**  
 * ClassName: InvokeExecuteCMD <br/>  
 * Function:  ADD FUNCTION.接口参数数据结构体
 * date: 2018年1月22日 下午2:36:04 <br/>  
 * @since JDK 1.7  
 */
public class InvokeExecuteCMD {
	/**
	* <p>方法名称
	*/
	private String methodName;
	
	/**
	* <p>方法参数
	*/
	private String parameter;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
}
