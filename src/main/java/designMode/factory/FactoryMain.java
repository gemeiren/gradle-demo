package designMode.factory;

public class FactoryMain {

	public static void main(String[] args) {
		IGFFactory yunNanGFFactory = new YunNanGFFactory();
		BaseGF yunNanGF = yunNanGFFactory.createGF();
		yunNanGF.eatFood();
		yunNanGF.shopping();

		System.out.println(" ");
		System.out.println(" =================== ");
		System.out.println(" ");

		IGFFactory siChuanGFFactory = new SiChuanGFFactory();
		BaseGF siChuanGF = siChuanGFFactory.createGF();
		siChuanGF.eatFood();
		siChuanGF.shopping();
	}

}
