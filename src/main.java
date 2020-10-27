import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FileHandler filehandler = new FileHandler();

        populateArray(filehandler.getPeopleList(), filehandler.readPeopleFromFile());

        mainMenu(input);

        // Example on how to get customer by ID
        //System.out.println(filehandler.getCustomerByID(1));

        /*
        //Example on how to create a new Event
        filehandler.getEventList().add(addEvent("Birthday", 5.5, "beskrivelse", 0, facilitator1, "fri", 8.5));


        //Example on how to create a new Person
        filehandler.getPeopleList().add(addPerson(getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList()), "Hemming4", "Hansen", "HemmingHansen4@gayMail.com", 20202020));

         */
    }

    public static void mainMenu(Scanner input){
        System.out.println("====== Main Menu ======");
        System.out.println("A: Add functions");
        System.out.println("S: Show Data");
        System.out.println("D: Delete functions");
        System.out.println("?: Help");
        System.out.println("=======================");

        String option = input.nextLine();

        if(option.toLowerCase().contains("a")){
            addFunctions(input);
        }
    }

    public static void addFunctions(Scanner input){
        System.out.println("========= Add =========");
        System.out.println("P: Person");
        System.out.println("F: Firm");
        System.out.println("E: Event");
        System.out.println("A: Arrengement");
        System.out.println("I: Facilitator");

        String option = input.nextLine();
        if(option.toLowerCase().contains("p")){
            newPersonScanner();
        }
    }

    public static void newPersonScanner()   {
        FileHandler filehandler = new FileHandler();
        Scanner scan = new Scanner(System.in);
        int cosID = getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList());

        System.out.println("Enter your firstname: ");
        String firstName = scan.next();

        System.out.println("Enter your lastname: ");
        String lastName = scan.next();

        System.out.println("Enter your contact mail: ");
        String mail = scan.next();

        System.out.println("Enter your phonenumber: ");
        int phoneNumber = scan.nextInt();

        filehandler.getPeopleList().add(addPerson(cosID, firstName, lastName, mail, phoneNumber));
    }

    public static Person addPerson(int costumerID, String firstName, String lastName, String email, int number){
        //creates an new person object
        Person tempPerson = new Person(costumerID, firstName, lastName, email, number);

        return tempPerson;
    }

    public static Event addEvent(String type, double duration, String description, int customerID, int facilitatorID, String weekday, double time){
        //creates an new event object
        Event tempEvent = new Event(type, duration, description, customerID, facilitatorID, weekday, time);

        return tempEvent;
    }


    // Skal have lavet denne metode
    public static int getFreeFacilitatorId(){


        return 1;
    }

    // Get a unused ComputerID by finding the highest ID out of all costumer ID's
    public static int getFreeCostumerId(ArrayList<Person> peopleList, ArrayList<Firm> firmList){

        //Init new Integer array
        ArrayList<Integer> ids = new ArrayList<Integer>();

        // Populate array with current ids
        if(peopleList.size() > 0){ // checks if there's any indexes in the peopleList
            for (int i = 0; i <= peopleList.size() - 1; i++){
                ids.add(peopleList.get(i).getCostumerId()); // adds the ids of the peoples in the peopleList
            }
        }

        if(firmList.size() > 0){// checks if there's any indexes in the firmList
            for(int k = 0; k <= firmList.size() - 1; k++){
                ids.add(firmList.get(k).getCostumerId()); // adds the ids of the firms in the firmList
            }
        }

        int newID = 1; // initiate a new variable.

        // Finds the highest value in the array and adds one to it. Only happens if ids is populated by at least one ID.
        if(ids.size() != 0){ // if the ids Array is populated
            newID = Collections.max(ids) + 1; // find the largest number and add one to it.
        }

        return newID; // return the new ID.
    }

    // Takes an array and adds it to another array.
    public static ArrayList populateArray(ArrayList pasteInto, ArrayList copiedFrom){

        for (int i = 0; i <= copiedFrom.size() - 1; i++){ // runs through the array that's going to be copied from
            pasteInto.add(copiedFrom.get(i)); // add the indexes into the array that's getting pasted into.
        }

        return pasteInto; // return the pasted array;
    }

}
