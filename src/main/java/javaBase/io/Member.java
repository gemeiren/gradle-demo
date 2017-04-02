package javaBase.io;
/**
 * http://www.cnblogs.com/jianmang/articles/4909784.html
 * @Description : 4.有时没有必要存储整个对象的信息，而只是要存储一个对象的成员数据，
 * 成员数据的类型假设都是Java的基本数据类型，这样的需求不必 使用到与Object输入、
 * 输出相关的流对象，
 * 可以使用DataInputStream、DataOutputStream来写入或读出数据。下面是一个 例子：
 * @Date: 2017年4月2日 上午12:46:57
 */
public class Member {
	private String name;  
    private int age;  
    public Member() {  
    }  
   public Member(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
    public void setName(String name){  
        this.name = name;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public String getName() {  
        return name;  
    }  
    public int getAge() {  
        return age;  
    } 
}
