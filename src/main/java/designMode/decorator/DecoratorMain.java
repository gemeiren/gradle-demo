package designMode.decorator;

public class DecoratorMain {
	public static void main(String[] args) {
		Face girlFriend = new GirlFriend();
		Decorator fenDiFace = new FenDiDecorator();
		Decorator yanXianFace = new YanXianDecorator();
		Decorator otherFace = new OtherDecorator();
		
		fenDiFace.setFace(girlFriend);
		yanXianFace.setFace(fenDiFace);
		otherFace.setFace(yanXianFace);
		otherFace.show();
		
		System.out.println();
		System.out.println("=================");
		System.out.println();

		Decorator xieZhuangFace = new XieZhuangDecorator();
		xieZhuangFace.setFace(otherFace);
		xieZhuangFace.show();

	}
}
