import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    private ArrayList<privateCustomer> peopleList = new ArrayList<privateCustomer>();
    private ArrayList<Event> eventList = new ArrayList<Event>();
    private ArrayList<Facilitator> facilitatorList = new ArrayList<Facilitator>();
    private ArrayList<Firm> firmList = new ArrayList<Firm>();
    private ArrayList<Arrangement> arrangementList = new ArrayList<Arrangement>();

    public FileHandler() {

    }

    public ArrayList<Event> readEventsFromFile(){
        ArrayList<Event> tempArray = new ArrayList<Event>();

        try {
            File peopleFile = new File("eventsFile.txt");
            Scanner myReader = new Scanner(peopleFile);
            // reads lines from file
            while(myReader.hasNextLine()){
                int id = myReader.nextInt();
                String type = myReader.next();
                String description = myReader.next();
                double duration = myReader.nextDouble();
                int customerID = myReader.nextInt();
                int facilitatorID = myReader.nextInt();
                String weekday = myReader.next();
                double time = myReader.nextDouble();
                Event tempEvent = new Event(id ,type, duration, description, customerID, facilitatorID, weekday, time);
                tempArray.add(tempEvent);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return tempArray;
    }

    // Reads file, expected to have people in it.
    public ArrayList<privateCustomer> readPeopleFromFile(){

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

        return tempArray;
    }

    // Reads file from firm
    public ArrayList<Firm> readFirmFromFile(){

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

        return firmArray;

    }

    public ArrayList<Facilitator> readFacilitatorFromFile(){

        ArrayList<Facilitator> readFacilitator = new ArrayList<Facilitator>();

        try {
            File facilitatorFile = new File("facilitatorData.txt");
            Scanner myReader = new Scanner(facilitatorFile);

            while (myReader.hasNextLine()){
                int facilitatorID = myReader.nextInt();
                String name = myReader.next();
                int phonenumber = myReader.nextInt();
                String email = myReader.next();
                Facilitator newFacilitator = new Facilitator (facilitatorID, name, phonenumber, email);
                readFacilitator.add(newFacilitator);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return readFacilitator;
    }

    public void writeArrangementToFile(ArrayList<Arrangement> arragementList){
        // deletes file if it exsists.
        File personFile = new File("ArragementData.txt");
        personFile.delete();

        try {
            FileWriter myWriter = new FileWriter("ArragementData.txt", true);
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
            System.out.println("Successfully wrote Arrangement to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // writes people from an array into a file, can be read using readPeopleFromFile();
    public void writePeopleToFile(ArrayList<privateCustomer> people){

        // deletes file if it exsists.
        File personFile = new File("peopleData.txt");
        personFile.delete();

        try {
            FileWriter myWriter = new FileWriter("peopleData.txt", true);
            for(int i = 0; i <= people.size() - 1; i++){
                // writes variables into file in a line.
                myWriter.write(people.get(i).getCustomerId() + " " + people.get(i).getFirstName() + " " + people.get(i).getLastName() + " " + people.get(i).getEmail() + " " + people.get(i).getNumber());
                if(i != people.size() - 1){ // If we arent on the last index of the array, make a new line.
                    myWriter.write("\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote peoples to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // same as write people to file
    public void writeEventsToFile(ArrayList<Event> events){

        File eventsFile = new File("eventsFile.txt");
        eventsFile.delete();

        try {
            FileWriter myWriter = new FileWriter("eventsFile.txt", true);
            for(int i = 0; i <= events.size() - 1; i++){

                myWriter.write(events.get(i).getType() + " " + events.get(i).getDescription() + " " + events.get(i).getDuration() + " " + events.get(i).getCustomerID() + " " + events.get(i).getFacilitatorID() + " " + events.get(i).getWeekDay() + " " + events.get(i).getTime());
                if(i != events.size() - 1){
                    myWriter.write("\n");
                }

            }
            myWriter.close();
            System.out.println("Successfully wrote events to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // same as write people to file
    public void writeFirmToFile(ArrayList<Firm> firm){
        File firmFile = new File("firmData.txt");
        firmFile.delete();

        try {
            FileWriter myWriter = new FileWriter("firmData.txt", true);
            for (int i = 0; i <= firm.size() - 1; i++){

                myWriter.write(firm.get(i).getCustomerId() + " " + firm.get(i).getName() + " " + firm.get(i).getEmail() + " " + firm.get(i).getCVR() + " " + firm.get(i).getPhoneNumber() + " " + firm.get(i).getAdress());
                if (i != firm.size() - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote firm to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // same as write people to file
    public void writeFacilitatorToFile(ArrayList<Facilitator> facilitator){
        File facilitatorFile = new File("facilitatorData.txt");
        facilitatorFile.delete();

        try {
            FileWriter myWriter = new FileWriter("facilitatorData.txt");
            for (int i = 0; i <= facilitator.size() - 1; i++){
                myWriter.write(facilitator.get(i).getFacilitatorID() + " " + facilitator.get(i).getName() + " " + facilitator.get(i).getPhoneNumber() + " " + facilitator.get(i).getEmail());
                if (i != facilitator.size() - 1){
                    myWriter.write("\n");

                }
            }
            myWriter.close();
            System.out.println("Successfully wrote facilitator to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }


    // treverses through peopleList and firmList to find the ID that matches the paramter.
    public Object getCustomerByID(int id){
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
    public Event getEventByID(int id) {
        for (int i = 0; i <= eventList.size() - 1; i++){
            if (eventList.get(i).getID() == id){
                return eventList.get(i);
            }
        }
        return null;
    }

    // Method that calls all the write to file methods. Usable for quick save.
    public void saveProgress(){
        writePeopleToFile(getPeopleList());
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