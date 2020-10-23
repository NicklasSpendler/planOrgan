import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();

        ArrayList<Person> peopleList = new ArrayList<Person>();
        ArrayList<Event> eventList = new ArrayList<Event>();



        peopleList = populateArray(peopleList, filehandler.readPeopleFromFile());

        /*
        Person person1 = new Person("Henning", "Hansen", "Henning.Hansen@gmail.com", 29201049);

        Person person2 = new Person("Henning2", "Hansen1", "Hemming.Hansen@gmail.com3", 29201049);
        Person person3 = new Person("Henning3", "Hansen2", "Hemming.Hansen@gmail.com2", 29201049);
         */

        Firm firm1 = new Firm("OmfgFirm", 28583910, 29192919, "OmfgzAdresse");
        Facilitator facilitator1 = new Facilitator("Jørgen", 20202020, "Jørgen.jørgesen@gmail.com");
        Event event1 = new Event("Birthday", 5.5, peopleList.get(1), facilitator1, "fri");
        Event event2 = new Event("Firm Party", 3, peopleList.get(2), facilitator1, "mon");

        eventList.add(event1);
        eventList.add(event2);

        filehandler.writeEventsToFile(eventList);

        Event[] events = {event1, event2};

        Arrangement arrangement1 = new Arrangement(firm1, peopleList.get(1), "05/11/2020", events);
    }

    public static ArrayList populateArray(ArrayList pasteInto, ArrayList copiedFrom){
        pasteInto.clear();

        for (int i = 0; i <= copiedFrom.size() - 1; i++){
            pasteInto.add(copiedFrom.get(i));
        }

        return pasteInto;
    }

}
