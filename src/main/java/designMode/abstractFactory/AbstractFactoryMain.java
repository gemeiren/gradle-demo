package designMode.abstractFactory;

public class AbstractFactoryMain {

	public static void main(String[] args) {
		IGFFactory yunNanGFFactory = new YunNanGFFactory();
		BaseGF yunNanGF = yunNanGFFactory.createGF();
		yunNanGF.eatFood();
		yunNanGF.shopping();

		IGFFather yunNanGFFather = yunNanGFFactory.createGFFather();
		yunNanGFFather.suggestionToGirl();

		System.out.println();
		System.out.println(" ============== ");
		System.out.println();

		IGFFactory siChuanGFFactory = new SiChuanGFFactory();
		BaseGF siChuanGF = siChuanGFFactory.createGF();
		siChuanGF.eatFood();
		siChuanGF.shopping();

		IGFFather siChuanGFFather = siChuanGFFactory.createGFFather();
		siChuanGFFather.suggestionToGirl();
	}

}
