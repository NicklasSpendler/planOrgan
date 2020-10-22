public class Firm {

    private String name;
    private int CVR;
    private int phoneNumber;
    private String adresse;

    public Firm(String name, int CVR, int phoneNumber, String adresse){
        this.name = name;
        this.CVR = CVR;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "name='" + name + '\'' +
                ", CVR=" + CVR +
                ", phoneNumber=" + phoneNumber +
                ", adresse='" + adresse + '\'' +
                '}';
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
