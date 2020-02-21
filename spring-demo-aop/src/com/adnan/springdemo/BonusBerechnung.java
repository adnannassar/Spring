package com.adnan.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BonusBerechnung  implements BankingSystem{

	@Override
	public double getGehalt() {
		return 30000;
	}

}
