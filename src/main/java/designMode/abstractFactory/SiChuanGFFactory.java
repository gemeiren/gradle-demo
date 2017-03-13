package designMode.abstractFactory;
//创建川妹子的工厂
public class SiChuanGFFactory implements IGFFactory {
	@Override
	public BaseGF createGF() {
		return new SiChuanGF();
	}

	@Override
	public IGFFather createGFFather() {
		return new SiChuanGFFather();
	}
}
