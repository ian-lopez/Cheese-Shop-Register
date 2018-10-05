import java.util.Scanner;

public class Shop 
{
	static int choice;
	static int answer;
	static int [] amount;
	static String [] products;
	static double [] prices;
	static double discount;
	static double discountRate;
	static double [] productAmounts;
	static double preTotal;

	//Creating place for beginning user input
	public static void intro()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("This program supports 4 functions:");
		System.out.println("\t1. Setup Shop");
		System.out.println("\t2. Buy");
		System.out.println("\t3. List Items");
		System.out.println("\t4. Checkout");
		System.out.print("Please choose the function you want: ");
		choice = input.nextInt();
		System.out.println();
	}

	//Stores all of the information for the products being purchased
	public static void setupShop()
	{
		Scanner input = new Scanner (System.in);
		System.out.print("Please enter the number of items: ");
		answer = input.nextInt();
		amount = new int [answer];
		products = new String [answer];
		prices = new double [answer];

		for(int i = 0; i < amount.length; i++)
		{
			System.out.print("Enter name of product " + i + ": ");
			products[i] = input.next();
			System.out.print("Enter price of product " + i + ": ");
			prices[i] = input.nextDouble();
		}
		System.out.print("Please enter the amount to qualify for discount: ");
		discount = input.nextDouble();

		System.out.print("Please enter the discount rate (0.1 for 10%): ");
		discountRate = input.nextDouble();
	}

	//Gathers the amount of the product that is requested
	public static void buy(String [] products)
	{
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < products.length; i++)
		{
			System.out.print("Enter the amount of " + products[i] + ": ");
			amount[i] = input.nextInt();
		}
	}

	//Displays the items along with the prices
	public static void listItems(String [] products, double [] prices, int [] amount)
	{
		productAmounts = new double [answer];
		for(int i = 0; i < productAmounts.length; i++)
		{
			if(amount[i] > 0)
			{
				productAmounts[i] = amount[i] * prices[i];
				System.out.println(amount[i] + " counts of " + products[i] + " @ " + prices[i] + " = $" + productAmounts[i]);
			}
		}
	}

	//Produces subtotal
	public static double subTotal(double [] productAmounts)
	{
		double preTotal = 0.0;
		for(int i = 0; i < productAmounts.length; i++)
		{
			preTotal += productAmounts[i];
		}
		return preTotal;
	}

	//Projecting the final total
	public static void checkout(double preTotal, double discount, double discountRate)
	{
		double discountAmount = 0.0;
		double total;

		System.out.println("Thanks for coming!");
		System.out.println("SubTotal: " + preTotal);

		if(preTotal >= discount)
			discountAmount = preTotal * discountRate;
		total = preTotal - discountAmount;

		System.out.println("-Discount: " + discountAmount);
		System.out.println("Total: \t" + total);
	}

	//Ensuring that all properties are met
	//Cannot move on to method without doing all prior methods
	public static void fullProof()
	{
		while(true)
		{
			if(choice >= 1 && choice <= 4)
			{
				if(choice == 1)
				{
					setupShop();
					break;
				}
				else if (choice > 1 && choice <= 4)
				{
					System.out.println("You have not set up shop yet!");
					intro();
					continue;
				}
			}
			if(choice < 1 || choice > 4)
			{
				System.out.println("Do not know " + choice);
				intro();
				continue;
			}
		}
		intro();
		while(true)
		{
			if(choice >= 1 && choice <= 4)
			{
				if(choice == 1)
				{
					setupShop();
					intro();
					continue;
				}
				if(choice == 2)
				{
					buy(products);
					break;
				}
				if(choice == 3 || choice == 4)
				{
					System.out.println("You have not bought anything yet!");
					intro();
					continue;
				}
			}
			if(choice < 1 || choice > 4)
			{
				System.out.println("Do not know " + choice);
				intro();
				continue;
			}
		}
		intro();
		while(true)
		{
			if(choice >= 1 || choice <= 4)
			{
				if(choice == 1)
				{
					setupShop();
					intro();
					continue;
				}
				if(choice == 2)
				{
					buy(products);
					intro();
					continue;
				}
				if(choice == 3)
				{
					listItems(products, prices, amount);
					intro();
					break;
				}
				if(choice == 4)
				{
					System.out.println("You have not listed anything yet!");
					continue;
				}
			}
			if(choice < 0 || choice > 4)
			{
				System.out.println("Do not know " + choice);
				intro();
				continue;
			}
		}
		while(true)
		{
			if(choice >= 1 || choice <= 4)
			{
				if(choice == 1)
				{
					setupShop();
					intro();
					continue;
				}
				if(choice == 2)
				{
					buy(products);
					intro();
					continue;
				}
				if(choice == 3)
				{
					listItems(products, prices, amount);
					continue;
				}
				if(choice == 4)
				{
					preTotal = subTotal(productAmounts);
					checkout(preTotal, discount, discountRate);
					break;
				}
			}
			else
			{
				System.out.println("Do not know " + choice);
				intro();
				continue;
			}
		}
	}

	public static void main(String[] args) 
	{
		intro();
		fullProof();
	}
}