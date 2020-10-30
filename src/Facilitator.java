public class Facilitator {
    private int facilitatorID;
    private String name;
    private int phoneNumber;
    private String email;

    public Facilitator(int facilitatorID,String name, int phoneNumber, String email) {
        this.facilitatorID = facilitatorID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Facilitator(){

    }

    @Override
    public String toString() {
        return "Facilitator: " +
                "\nName: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nEmail: " + email + "\n=================================";

    }

    public int getFacilitatorID() {
        return facilitatorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getID(){
        return facilitatorID;
    }
}

