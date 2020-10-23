import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;


public class FileHandler {

    public FileHandler() {

    }

    // Reads file, expected to have people in it.
    public ArrayList<Person> readPeopleFromFile(){

        ArrayList<Person> tempArray = new ArrayList<Person>();

        try {
            File peopleFile = new File("peopleData.txt");
            Scanner myReader = new Scanner(peopleFile);

            while(myReader.hasNextLine()){
                String firstName = myReader.next();
                String lastName = myReader.next();
                String email = myReader.next();
                int phoneNumber = myReader.nextInt();
                Person tempPerson = new Person(firstName, lastName, email, phoneNumber);
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
                myWriter.write(people.get(i).getFirstName() + " " + people.get(i).getLastName() + " " + people.get(i).getMail() + " " + people.get(i).getNumber() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void writeEventsToFile(ArrayList<Event> events){

        File eventsFile = new File("eventsFile.txt");
        eventsFile.delete();

        try {
            FileWriter myWriter = new FileWriter("eventsFile.txt", true);
            for(int i = 0; i <= events.size() - 1; i++){

                // Checks if the customer is firm or person

                if(events.get(i).getCustomerFirm() != null){
                    myWriter.write(events.get(i).getType() + " " + events.get(i).getDuration() + " " + events.get(i).getCustomerFirm() + " " + events.get(i).getFacilitator() + " " + events.get(i).getWeekDay() + "\n");
                }else if(events.get(i).getCustomerPersom() != null){
                    myWriter.write(events.get(i).getType() + " " + events.get(i).getDuration() + " " + events.get(i).getCustomerPersom() + " " + events.get(i).getFacilitator() + " " + events.get(i).getWeekDay() + "\n");
                }

            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
