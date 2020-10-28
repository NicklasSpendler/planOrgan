import java.util.ArrayList;
import java.util.Arrays;

public class Arrangement {

    private Firm firm;
    private privateCustomer privateCustomer;
    private String date;
    private ArrayList<Integer> events;

    // need if the costumer is an private person
    public Arrangement(Firm firm, String date, ArrayList<Integer> events) {
        this.firm = firm;
        this.date = date;
        this.events = events;
    }



    public Arrangement(privateCustomer customer, String date, ArrayList<Integer> events) {
        this.privateCustomer = customer;
        this.date = date;
        this.events = events;
    }

    public Arrangement(Firm firm, String date) {
        this.firm = firm;
        this.date = date;
    }


    // An method that takes an arrayList<Event> as parameter to populate its Events array
    public void populateEvents(){

    }

    /*

    public double getPrice(){
        double price = 0;

        for (int i = 0; i <= events.size() - 1; i++){
            double tempPrice = 0; // initiate a new variable
            // checks if the day is an weekend
            if(events.get(i).getWeekDay() == "fri" || events.get(i).getWeekDay() == "sat" || events.get(i).getWeekDay() == "sun"){ // checks if the vents week day is either fri, sat or sunday.
                tempPrice = (events.get(i).getDuration() * 2) * 350; // add the price of an weekend
            }else{ // if not
                tempPrice = (events.get(i).getDuration() * 2) * 250; // add the price of an week day
            }
            price += tempPrice; // add the price to the total pricepool
        }
        return price; // return the total price pool;
    }
    */


    @Override
    public String toString() {
        return "Arrangement{" +
                "firm=" + firm +
                ", privateCustomer=" + privateCustomer +
                ", date='" + date + '\'' +
                ", events=" + events +
                '}';
    }


    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public privateCustomer getContact() {
        return privateCustomer;
    }

    public void setContact(privateCustomer privateCustomer) {
        this.privateCustomer = privateCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Integer> getEvents() {
        return events;
    }

    public privateCustomer getPrivateCustomer() {
        return privateCustomer;
    }

    public void setPrivateCustomer(privateCustomer privateCustomer) {
        this.privateCustomer = privateCustomer;
    }

    public void setEvents(ArrayList<Integer> events) {
        this.events = events;
    }
}
