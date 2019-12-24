import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Payroll {

	/**
	 * list of all employees
	 */
	private ArrayList<Employee> employees;

	/**
	 * constructor
	 */
	public Payroll() {
		employees = new ArrayList<>();
	}

	/**
	 * load data from file
	 * 
	 * @param filename file name
	 * @throws FileNotFoundException file not found
	 */
	public void load(String filename) throws FileNotFoundException {

		// create Scanner object to read file
		Scanner in = new Scanner(new File(filename));
		Employee emp = null; // an employee

		// read line by line
		while (in.hasNextLine()) {

			// assuming each data is split by space as in the text file
			String[] dataArray = in.nextLine().split(" ");

			if (dataArray[3].charAt(0) == 'H') { // hourly employee
				emp = new HourlyEmployee(dataArray[0], dataArray[1], dataArray[2], Double.parseDouble(dataArray[4]),
						Double.parseDouble(dataArray[5]));
			} else if (dataArray[3].charAt(0) == 'S') { // salary employee
				emp = new SalaryEmployee(dataArray[0], dataArray[1], dataArray[2], Double.parseDouble(dataArray[4]));
			} else { // commission employee
				emp = new CommissionEmployee(dataArray[0], dataArray[1], dataArray[2], Integer.parseInt(dataArray[4]),
						Double.parseDouble(dataArray[5]), Double.parseDouble(dataArray[7]),
						Double.parseDouble(dataArray[8]));
			}

			employees.add(emp);
		}

		in.close();
	}

	/**
	 * add employee
	 * 
	 * @param emp new employee
	 */
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	/**
	 * This includes resetting the hours worked this week, the sales this week and
	 * adds one to the number of weeks since the beginning of the year or employment
	 * whichever is smaller
	 * 
	 * @param datafile data file name
	 * @throws IOException write file error
	 */
	public void endOfWeekProcessing(String datafile) throws IOException {

		// iterate the array
		for (int i = 0; i < employees.size(); i++) {

			// check commission employee
			if (employees.get(i) instanceof CommissionEmployee) {

				CommissionEmployee emp = (CommissionEmployee) employees.get(i);

				// weekly pay
				double weeklyPay = employees.get(i).calcWeeklySalary();

				emp.setSales(0.00);
				emp.setNumWeeks(emp.getNumWeeks() + 1);
				emp.setAllSales(emp.getAllSales() + weeklyPay);
				
			} else if (employees.get(i) instanceof HourlyEmployee) {
				HourlyEmployee emp = (HourlyEmployee) employees.get(i);
				emp.setWorkedHours(0.00);
			}
		}

		// save to file
		PrintWriter out = new PrintWriter(datafile);

		// iterate the array
		for (int i = 0; i < employees.size(); i++) {

			out.println(employees.get(i).writeData());
		}

		out.close();
	}

	/**
	 * top sellers list
	 */
	public void topSellersList() {

		boolean found = false;

		// iterate the array
		for (int i = 0; i < employees.size(); i++) {
			// check commission employee only
			if (employees.get(i) instanceof CommissionEmployee) {
				CommissionEmployee emp = (CommissionEmployee) employees.get(i);

				if (emp.topSeller()) {

					System.out.println(emp);
					System.out.println();

					found = true;
				}
			}
		}

		if (!found) {
			System.out.println("There is no top seller");
		}

	}

	/**
	 * retrieve employee by number
	 * 
	 * @param number number of employee
	 * @return employee with number
	 */
	public Employee getEmployee(String number) {
		// iterate the array
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getNumber().equals(number)) {
				return employees.get(i);
			}
		}

		return null;// not found
	}

	/**
	 * remove employee by number
	 * 
	 * @param number number of removed employee
	 */
	public void removeEmployee(String number) {

		// iterate the array
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getNumber().equals(number)) {
				employees.remove(i);
				break;
			}
		}
	}

	/**
	 * print weekly salary report for all employees
	 */
	public void printSalaryReport() {

		// iterate the array
		for (int i = 0; i < employees.size(); i++) {

			// weekly pay
			double weeklyPay = employees.get(i).calcWeeklySalary();

			// employee type
			String type = "Hourly";
			if (employees.get(i).getType() == 'S') {
				type = "Salary";
			} else if (employees.get(i).getType() == 'C') {
				type = "Commission";
			}

			System.out.printf("%-15s %-15s %-15s $ %7.2f\n", employees.get(i).getName(), employees.get(i).getNumber(),
					type, weeklyPay);
		}

	}
}
