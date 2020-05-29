package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class BankTeller {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int accountNumber = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(accountNumber, holder, initialBalance, withdrawLimit);
		
		System.out.print("Enter amount for withdraw: ");
		double value = sc.nextDouble();
		
			account.withdraw(value);
			System.out.println("Balance updated: " + account.getBalance());
		} 
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error, try: \n1. The name is not filled with letters."
					+ "\n2. The number account is not filled with numbers." 
					+ "\n3. Balance or withdraw limit is not filled with numbers.");
		}
		
		sc.close();

	}

}
