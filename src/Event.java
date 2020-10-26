public class Event {

    private int id;    private String type;
    private double duration;
    private String description;
    private int customerID;
    private int facilitatorID;
    private String weekDay;
    private double time;

    public Event(String type, double duration, String description, int customerID, int facilitatorID, String weekday, double time) {
        this.type = type;
        this.duration = duration;
        this.description = description;
        this.customerID = customerID;
        this.facilitatorID = facilitatorID;
        this.weekDay = weekday;
        this.time = time;
    }


    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", customerID=" + customerID +
                ", facilitator=" + facilitatorID +
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

    public int getCustomerID() {
        return customerID;
    }

    public int getId() {
        return id;
    }

    public int getFacilitatorID() {
        return facilitatorID;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getTime() {
        return time;
    }

    // Kunne godt lave noget validering så at den giver description med '_' istedet for spaces
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
