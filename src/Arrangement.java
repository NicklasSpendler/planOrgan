import java.util.Arrays;

public class Arrangement {

    private Firm firm;
    private privateCustomer privateCustomer;
    private String date;
    private Event[] events;

    // need if the costumer is an private person
    public Arrangement(Firm firm, String date, Event[] events) {
        this.firm = firm;
        this.date = date;
        this.events = events;
    }



    public Arrangement(privateCustomer customer, String date, Event[] events) {
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

    public double getPrice(){
        double price = 0;

        for (int i = 0; i <= events.length - 1; i++){
            double tempPrice = 0; // initiate a new variable
            // checks if the day is an weekend
            if(events[i].getWeekDay() == "fri" || events[i].getWeekDay() == "sat" || events[i].getWeekDay() == "sun"){ // checks if the vents week day is either fri, sat or sunday.
                tempPrice = (events[i].getDuration() * 2) * 350; // add the price of an weekend
            }else{ // if not
                tempPrice = (events[i].getDuration() * 2) * 250; // add the price of an week day
            }
            price += tempPrice; // add the price to the total pricepool
        }
        return price; // return the total price pool;
    }


    // Needs an condictional if the arrangement has an private customer or firm
    @Override
    public String toString() {
        return "Arrangement{" +
                "firm=" + firm +
                ", person=" + privateCustomer +
                ", date='" + date + '\'' +
                ", events=" + Arrays.toString(events) +
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

    public Event[] getEvents() {
        return events;
    }

    public privateCustomer getPrivateCustomer() {
        return privateCustomer;
    }

    public void setPrivateCustomer(privateCustomer privateCustomer) {
        this.privateCustomer = privateCustomer;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }
}
