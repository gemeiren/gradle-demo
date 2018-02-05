package javaBase.spi.impl;

import javaBase.spi.DogService;


public class BlackDogServiceImpl implements DogService {

	@Override
	public void sleep() {
		System.out.println("黑色dog。。。呼呼大睡觉...");
	}

}
