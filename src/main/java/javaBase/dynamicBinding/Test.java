package javaBase.dynamicBinding;

/** 
 * http://www.cnblogs.com/jack204/archive/2012/10/29/2745150.html
* @Description: Java��̬�����
* @date : 2017��2��28�� ����11:24:31  
*/
public class Test {
	
	//��̬�� ָ����ͬ��Ķ����ͬһ��Ϣ������Ӧ��
	//      ��ͬһ��Ϣ���Ը��ݷ��Ͷ���Ĳ�ͬ�����ö��ֲ�ͬ����Ϊ��ʽ����������Ϣ���Ǻ������ã�
    public static void main(String[] args) {
        AA a1 = new AA();
        AA a2 = new BB();
        BB b = new BB();
        CC c = new CC();
        DD d = new DD();
        
        System.out.println("1--   " + a1.show(b));
        System.out.println("2--   " + a1.show(c));
        System.out.println("3--   " + a1.show(d));
        System.out.println("4--   " + a2.show(b));
        System.out.println("5--   " + a2.show(c));
        System.out.println("6--   " + a2.show(d));
        System.out.println("7--   " + b.show(b));
        System.out.println("8--   " + b.show(c));
        System.out.println("9--   " + b.show(d));      
    }
    
    
}