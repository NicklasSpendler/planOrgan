import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    private ArrayList<Person> peopleList = new ArrayList<Person>();
    private ArrayList<Event> eventList = new ArrayList<Event>();
    private ArrayList<Facilitator> facilitatorList = new ArrayList<Facilitator>();
    private ArrayList<Firm> firmList = new ArrayList<Firm>();

    public FileHandler() {

    }


    public ArrayList<Event> readEventsFromFile(){
        ArrayList<Event> tempArray = new ArrayList<Event>();

        try {
            File peopleFile = new File("eventsFile.txt");
            Scanner myReader = new Scanner(peopleFile);
            // reads lines from file
            while(myReader.hasNextLine()){
                String type = myReader.next();
                String description = myReader.next();
                double duration = myReader.nextDouble();
                int customerID = myReader.nextInt();
                int facilitatorID = myReader.nextInt();
                String weekday = myReader.next();
                double time = myReader.nextDouble();
                Event tempEvent = new Event(type, duration, description, customerID, facilitatorID, weekday, time);
                tempArray.add(tempEvent);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return tempArray;
    }

    // Reads file, expected to have people in it.
    public ArrayList<Person> readPeopleFromFile(){

        ArrayList<Person> tempArray = new ArrayList<Person>();

        try {
            File peopleFile = new File("peopleData.txt");
            Scanner myReader = new Scanner(peopleFile);

            while(myReader.hasNextLine()){
                int costumerId = myReader.nextInt();
                String firstName = myReader.next();
                String lastName = myReader.next();
                String email = myReader.next();
                int phoneNumber = myReader.nextInt();
                Person tempPerson = new Person(costumerId, firstName, lastName, email, phoneNumber);
                tempArray.add(tempPerson);
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


    // writes people from an array into a file, can be read using readPeopleFromFile();
    public void writePeopleToFile(ArrayList<Person> people){

        // deletes file if it exsists.
        File personFile = new File("peopleData.txt");
        personFile.delete();

        try {
            FileWriter myWriter = new FileWriter("peopleData.txt", true);
            for(int i = 0; i <= people.size() - 1; i++){
                // writes variables into file in a line.
                myWriter.write(people.get(i).getCostumerId() + " " + people.get(i).getFirstName() + " " + people.get(i).getLastName() + " " + people.get(i).getMail() + " " + people.get(i).getNumber());
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


    // treverses through peopleList and firmList to find the ID that matches the paramter.
    public Object getCustomerByID(int id){
        for (int i = 0; i <= peopleList.size() -1; i++){
            if(peopleList.get(i).getCostumerId() == id){
                return peopleList.get(i);
            }
        }
        for(int i = 0; i <= firmList.size() - 1; i++){
            if(firmList.get(i).getCostumerId() == id){
                return firmList.get(i);
            }
        }
        return null;
    }

    // same as write people to file
    public void writeFirmToFile(ArrayList<Firm> firm){
        File firmFile = new File("firmData.txt");
        firmFile.delete();

        try {
            FileWriter myWriter = new FileWriter("firmData.txt", true);
            for (int i = 0; i <= firm.size() - 1; i++){

                myWriter.write(firm.get(i).getCostumerId() + " " + firm.get(i).getName() + " " + firm.get(i).getEmail() + " " + firm.get(i).getCVR() + " " + firm.get(i).getPhoneNumber() + " " + firm.get(i).getAdress());
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


    // treverses through facilitators to find the one with the ID in the paramter;
    public Facilitator getFacilitatorByID(int id){
        for(int i = 0; i <= facilitatorList.size() -1; i++){
            if(facilitatorList.get(i).getID() == id){
                return facilitatorList.get(i);
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

    public ArrayList<Person> getPeopleList() {
        return peopleList;
    }

    public ArrayList<Firm> getFirmList(){
        return firmList;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }
}
