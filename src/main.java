import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();

        Person person1 = new Person("Henning", "Hansen", "Henning.Hansen@gmail.com", 29201049);
        /*
        Person person2 = new Person("Henning2", "Hansen1", "Hemming.Hansen@gmail.com3", 29201049);
        Person person3 = new Person("Henning3", "Hansen2", "Hemming.Hansen@gmail.com2", 29201049);
         */

        Firm firm1 = new Firm("OmfgFirm", 28583910, 29192919, "OmfgzAdresse");
        Facilitator facilitator1 = new Facilitator("Jørgen", 20202020, "Jørgen.jørgesen@gmail.com");
        Event event1 = new Event("Birthday", 5.5, person1, facilitator1, "fri");
        Event event2 = new Event("Firm Party", 3, person1, facilitator1, "mon");

        Event[] events = {event1, event2};

        Arrangement arrangement1 = new Arrangement(firm1, person1, "05/11/2020", events);

        System.out.println(arrangement1.getPrice());
    }

}
