package designMode.simpleFactory;

public class SimpleFactoryMain {

	public static void main(String[] args) {
		BaseGF siChuanGirl = GFFactory.createGF(GFType.SI_CHUAN);
		siChuanGirl.eatFood();
		siChuanGirl.shopping();

		System.out.println();

		BaseGF shanDongGirl = GFFactory.createGF(GFType.SHAN_DONG);
		shanDongGirl.eatFood();
		shanDongGirl.shopping();
	}

}
