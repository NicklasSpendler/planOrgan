import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();


        //Example on how to create a new Person

        /*
        filehandler.getPeopleList().add(addPerson(getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList()), "Hemming4", "Hansen", "HemmingHansen4@gayMail.com", 20202020));
        filehandler.getPeopleList().add(addPerson(getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList()), "Hemming2", "Hansen", "HemmingHansen4@gayMail.com", 20202020));
        filehandler.getPeopleList().add(addPerson(getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList()), "Hemming1", "Hansen", "HemmingHansen4@gayMail.com", 20202020));
         */

        

        /*
        Firm firm1 = new Firm(4,"OmfgFirm", "pyskoFirm@gangstermail.com", 28583910, 29192919, "OmfgzAdresse");

        firmList.add(firm1);

        Facilitator facilitator1 = new Facilitator("Jørgen", 20202020, "Jørgen.jørgesen@gmail.com");
        Event event1 = new Event("Birthday", 5.5, "beskrivelse", peopleList.get(1), facilitator1, "fri", 8.5);
        Event event2 = new Event("Firm Party", 3,"beskrivelse", peopleList.get(2), facilitator1, "mon",20);

        Event[] events = {event1, event2};

        Arrangement arrangement1 = new Arrangement(firm1, "05/11/2020", events);
         */
    }

    public static Person addPerson(int costumerID, String firstName, String lastName, String email, int number){

        //creates an new person object
        Person tempPerson = new Person(costumerID, firstName, lastName, email, number);

        return tempPerson;
    }

    // Get a unused ComputerID by finding the highest ID out of all costumer ID's
    public static int getFreeCostumerId(ArrayList<Person> peopleList, ArrayList<Firm> firmList){

        //Init new Integer array
        ArrayList<Integer> ids = new ArrayList<Integer>();

        // Populate array with current ids
        if(peopleList.size() > 0){
            for (int i = 0; i <= peopleList.size() - 1; i++){
                ids.add(peopleList.get(i).getCostumerId());
            }
        }

        if(firmList.size() > 0){
            for(int k = 0; k <= firmList.size() - 1; k++){
                ids.add(firmList.get(k).getCostumerId());
            }
        }

        int newID = 1;

        // Finds the highest value in the array and adds one to it.
        if(ids.size() != 0){
            newID = Collections.max(ids) + 1;
        }

        return newID;
    }

    public static ArrayList populateArray(ArrayList pasteInto, ArrayList copiedFrom){

        for (int i = 0; i <= copiedFrom.size() - 1; i++){
            pasteInto.add(copiedFrom.get(i));
        }

        return pasteInto;
    }

}
