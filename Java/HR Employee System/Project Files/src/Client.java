import java.io.IOException;
import java.util.Scanner;

public class Client {

	private static Scanner kbd = new Scanner(System.in);

	public static void main(String args[]) throws IOException {

		// create Payroll object
		Payroll payroll = new Payroll();

		// ask for data file name (in.txt)
		System.out.print("Please enter data file name: (in.txt) ");
		String datafile = kbd.nextLine();

		// load payroll
		payroll.load(datafile);

		// show menu
		showMenu();

		// read selection
		System.out.println("Your selection? ");
		String selection = kbd.nextLine();

		// run until user enters q or Q to exit
		while (!selection.equalsIgnoreCase("q")) {

			if (selection.equalsIgnoreCase("a")) {// Add a new employee
				addNewEmployee(payroll);
			} else if (selection.equalsIgnoreCase("i")) {// Print information of an individual employee
				printIndividualEmployee(payroll);
			} else if (selection.equalsIgnoreCase("d")) {// Remove an employee from payroll
				removeEmployeeFromPayroll(payroll);
			} else if (selection.equalsIgnoreCase("s")) {// calculate and print the weekly pay of an employee
				printWeeklyPay(payroll);
			} else if (selection.equalsIgnoreCase("t")) {// Top Sellers List
				topSellersList(payroll);
			} else if (selection.equalsIgnoreCase("p")) {// prints salary report
				printSalaryReport(payroll);
			} else if (selection.equalsIgnoreCase("w")) {// end of week processing
				endOfWeekProcessing(payroll, datafile);
			} else if (selection.equalsIgnoreCase("h")) {// end of week processing
				addSalesHoursWorked(payroll);
			} else {
				System.out.println("Invalid selection");
			}

			// show menu
			showMenu();

			// read next selection
			System.out.println("Your selection? ");
			selection = kbd.nextLine();
		}

		System.out.println("Thank you for using the Payroll Processing System");
	}

	/**
	 * add sales or hours worked for employee
	 * 
	 * @param payroll payroll
	 */
	private static void addSalesHoursWorked(Payroll payroll) {
		// ask for number
		System.out.print("Enter employee number: ");
		String number = kbd.nextLine();

		// get employee by number
		Employee emp = payroll.getEmployee(number);

		if (emp != null) {

			System.out.println(emp);

			if (emp instanceof CommissionEmployee) {

				CommissionEmployee ce = (CommissionEmployee) emp;

				// ask for sales
				System.out.print("Enter sales this week: ");
				double sales = kbd.nextDouble();
				kbd.nextLine();

				ce.setSales(sales);
			} else if (emp instanceof HourlyEmployee) {

				HourlyEmployee he = (HourlyEmployee) emp;

				// ask for workedHours
				System.out.print("Enter hours worked this week: ");
				double workedHours = kbd.nextDouble();
				kbd.nextLine();

				he.setWorkedHours(workedHours);
			} else {
				System.out.println("Salary Employee. The operation has ben cancelled");
			}

		} else {
			System.out.println("Employee with that number is not found!");
		}

	}

	/**
	 * end of week processing
	 * 
	 * @param payroll  payroll
	 * @param datafile data file name
	 * @throws IOException write file error
	 */
	private static void endOfWeekProcessing(Payroll payroll, String datafile) throws IOException {

		/*
		 * This basically prepares the data for next week's processing. This includes
		 * resetting the hours worked this week, the sales this week and adds one to the
		 * number of weeks since the beginning of the year or employment whichever is
		 * smaller
		 */
		payroll.endOfWeekProcessing(datafile);

		System.out.println("The data for next week's processing has been processed succesfully");
	}

	/**
	 * print salary report
	 * 
	 * @param payroll payroll
	 */
	private static void printSalaryReport(Payroll payroll) {
		payroll.printSalaryReport();
	}

	/**
	 * top sellers list
	 * 
	 * @param payroll payroll
	 */
	private static void topSellersList(Payroll payroll) {
		payroll.topSellersList();
	}

	/**
	 * calculate and print the weekly pay for an employee
	 * 
	 * @param payroll payroll
	 */
	private static void printWeeklyPay(Payroll payroll) {

		// ask for number
		System.out.print("Enter employee number: ");
		String number = kbd.nextLine();

		// get employee by number
		Employee emp = payroll.getEmployee(number);

		if (emp != null) {

			double weeklyPay = emp.calcWeeklySalary();

			System.out.printf("Weekly pay: %.2f\n", weeklyPay);

		} else {
			System.out.println("Employee with that number is not found!");
		}
	}

	/**
	 * remove employee from payroll
	 * 
	 * @param payroll payroll
	 */
	private static void removeEmployeeFromPayroll(Payroll payroll) {

		// ask for number
		System.out.print("Enter employee number: ");
		String number = kbd.nextLine();

		// get employee by number
		Employee emp = payroll.getEmployee(number);

		if (emp != null) {

			System.out.println(emp);

			// ask for confirmation
			System.out.print("Do you want to delete? [y/n] ");
			String confirm = kbd.nextLine();

			if (confirm.equalsIgnoreCase("y")) {

				payroll.removeEmployee(number);

				System.out.println("Employee has been removed successfully");
			}

		} else {
			System.out.println("Employee with that number is not found!");
		}

	}

	/**
	 * print individual employee
	 * 
	 * @param payroll payroll
	 */
	private static void printIndividualEmployee(Payroll payroll) {

		// ask for number
		System.out.print("Enter employee number: ");
		String number = kbd.nextLine();

		// get employee by number
		Employee emp = payroll.getEmployee(number);

		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("Employee with that number is not found!");
		}
	}

	/**
	 * the Payroll processing menu
	 */
	public static void showMenu() {
		System.out.println("\nMENU:");
		System.out.println("A - Add a new employee");
		System.out.println("I - Print information of an individual employee");
		System.out.println("D - Remove an employee from payroll");
		System.out.println("S - calculate and print the weekly pay of an employee");
		System.out.println("T - Top Sellers List");
		System.out.println("P - prints salary report");
		System.out.println("W - End of week processing");
		System.out.println("H - Add Sales/Hours Worked");
		System.out.println();
		System.out.println("Q - Quit the system");
	}

	/**
	 * add new employee to payroll
	 * 
	 * @param payroll payroll
	 */
	private static void addNewEmployee(Payroll payroll) {

		// ask for type
		System.out.print("Please enter H for hourly, S for salary or C for commision employee: ");
		String type = kbd.nextLine();

		// ask for name
		System.out.print("Enter employee's first name: ");
		String name = kbd.nextLine();

		// ask for number
		System.out.print("Enter employee number: ");
		String number = kbd.nextLine();

		// ask for department
		System.out.print("Enter employee department: ");
		String department = kbd.nextLine();

		if (type.equalsIgnoreCase("H")) {

			// ask for hourlyPayRate
			System.out.print("Enter hourly pay rate: ");
			double hourlyPayRate = kbd.nextDouble();
			kbd.nextLine();

			// ask for workedHours
			System.out.print("Enter hours worked this week: ");
			double workedHours = kbd.nextDouble();
			kbd.nextLine();

			payroll.addEmployee(new HourlyEmployee(name, number, department, hourlyPayRate, workedHours));

			System.out.println("Employee has been added successfully");

		} else if (type.equalsIgnoreCase("S")) {

			// ask for yearly salary
			System.out.print("Enter yearly salary: ");
			double yearlySalary = kbd.nextDouble();
			kbd.nextLine();

			payroll.addEmployee(new SalaryEmployee(name, number, department, yearlySalary));

			System.out.println("Employee has been added successfully");

		} else if (type.equalsIgnoreCase("C")) {

			// ask for numWeeks
			System.out.print("Enter number of weeks since start of year or employment: ");
			int numWeeks = kbd.nextInt();
			kbd.nextLine();

			// ask for weeklySalary
			System.out.print("Enter base weekly salary: ");
			double weeklySalary = kbd.nextDouble();
			kbd.nextLine();

			// ask for sales
			System.out.print("Enter sales this week: ");
			double sales = kbd.nextDouble();
			kbd.nextLine();

			// ask for sales so far this year but not including this week
			System.out.print("Enter sales so far this year but not including this week: ");
			double allSales = kbd.nextDouble();
			kbd.nextLine();

			// ask for commission rate
			System.out.print("Enter commission rate % (e.g. 5): ");
			double commissionRate = kbd.nextDouble();
			kbd.nextLine();

			CommissionEmployee comm = new CommissionEmployee(name, number, department, numWeeks, weeklySalary, allSales,
					commissionRate);
			comm.setSales(sales);

			payroll.addEmployee(comm);

			System.out.println("Employee has been added successfully");

		} else {
			System.out.println("Employee type is incorrect");
		}

	}

}
