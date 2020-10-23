public class Person {
    private int costumerId;
    private String firstName;
    private String lastName;
    private String mail;
    private int number;

    public Person(int costumerId, String firstName, String lastName, String mail, int number) {
        this.costumerId = costumerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.number = number;
    }

    public Person() {

    }



    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", number=" + number +
                '}';
    }
    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

