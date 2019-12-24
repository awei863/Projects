
public class CommissionEmployee extends Employee {

	/**
	 * number of weeks since start of year or employment
	 */
	private int numWeeks;

	/**
	 * base weekly salary
	 */
	private double weeklySalary;

	/**
	 * sales this week
	 */
	private double sales;

	/**
	 * sales so far this year but not including this week
	 */
	private double allSales;

	/**
	 * commission rate
	 */
	private double commissionRate;

	/**
	 * constructor
	 */
	public CommissionEmployee() {
		this.numWeeks = 0;
		this.weeklySalary = 0;
		this.sales = 0;
		this.allSales = 0;
		this.commissionRate = 0;
		this.type = 'C';
	}

	/**
	 * constructor
	 * 
	 * @param name           name of employee
	 * @param number         employee number
	 * @param department     department where the employee works
	 * @param numWeeks       number of weeks since start of year or employment
	 * @param weeklySalary   base weekly salary
	 * @param allSales       all sales
	 * @param commissionRate commission rate
	 */
	public CommissionEmployee(String name, String number, String department, int numWeeks, double weeklySalary,
			double allSales, double commissionRate) {
		super(name, number, department);
		this.numWeeks = numWeeks;
		this.weeklySalary = weeklySalary;
		this.allSales = allSales;
		this.commissionRate = commissionRate;

		this.sales = 0;
		this.type = 'C';
	}

	/**
	 * getter of numWeeks
	 * 
	 * @return number of weeks since start of year or employment
	 */
	public int getNumWeeks() {
		return numWeeks;
	}

	/**
	 * setter of numWeeks
	 * 
	 * @param numWeeks number of weeks since start of year or employment
	 */
	public void setNumWeeks(int numWeeks) {
		this.numWeeks = numWeeks;
	}

	/**
	 * setter of allSales
	 * 
	 * @param allSales sales so far this year but not including this week
	 */
	public void setAllSales(double allSales) {
		this.allSales = allSales;
	}

	/**
	 * getter of weeklySalary
	 * 
	 * @return base weekly salary
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	}

	/**
	 * setter of weeklySalary
	 * 
	 * @param weeklySalary base weekly salary
	 */
	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	/**
	 * getter of the sales
	 * 
	 * @return sales this week
	 */
	public double getSales() {
		return sales;
	}

	/**
	 * setter of sales
	 * 
	 * @param sales sales this week
	 */
	public void setSales(double sales) {
		this.sales = sales;
	}

	/**
	 * getter of allSales
	 * 
	 * @return sales so far this year but not including this week
	 */
	public double getAllSales() {
		return allSales;
	}

	/**
	 * getter of commissionRate
	 * 
	 * @return commission rate
	 */
	public double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * setter of commissionRate
	 * 
	 * @param commission rate
	 */
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	/**
	 * calculate the weekly salary
	 * 
	 * @return the weekly salary
	 */
	public double calcWeeklySalary() {

		double amount = weeklySalary; // base salary

		// commission paid on weekly sales
		amount += sales * commissionRate / 100.0;

		return amount;
	}

	/**
	 * check if this employee is top seller
	 * 
	 * a person is a member of the Top Seller's Club if the sales this year are more
	 * than $1,500 / week. This includes all weeks from the beginning of the year.
	 * 
	 * @return true/false
	 */
	public boolean topSeller() {
		if (numWeeks > 0) {

			// average of each week
			double avgWeekSales = allSales / numWeeks;
			if (avgWeekSales < 1500) {
				return false;
			}
		}

		return sales > 1500;
	}

	/**
	 * get the string representing the data to write
	 * 
	 * @return string representing the data to write
	 */
	public String writeData() {

		// Bobby 111-111-111 Appliances C 10,300 0.0 10000 10.0
		return getName() + " " + getNumber() + " " + getDepartment() + " " + getType() + " " + getNumWeeks() + " "
				+ String.format("%.2f", weeklySalary) + " " + String.format("%.2f", sales) + " "
				+ String.format("%.2f", allSales) + " " + String.format("%.2f", commissionRate);
	}

	/**
	 * return a string representing this employee
	 */
	@Override
	public String toString() {
		return super.toString() + "\nNumber of weeks since start of year or employment: " + numWeeks
				+ "\nBase weekly salary: " + String.format("%.2f", weeklySalary) + "\nSales this week: "
				+ String.format("%.2f", sales) + "\nSales so far this year but not including this week: "
				+ String.format("%.2f", allSales) + "\nCommission rate: " + String.format("%.2f", commissionRate);
	}
}
