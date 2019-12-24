import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) throws Exception {

		Scanner kbd = new Scanner(System.in);

		// user selection from menu
		int selection;

		// read configuration file
		System.out.print("Please enter seat configuration file name: ");
		String configurationFilename = kbd.nextLine();

		String dataFilename;// saved data file name

		// read number of rows from configuration file
		int numRows = readNumberOfRows(configurationFilename);

		ReserveSeats reserveSeats = new ReserveSeats(numRows, new Scanner(new File(configurationFilename)));

		// load reservation
		reserveSeats.seatConfiguration();

		// load from saved data
		System.out.print("Please enter file name of saved data: ");
		dataFilename = kbd.nextLine();

		// load data if existing
		File inFile = new File(dataFilename);
		if (inFile.exists()) {
			reserveSeats.loadReservation(new Scanner(new File(dataFilename)));
		}

		// show map of seats
		reserveSeats.printConfiguration();

		showMenu();

		System.out.print("Please enter your selection: ");
		selection = kbd.nextInt();
		kbd.nextLine();

		// run until user wants to exit
		while (selection != 6) {

			switch (selection) {
			case 1:// Adding a seat reservation

				addSeatReservation(reserveSeats, kbd);
				break;

			case 2:// Changing an existing seat reservation

				changeSeatReservation(reserveSeats, kbd);
				break;

			case 3:// Canceling an existing reservation

				cancelSeatReservation(reserveSeats, kbd);
				break;

			case 4:// List current reservations

				reserveSeats.listAllCurrentReservations();
				break;

			case 5:// List food preferences per seat

				reserveSeats.listFoodPreferences();

				break;
			default:// invalid selection
				System.out.println("Invalid selection, please try again");
				break;
			}

			System.out.println();

			reserveSeats.printConfiguration();

			showMenu();

			System.out.print("Please enter your selection: ");
			selection = kbd.nextInt();
			kbd.nextLine();
		}

		reserveSeats.saveData(dataFilename);

		System.out.println("Thank you for using this application");

	}

	/**
	 * change a seat reservation
	 * 
	 * @param reserveSeats reference to ReserveSeats object
	 * @param kbd          Scanner from kbd
	 */
	private static void changeSeatReservation(ReserveSeats reserveSeats, Scanner kbd) {

		int row1; // current
		int row2; // changed to
		int column1;
		int column2;

		System.out.print("Please enter the current seat identifier: ");
		row1 = kbd.nextInt() - 1;
		column1 = kbd.next().toUpperCase().charAt(0) - 'A';
		kbd.nextLine();

		System.out.print("Please enter the next seat identifier: ");
		row2 = kbd.nextInt() - 1;
		column2 = kbd.next().toUpperCase().charAt(0) - 'A';
		kbd.nextLine();

		// valid seat ?
		if (reserveSeats.isValidSeat(row1, column1)) {

			// valid seat ?
			if (reserveSeats.isValidSeat(row2, column2)) {

				// is being reserved ?
				if (reserveSeats.isBeingReserved(row1, column1)) {

					reserveSeats.changeReservation(row1, column1, row2, column2);

					System.out.println("The seat has been changed successfully");
				} else {
					System.out.println("The current seat is not being reserved");
				}

			} else {
				System.out.println("Row/Column of new seat is not valid");
			}
		} else {
			System.out.println("Row/Column of current seat is not valid");
		}

	}

	/**
	 * cancel a seat reservation
	 * 
	 * @param reserveSeats reference to ReserveSeats object
	 * @param kbd          Scanner from kbd
	 */
	private static void cancelSeatReservation(ReserveSeats reserveSeats, Scanner kbd) {

		int row;
		int column;

		System.out.print("Please enter the seat identifier: ");
		row = kbd.nextInt() - 1;
		column = kbd.next().toUpperCase().charAt(0) - 'A';
		kbd.nextLine();

		// valid seat ?
		if (reserveSeats.isValidSeat(row, column)) {

			// can reserve ?
			if (reserveSeats.isBeingReserved(row, column)) {

				reserveSeats.removeReservation(row, column);

				System.out.println("The seat has been removed successfully");
			} else {
				System.out.println("The current seat is not being reserved");
			}

		} else {
			System.out.println("Row/Column of current seat is not valid");
		}

	}

	/**
	 * adding a seat reservation
	 * 
	 * @param reserveSeats reference to ReserveSeats object
	 * @param kbd          Scanner from kbd
	 */
	private static void addSeatReservation(ReserveSeats reserveSeats, Scanner kbd) {

		int row;
		int column;

		// seat preference
		String preference;

		// available seat
		String availableSeats;

		// full seats
		availableSeats = reserveSeats.listAvailableSeat("");
		if (availableSeats.equals("")) {// no seat available
			System.out.println("No seat available");
			return;
		}

		// show menu
		addResMenu();

		System.out.print("Your selection? ");
		int selection = kbd.nextInt();
		kbd.nextLine();

		switch (selection) {
		case 1:// Reserving a specific seat

			System.out.print("Please enter the seat identifier (i.e. 1 D): ");
			row = kbd.nextInt() - 1;
			column = kbd.next().toUpperCase().charAt(0) - 'A';
			kbd.nextLine();

			// reserve the specific seat
			reserveSpecificSeat(reserveSeats, kbd, row, column);

			break;

		case 2:// Reserving a seat preference (Window, Aisle, Middle)

			preference = readSeatPreference(kbd);
			availableSeats = reserveSeats.listAvailableSeat(preference);

			if (availableSeats.equals("")) {// no seat available
				System.out.println("No seat available");
			} else {

				System.out.println("Available Seats:");
				System.out.println(availableSeats);

				System.out.print("Please enter the seat identifier (i.e. 1 D): ");
				row = kbd.nextInt() - 1;
				column = kbd.next().toUpperCase().charAt(0) - 'A';
				kbd.nextLine();

				// reserve the specific seat
				reserveSpecificSeat(reserveSeats, kbd, row, column);
			}

			break;
		case 3:// Reserving any available seat

			reserveSeats.addReservation(readPassenger(kbd));

			break;

		default:// invalid selection
			System.out.println("Invalid selection");
			break;
		}
	}

	/**
	 * reserve the specific seat
	 * 
	 * @param reserveSeats ReserveSeats object
	 * @param kbd          Scanner object
	 * @param row          specific row
	 * @param column       specific column
	 */
	private static void reserveSpecificSeat(ReserveSeats reserveSeats, Scanner kbd, int row, int column) {

		// valid seat ?
		if (reserveSeats.isValidSeat(row, column)) {

			// can reserve ?
			if (reserveSeats.seatCanReserve(row, column)) {
				reserveSeats.addReservation(row, column, readPassenger(kbd));

				System.out.println("The seat has been reserved successfully");
			} else {
				System.out.println("The seat is not available");
			}

		} else {
			System.out.println("Row/Column is not valid");
		}
	}

	/**
	 * read information of passenger from kbd
	 * 
	 * @param kbd Scanner object
	 * @return Passenger object
	 */
	private static Passenger readPassenger(Scanner kbd) {

		String name;

		int age;

		String foodPreference;

		System.out.print("Please enter the passenger's first name: ");
		String firstName = kbd.next();
		System.out.print("Please enter the passenger's last name: ");
		String lastName = kbd.next();
		kbd.nextLine();

		name = firstName + " " + lastName;

		System.out.print("Please enter the passenger's age: ");
		age = kbd.nextInt();
		kbd.nextLine();

		System.out.print("Please enter the passenger's food preference: ");
		foodPreference = kbd.nextLine();

		return new Passenger(name, age, foodPreference);
	}

	/**
	 * read number of rows from configuration file
	 * 
	 * @param configurationFilename
	 * @return
	 * @throws FileNotFoundException
	 */
	private static int readNumberOfRows(String configurationFilename) throws FileNotFoundException {

		int numRows = 0;
		Scanner in = new Scanner(new File(configurationFilename));

		while (in.hasNextLine()) {
			in.nextLine();
			numRows++;
		}

		in.close();

		return numRows;
	}

	// Main Menu
	public static void showMenu() {
		System.out.println("\nMain Menu:");
		System.out.println("1) Adding a seat reservation");
		System.out.println("2) Changing an existing seat reservation");
		System.out.println("3) Canceling an existing reservation");
		System.out.println("4) List current reservations");
		System.out.println("5) List food preferences per seat");
		System.out.println("6) Exit");
	}

	// Sub Menu for adding a seat reservation
	public static void addResMenu() {
		System.out.println("\nAdd Reservation Menu");
		System.out.println("1) Reserving a specific seat");
		System.out.println("2) Reserving a seat preference (Window, Aisle, Middle)");
		System.out.println("3) Reserving any available seat");
	}

	/**
	 * read an integer from console
	 * 
	 * @param kbd Scanner from kbd
	 * @return integer value
	 */
	public static int readInt(Scanner kbd) {

		int value = Integer.parseInt(kbd.nextLine());

		return value;
	}

	/**
	 * read seat preference from console
	 * 
	 * @param kbd Scanner from kbd
	 * @return preference
	 */
	public static String readSeatPreference(Scanner kbd) {

		String preference;

		// read until user enters valid
		System.out.print("Please enter seat preference (Window, Aisle, Middle): ");
		preference = kbd.nextLine();

		return preference;
	}

	/**
	 * read a character from console
	 * 
	 * @param kbd Scanner from kbd
	 * @return character value
	 */
	public static char readChar(Scanner kbd) {

		char value = kbd.nextLine().charAt(0);
		return value;
	}
}
