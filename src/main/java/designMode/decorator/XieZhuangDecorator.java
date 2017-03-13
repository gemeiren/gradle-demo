package designMode.decorator;

public class XieZhuangDecorator extends Decorator {
	@Override
	public void show() {
		super.show();
		System.out.println("Xie zhuang.");
	}
}
