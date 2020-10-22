import java.util.Arrays;

public class Arrangement {

    private Firm firm;
    private Person contact;
    private String date;
    private Event[] events;

    public Arrangement(Firm firm, Person contact, String date, Event[] events) {
        this.firm = firm;
        this.contact = contact;
        this.date = date;
        this.events = events;
    }

    public Arrangement(Firm firm, Person contact, String date) {
        this.firm = firm;
        this.contact = contact;
        this.date = date;
    }

    public double getPrice(){
        double price = 0;

        for (int i = 0; i <= events.length - 1; i++){
            double tempPrice = 0;
            // checks if the day is an weekend
            if(events[i].getWeekDay() == "fri" || events[i].getWeekDay() == "sat" || events[i].getWeekDay() == "sun"){
                tempPrice = (events[i].getDuration() * 2) * 350;
                System.out.println("Weekend");
            }else{ // if weekday
                System.out.println("Weekday");
                tempPrice = (events[i].getDuration() * 2) * 250;
            }
            System.out.println(events[i].getWeekDay());
            price += tempPrice;
        }
        return price;
    }


    @Override
    public String toString() {
        return "Arrangement{" +
                "firm=" + firm +
                ", contact=" + contact +
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

    public Person getContact() {
        return contact;
    }

    public void setContact(Person contact) {
        this.contact = contact;
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

    public void setEvents(Event[] events) {
        this.events = events;
    }
}
