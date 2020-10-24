public class Facilitator {
    private String name;
    private int phoneNumber;
    private String email;
    private int facilitatorID;

    public Facilitator(int facilitatorID,String name, int phoneNumber, String email) {
        this.facilitatorID = facilitatorID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString() {
        return "Facilitator{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
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

