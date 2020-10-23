import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;


public class FileHandler {

    public FileHandler() {
        Person person1 = new Person("Henning", "Hansen", "Hemming.Hansen@gmail.com", 29201049);
        Person person2 = new Person("Henning2", "Hansen1", "Hemming.Hansen@gmail.com3", 29201049);
        Person person3 = new Person("Henning3", "Hansen2", "Hemming.Hansen@gmail.com2", 29201049);

        Person[] people = {person1, person2, person3};

        writePersonToFile(people);
        readPersonFromFile();
    }

    public void readPersonFromFile(){

        try {
            File peopleFile = new File("filename.txt");
            Scanner myReader = new Scanner(peopleFile);

            while(myReader.hasNextLine()){
                String data = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void writePersonToFile(Person[] people){

        File personFile = new File("fileName.txt");
        personFile.delete();

        try {
            FileWriter myWriter = new FileWriter("filename.txt", true);
            for(int i = 0; i <= people.length - 1; i++){
                myWriter.write(people[i].getFirstName() + "\n" + people[i].getLastName() + "\n" + people[i].getMail() + "\n" + people[i].getNumber() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
