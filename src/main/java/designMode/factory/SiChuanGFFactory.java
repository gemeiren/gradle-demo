package designMode.factory;

//创建川妹子的工厂
public class SiChuanGFFactory implements IGFFactory {
	@Override
	public BaseGF createGF() {
		return new SiChuanGF();
	}
}
