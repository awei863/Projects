
import java.util.*;
import java.io.*;
public class Directory{

    Scanner kbd = new Scanner (System.in);
    ArrayList <Person> persons = new ArrayList <Person>();

    public void run() throws FileNotFoundException{
        //declare variables
        String firstName;
        String lastName;
        String initial;
        String department;
        int telNum;
        String fileName;

        //ask for input file name, assumming client enters .txt
        System.out.println("Please enter the input file name");
        fileName = kbd.nextLine();

        File inFile = new File (fileName);
        Scanner in = new Scanner (inFile);

        //load text file info into an arraylist
        while (in.hasNext()){
            Person list;
            lastName = in.next();
            firstName = in.next();
            initial = in.next();
            department = in.next();
            telNum = in.nextInt();
            list = new Person(lastName, firstName, initial, department, telNum);
            persons.add(list);
        }
        in.close();

        //show menu
        showMenu();
        System.out.println();

        //ask client to choose an option
        System.out.println("Please choose an option from the menu");
        char userInput = kbd.next().charAt(0);

        //keep asking until user exits
        while(userInput != 'e' || userInput != 'E'){

            if (userInput == 'p' || userInput == 'P'){
                optionP();
            }
            else if (userInput == 'l' || userInput == 'L'){
                optionL();
            }
            else if (userInput == 'r' || userInput == 'R'){
                optionR();
            }
            else if (userInput == 'c' || userInput == 'C'){
                optionC();
            }
            else if (userInput == 'a' || userInput == 'A'){
                optionA();
            }
            else if (userInput == 'd' || userInput == 'D'){
                optionD();
            }
            else if (userInput == 'e' || userInput == 'E'){
                System.out.println ("Thank you for using the Directory System"); 
                optionE();

            }
            else{

                System.out.println("Wrong input, please try again");
            }
            showMenu();
            System.out.println();
            System.out.println("Please choose an option from the menu");
            userInput = kbd.next().charAt(0);
        }
    }

    public void showMenu()
    {
        System.out.println("\nMENU:");
        System.out.println("P - Print a list of all persons in the directory");
        System.out.println("L - Look up a person's number");
        System.out.println("R - Create a report with a department phone list");
        System.out.println("C - Change a listing");
        System.out.println("A - Add  new Listing");
        System.out.println("D - Delete a listing");
        System.out.println();
        System.out.println("E - Exit");

    }

    public void optionP(){
        //declare variables
        int i;
        i = 0;

        System.out.println("Fly By Night Consulting");
        System.out.println("Name            Department         Telephone Number");

        //print toString
        while (i < persons.size()){
            System.out.println(persons.get(i).toString());
            i++;
        }

    }

    /**
     * This searches a last name in an array list
     * 
     * @param lastName  last name of employee
     */
    public int searchLastName (String lastName){
        //declare variables
        int i;
        boolean found = false;
        int index;

        i = 0;
        index = -1;

        while (i < persons.size() && !found){
            if (lastName.equalsIgnoreCase (persons.get(i).getLastName())){
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public void notFoundMsg(){
        System.out.println("Employee not found, please try again");
    }

    public void optionL(){
        //declare variables
        String lastName;
        System.out.println("Please enter a last name for the person's information");
        lastName = kbd.next();
        int index = searchLastName(lastName);
        //index is a -1 if name is not found and 1 if found
        if (index < 0){
            notFoundMsg();
        }
        else{
            System.out.println(persons.get(index).toString());   
        }

    }

    /**
     * This searches a department in an array list
     * 
     * @param department    department of employee
     */
    public int searchDepartment (String department){
        //declare variables
        int i;
        boolean found = false;
        int index;

        i = 0;
        index = -2;

        while (i < persons.size() && !found){
            if (department.equalsIgnoreCase (persons.get(i).getDepartment())){
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public void optionR() throws FileNotFoundException{ 
        //declare variables
        String department;
        String lastName;
        String answer;
        String fileName;
        int indexLN;
        int indexDpt;

        System.out.println("Please enter the name of the department");
        department = kbd.next();
        System.out.println("Please enter the last name of the employee");
        lastName = kbd.next();

        //last name index
        indexLN = searchLastName(lastName);
        //department index
        indexDpt = searchDepartment(department);
        //if last name and department has same index
        if(indexLN == indexDpt){
            System.out.println("Where would you like the report be written to (File or Screen)?");
            answer = kbd.next();

            //if choose file
            if (answer.equals("File") || answer.equals("file")){
                System.out.println("Please enter a name for the file to which the report should be written to");
                fileName = kbd.next();
                PrintWriter out = new PrintWriter(fileName);
                out.println(department + " department");

                out.println(persons.get(indexLN).toOptionR());

                out.close();

            }
            //if choose screen
            else {
                System.out.println(persons.get(indexLN).toOptionR());
            }
        }
        //if employee and department don't matched
        else{
            System.out.println("The employee you are looking for is not in the requested department");
        }
    }

    public void optionC(){
        //declare variables
        String lastName;
        char departAns;
        char phoneAns;
        String departChange;
        int phoneChange;
        int index;

        System.out.println("Please enter a last name for the person's information");
        lastName = kbd.next();
        index = searchLastName(lastName);
        //if last name is not found
        if (index < 0){
            notFoundMsg();
        }
        //if name found then ask for department/phone change
        else{
            System.out.println(persons.get(index).toString());   

            System.out.println("Do you wish to change the department (Y or N)?");
            departAns = kbd.next().charAt(0);

            if (departAns == 'Y' || departAns == 'y'){
                System.out.println("What would you like to change it to?");
                departChange = kbd.next();
                persons.get(index).setDepartment(departChange);
            }

            System.out.println("Do you wish to change the local phone number (Y or N)?");
            phoneAns = kbd.next().charAt(0);

            if (phoneAns == 'Y' || phoneAns == 'y'){
                System.out.println("What would you like to change it to?");
                phoneChange = kbd.nextInt();
                persons.get(index).setTelNum(phoneChange);
            }
            
        }
    }

    public void optionA(){
        //declare variables
        Person one;
        String lastName;
        String firstName;
        String initial;
        String department;

        int telNum;
        int index;

        System.out.println("Please enter a last name to add into directory");
        lastName = kbd.next();
        index = searchLastName(lastName);
        //if last name is not found then add it
        if (index < 0){
            System.out.println("Please enter first name");
            firstName = kbd.next();

            System.out.println("Please enter initial");
            initial = kbd.next();

            System.out.println("Please enter department");
            department = kbd.next();

            System.out.println("Please enter local phone number");
            telNum = kbd.nextInt();

            one = new Person(lastName, firstName, initial, department, telNum);

            persons.add(one);

        }
        else{
            System.out.println("This name is already in the directory, please try again");
        }

    }
    public void optionD(){
        //declare variables
        String lastName;
        int index;

        System.out.println("Please enter a last name to remove from directory");
        lastName = kbd.next();
        index = searchLastName(lastName);
        //if last found then delete, if not then not found msg
        if (index < 0){
            System.out.println("The person you are looking for is not found");
        }
        else {
            persons.remove(index);
        }   
        
    }

    public void optionE()throws FileNotFoundException{
        //declare variables
        int i;
        String fileName;

        //ask for an updated file name
        System.out.println("Please enter an updated file name");
        fileName = kbd.next();

        PrintWriter out = new PrintWriter(fileName);
        out.println("Fly By Night Consulting");
        out.println("Name            Department         Telephone Number");

        i = 0;
        while (i < persons.size()){        
            out.println(persons.get(i).toString());
            i++;
        }

        out.close();
        System.exit(0);
    }

}
