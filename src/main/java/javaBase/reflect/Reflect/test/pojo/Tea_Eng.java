package javaBase.reflect.Reflect.test.pojo;

import javaBase.reflect.Reflect.test.inter.author;

public class Tea_Eng extends Teacher implements author{

	private String ability;

	public Tea_Eng(){
		System.out.println("我是默认构造函数");
	}
	public Tea_Eng(String ability){
		System.out.println("我是设置能力值的构造函数");
		this.ability=ability;
	}
	public void haveAbility(){
		System.out.println("I Have "+ ability);
	}
	@Override
	public void writeAuthor(String context) {
		System.out.println(context);
	}
	
	
}
