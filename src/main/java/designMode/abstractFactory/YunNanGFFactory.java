package designMode.abstractFactory;

//我想要的云南的妹子的创建工厂
public class YunNanGFFactory implements IGFFactory {
	@Override
	public BaseGF createGF() {
		return new YunNanGF();
	}

	@Override
	public IGFFather createGFFather() {
		return new YunNanGFFather();
	}
}
