package com.adfc.bank.service;

public class OTPGenerator {

	public static int generateOtp() {
		return (int)(Math.random()* 9000) +1000;
	}
}
