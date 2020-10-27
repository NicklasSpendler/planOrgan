import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FileHandler filehandler = new FileHandler();

        populateArray(filehandler.getPeopleList(), filehandler.readPeopleFromFile());

        mainMenu(input, filehandler);

        //Example on how to get customer by ID
        //System.out.println(filehandler.getCustomerByID(1));

        /*
        //Example on how to create a new Event
        filehandler.getEventList().add(addEvent("Birthday", 5.5, "beskrivelse", 0, facilitator1, "fri", 8.5));


        //Example on how to create a new Person
        filehandler.getPeopleList().add(addPerson(getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList()), "Hemming4", "Hansen", "HemmingHansen4@gayMail.com", 20202020));
         */
    }

    public static void mainMenu(Scanner input, FileHandler filehandler){
        System.out.println("====== Main Menu ======");
        System.out.println("A: Add functions");
        System.out.println("S: Show Data");
        System.out.println("D: Delete functions");
        System.out.println("?: Help");
        System.out.println("=======================");

        String option = input.next();

        if(option.toLowerCase().contains("a")){
            addFunctions(input, filehandler);
        }
    }

    public static void addFunctions(Scanner input, FileHandler filehandler){
        System.out.println("========= Add =========");
        System.out.println("P: Person");
        System.out.println("F: Firm");
        System.out.println("E: Event");
        System.out.println("A: Arrangement");
        System.out.println("I: Facilitator");
        System.out.println("B: Back");

        String option = input.next();
        if(option.toLowerCase().contains("p")){
            newPersonScanner(input, filehandler);
        }else if(option.toLowerCase().contains("b")){
            mainMenu(input, filehandler);
        }else if(option.toLowerCase().contains("f")){
            newFirmScanner(input, filehandler);
        }else if(option.toLowerCase().contains("e")){
            newEventScanner(input, filehandler);
        }
    }

    public static void newPersonScanner(Scanner input, FileHandler filehandler)   {
        int cosID = getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList());

        System.out.println("Enter costumers firstname: ");
        String firstName = input.next();

        System.out.println("Enter costumers lastname: ");
        String lastName = input.next();

        System.out.println("Enter costumers contact mail: ");
        String mail = input.next();

        System.out.println("Enter costumers phonenumber: ");
        int phoneNumber = input.nextInt();

        filehandler.getPeopleList().add(addPerson(cosID, firstName, lastName, mail, phoneNumber));
        System.out.println(firstName + " has been added with ID: " + cosID);
        System.out.println("Would you like to create add another Person? (Y/N)");
        String option = input.next();
        if(option.toLowerCase().contains("y")){
            newPersonScanner(input, filehandler);
        }else{
            addFunctions(input, filehandler);
        }
    }

    public static void newEventScanner(Scanner input, FileHandler filehandler){

        int eventID = getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList());

        System.out.println("Enter event Type: ");
        String type = input.next();

        System.out.println("Enter duration: ");
        double duration = input.nextDouble();

        System.out.println("Enter description: ");
        input.next();
        String description = input.nextLine();

        System.out.println("Enter costumer ID: ");
        int costID = input.nextInt();

        System.out.println("Enter facilitator ID: ");
        int facilitatorID = input.nextInt();

        System.out.println("Enter weekday: ");
        String weekDay = input.next();

        System.out.println("Enter time: ");
        double time = input.nextDouble();


        filehandler.getEventList().add(addEvent(eventID, type, duration, description, costID, facilitatorID, weekDay, time));
        System.out.println("Event has been created with ID: " + eventID);
        System.out.println("Would you like to create another event? (y/n)");
        String option = input.next();
        if(option.toLowerCase().equals("y")){
            newEventScanner(input, filehandler);
        }else{
            addFunctions(input, filehandler);
        }
    }

    public static void newFirmScanner(Scanner input, FileHandler filehandler) {
        int cosID = getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList());

        System.out.println("Enter the name of the firm: ");
        String name = input.next();

        System.out.println("Enter the firm's contact email: ");
        String mail = input.next();

        System.out.println("Enter the CVR-number of the firm: ");
        int CVR = input.nextInt();

        System.out.println("Enter the firm's contact phonenumber: ");
        int phoneNumber = input.nextInt();

        System.out.println("Enter the firm's address: ");
        String address = input.next();

        filehandler.getFirmList().add(addFirm(cosID, name, mail, CVR, phoneNumber, address));
        System.out.println(name + " has been added with ID:" + cosID);
        System.out.println("Would you like to add another Firm? (y/n)");
        String option = input.next();
        if(option.toLowerCase().equals("y")){
            newFirmScanner(input, filehandler);
        }else{
            addFunctions(input, filehandler);
        }
    }

    public static Firm addFirm(int costumerID, String name, String email, int CVR, int phoneNumber, String address) {
        Firm tempFirm = new Firm(costumerID, name, email, CVR, phoneNumber, address);

        return tempFirm;
    }

    public static privateCustomer addPerson(int costumerID, String firstName, String lastName, String email, int number){
        //creates an new person object
        privateCustomer tempPrivateCustomer = new privateCustomer(costumerID, firstName, lastName, email, number);

        return tempPrivateCustomer;
    }

    public static Event addEvent(int id ,String type, double duration, String description, int customerID, int facilitatorID, String weekday, double time){
        //creates an new event object
        Event tempEvent = new Event(id ,type, duration, description, customerID, facilitatorID, weekday, time);

        return tempEvent;
    }

    // implementer til koden
    public static void deleteFirm() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Firm> arrayFirm = new ArrayList<Firm>();

        Firm firm1 = new Firm(22, "lol", "lol.dk", 141516, 2224, "hejjj");

        arrayFirm.add(firm1);

        System.out.println("Do you want to delete a firm? Y/N");
        String ans = scan.next();

        if(ans.equalsIgnoreCase("Y")) {
            System.out.println("Which firm do you want to delete, enter costumer id: ");
            int delete = scan.nextInt();

            for (int i = 0; i <= arrayFirm.size() - 1; i++) {
                System.out.println(arrayFirm.get(i).getCostumerId());
                if (arrayFirm.get(i).getCostumerId() == delete) {
                    System.out.println("Are you sure? You're deleting: " + arrayFirm.get(i).getName() + "\nAnswer with: Y/N");
                    String answer = scan.next();
                    if(answer.equalsIgnoreCase("y"))
                        System.out.println("Succesfully deleted: " + arrayFirm.get(i).getName() + "\nWith costumer id: " + arrayFirm.get(i).getCostumerId());
                    arrayFirm.remove(i);
                }
            }
        }else if(ans.equalsIgnoreCase("N"))   {
        }
    }

    public static int getFreeEventId(ArrayList<Event> eventList){
        ArrayList<Integer> ids = new ArrayList<Integer>();

        if(eventList.size() > 0){
            for(int i = 0; i <= eventList.size() - 1; i++){
                ids.add(eventList.get(i).getID());
            }
        }

        int newID = 1;

        if(ids.size() != 0){
            newID = Collections.max(ids) + 1;
        }
        return newID;
    }

    // Get a unused ComputerID by finding the highest ID out of all costumer ID's
    public static int getFreeCostumerId(ArrayList<privateCustomer> peopleList, ArrayList<Firm> firmList){

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

    // same as getFreeCostumerId
    public static int getFreeFacilitatorId(ArrayList<Facilitator> facilitatorList){
        ArrayList<Integer> ids = new ArrayList<Integer>();

        if(facilitatorList.size() > 0){
            for(int i = 0; i <= facilitatorList.size() - 1; i++){
                ids.add(facilitatorList.get(i).getID());
            }
        }

        int newID = 1;

        if(ids.size() != 0){
            newID = Collections.max(ids) + 1;
        }
        return newID;
    }

    // Takes an array and adds it to another array.
    public static ArrayList populateArray(ArrayList pasteInto, ArrayList copiedFrom){

        for (int i = 0; i <= copiedFrom.size() - 1; i++){ // runs through the array that's going to be copied from
            pasteInto.add(copiedFrom.get(i)); // add the indexes into the array that's getting pasted into.
        }

        return pasteInto; // return the pasted array;
    }

}
