
public abstract class Employee {

	/**
	 * name of employee
	 */
	private String name;

	/**
	 * employee number
	 */
	private String number;

	/**
	 * department where the employee works
	 */
	private String department;

	/**
	 * employee type
	 */
	protected char type;

	/**
	 * constructor
	 */
	public Employee() {
		this.name = "";
		this.number = "";
		this.department = "";
	}

	/**
	 * constructor
	 * 
	 * @param name       name of employee
	 * @param number     employee number
	 * @param department department where the employee works
	 */
	public Employee(String name, String number, String department) {
		this.name = name;
		this.number = number;
		this.department = department;
	}

	/**
	 * getter of name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter of name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter of number
	 * 
	 * @return employee number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * setter of number
	 * 
	 * @param number employee number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * getter of department
	 * 
	 * @return the department where the employee works
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * setter of department
	 * 
	 * @param department department where the employee works
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * getter of type
	 * 
	 * @return the type of employee
	 */
	public char getType() {
		return type;
	}

	/**
	 * calculate the weekly salary
	 * 
	 * @return the weekly salary
	 */
	public abstract double calcWeeklySalary();

	/**
	 * get the string representing the data to write
	 * 
	 * @return string representing the data to write
	 */
	public abstract String writeData();

	/**
	 * check if two employees are equals (compare the number)
	 * 
	 * @param e other employee
	 * @return true/false
	 */
	public boolean equals(Employee e) {
		return number.equals(e.getNumber());
	}

	/**
	 * return a string representing this employee
	 */
	@Override
	public String toString() {
		return "Name: " + name + "\nNumber: " + number + "\nDepartment: " + department + "\nType: " + type;
	}

}
