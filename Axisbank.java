package com.demo;

import java.util.Scanner;

public class Axisbank extends Thread {
	public void run() {
		System.out.println("Welcome to " + getName() + " ATM");
	}

	public void Card() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your card number");
		long cardNumber = sc.nextLong();
		if (cardNumber > 9999 && cardNumber < 999999999l) {
			System.out.println("Axis bank account");
			System.out.println("1.Biomatric 2.Process with card");
			System.out.println("Enter your choice by pressing 1 or 2");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Scann your fingurprint");
				cashWithdrawal();
				break;

			case 2:
				pin();
				break;
			}
		} else {
			System.out.println("Other bank account");
			pin();

		}
	}

	public void pin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your pin:");
		int pin = sc.nextInt();
		int attempts = 1;
		boolean pinCorrect = false;
		while (attempts <= 3 && !pinCorrect) {
			if (pin > 999 && pin < 9999) {
				cashWithdrawal();
				pinCorrect = true;
			} else {
				System.out.println("Incorrect pin. Try again.");
				if (attempts < 3) {
					System.out.println("Enter your pin:");
					pin = sc.nextInt();
				}
				attempts++;
			}
		}
		if (!pinCorrect) {
			System.out.println("Multiple incorrect pin attempts. Card blocked.");
		}
	}

	public void cashWithdrawal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to withdraw");
		double amount = sc.nextDouble();
		System.out.println("Processing...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Collect cash");
		System.out.println("Thank you");

	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
		Axisbank atm = new Axisbank();
		atm.setName("Axis Bank");
		atm.start();
		atm.Card();

	}
}
