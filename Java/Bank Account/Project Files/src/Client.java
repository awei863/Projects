import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Client {
	
	/**
	 * date formatter
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * scanner object to read from standard input
	 */
	private static Scanner kbd = new Scanner(System.in);
	
	/**
	 * display main menu
	 */
	public static void mainMenu(){
		System.out.println("MAIN MENU:");
		System.out.println("   1) Account information inquiry");
		System.out.println("   2) Customer menu");
		System.out.println("   3) Print transactions");
		System.out.println("   4) End of Period Processing");
		System.out.println("   5) Exit");
	}
	
	/**
	 * display customer menu
	 */
	public static void customerMenu(){
		System.out.println("CUSTOMER MENU:");
		System.out.println("   1) Depositing to the account");
		System.out.println("   2) Withdrawing funds from the account");
		System.out.println("   3) Writing a cheque");
		System.out.println("   4) Return to Main Menu");
	}
	
	/**
	 * process customer menu 
	 * @param processTransaction ProcessTrans object
	 * @throws ParseException if parse error
	 */
	public static void processCustomerMenu(ProcessTrans processTransaction) throws ParseException{
				
		//display customer menu
		customerMenu();
		
		//read user selection
		int userSelection = kbd.nextInt();
		kbd.nextLine();
		
		Date date; //transaction date
		double amount; //transaction amount
		
		while (userSelection != 4){
			
			switch (userSelection) {
			case 1://Depositing to the account
				
				//read transaction date
				System.out.println("Please enter transaction date (dd/mm/yyyy): ");
				date = sdf.parse(kbd.nextLine());
				
				//read amount
				System.out.println("Please enter amount: ");
				amount = kbd.nextDouble();
				kbd.nextLine();
				
				processTransaction.makeDeposit(amount, date);
				
				System.out.println("Deposit transaction successfully");
				
				break;
			case 2://Withdrawing funds from the account
				
				//read transaction date
				System.out.println("Please transaction date (dd/mm/yyyy): ");
				date = sdf.parse(kbd.nextLine());
				
				//read amount
				System.out.println("Please enter amount: ");
				amount = kbd.nextDouble();
				kbd.nextLine();
				
				if (processTransaction.makeWithdraw(amount, date)){
					System.out.println("Withdrawing transaction successfully");
				}else{
					System.out.println("Not enought balance for withdrawing transaction");
				}
				
				break;
			case 3://Writing a cheque
				
				//read transaction date
				System.out.println("Please enter transaction date (dd/mm/yyyy): ");
				date = sdf.parse(kbd.nextLine());
				
				//read amount
				System.out.println("Please enter amount: ");
				amount = kbd.nextDouble();
				kbd.nextLine();
				
				processTransaction.writeCheque(amount, date);
				
				System.out.println("Writing a cheque transaction successfully");
				
				break;
			case 4://Return to Main Menu
				
				break;				
			default:
				System.out.println("Invalid selection");
				break;
			}
			System.out.println();
			
			//display customer menu
			customerMenu();
			
			//read user selection
			userSelection = kbd.nextInt();
			kbd.nextLine();
			
		}
	}
	

	/**
	 * process main menu 
	 * 
	 * @param processTransaction ProcessTrans object
	 * @throws ParseException if parse error
	 */
	public static void processMainMenu(ProcessTrans processTransaction) throws ParseException{
		
		//display main menu
		mainMenu();
		
		//read user selection
		int userSelection = kbd.nextInt();
		kbd.nextLine();
		
		Date date; //date of the end of the period
		
		while (userSelection != 5){
			
			switch (userSelection) {
			case 1://Account information inquiry
				
				processTransaction.printAccountDetails();
				
				break;
			case 2://Customer menu
				
				processCustomerMenu(processTransaction);
				
				break;
			case 3://Print transactions
				
				processTransaction.listTransactions();
				
				break;
			case 4://End of Period Processing
				
				//read starting date
				System.out.println("Please enter the date of the end of the period (dd/mm/yyyy): ");
				date = sdf.parse(kbd.nextLine());
				
				processTransaction.endStatementPeriodProcesses(date);
				
				break;
			case 5://Exit
				
				break;				
			default:
				System.out.println("Invalid selection");
				break;
			}
			System.out.println();
			
			//display main menu
			mainMenu();
			
			//read user selection
			userSelection = kbd.nextInt();
			kbd.nextLine();
			
		}
	}
	
	/**
	 * main method to start Java application
	 */
	public static void main(String[] args) throws ParseException, IOException {
		//account
		Account account = null;
		
		//create account?
		System.out.println("Do you want to create new account? [y/n] ");
		String choice = kbd.nextLine(); //choose y or n
		
		if (choice.equalsIgnoreCase("y")){
			
			//account details
			String accountNumber;
			String customerName; 
			double startingBalance;
			
			//read account number
			System.out.println("Please enter account number: ");
			accountNumber = kbd.nextLine();
			
			//read customer name
			System.out.println("Please enter customer name: [e.g. John Doe]");
			customerName = kbd.nextLine();
			
			//read startingBalance
			System.out.println("Please enter opening balance: ");
			startingBalance = kbd.nextDouble();
			kbd.nextLine();
			
			account = new Account(accountNumber, customerName, startingBalance, null);
		}
		
		//read starting date
		System.out.println("Please enter the starting date (dd/mm/yyyy): ");
		Date startingDate;
		startingDate = sdf.parse(kbd.nextLine());
		
		//create object to process transactions
		ProcessTrans processTransaction = new ProcessTrans(account, startingDate);
		
		if (!choice.equalsIgnoreCase("y")){
			
			//load from file
			if (!processTransaction.run()){				
				System.out.println("Could not process transaction on empty account");	
				return;
			}
		}
	
		//main menu
		processMainMenu(processTransaction);		
		
		processTransaction.endSession();
		
		System.out.println("Thank you for using the system");		
	}
}
