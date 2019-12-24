import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProcessTrans {

	/**
	 * list of transactions
	 */
	private ArrayList<Transaction> transactions;

	/**
	 * an account
	 */
	private Account account;

	/**
	 * starting date of the statement period
	 */
	private Date startingDate;

	/**
	 * account file name
	 */
	private static final String ACCOUNT_FILE = "account.txt";

	/**
	 * transactions file name
	 */
	private static final String TRANSACTIONS_FILE = "transactions.txt";

	/**
	 * constructor
	 * 
	 * @param account      Account object
	 * @param startingDate starting date of the statement period
	 */
	public ProcessTrans(Account account, Date startingDate) {
		this.transactions = new ArrayList<>();
		this.account = account;
		this.startingDate = startingDate;
	}

	/**
	 * method called by the client to start the processing. Its main function is to
	 * load the data so that the transactions can be processed.
	 * 
	 * @throws IOException    if error
	 * @throws ParseException if parse error
	 */
	public boolean run() throws IOException, ParseException {

		// load account and transaction
		loadAccount(ACCOUNT_FILE);
		loadTransactions(TRANSACTIONS_FILE);

		// validate account and transactions
		if (account == null || transactions == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * list transactions
	 */
	public void listTransactions() {
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i).transDetails());
		}
	}

	/**
	 * make deposit
	 * 
	 * update balance of account and create transaction
	 * 
	 * @param amount          amount of deposit
	 * @param transactionDate date of the transaction
	 */
	public void makeDeposit(double amount, Date transactionDate) {

		account.makeDeposit(amount);

		Transaction trans = new Transaction('D', amount, transactionDate, account.getCurrentBal());
		transactions.add(trans);

		account.setLastStatementUsedDate(transactionDate);
	}

	/**
	 * make withdraw
	 * 
	 * @param amount          amount of withdrawal
	 * @param transactionDate date of the transaction
	 * @return true if success, false if not enough funds to withdraw the amount
	 */
	public boolean makeWithdraw(double amount, Date transactionDate) {

		// check enough balance
		if (account.getCurrentBal() < amount) {
			return false;
		}

		account.withdraw(amount);

		Transaction trans = new Transaction('W', amount, transactionDate, account.getCurrentBal());
		transactions.add(trans);

		account.setLastStatementUsedDate(transactionDate);

		return true;
	}

	/**
	 * write a cheque then update balance of account and create transaction assume
	 * that enough balance of cheque
	 * 
	 * @param amount          amount of withdrawal
	 * @param transactionDate date of the transaction
	 */
	public void writeCheque(double amount, Date transactionDate) {

		account.withdraw(amount);

		Transaction trans = new Transaction('C', amount, transactionDate, account.getCurrentBal());
		transactions.add(trans);

		// apply service charge
		if (account.getCurrentBal() < Account.getBalanceForService()) {
			account.processServiceCharge();

			trans = new Transaction('S', Account.getServiceCharge(), transactionDate, account.getCurrentBal());
			transactions.add(trans);
		}

		account.setLastStatementUsedDate(transactionDate);

	}

	/**
	 * Account Info Inquiry
	 */
	public void printAccountDetails() {

		account.print();
	}

	/**
	 * End of Statement Period Processes: Calculation of Interest End of Statement
	 * Period Report Completing the process
	 * 
	 * @param endDate date of the end of the period
	 */
	public void endStatementPeriodProcesses(Date endDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// Calculation of Interest
		double interest = account.calculateProcessInterest();

		Transaction trans = new Transaction('I', interest, endDate, account.getCurrentBal());
		transactions.add(trans);

		// End of Statement Period Report
		System.out.println("Monthly Statement as of " + sdf.format(endDate));
		System.out.println("Statement for " + account.getCustomerName() + ", Account #" + account.getAccNum());
		System.out.println();

		System.out.printf("%-12s %-16s   %14s $ %,.2f\n", startingDate, "Opening Balance", "",
				account.getOpeningBalance());

		for (int i = 0; i < transactions.size(); i++) {

			String type = ""; // transaction type

			if (transactions.get(i).getType() == 'D') {
				type = "Deposit";
			} else if (transactions.get(i).getType() == 'W') {
				type = "Withdrawal";
			} else if (transactions.get(i).getType() == 'C') {
				type = "Cheque";
			} else if (transactions.get(i).getType() == 'S') {
				type = "Service Charge";
			} else if (transactions.get(i).getType() == 'I') {
				type = "Interest";
			}

			System.out.printf("%-12s %-16s $ %,.2f $ %,.2f\n", sdf.format(transactions.get(i).getDate()), type,
					transactions.get(i).getAmount(), transactions.get(i).getBalance());
		}

	}

	/**
	 * end transaction
	 * 
	 * @throws IOException if file error
	 */
	public void endSession() throws IOException {

		saveAccount(ACCOUNT_FILE);
		saveTransactions(TRANSACTIONS_FILE);
	}

	/**
	 * load account from file
	 * 
	 * @param filename file name
	 * @throws IOException Write error
	 */
	public void loadAccount(String filename) throws IOException {

		String accountNumber; // account number
		String customerName; // Customer Name
		double currentBalance; // current balance

		Scanner in = new Scanner(new File(ACCOUNT_FILE));

		if (in.hasNextLine()) {
			accountNumber = in.nextLine();
			customerName = in.nextLine();
			currentBalance = in.nextDouble();

			account = new Account(accountNumber, customerName, currentBalance, null);
		}
		// close file
		in.close();
	}

	/**
	 * load transactions from file
	 * 
	 * @param filename file name
	 * @throws IOException    Write error
	 * @throws ParseException
	 */
	public void loadTransactions(String filename) throws IOException, ParseException {

		char code; // code for the transaction type
		double amount; // amount of the transaction
		Date date; // date that the transaction had taken place
		double balance; // new balance after transaction

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner in = new Scanner(new File(TRANSACTIONS_FILE));

		transactions = new ArrayList<>();

		// read transaction
		while (in.hasNext()) {
			code = in.next().charAt(0);
			date = sdf.parse(in.next());
			amount = in.nextDouble();
			balance = in.nextDouble();

			transactions.add(new Transaction(code, amount, date, balance));

			account.setLastStatementUsedDate(date);
		}

		// close file
		in.close();
	}

	/**
	 * save account to file
	 * 
	 * @param filename file name
	 * @throws IOException Write error
	 */
	public void saveAccount(String filename) throws IOException {

		// create FileWriter object
		PrintWriter out = new PrintWriter(filename);

		out.println(account.getAccNum());
		out.println(account.getCustomerName());
		out.println(account.getCurrentBal());

		// close file
		out.close();
	}

	/**
	 * save transactions to file
	 * 
	 * @param filename file name
	 * @throws IOException Write error
	 */
	public void saveTransactions(String filename) throws IOException {

		// create FileWriter object
		PrintWriter out = new PrintWriter(filename);

		for (int i = 0; i < transactions.size(); i++) {
			out.println(transactions.get(i).transDetails());
		}

		// close file
		out.close();
	}
}
