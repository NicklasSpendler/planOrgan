import java.util.ArrayList;
import java.util.Arrays;

public class Arrangement {

    private int id;
    private int customerID;
    private String date;
    private ArrayList<Integer> events;

    // need if the costumer is an private person
    public Arrangement(int id, int customerID, String date, ArrayList<Integer> events) {
        this.id = id;
        this.customerID = customerID;
        this.date = date;
        this.events = events;
    }

    public Arrangement(){

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
        return "Arrangement:" +
                "\nID: " + id +
                "\nCustomer id: " + customerID +
                "\nDate: " + date +
                "\nEvents: " + events +
                "\n=================================";
    }
    public int getId() {
        return id;
    }

    public int getCustomerID() {
        return customerID;
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

    public void setEvents(ArrayList<Integer> events) {
        this.events = events;
    }

    public void addEvent(Integer eventid){
        events.add(eventid);
    }
}
