public class Event {
    private int id;
    private String type;
    private double duration;
    private String description;
    private int customerID;
    private int facilitatorID;
    private String weekDay;
    private double time;

    public Event(int id, String type, double duration, String description, int customerID, int facilitatorID, String weekday, double time) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.description = description;
        this.customerID = customerID;
        this.facilitatorID = facilitatorID;
        this.weekDay = weekday;
        this.time = time;
    }

    public Event(){
    }

    @Override
    public String toString() {
        return "Event: " +
                "\nID: " + id +
                "\nType: " + type +
                "\nDuration: " + duration +
                "\nDescription: " + description +
                "\nCustomer id: " + customerID +
                "\nFacilitator id: " + facilitatorID +
                "\nWeekday: " + weekDay +
                "\nTime: " + time +
                "\n=================================";
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

    public int getID() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFacilitatorID(int facilitatorID) {
        this.facilitatorID = facilitatorID;
    }

    public void setTime(double time) {
        this.time = time;
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
