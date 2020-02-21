package com.adnan.springdemo;

import org.springframework.stereotype.Component;

@Component
public class GehaltVerwaltung  implements BankingSystem{

	@Override
	public double getGehalt() {
		return 20000.000;
	}

}
