import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	/**
	 * type for the transaction type
	 */
	private char type;

	/**
	 * amount of the transaction
	 */
	private double amount;

	/**
	 * date that the transaction had taken place
	 */
	private Date date;

	/**
	 * new balance after transaction
	 */
	private double balance;

	/**
	 * default constructor
	 * 
	 */
	public Transaction() {
		this.type = ' ';
		this.amount = 0;
		this.date = new Date();
	}

	/**
	 * constructor
	 * 
	 * @param type   type for the transaction type
	 * @param amount amount of the transaction
	 * @param date   date that the transaction had taken place
	 */
	public Transaction(char type, double amount, Date date, double balance) {
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.balance = balance;
	}

	/**
	 * Accessors of type
	 * 
	 * @return type for the transaction type
	 */
	public char getType() {
		return type;
	}

	/**
	 * Accessors of amount
	 * 
	 * @return amount of the transaction
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Accessors of date
	 * 
	 * @return date that the transaction had taken place
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Accessors of balance
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Mutator
	 * 
	 * @param type   type for the transaction type
	 * @param amount amount of the transaction
	 * @param date   date that the transaction had taken place
	 */
	public void setValues(char type, double amount, Date date) {
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	/**
	 * method returns the string that contains the details of the transaction
	 * 
	 * @return transaction details
	 */
	public String transDetails() {

		// date formatter
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return type + " " + sdf.format(date) + " " + String.format("%,.2f", amount) + " "
				+ String.format("%,.2f", balance);
	}
}
