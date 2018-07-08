package javaBase.generic;


/**
 * Java总结篇系列：Java泛型
 * @Description : https://www.cnblogs.com/lwbqqyumidi/p/3837629.html
 * @Date: 2018年7月8日 下午2:35:30
 */
public class GenericTest {
	/*public static void main(String[] args) {

        Box<Integer> a = new Box<Integer>(712);
        //Box<Number> b = a;  // 1
        Box<Float> f = new Box<Float>(3.14f);
        //b.setData(f);        // 2

    }

    public static void getData(Box<Number> data) {
        System.out.println("data :" + data.getData());
    }*/

	/*public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }*/
    
	public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);
        
        //getUpperNumberData(name); // 1
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }
    
    public static void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }
	
	
}

class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
