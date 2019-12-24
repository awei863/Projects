
public class Passenger {

	/**
	 * passenger name
	 */
	private String name;

	/**
	 * passenger age
	 */
	private int age;

	/**
	 * passenger's food preference
	 */
	private String foodPreference;

	/**
	 * constructor
	 * 
	 * @param nameInput           passenger name
	 * @param ageInput            passenger age
	 * @param foodPreferenceInput passenger's food preference
	 */
	public Passenger(String nameInput, int ageInput, String foodPreferenceInput) {
		name = nameInput;
		age = ageInput;
		foodPreference = foodPreferenceInput;
	}

	/**
	 * accessor method of name
	 * 
	 * @return passenger name
	 */
	public String getName() {
		return name;
	}

	/**
	 * accessor method of age
	 * 
	 * @return passenger age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * accessor method of foodPreference
	 * 
	 * @return food preference
	 */
	public String getFoodPreference() {
		return foodPreference;
	}

	/**
	 * mutator method of name
	 * 
	 * @param nameInput passenger name
	 */
	public void setName(String nameInput) {
		name = nameInput;
	}

	/**
	 * mutator method of age
	 * 
	 * @param ageInput passenger age
	 */
	public void setAge(int ageInput) {
		age = ageInput;
	}

	/**
	 * mutator method of foodPreference
	 * 
	 * @param foodPreferenceInput food preference
	 */
	public void setFoodPreference(String foodPreferenceInput) {
		foodPreference = foodPreferenceInput;
	}

	/**
	 * return a string representing this passenger
	 */

	public String toString() {
		return name + ", " + age + ", " + foodPreference;
	}

}
