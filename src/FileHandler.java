import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;


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

            while(myReader.hasNextLine()){
                String type = myReader.next();
                double duration = myReader.nextDouble();
                String description = myReader.next();
                int customerID = myReader.nextInt();
                int facilitatorID = myReader.nextInt();
                String weekday = myReader.next();
                double time = myReader.nextDouble();
                Event tempEvent = new Event(type, duration, description, getCustomerByID(customerID), getFacilitatorByID(facilitatorID), weekday, time);
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


    // writes people from an array into a file, can be read using readPeopleFromFile();
    public void writePeopleToFile(ArrayList<Person> people){

        File personFile = new File("peopleData.txt");
        personFile.delete();

        try {
            FileWriter myWriter = new FileWriter("peopleData.txt", true);
            for(int i = 0; i <= people.size() - 1; i++){
                myWriter.write(people.get(i).getCostumerId() + " " + people.get(i).getFirstName() + " " + people.get(i).getLastName() + " " + people.get(i).getMail() + " " + people.get(i).getNumber());
                if(i != people.size() - 1){
                    myWriter.write("\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
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

                myWriter.write(events.get(i).getType() + " " + events.get(i).getDescription() + " " + events.get(i).getDuration() + " " + events.get(i).getCustomerID() + " " + events.get(i).getFacilitator().getID() + " " + events.get(i).getWeekDay() + " " + events.get(i).getTime());
                if(i != events.size() - 1){
                    myWriter.write("\n");
                }

            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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

    public void saveProgress(){
        writePeopleToFile(getPeopleList());
    }


}
