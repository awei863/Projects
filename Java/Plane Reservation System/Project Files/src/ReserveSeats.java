import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReserveSeats {

	// max 6 seats
	public static final int NUM_COLUMNS = 6;

	// 2D array of Passenger objects
	private Passenger[][] passengers;

	private int rows;

	private int columns = NUM_COLUMNS;

	// reference to scanner object
	private Scanner scanner;

	// dummy available passenger
	private static Passenger availablePassenger = new Passenger("Available", 0, "");

	// dummy unavailable passenger
	private static Passenger unavailablePassenger = new Passenger("Unavailable", 0, "");

	/**
	 * constructor
	 * 
	 * @param rowsInput    number of rows
	 * @param scannerInput Scanner object to configuration file
	 */
	public ReserveSeats(int rowsInput, Scanner scannerInput) {
		rows = rowsInput;
		scanner = scannerInput;
	}

	// load configuration
	public void seatConfiguration() {

		passengers = new Passenger[rows][columns];

		for (int row = 0; row < rows; row++) {
			String line = scanner.nextLine();
			if (line.length() == 4) { // A C D F only

				if (line.charAt(0) == 'W') {// window

					passengers[row][0] = availablePassenger;
					passengers[row][NUM_COLUMNS - 1] = availablePassenger;

					if (line.charAt(1) == 'M') {// middle seat
						passengers[row][1] = availablePassenger;
						passengers[row][NUM_COLUMNS - 2] = availablePassenger;

						passengers[row][2] = unavailablePassenger;
						passengers[row][NUM_COLUMNS - 3] = unavailablePassenger;

					} else { // aisle seat
						passengers[row][1] = unavailablePassenger;
						passengers[row][NUM_COLUMNS - 2] = unavailablePassenger;

						passengers[row][2] = availablePassenger;
						passengers[row][NUM_COLUMNS - 3] = availablePassenger;
					}
				} else { // aisle seat

					passengers[row][0] = unavailablePassenger;
					passengers[row][NUM_COLUMNS - 1] = unavailablePassenger;

					passengers[row][1] = availablePassenger;
					passengers[row][NUM_COLUMNS - 2] = availablePassenger;

					passengers[row][2] = availablePassenger;
					passengers[row][NUM_COLUMNS - 3] = availablePassenger;

				}
			} else {// A B C D E F
				for (int col = 0; col < columns; col++) {
					passengers[row][col] = availablePassenger;
				}
			}
		}
	}

	/**
	 * load reservation from saved data file
	 * 
	 * @param scanner scanner to reservation file
	 */
	public void loadReservation(Scanner scanner) {

		// read line by line and create Passenger
		while (scanner.hasNextLine()) {
			createReservationFromString(scanner.nextLine());
		}
	}

	/**
	 * create reservation from string
	 * 
	 * @param line a string
	 */
	private void createReservationFromString(String line) {

		String[] data = line.split(" ");
		int row = Integer.parseInt(data[0]) - 1;
		int col = data[1].charAt(0) - 'A';

		passengers[row][col] = new Passenger(data[2] + " " + data[3], Integer.parseInt(data[4]), data[5]);
	}

	// prints the entire configuration of the plane
	public void printConfiguration() {

		System.out.println("Current layout of the seats of the plane:");

		System.out.println("    A  B  C  D  E  F");

		// for each row
		for (int row = 0; row < rows; row++) {

			System.out.print((row + 1) + "  ");

			// for each column
			for (int col = 0; col < columns; col++) {
				if (passengers[row][col] == unavailablePassenger) {
					System.out.print("   ");
				} else if (passengers[row][col] == availablePassenger) {
					System.out.print(" - ");
				} else {
					System.out.print(" R ");
				}
			}
			System.out.println();
		}
	}

	// list all current reservations
	public void listAllCurrentReservations() {
		// for each row
		for (int row = 0; row < rows; row++) {
			// for each column
			for (int col = 0; col < columns; col++) {
				if (passengers[row][col] != unavailablePassenger && passengers[row][col] != availablePassenger) {

					System.out.println((row + 1) + " " + (char) ('A' + col) + " " + passengers[row][col].getName());

				}
			}
		}
	}

	// list of food preferences
	public void listFoodPreferences() {
		// for each row
		for (int row = 0; row < rows; row++) {
			// for each column
			for (int col = 0; col < columns; col++) {
				if (passengers[row][col] != unavailablePassenger && passengers[row][col] != availablePassenger) {

					System.out.println(
							(row + 1) + " " + (char) ('A' + col) + " " + passengers[row][col].getFoodPreference());

				}
			}
		}
	}

	/**
	 * save to file
	 * 
	 * @param filename file name
	 * @throws IOException Write error
	 */
	public void saveData(String filename) throws IOException {

		PrintWriter out = new PrintWriter(filename);

		// for each row
		for (int row = 0; row < rows; row++) {
			// for each column
			for (int col = 0; col < columns; col++) {
				if (passengers[row][col] != unavailablePassenger && passengers[row][col] != availablePassenger) {

					out.println((row + 1) + " " + (char) ('A' + col) + " " + passengers[row][col].getName() + " "
							+ passengers[row][col].getAge() + " " + passengers[row][col].getFoodPreference());

				}
			}
		}

		out.close();
	}

	/**
	 * list available seats
	 * 
	 * @param type: Window, Aisle, Middle
	 * @return string of available seats
	 */
	public String listAvailableSeat(String type) {

		// available seats
		String seats = "";

		// for each row
		for (int row = 0; row < rows; row++) {
			// for each column
			for (int col = 0; col < columns; col++) {

				if (passengers[row][col] == availablePassenger) {

					if (type.equalsIgnoreCase("Window")) {
						if (col == 0 || col == NUM_COLUMNS - 1) {
							seats += (row + 1) + " " + (char) ('A' + col) + '\r' + '\n';
						}
					} else if (type.equalsIgnoreCase("Aisle")) {
						if (col == 2 || col == NUM_COLUMNS - 3) {
							seats += (row + 1) + " " + (char) ('A' + col) + '\r' + '\n';
						}
					} else if (type.equalsIgnoreCase("Middle")) {
						if (col == 1 || col == NUM_COLUMNS - 2) {
							seats += (row + 1) + " " + (char) ('A' + col) + '\r' + '\n';
						}
					} else {// any seat reference
						seats += (row + 1) + " " + (char) ('A' + col) + '\r' + '\n';
					}
				}
			}
		}

		return seats;
	}

	/**
	 * check if seat is available for reservation
	 * 
	 * @param row    specific row
	 * @param column specific column
	 * @return true if seat can be reserved
	 */
	public boolean seatCanReserve(int row, int column) {
		return passengers[row][column] == availablePassenger;
	}

	/**
	 * check if the seat is being reserved
	 * 
	 * @param row    specific row
	 * @param column specific column
	 * @return true if seat can be reserved
	 */
	public boolean isBeingReserved(int row, int column) {
		return passengers[row][column] != availablePassenger && passengers[row][column] != unavailablePassenger;
	}

	/**
	 * check if seat is valid
	 * 
	 * @param row    specific row
	 * @param column specific column
	 * @return true if valid
	 */
	public boolean isValidSeat(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	/**
	 * add reservation
	 * 
	 * @param row       specific row
	 * @param column    specific column
	 * @param passenger passenger
	 */
	public void addReservation(int row, int column, Passenger passenger) {
		passengers[row][column] = passenger;
	}

	/**
	 * add reservation for any position that is available
	 * 
	 * @param passenger passenger
	 */
	public void addReservation(Passenger passenger) {

		// for each row
		for (int row = 0; row < rows; row++) {
			// for each column
			for (int col = 0; col < columns; col++) {

				if (passengers[row][col] == availablePassenger) {
					passengers[row][col] = passenger;
					return;
				}
			}
		}
	}

	/**
	 * change reservation
	 * 
	 * @param row1    from row
	 * @param column1 from column
	 * @param row2    to row
	 * @param column2 to column
	 */
	public void changeReservation(int row1, int column1, int row2, int column2) {
		passengers[row2][column2] = passengers[row1][column1];
		passengers[row1][column1] = availablePassenger;
	}

	/**
	 * remove reservation
	 * 
	 * @param row    row
	 * @param column column
	 */
	public void removeReservation(int row, int column) {
		passengers[row][column] = availablePassenger;
	}
}
