import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class FileHandler {

    private static ArrayList<privateCustomer> peopleList = new ArrayList<privateCustomer>();
    private ArrayList<Event> eventList = new ArrayList<Event>();
    private ArrayList<Facilitator> facilitatorList = new ArrayList<Facilitator>();
    private static ArrayList<Firm> firmList = new ArrayList<Firm>();
    private ArrayList<Arrangement> arrangementList = new ArrayList<Arrangement>();

    public FileHandler() {

    }

    public void readEventsFromFile(){
        ArrayList<Event> tempArray = new ArrayList<Event>();

        try {
            File peopleFile = new File("eventsData.txt");
            Scanner myReader = new Scanner(peopleFile);
            // reads lines from file
            while(myReader.hasNextLine()){
                int id = myReader.nextInt();
                String type = myReader.next();
                String description = myReader.next();
                String durationString = myReader.next();
                double duration = Double.parseDouble(durationString);
                int customerID = myReader.nextInt();
                int facilitatorID = myReader.nextInt();
                String weekday = myReader.next();
                String timeString = myReader.next();
                double time = Double.parseDouble(timeString);
                Event tempEvent = new Event(id ,type, duration, description, customerID, facilitatorID, weekday, time);
                tempArray.add(tempEvent);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i <= tempArray.size() - 1; i++){
            getEventList().add(tempArray.get(i));
        }
    }

    // Reads file, expected to have people in it.
    public void readPeopleFromFile(){

        ArrayList<privateCustomer> tempArray = new ArrayList<privateCustomer>();

        try {
            File peopleFile = new File("peopleData.txt");
            Scanner myReader = new Scanner(peopleFile);

            while(myReader.hasNextLine()){
                int costumerId = myReader.nextInt();
                String firstName = myReader.next();
                String lastName = myReader.next();
                String email = myReader.next();
                int phoneNumber = myReader.nextInt();
                privateCustomer tempPrivateCustomer = new privateCustomer(costumerId, firstName, lastName, email, phoneNumber);
                tempArray.add(tempPrivateCustomer);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0;i <= tempArray.size() - 1; i++){
            getPeopleList().add(tempArray.get(i));
        }
    }

    // Reads file from firm
    public void readFirmFromFile(){

        ArrayList<Firm> firmArray = new ArrayList<Firm>();

        try {
            File firmFile = new File("firmData.txt");
            Scanner myReader = new Scanner(firmFile);

            while(myReader.hasNextLine()){
                int costumerId = myReader.nextInt();
                String name = myReader.next();
                String email = myReader.next();
                int CVR = myReader.nextInt();
                int phoneNumber = myReader.nextInt();
                String adresse = myReader.next();
                Firm newFirm = new Firm(costumerId, name, email, CVR, phoneNumber, adresse);
                firmArray.add(newFirm);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i <= firmArray.size() -1; i++){
            getFirmList().add(firmArray.get(i));
        }
    }

    public void readArrangementFromFile(){
        ArrayList<Arrangement> arrangementArray = new ArrayList<Arrangement>();



        try {
            File firmFile = new File("ArragementData.txt");
            Scanner myReader = new Scanner(firmFile);

            while(myReader.hasNextLine()){
                int arrangementID = myReader.nextInt();
                int customerID = myReader.nextInt();
                String date = myReader.next();
                String eventIDS = myReader.next();
                String[] tempArrayOfEventsString = eventIDS.split(",");
                int[] tempArrayOfEventsInt = new int[tempArrayOfEventsString.length];
                ArrayList<Integer> arrayOfEvents = new ArrayList<Integer>();
                for (int i = 0; i <= tempArrayOfEventsString.length - 1; i++){
                    tempArrayOfEventsInt[i] = Integer.parseInt(tempArrayOfEventsString[i]);
                }
                for (int i = 0; i <= tempArrayOfEventsInt.length - 1; i++){
                    arrayOfEvents.add(tempArrayOfEventsInt[i]);
                }
                Arrangement tempArrangement = new Arrangement(arrangementID, customerID, date, arrayOfEvents);

                arrangementArray.add(tempArrangement);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getArrangementList().clear();
        for(int i = 0; i<= arrangementArray.size() - 1; i++){
            getArrangementList().add(arrangementArray.get(i));
        }
    }

    public void readFacilitatorFromFile(){

        ArrayList<Facilitator> tempFacilitatorArray = new ArrayList<Facilitator>();

        try {
            File facilitatorFile = new File("facilitatorData.txt");
            Scanner myReader = new Scanner(facilitatorFile);

            while (myReader.hasNextLine()){
                int facilitatorID = myReader.nextInt();
                String name = myReader.next();
                int phonenumber = myReader.nextInt();
                String email = myReader.next();
                Facilitator newFacilitator = new Facilitator (facilitatorID, name, phonenumber, email);
                tempFacilitatorArray.add(newFacilitator);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= tempFacilitatorArray.size() - 1; i++){
            getFacilitatorList().add(tempFacilitatorArray.get(i));
        }
    }

    public void writeArrangementToFile(ArrayList<Arrangement> arragementList){


        try {
            FileWriter deleteContentWriter = new FileWriter("ArragementData.txt", false);
            deleteContentWriter.write("");

            FileWriter myWriter = new FileWriter("ArragementData.txt", true);
            myWriter.write("");
            for(int i = 0; i <= arragementList.size() - 1; i++){
                // writes variables into file in a line.
                String tempArray = "";
                for(int k = 0; k <= arragementList.get(i).getEvents().size()-1; k++){

                    tempArray = tempArray + arragementList.get(i).getEvents().get(k);

                    if(k != arragementList.get(i).getEvents().size () -1){

                        tempArray = tempArray + ",";

                    }
                }
                String eventList;
                myWriter.write(arragementList.get(i).getId() + " " + arragementList.get(i).getCustomerID() + " " + arragementList.get(i).getDate() + " " + tempArray);
                if(i != arragementList.size() - 1){ // If we arent on the last index of the array, make a new line.
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // writes people from an array into a file, can be read using readPeopleFromFile();
    public void writePeopleToFile(ArrayList<privateCustomer> people){
        try {
            FileWriter clearFile = new FileWriter("peopleData.txt", false);
            clearFile.write("");


            FileWriter myWriter = new FileWriter("peopleData.txt", true);
            for(int i = 0; i <= people.size() - 1; i++){
                // writes variables into file in a line.
                myWriter.write(people.get(i).getCustomerId() + " " + people.get(i).getFirstName() + " " + people.get(i).getLastName() + " " + people.get(i).getEmail() + " " + people.get(i).getNumber());
                if(i != people.size() - 1){ // If we arent on the last index of the array, make a new line.
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // same as write people to file
    public void writeEventsToFile(ArrayList<Event> events){

        try {
            FileWriter clearFile = new FileWriter("eventsData.txt", false);
            clearFile.write("");

            FileWriter myWriter = new FileWriter("eventsData.txt", true);
            for(int i = 0; i <= events.size() - 1; i++){
                myWriter.write(events.get(i).getID() + " " + events.get(i).getType() + " " + events.get(i).getDescription() + " " + (double) events.get(i).getDuration() + " " + events.get(i).getCustomerID() + " " + events.get(i).getFacilitatorID() + " " + events.get(i).getWeekDay() + " " + events.get(i).getTime());
                if(i != events.size() - 1){
                    myWriter.write("\n");
                }

            }
            myWriter.close();
        } catch (IOException  e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // same as write people to file
    public void writeFirmToFile(ArrayList<Firm> firm){
        try {
            FileWriter clearFile = new FileWriter("firmData.txt", false);
            clearFile.write("");
            FileWriter myWriter = new FileWriter("firmData.txt", true);
            for (int i = 0; i <= firm.size() - 1; i++){

                myWriter.write(firm.get(i).getCustomerId() + " " + firm.get(i).getName() + " " + firm.get(i).getEmail() + " " + firm.get(i).getCVR() + " " + firm.get(i).getPhoneNumber() + " " + firm.get(i).getAdress());
                if (i != firm.size() - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // same as write people to file
    public void writeFacilitatorToFile(ArrayList<Facilitator> facilitator){

        try {
            FileWriter clearFile = new FileWriter("facilitatorData.txt");
            clearFile.write("");


            FileWriter myWriter = new FileWriter("facilitatorData.txt");
            for (int i = 0; i <= facilitator.size() - 1; i++){
                myWriter.write(facilitator.get(i).getFacilitatorID() + " " + facilitator.get(i).getName() + " " + facilitator.get(i).getPhoneNumber() + " " + facilitator.get(i).getEmail());
                if (i != facilitator.size() - 1){
                    myWriter.write("\n");

                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void deleteEventByID(int selectedID){
        for (int i = 0; i <= eventList.size() - 1; i++)   {
            if (eventList.get(i).getID() == selectedID) {
                eventList.remove(i);
            }
        }
    }

    public void deleteFacilitatorByID (int selectedID)  {
        for(int i = 0; i <= facilitatorList.size() - 1; i++)    {
            if (facilitatorList.get(i).getFacilitatorID() == selectedID)    {
                facilitatorList.remove(i);
            }
        }
    }


    // treverses through peopleList and firmList to find the ID that matches the paramter.
    public static Object getCustomerByID(int id){
        for (int i = 0; i <= peopleList.size() -1; i++){
            if(peopleList.get(i).getCustomerId() == id){
                return peopleList.get(i);
            }
        }
        for(int i = 0; i <= firmList.size() - 1; i++){
            if(firmList.get(i).getCustomerId() == id){
                return firmList.get(i);
            }
        }
        return null;
    }
    // treverses through facilitators to find the one with the ID in the paramter;
    public Facilitator getFacilitatorByID(int id){
        for(int i = 0; i <= facilitatorList.size() -1; i++){
            if(facilitatorList.get(i).getID() == id){
                return facilitatorList.get(i);
            }
        }
        return null;
    }
    public Arrangement getArrangementByEventID(int id){
        for (int i = 0; i <= getArrangementList().size() - 1; i++){
            if(getArrangementList().get(i).getEvents().contains(id)){
                return  getArrangementList().get(i);
            }
        }
        return null;
    }

    public Event getEventByID(int id) {
        for (int i = 0; i <= eventList.size() - 1; i++){
            if (eventList.get(i).getID() == id){
                return eventList.get(i);
            }
        }
        return null;
    }

    public void createFiles() throws IOException {
        File personFile = new File("peopleData.txt");
        File firmFile = new File("firmData.txt");
        File facilitator = new File("facilitatorData.txt");
        File event = new File("eventsData.txt");
        File Arrangement = new File("ArragementData.txt");
        if(!personFile.exists()){
             FileWriter myWriter = new FileWriter("peopleData.txt", true);
        }
        if(!firmFile.exists()){
            FileWriter myWriter = new FileWriter("firmData.txt", true);
        }
        if(!facilitator.exists()){
            FileWriter myWriter = new FileWriter("facilitatorData.txt", true);
        }
        if(!event.exists()){
            FileWriter myWriter = new FileWriter("eventsData.txt", true);
        }
        if(!Arrangement.exists()){
            FileWriter myWriter = new FileWriter("ArragementData.txt", true);
        }
    }

    // Method that calls all the write to file methods. Usable for quick save.
    public void saveProgress(){
        writePeopleToFile(getPeopleList());
        writeArrangementToFile(getArrangementList());
        writeEventsToFile(getEventList());
        writeFacilitatorToFile(getFacilitatorList());
        writeFirmToFile(getFirmList());

        System.out.println("Saved data");
    }

    //Method that replaces space with underscore '_'
    public String replaceWithUC(String str){
        String newstring = "";
        newstring = str.replaceAll(" ", "_");
        return newstring;
    }

    //Method that replaces underscore with space
    public String replaceWithSpace(String str){
        String newstring = "";
        newstring = str.replaceAll("_", " ");
        return newstring;
    }

    // Getters
    public ArrayList<Facilitator> getFacilitatorList() {
        return facilitatorList;
    }

    public ArrayList<privateCustomer> getPeopleList() {
        return peopleList;
    }

    public ArrayList<Firm> getFirmList(){
        return firmList;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public ArrayList<Arrangement> getArrangementList() {
        return arrangementList;
    }
}