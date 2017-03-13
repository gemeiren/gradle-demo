package designMode.abstractFactory;

//IGFFactory增加一个创建妹子父亲的方法
public interface IGFFactory {
	BaseGF createGF();

	IGFFather createGFFather();
}