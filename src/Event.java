public class Event {

    private String type;
    private double duration;
    private String description;
    private Person customerPersom;
    private Firm customerFirm;
    private Facilitator facilitator;
    private String weekDay;
    private double time;

    public Event(String type, double duration, String description, Person customer, Facilitator facilitator, String weekday, double time) {
        this.type = type;
        this.duration = duration;
        this.description = description;
        this.customerPersom = customer;
        this.facilitator = facilitator;
        this.weekDay = weekday;
        this.time = time;
    }

    public Event(String type, double duration, Firm customer, Facilitator facilitator, String weekday, double time) {
        this.type = type;
        this.duration = duration;
        this.description = description;
        this.customerFirm = customer;
        this.facilitator = facilitator;
        this.weekDay = weekday;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", customerPersom=" + customerPersom +
                ", customerFirm=" + customerFirm +
                ", facilitator=" + facilitator +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Person getCustomerPersom() {
        return customerPersom;
    }

    public void setCustomerPersom(Person customerPersom) {
        this.customerPersom = customerPersom;
    }

    public Firm getCustomerFirm() {
        return customerFirm;
    }

    public void setCustomerFirm(Firm customerFirm) {
        this.customerFirm = customerFirm;
    }

    public Facilitator getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(Facilitator facilitator) {
        this.facilitator = facilitator;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
}
