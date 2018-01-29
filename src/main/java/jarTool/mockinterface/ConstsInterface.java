package jarTool.mockinterface;


@SuppressWarnings("rawtypes")
public class ConstsInterface implements ConstsReflectInterface{
	
	public static final Boolean SWITH = true ;

	//将静态值变为普通的方法
	@Override
	public Object getValue() {
		return SWITH;
	}

}
