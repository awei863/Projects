/**
 * This is the class that defines the Person included in the Directory 
 * 
 * @author 
 * 
 */
public class Person{

    // Instance Variables
    private String lastName;
    private String firstName;
    private String initial;
    private String department;
    private int telNum;

    // Constructor
    /**
     * This is the parameterized constructor for the Person class
     * 
     * @param lastN     last name of employee
     * @param firstN    first name of employee
     * @param intl      initial of employee
     * @param departm   department of employee
     * @param tel       local phone number of employee 
     */
    public Person (String lastN, String firstN, String intl, String departm, int tel){
        lastName = lastN;
        firstName = firstN;
        initial = intl;
        department = departm;
        telNum = tel;
    }

    // Accessors
    /**
     * This is the accessor to the last name of employee
     * 
     * @return      last name of employee
     */    
    public String getLastName(){
        return lastName;
    }
    
    /**
     * This is the accessor to the first name of employee
     * 
     * @return      first name of employee
     */   
    public String getFirstName(){
        return firstName;
    }

    /**
     * This is the accessor to the initial of employee
     * 
     * @return      initial of employee
     */   
    public String getInitial(){
        return initial;
    }

    /**
     * This is the accessor to the department of employee
     * 
     * @return      department of employee
     */   
    public String getDepartment(){
        return department;
    }

    /**
     * This is the accessor to the local phone number of employee
     * 
     * @return      local phone number of employee
     */   
    public double getTelNum(){
        return telNum;
    }

    // Mutators
    /**
     * This is the mutator to the last name of employee
     * 
     * @param lastN     last name of employee
     */
    public void setLastName (String lastN){
        lastName = lastN;
    }

    /**
     * This is the mutator to the first name of employee
     * 
     * @param firstN     first name of employee
     */
    public void setFirstName (String firstN){
        firstName = firstN;
    }

    /**
     * This is the mutator to the initial of employee
     * 
     * @param intl     intitial name of employee
     */
    public void setInitial (String intl){
        initial = intl;
    }

    /**
     * This is the mutator to the department of employee
     * 
     * @param departm     department of employee
     */
    public void setDepartment (String departm){
        department = departm;
    }

    /**
     * This is the mutator to the local phone number of employee
     * 
     * @param tel     local phone number of employee
     */
    public void setTelNum (int tel){
        telNum = tel;
    }

    

    // Place print and toString methods here
    /**
     * This is the toString method to print option L
     * 
     * @return      formated information of option L
     */
    public String toString(){
        return String.format("%s %s. %s\t%-10s\t   %-10d", firstName, initial, lastName, department, telNum);
    }
    
    /**
     * This is the toString method to print option R
     * 
     * @return      formated information of option R
     */
    public String toOptionR(){
        String text;
        text = firstName + " " + initial + "." + " " + lastName + " " + telNum;
        return text;
    }

}
