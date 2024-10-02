package userinterface;

import entity.Account;
import operations.AccountOperation;
import validation.AccountValidation;
import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {

		Account account1 = new Account();
		Account account2 = new Account();
		AccountOperation accountOperation = new AccountOperation();
		AccountValidation accountValidation = new AccountValidation();

		int ch;
		String choice;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("|    ICICI Bank    |");
			System.out.println("|------------------|");
			System.out.println("|1. Accept Details |");
			System.out.println("|2.Display  Details|");
			System.out.println("|3.Withdraw Amount |");
			System.out.println("|4.Deposit Amount  |");
			System.out.println("|5.Transfer Amount |");
			System.out.println("|6.Check balance   |");
			System.out.println("|7.update balance  |");
			System.out.println("|8.exit            |");
			System.out.println("--------------------");
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("----------------------");
				System.out.println("Enter accno,holderName, balance");
				int accNo = sc.nextInt();
				String accHolderName = sc.next();
				double balance = sc.nextDouble();

				// validaring the i/ps

				boolean result2 = accountValidation.checkAll(accNo, accHolderName, balance);
				if (result2 == true) {
					System.out.println("all  inputs valid..!!!");
					account1.setAccNo(accNo);
					account1.setAccHolder(accHolderName);
					account1.setBalance(balance);

				} else {
					System.out.println("Invalid Inputs");
				}
				break;

			case 2:
				System.out.println("----------------------");
				System.out.println("Displaying details");
				System.out.println("accNo is " + account1.getAccNo());
				System.out.println("name " + account1.getAccHolder());
				System.out.println("balance is " + account1.getBalance());

				break;
			case 3:
				System.out.println("----------------------");
				System.out.println("Enter Amount to Withdraw ");
				double amount = sc.nextInt();
				boolean result = accountOperation.withdraw(account1, amount);
				if (result == true) {
					System.out.println("Withdraw is Successful...!!!");
					System.out.println("The New Balance is" + account1.getBalance());
					System.out.println("----------------------");
				} else
					System.out.println("Withdraw is failed...");

				break;
			case 4:
				System.out.println("----------------------");
				System.out.println("Enter Amount to Deposit");
				amount = sc.nextDouble();
				result = accountOperation.deposit(account1, amount);
				if (result == true) {
					System.out.println("Deposit is Successful...!!!");
					System.out.println("the New Balance is" + account1.getBalance());
					System.out.println("----------------------");
				} else
					System.out.println("Deposit is failed...");

				break;
			case 5:
				System.out.println("----------------------");

				System.out.println("Enter accno,holderName, balance");
				accNo = sc.nextInt();
				accHolderName = sc.next();
				balance = sc.nextDouble();

				// validaring the i/ps

				result2 = accountValidation.checkAll(accNo, accHolderName, balance);
				if (result2 == true) {
					System.out.println("all  inputs valid..!!!");
					account2.setAccNo(accNo);
					account2.setAccHolder(accHolderName);
					account2.setBalance(balance);

				} else {
					System.out.println("Invalid Inputs");
				}

				System.out.println("Enter the Amount to Transfer ");
				amount = sc.nextDouble();
				System.out.println("account 1 balance is" + account1.getBalance());
				System.out.println("account 2 balance is" + account2.getBalance());
				System.out.println("----------------------");
				result = accountOperation.transfer(account1, account2, amount);
				if (result == true) {
					System.out.println("Transfer is Successful...!!!");
					System.out.println("account1 new balance is" + account1.getBalance());
					System.out.println("account2 new balance is" + account2.getBalance());
				} else
					System.out.println("Trasnfer is failed...");

				break;
			case 6:
				System.out.println("----------------------");

				System.out.println("the balance is" + account1.getBalance());

				break;

			case 7:
				System.out.println("----------------------");
				System.out.println("Enter new Balance");
				balance = sc.nextDouble();
				account1.setBalance(balance);
				System.out.println("Updated the Balance");
				System.out.println(account1);

				break;
			case 8:
				System.out.println("Thank you for visiting.....!!!!");

				System.exit(0);

			}
			System.out.println("Do you want to continue yes/no");
			choice = sc.next();

		} while (choice.equalsIgnoreCase("Y"));
		System.out.println("Thank you for visiting.....!!!!");

	}

}
