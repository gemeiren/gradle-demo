package javaBase.withor;
/** 
 * @Description: 两两为真，或一真一假
 * @date 2016年2月26日  下午3:43:43
 */
public class testAndOr {

	public static void main(String[] args) {
	//	int a=1 ,b =0;
		
		boolean a = false ,b =false;
		TestOr(a, b);
		boolean a1 = true ,b1 =false;
		TestOr(a1, b1);
		boolean a2 = false ,b2 =true;
		TestOr(a2, b2);
		boolean a3 = true ,b3 =true;
		TestOr(a3, b3);
		
	}

	private static void TestOr(boolean a, boolean b) {
		if(a || b){
			System.out.println("a="+a+"  b="+b);
		}
	}
}
