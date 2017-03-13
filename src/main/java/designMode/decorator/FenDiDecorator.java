package designMode.decorator;

public class FenDiDecorator extends Decorator {
	@Override
	public void show() {
		super.show();
		System.out.println("With fendi.");
	}
}
