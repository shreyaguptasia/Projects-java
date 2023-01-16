package java_programs;

import java.util.*;


public class BankingApplication {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the customer name :");
		String name = scanner.next();
		
		System.out.println("Enter customer Id :");
		String id = scanner.next();
		
		BankAccount user = new BankAccount(name, id);
		user.showMenu();
	}

}


class BankAccount
{
	int balance;
	int prevTrans;
	String customerName;
	String customerId;

	
	BankAccount(String custName, String custID)
	{
		customerName = custName;
		customerId = custID;
	}
	
	void deposit(int amount)
	{
		if(amount !=0)
		{
			balance += amount;
			prevTrans = amount;
		}
	}
	
	void withdraw(int amount)
	{
		if(amount!=0)
		{
			balance -= amount;
			prevTrans = -amount;
		}
	}
	
	void getPrevTrans()
	{
		if(prevTrans > 0)
		{
			System.out.println("Deposited: "+prevTrans);
		}
		else if(prevTrans < 0)
		{
			System.out.println("Withdrawn: "+Math.abs(prevTrans));
		}
		else 
		{
			System.out.println("No transaction");
		}
	}
	
	void showMenu()
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello! "+customerName);
		System.out.println("Your Id is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdrawn");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("================================================");
			System.out.println("Enter an option");
			System.out.println("================================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'A':
				System.out.println("--------------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("--------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("--------------------------------------------");
				System.out.println("Enter an amount to deposit");
				System.out.println("--------------------------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("--------------------------------------------");
				System.out.println("Enter an amount to withdraw");
				System.out.println("--------------------------------------------");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("--------------------------------------------");
				getPrevTrans();
				System.out.println("--------------------------------------------");
				System.out.println("\n");
				break;
			
			case 'E':
				System.out.println("********************************************");
				break;
				
			default:
				System.out.println("Invalid Option!. Please enter again ");
				break;
			}
		}while(option != 'E');
		
		System.out.println("Thanks for Visiting");
		
	}
}

