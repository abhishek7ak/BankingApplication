package com.adfc.bank.service;
import com.adfc.bank.modul.UserAccount;
public interface InternetBanking {

	public void checkBalance(UserAccount account);
	
	public boolean deposit(UserAccount account, double amount);
	
	public boolean withdraw(UserAccount account, double amount);
	
	public boolean transfer(UserAccount fromAccount, UserAccount toaccount, double amount, int otp);

	public boolean validateLogin(String accountNo, String password, UserAccount account) ;

	public int generateOtp();
}

