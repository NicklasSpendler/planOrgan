public class Firm {

    int costumerId;
    private String name;
    private String email;
    private int CVR;
    private int phoneNumber;
    private String address;

    public Firm(int costumerId, String name, String email, int CVR, int phoneNumber, String address){
        this.costumerId = costumerId;
        this.name = name;
        this.email = email;
        this.CVR = CVR;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "ID: '" + costumerId + '\'' +
                "name='" + name + '\'' +
                ", CVR=" + CVR +
                ", phoneNumber=" + phoneNumber +
                ", adresse='" + address + '\'' +
                '}';
    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getCVR() {
        return CVR;
    }

    public void setCVR(int CVR) {
        this.CVR = CVR;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adresse) {
        this.address = adresse;
    }
}
