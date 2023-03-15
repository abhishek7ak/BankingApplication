package com.adfc.bank.service;

import com.adfc.bank.modul.UserAccount;

public class InternetBankingService implements InternetBanking {

	private static final double MIN_BALANCE = 1000;
	private static final double MAX_DEPOSITE_BALANCE = 100000;
	@Override
	public void checkBalance(UserAccount account) {
		if(account.getBalance()< MIN_BALANCE) {
			System.out.println("Please maintain account minimum balance of " +MIN_BALANCE );
		}
		System.out.println("Current account balance is: " +account.getBalance());
	}

	@Override
	public boolean deposit(UserAccount account, double amount) {
		if(amount > 0 && amount <= MAX_DEPOSITE_BALANCE) {
		double currBalance = account.getBalance();
		
		double newBalance = currBalance + amount;
		account.setBalance(newBalance);
		System.out.println("Amount deposit sucessfully...!");
		System.out.println("Updated account balance is" +account.getBalance());
		return true;
	}else
		return false;
	}
	@Override
	public boolean withdraw(UserAccount account, double amount) {
		if(amount > 0 && amount <= account.getBalance()) {
			double currBalance = account.getBalance();
			double newBalance = currBalance - amount;
			account.setBalance(newBalance);
			System.out.println("Amount withdrawl sucessfully...!");
			System.out.println("Updated account balance is" +account.getBalance());
		return true;
	}else {
		System.out.println("Witdrawl failed. Insufficient Balance");
		return false;
	}
}
	@Override
	public boolean transfer(UserAccount fromAccount, UserAccount toaccount, double amount, int otp) {
		if(otp == fromAccount.getOtp()) {
			System.out.println("OTP validation sucessfully");
			if(amount > 0 && amount <= fromAccount.getBalance()) {
				
				double fromCurrBalance = fromAccount.getBalance();
				double fromNewBalance = fromCurrBalance - amount;
				fromAccount.setBalance(fromNewBalance);
				
				double toCurrBalance = toaccount.getBalance();
				double toNewBalance = toCurrBalance + amount;
				fromAccount.setBalance(toNewBalance);
				
				System.out.println("Amount transfer sucessfully...!");
			
				System.out.println("Updated from account balance is" +fromAccount.getBalance());
				System.out.println("Updated to account balance is" +toaccount.getBalance());
			return true;
		}else {
			System.out.println("transfer failed. Insufficient Balance");
			return false;
		}
	}else {
		System.out.println("OTP validation failed");
		return false;
	}
	}
	@Override
	public boolean validateLogin(String accountNo, String password, UserAccount account) {
		if(accountNo.equals(account.getAccountNo()) && password.equals(account.getPassword())) {
		return true;
	}
     return false; 
	}
	@Override
	public int generateOtp() {
	OTPGenerator genertor = new OTPGenerator();
			return OTPGenerator.generateOtp();
	}

}
