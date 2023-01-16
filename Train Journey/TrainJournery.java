package java_programs;

import java.util.Scanner;


// Passenger's class with passenger's name and journey details
class Passenger
{
	String name;
	int age;
	String mobile;
	String source;
	String destination;
	String journeyDate;
	String seatClass;
	
	public Passenger(String name, int age, String mobile)
	{
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	public void journeyDetails(String journeyDate, String seatClass)
	{
		this.source = "RaeBareli";
		this.destination = "Gorakhpur";
		this.journeyDate = journeyDate;
		this.seatClass = seatClass;
	}
	
	public void journeyDetails(String source, String destination, String journeyDate, String seatClass)
	{
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.seatClass = seatClass;
	}
	
	// getter
	public String getName()
	{
		return name;
	}
	
	// Ticket Details
	public void ticketStatus()
	{
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\nCongratulations! "+this.name+" \nYour tickets from "+this.source+" to "+this.destination+" has been successfully booked.");
		System.out.println();
		System.out.println("***************************************");
		System.out.println("            Ticket Details             ");
		System.out.println("          ..................           ");
		System.out.println("  Source : "+this.source);
		System.out.println("  Destination : "+this.destination);
		System.out.println("  Journey Date : "+this.journeyDate);
		System.out.println("  Seat class: "+this.seatClass);
		System.out.println("  Passenger's Name : "+this.name);
		System.out.println("  Passenger's Age : "+this.age);
		System.out.println("***************************************");
		System.out.println();
		System.out.println();
	}
	
}


/* Train class aggregated with passenger class
   and composed with in-built features beverages Tea and Coffee. 
*/
class Train
{
	Passenger passenger;
	Beverages b;
	String trainName;
	
	// default constructor
	Train()
	{
		this.trainName = "Intercity";
	}
	
	// parameterized constructor
	Train(String trainName)
	{
		this.trainName = trainName;
	}
	
	// Journey Started...
	void getInTheTrain(Passenger passenger)
	{
		passenger.ticketStatus();
		System.out.println("Hey! "+passenger.getName()+" Enjoy your journey with "+this.trainName);
	}
	
	// Beverages
	void enjoyBeverages()
	{
		System.out.println("Want Beverage?");
		System.out.println("Choose from menu : -");
		System.out.println("0. No Thanks\n1. Tea\n2. Coffee");
		
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		if(choice == 1)
		{
			b = new Tea();
			b.getBeverage();
		}
		else if(choice == 2)
		{
			b = new Coffee();
			b.getBeverage();
		}
		else
		{
			System.out.println("Okay no worries Enjoy your Journey");
		}
		
		
	}
}


// Beverages abstract class
abstract class Beverages 
{
	private void addWater()
	{
		System.out.println("Adding hot water");
	}
	
	private void addMilk()
	{
		System.out.println("Adding some hot milk");
	}
	
	private void addSugar()
	{
		System.out.println("Adding Sugar");
	}
	
	public void getMixture()
	{
		System.out.println("Your Beverage is "+"getting ready...");
		addWater();
		addMilk();
		addSugar();
	}
	
	public abstract void getBeverage();
	
	public abstract void addIngredients();
}


// Interface to enforce to implement sub-classes Tea and Coffee, cleaing the pot.
interface Clean
{
	void cleanPot();
}


// sub-class Tea extends Beverages class
class Tea extends Beverages implements Clean
{
	public void addIngredients()
	{
		System.out.println("Tea Bag added");
	}
	
	public void getBeverage()
	{
		cleanPot();
		getMixture();
		addIngredients();
		System.out.println("Your Tea is Ready! Enjoy ");
		System.out.println("\n________________________________________________________________\n");
	}
	
	public void cleanPot()
	{
		System.out.println("\n________________________________________________________________\n");
		System.out.println("\nCleaning tea pot, cup and plates...");                          
	}
}


//sub-class Coffee extends Beverages class
class Coffee extends Beverages implements Clean
{
	public void addIngredients()
	{
		System.out.println("Coffee Bag added");
	}
	
	public void getBeverage()
	{
		cleanPot();
		getMixture();
		addIngredients();
		System.out.println("Your Coffee is Ready! Enjoy ");
		System.out.println("\n________________________________________________________________\n");
	}
	
	public void cleanPot()
	{
		System.out.println("\n________________________________________________________________\n");
		System.out.println("Cleaning Coffee pot, cup and plates...");
	}
}


// Main Train Journery Program
public class TrainJournery {

	public static void main(String[] args) {
		
		System.out.println("================================================================");
		System.out.println("=                    Welcome to Train Journey                  =");
		System.out.println("================================================================\n");
		
		// scanner class to take input
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("To start the train journey Enter the passenger's details");
		
		System.out.println("Enter your name :");
		String name = scanner.next();
		
		System.out.println("Enter your age :");
		int age = scanner.nextInt();
		
		System.out.println("Enter your mobile number :");
		String mobile = scanner.next();
		
		System.out.println("\n----------------------------------------------------------------\n");
		
		// object of passenger class
		Passenger p = new Passenger(name,age,mobile);
		
		System.out.println("Enter the journey details");
		System.out.println("Choose Source and Destination :");
		System.out.println("1.Raebareli to Gorakhpur \n2.Others");
		int choice = scanner.nextInt();
		
		
		if(choice == 1)
		{
			System.out.println("Enter the date of journey (dd/mm/yyyy) : ");
			String date = scanner.next();
			
			System.out.println("Enter the class (1AC, 2AC, 3AC, SL, 2S)");
			String cl = scanner.next();
			
			p.journeyDetails(date,cl);
		}
		else if(choice == 2)
		{
			System.out.println("Enter source :");
			String source = scanner.next();
			
			System.out.println("Enter destination :");
			String destination = scanner.next();
			
			System.out.println("Enter the date of journey (dd/mm/yyyy) : ");
			String date = scanner.next();
			
			System.out.println("Enter the class (1AC, 2AC, 3AC, SL, 2S");
			String cl = scanner.next();
			
			p.journeyDetails(source, destination, date, cl);
		}
		
		
		System.out.println("Choose the train by which you want to travel");
		System.out.println("1.Intercity \n2.Others");
		int tchoice = scanner.nextInt();
		
		
		if(tchoice == 1)
		{
			// object of train class
			Train t = new Train();
			
			t.getInTheTrain(p);
			t.enjoyBeverages();
		}
		else if(tchoice == 2)
		{
			System.out.println("Enter the train name :");
			String tname = scanner.next();
			//object of train class
			Train t = new Train(tname);
			
			t.getInTheTrain(p);
			t.enjoyBeverages();
		}
		
		System.out.println("Your Destination will arrives in few hours till then Take Care");
		
	}

}
