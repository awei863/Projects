
public class HourlyEmployee extends Employee {

	/**
	 * hourly pay rate
	 */
	private double hourlyPayRate;

	/**
	 * hours worked this week
	 */
	private double workedHours;

	/**
	 * constructor
	 */
	public HourlyEmployee() {
		this.hourlyPayRate = 0;
		this.workedHours = 0;
		this.type = 'H';
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
	public HourlyEmployee(String name, String number, String department, double hourlyPayRate, double workedHours) {
		super(name, number, department);
		this.hourlyPayRate = hourlyPayRate;
		this.workedHours = workedHours;
		this.type = 'H';
	}

	/**
	 * getter of hourly pay rate
	 * 
	 * @return the hourly pay rate
	 */
	public double getHourlyPayRate() {
		return hourlyPayRate;
	}

	/**
	 * setter of hourlyPayRate
	 * 
	 * @param hourlyPayRate the hourly pay rate
	 */
	public void setHourlyPayRate(double hourlyPayRate) {
		this.hourlyPayRate = hourlyPayRate;
	}

	/**
	 * get worked hours for this week
	 * 
	 * @return the worked hours
	 */
	public double getWorkedHours() {
		return workedHours;
	}

	/**
	 * setter of worked hours
	 * 
	 * @param workedHours worked hours this week
	 */
	public void setWorkedHours(double workedHours) {
		this.workedHours = workedHours;
	}

	/**
	 * calculate the weekly salary
	 * 
	 * @return the weekly salary
	 */
	public double calcWeeklySalary() {

		double amount = 0; // salary

		amount = workedHours * hourlyPayRate;

		// part time
		if (workedHours > 40) {
			amount += (workedHours - 40) * 0.5 * hourlyPayRate;
		}

		return amount;
	}

	/**
	 * get the string representing the data to write
	 * 
	 * @return string representing the data to write
	 */
	public String writeData() {

		// Sally 333-333-333 Finance H 15.75 0.0
		return getName() + " " + getNumber() + " " + getDepartment() + " " + getType() + " "
				+ String.format("%.2f", hourlyPayRate) + " " + String.format("%.2f", workedHours);
	}

	/**
	 * return a string representing this employee
	 */
	@Override
	public String toString() {
		return super.toString() + "\nHourly pay rate (%): " + String.format("%.2f", hourlyPayRate) + "\nHoured worked: "
				+ String.format("%.2f", workedHours);
	}
}
