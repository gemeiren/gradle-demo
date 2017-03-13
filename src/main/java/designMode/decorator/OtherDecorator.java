package designMode.decorator;

public class OtherDecorator extends Decorator {
	@Override
	public void show() {
		super.show();
		System.out.println("With other huazhuangpin.");
	}
}
