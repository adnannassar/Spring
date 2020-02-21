package com.adnan.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {
	
	@Override
	public String getFortune() {
		return "Random Service : " +   new Random().nextInt(10);
	}

}
