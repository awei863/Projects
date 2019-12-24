import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {

	/**
	 * Daily Interest Rate interest rate that is used to calculate the interest
	 * earned by the account during the statement period,
	 */
	private static double interestRate = 0.25; // %

	/**
	 * Required balance for interest to be paid balance required before interest is
	 * paid daily interest rate
	 */
	private static double balanceForInterest = 700.00;

	/**
	 * Required balance for Service Charge balance required before a service charge
	 */
	private static double balanceForService = 1000.00;

	/**
	 * Service Charge
	 */
	private static double serviceCharge = 4.50;

	/**
	 * Account Number
	 */
	private String accNum;

	/**
	 * Customer Name
	 */
	private String customerName;

	/**
	 * current balance
	 */
	private double currentBal;

	/**
	 * balance at the start of this statement period
	 */
	private double startingBal;

	/**
	 * minimum balance for this statement period
	 */
	private double minBal;

	/**
	 * date of the last statement issued
	 */
	private Date lastStatementUsedDate;

	/**
	 * starting balance (opening balance)
	 */
	private double openingBalance;

	/**
	 * lowest balance
	 */
	private double lowestBalance;

	/**
	 * constructor
	 * 
	 * @param accountNumber         Account Number
	 * @param customerName          Customer Name
	 * @param startingBalance       starting balance
	 * @param lastStatementUsedDate date of the last statement issued
	 */
	public Account(String accNum, String customerName, double startingBal, Date lastStatementUsedDate) {
		this.accNum = accNum;
		this.customerName = customerName;
		this.openingBalance = startingBal;
		this.lastStatementUsedDate = lastStatementUsedDate;

		this.currentBal = openingBalance;
		this.lowestBalance = openingBalance;
	}

	/**
	 * constructor
	 * 
	 * @param accountNumber               Account Number
	 * @param customerName                Customer Name
	 * @param startingBalance             starting balance
	 * @param startStatementPeriodBalance balance at the start of this statement
	 *                                    period
	 * @param statementPeriodMinBalance   minimum balance for this statement period
	 * @param lastStatementUsedDate       date of the last statement issued
	 */
	public Account(String accNum, String customerName, double startingBal, double openingBal, double minBal,
			Date lastStatementUsedDate) {
		this.accNum = accNum;
		this.customerName = customerName;
		this.openingBalance = startingBal;
		this.startingBal = openingBal;
		this.minBal = minBal;
		this.lastStatementUsedDate = lastStatementUsedDate;

		this.currentBal = openingBalance;
		this.lowestBalance = openingBalance;
	}

	/**
	 * accessor method of interestRate
	 * 
	 * @return Daily Interest Rate
	 */
	public static double getInterestRate() {
		return interestRate;
	}

	/**
	 * accessor method of iterestRequiredBalance
	 * 
	 * @return Required balance for interest to be paid
	 */
	public static double getBalanceForInterst() {
		return balanceForInterest;
	}

	/**
	 * accessor method of serviceChargeRequiredBalance
	 * 
	 * @return Required balance for Service Charge
	 */
	public static double getBalanceForService() {
		return balanceForService;
	}

	/**
	 * accessor method of serviceCharge
	 * 
	 * @return Service Charge
	 */
	public static double getServiceCharge() {
		return serviceCharge;
	}

	/**
	 * accessor method of accountNumber
	 * 
	 * @return Account Number
	 */
	public String getAccNum() {
		return accNum;
	}

	/**
	 * accessor method of customerName
	 * 
	 * @return Customer Name
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * accessor method of currentBalance
	 * 
	 * @return current balance
	 */
	public double getCurrentBal() {
		return currentBal;
	}

	/**
	 * accessor method of startStatementPeriodBalance
	 * 
	 * @return balance at the start of this statement period
	 */
	public double getStartingBal() {
		return startingBal;
	}

	/**
	 * accessor method of statementPeriodMinBalance
	 * 
	 * @return minimum balance for this statement period
	 */
	public double getMinBal() {
		return minBal;
	}

	/**
	 * accessor method of lastStatementUsedDate
	 * 
	 * @return date of the last statement issued
	 */
	public Date getLastStatementUsedDate() {
		return lastStatementUsedDate;
	}

	/**
	 * accessor method of openingBalance
	 * 
	 * @return opening balance
	 */
	public double getOpeningBalance() {
		return openingBalance;
	}

	/**
	 * mutator method of customerName
	 * 
	 * @param customer name
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * set last statement used date
	 * 
	 * @param date a date
	 */
	public void setLastStatementUsedDate(Date date) {
		lastStatementUsedDate = date;
	}

	/**
	 * make a deposit
	 * 
	 * @param amount amount of deposit
	 */
	public void makeDeposit(double amount) {
		currentBal = currentBal + amount;
	}

	/**
	 * Withdrawing from the account
	 * 
	 * update the lowest balance if appropriate
	 * 
	 * @param amount amount of withdrawal
	 */
	public void withdraw(double amount) {
		currentBal = currentBal - amount;
		if (lowestBalance > currentBal) {
			lowestBalance = currentBal;
		}
	}

	/**
	 * process a service charge
	 * 
	 * @param amount amount of service charge
	 */
	public void processServiceCharge() {
		currentBal = currentBal - serviceCharge;
	}

	/**
	 * calculate and process the interest
	 * 
	 * @return interest amount
	 */
	public double calculateProcessInterest() {

		// interest amount
		double interest = 0;

		if (currentBal >= balanceForInterest) {
			interest = lowestBalance * interestRate / 100.0;
			currentBal = lowestBalance + interest;
		}

		return interest;
	}

	/**
	 * helper method prints out the details of the account
	 */
	public void print() {

		// date formatter
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Account Number:       " + accNum);
		System.out.println("Customer Name:        " + customerName);
		System.out.printf("Current Balance:      $ %,.2f\n", currentBal);
		System.out.printf("Opening Balance:      $ %,.2f\n", openingBalance);
		System.out.printf("Lowest Balance:       $ %,.2f\n", lowestBalance);
		if (lastStatementUsedDate == null) {
			System.out.println("Last Statement Date:  ");
		} else {
			System.out.println("Last Statement Date:  " + sdf.format(lastStatementUsedDate));
		}
	}

}
