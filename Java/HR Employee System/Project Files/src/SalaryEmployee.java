
public class SalaryEmployee extends Employee {

	/**
	 * yearly salary
	 */
	private double yearlySalary;

	/**
	 * constructor
	 */
	public SalaryEmployee() {
		this.yearlySalary = 0;
		this.type = 'S';
	}

	/**
	 * constructor
	 * 
	 * @param name          name of employee
	 * @param number        employee number
	 * @param department    department where the employee works
	 * @param hourlyPayRate hourly pay rate
	 * @param workedHours   hours worked this week
	 */
	public SalaryEmployee(String name, String number, String department, double yearlySalary) {
		super(name, number, department);
		this.yearlySalary = yearlySalary;
		this.type = 'S';
	}

	/**
	 * getter of yearly salary
	 * 
	 * @return the yearly salary
	 */
	public double getYearlySalary() {
		return yearlySalary;
	}

	/**
	 * setter of yearly salary
	 * 
	 * @param yearlySalary yearly salary
	 */
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	/**
	 * calculate the weekly salary
	 * 
	 * @return the weekly salary
	 */
	public double calcWeeklySalary() {

		double amount = yearlySalary / 52; // salary
		return amount;
	}

	/**
	 * get the string representing the data to write
	 * 
	 * @return string representing the data to write
	 */
	public String writeData() {

		// Arnie 222-222-222 Human Resources S 52000
		return getName() + " " + getNumber() + " " + getDepartment() + " " + getType() + " "
				+ String.format("%.2f", yearlySalary);
	}

	/**
	 * return a string representing this employee
	 */
	@Override
	public String toString() {
		return super.toString() + "\nYearly salary: " + yearlySalary;
	}
}
