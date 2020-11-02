import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        FileHandler filehandler = new FileHandler();

        // create files that doesnt exsist
        filehandler.createFiles();

        filehandler.readArrangementFromFile();
        filehandler.readPeopleFromFile();
        filehandler.readEventsFromFile();
        filehandler.readFacilitatorFromFile();
        filehandler.readFirmFromFile();

        /*
        filehandler.getEventList().add(addEvent(getFreeEventId(filehandler.getEventList()), "lol", 8, "lol", 1, 1, "mon", 8));
        filehandler.getEventList().add(addEvent(getFreeEventId(filehandler.getEventList()), "lol", 8, "lol", 1, 1, "mon", 8));

        ArrayList<Integer> tempIds = new ArrayList<Integer>();
        tempIds.add(1);
        tempIds.add(2);

        filehandler.getArrangementList().add(addArrangement(getFreeArrangementId(filehandler.getArrangementList()),1,"1", tempIds));

         */

        mainMenu(input, filehandler);

        //Example on how to get customer by ID
        //System.out.println(filehandler.getCustomerByID(1));

        /*
        //Example on how to create a new Event
        filehandler.getEventList().add(addEvent("Birthday", 5.5, "beskrivelse", 0, facilitator1, "fri", 8.5));


        //Example on how to create a new Person
        filehandler.getPeopleList().add(addPerson(getFreeCostumerId(filehandler.getPeopleList(), filehandler.getFirmList()), "Hemming4", "Hansen", "HemmingHansen4@gayMail.com", 20202020));
         */
    }

    // Husk at lave search funktionalitet

    public static void mainMenu(Scanner input, FileHandler filehandler){
        System.out.println("====== Main Menu ======");
        System.out.println("S: Show Data");
        System.out.println("A: Search data");
        System.out.println("D: Save Data");
        System.out.println("H: Help menu");
        System.out.println("Q: Quit");
        System.out.println("=======================");

        String option = input.next();

        if (option.equalsIgnoreCase("s")){
            showData(input, filehandler);
        }else if (option.equalsIgnoreCase("d")){
            filehandler.saveProgress();
            mainMenu(input, filehandler);
        }else if(option.equalsIgnoreCase("a")){
            searchList(input, filehandler);
        }else if (option.equalsIgnoreCase("H")){
            helpMenu(input, filehandler);
        }
    }

    public static void showData(Scanner input, FileHandler filehandler){
        System.out.println("=======Show Data=======");
        System.out.println("P: Private Customer[" + filehandler.getPeopleList().size() + "]");
        System.out.println("F: Firm[" + filehandler.getFirmList().size() + "]");
        System.out.println("A: Arrangement[" + filehandler.getArrangementList().size() + "]");
        System.out.println("I: Facilitator[" + filehandler.getFacilitatorList().size() + "]");
        System.out.println("E: Events");
        System.out.println("B: Back");

        String option = input.next();
        if(option.equalsIgnoreCase("b")){
            mainMenu(input, filehandler);
        } else if (option.equalsIgnoreCase("p")){
            showPeopleData(input, filehandler);
        } else if(option.equalsIgnoreCase("f")){
            showFirmData(input, filehandler);
        }else if(option.equalsIgnoreCase("i")){
            showFacilitatorData(input, filehandler);
        }else if(option.equalsIgnoreCase("a")){
            showArrangement(input, filehandler);
        }else if(option.equalsIgnoreCase("e")){
            showEvents(input, filehandler);
        }
    }

    public static void showEvents(Scanner input, FileHandler filehandler){
        System.out.println(filehandler.getEventList());
        showData(input, filehandler);
    }

    public static void showFirmData(Scanner input, FileHandler filehandler){
        System.out.println("====Show Firm Data=====");
        if(filehandler.getFirmList().size() == 0){
            System.out.println("There's No Firm Data");
        }else{
            for(int i = 0; i <= filehandler.getFirmList().size() -1; i++){
                System.out.println(" Customer ID: " + filehandler.getFirmList().get(i).getCustomerId() + " Firm name: " + filehandler.getFirmList().get(i).getName() + " Email: " + filehandler.getFirmList().get(i).getEmail() + " CVR: " + filehandler.getFirmList().get(i).getCVR() + " Phone number: " + filehandler.getFirmList().get(i).getPhoneNumber() + " Address: " + filehandler.getFirmList().get(i).getAddress());
            }
        }

        System.out.println("A = Add a new Firm | D = Delete a private Customer | E = Edit a Firm | B = back");
        String option = input.next();
        if(option.equalsIgnoreCase("d")){
            System.out.println("Give the ID of the Private Customer you would like to delete: ");
            int selectedId = input.nextInt();
            deleteFirm(input, filehandler, selectedId);
        }else if(option.equalsIgnoreCase("b")){
            showData(input, filehandler);
        } else if (option.equalsIgnoreCase("a")){
            newFirmScanner(input, filehandler);
        }else if(option.equalsIgnoreCase("E")){
            System.out.println("Which Firm would you like to edit? Give Firm ID");
            int chooseID = input.nextInt();
            editFirm(input, filehandler, chooseID);
        }
    }

    public static void showFacilitatorData(Scanner input, FileHandler filehandler){
        System.out.println("===Show Facilitator===");
        if (filehandler.getFacilitatorList().size() == 0){
            System.out.println("There's No Facilitator Data");
        }else {
            for (int i = 0; i <= filehandler.getFacilitatorList().size() - 1; i++) {
                System.out.println("ID: " + filehandler.getFacilitatorList().get(i).getFacilitatorID() + " Name: " + filehandler.getFacilitatorList().get(i).getName() + " Phone number: " + filehandler.getFacilitatorList().get(i).getPhoneNumber() + " Email: " + filehandler.getFacilitatorList().get(i).getEmail());
            }
        }
        System.out.println("A = Add a new Facilitator | D = Delete a Facilitator | E = Edit a Facilitator | B = back");
        String answer = input.next();
        if(answer.equalsIgnoreCase("D")) {
            System.out.println("Enter the ID of the Facilitator that you would like to delete");
            int selectedID = input.nextInt();
            deleteFacilitator(input, filehandler, selectedID);
        }else if (answer.equalsIgnoreCase("B")){
            showData(input, filehandler);
        }else if(answer.equalsIgnoreCase("A")){
            newFacilitatorScanner(input, filehandler);
        }else if(answer.equalsIgnoreCase("E")){
            System.out.println("Which facilitator would you like to edit? Give facilitator ID");
            int chooseID = input.nextInt();
            editFacilitator(input, filehandler, chooseID);
        }
    }

    public static void showPeopleData(Scanner input, FileHandler filehandler){
        System.out.println("=Show Private Customer=");
        if (filehandler.getPeopleList().size() == 0){
            System.out.println("There's No People Data");
        }else {
            for (int i = 0; i <= filehandler.getPeopleList().size() - 1; i++) {
                System.out.println("id: " + filehandler.getPeopleList().get(i).getCustomerId() + " Name: " + filehandler.getPeopleList().get(i).getFirstName() + " " + filehandler.getPeopleList().get(i).getLastName() + " Email: " + filehandler.getPeopleList().get(i).getEmail() + " Phone number: " + filehandler.getPeopleList().get(i).getNumber());
            }
        }

        System.out.println("A = Add a new private Customer | D = Delete a private Customer | E = Edit a Private Customer | B = back");
        String option = input.next();
        if(option.equalsIgnoreCase("d")){
            System.out.println("Give the ID of the Private Customer you would like to delete: ");
            int selectedId = input.nextInt();
            deletePerson(input, filehandler, selectedId);
        }else if(option.equalsIgnoreCase("A")){
            newPersonScanner(input, filehandler);
        }else if(option.equalsIgnoreCase("b")){
            showData(input, filehandler);
        }else if(option.equalsIgnoreCase("e")){
            System.out.println("Which costumer would you like to edit? Give the customers ID");
            int chooseID = input.nextInt();
            editPerson(input, filehandler, chooseID);
        }
    }

    public static void showArrangement(Scanner input, FileHandler filehandler){
        System.out.println("======Arrangement======");
        for (int i = 0; i <= filehandler.getArrangementList().size() -1; i++){
            System.out.println("id: " + filehandler.getArrangementList().get(i).getId() + " Customer: " + filehandler.getArrangementList().get(i).getCustomerID() + " Date: " + filehandler.getArrangementList().get(i).getDate() + " Event ids: " + filehandler.getArrangementList().get(i).getEvents());
        }

        System.out.println("A = Add a new Arrangement | D = Delete an Arrangement | E = Edit an Arrangement | B = Back");
        String option = input.next();

        if(option.equalsIgnoreCase("a")){
            newArrangementScanner(input, filehandler);
        }else if(option.equalsIgnoreCase("b")){
            showData(input, filehandler);
        }else if(option.equalsIgnoreCase("e")){
            System.out.println("Give the ID of the Arrangement you would like to edit");
            int selectedID = input.nextInt();
            editArrangement(input, filehandler, selectedID);
        }else if(option.equalsIgnoreCase("d")){
            System.out.println("Give the ID of the Arrangement you would like to delete");
            int selectedID = input.nextInt();
            deleteArrangement(input, filehandler, selectedID);
        }
    }

    public static void deletePerson(Scanner input, FileHandler filehandler, int selectedID) {
            for (int i = 0; i <= filehandler.getPeopleList().size() - 1; i++){
                if (filehandler.getPeopleList().get(i).getCustomerId() == selectedID) {
                    System.out.println("Are you sure? You're deleting: " + filehandler.getPeopleList().get(i).getFirstName() + "\nAnswer with Y/N");
                    String answer = input.next();
                    if(answer.equalsIgnoreCase("y")) {
                        System.out.println("Succesfully deleted: " + filehandler.getPeopleList().get(i).getFirstName() + "\nWith costumer id: " + filehandler.getPeopleList().get(i).getCustomerId());
                        filehandler.getPeopleList().remove(i);
                    }
                }
            }
        showPeopleData(input, filehandler);
        }

    // Deletes firm with chosen ID
    public static void deleteFirm(Scanner input, FileHandler filehandler, int selectedID) {
            for (int i = 0; i <= filehandler.getFirmList().size() - 1; i++) {
                System.out.println(filehandler.getFirmList().get(i).getCustomerId());
                if (filehandler.getFirmList().get(i).getCustomerId() == selectedID) {
                    System.out.println("Are you sure? You're deleting: " + filehandler.getFirmList().get(i).getName() + "\nAnswer with: Y/N");
                    String answer = input.next();
                    if(answer.equalsIgnoreCase("y"))
                        System.out.println("Succesfully deleted: " + filehandler.getFirmList().get(i).getName() + "\nWith costumer id: " +filehandler.getFirmList().get(i).getCustomerId());
                    filehandler.getFirmList().remove(i);
                }
            }
            showFirmData(input, filehandler);
        }

    public static void deleteEvent(Scanner input, FileHandler filehandler, int selectedID, int arrangementID) {
        for (int i = 0; i <= filehandler.getEventList().size() - 1; i++) {
            System.out.println(filehandler.getEventList().get(i).getCustomerID());
            if (filehandler.getEventList().get(i).getCustomerID() == selectedID) {
                System.out.println("Are you sure? You're deleting: " + filehandler.getEventList().get(i).getCustomerID() + "\nType: " + filehandler.getEventList().get(i).getType() + "\nAnswer with: Y/N");
                String answer = input.next();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Successfully deleted: " + filehandler.getEventList().get(i).getCustomerID() + "\nType: " + filehandler.getEventList().get(i).getType());
                    filehandler.getEventList().remove(i);
                }

            }
        }
        editArrangement(input, filehandler, arrangementID);
    }

    public static void deleteFacilitator(Scanner input, FileHandler filehandler, int selectedID) {
        for (int i = 0; i <= filehandler.getFacilitatorList().size() - 1; i++) {
            System.out.println(filehandler.getFacilitatorList().get(i).getFacilitatorID());
            if (filehandler.getFacilitatorList().get(i).getFacilitatorID() == selectedID) {
                System.out.println("Are you sure? You're deleting: " + filehandler.getFacilitatorList().get(i).getName() + "\nAnswer with Y/N");
                String answer = input.next();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Successfully deleted: " + filehandler.getFacilitatorList().get(i).getName() + "\nWith facilitatorID: " + filehandler.getFacilitatorList().get(i).getFacilitatorID());
                    filehandler.getFacilitatorList().remove(i);
                }

            }
        }
        showFacilitatorData(input, filehandler);
    }

    public static void deleteArrangement(Scanner input, FileHandler fileHandler, int selectedID){
        for (int i = 0; i <= fileHandler.getArrangementList().size() -1; i++){

            if(fileHandler.getArrangementList().get(i).getId() == selectedID){

                System.out.println(fileHandler.getArrangementList().get(i));
                System.out.println("You sure you want to delete this Arrangement? (y/n)");
                String option = input.next();
                if(option.equalsIgnoreCase("y")){
                    // deletes events that's associated with arrangement
                    for (int j = 0; j <= fileHandler.getEventList().size() -1; j++){
                        for (int k = 0; k <= fileHandler.getArrangementList().get(i).getEvents().size() - 1; k++){
                            if(fileHandler.getEventList().get(j).getID() == fileHandler.getArrangementList().get(i).getEvents().get(k)){
                                fileHandler.getEventList().remove(j);
                            }
                        }
                    }

                    fileHandler.getArrangementList().remove(i);
                }
            }

        }
        showArrangement(input,fileHandler);
    }

    public static void editPerson(Scanner input, FileHandler fileHandler, int selectedID){
        privateCustomer tempPrivateCustomer = new privateCustomer();
        int indexNumber = 0;

        for (int i = 0; i <= fileHandler.getPeopleList().size() - 1; i++){
            if (fileHandler.getPeopleList().get(i).getCustomerId() == selectedID){
                tempPrivateCustomer = fileHandler.getPeopleList().get(i);
                indexNumber = i;
            }
        }
        System.out.println("Change the firstName from '" + tempPrivateCustomer.getFirstName() + "' to:");
        String newName = input.next();
        if(!newName.equalsIgnoreCase("0")){
            tempPrivateCustomer.setFirstName(newName);
        }
        System.out.println("Change the lastName from '"+ tempPrivateCustomer.getLastName() +"' to:");
        String newLastName = input.next();
        if(!newLastName.equalsIgnoreCase("0")){
            tempPrivateCustomer.setLastName(newLastName);
        }
        System.out.println("Change the email from '"+ tempPrivateCustomer.getEmail() +"' to:");
        String newEmail = input.next();
        if(!newEmail.equalsIgnoreCase("0")){
            tempPrivateCustomer.setEmail(newEmail);
        }
        System.out.println("Change phone number from '" + tempPrivateCustomer.getNumber() + "' to");
        int newNumber = input.nextInt();
        if(newNumber != 0){
            tempPrivateCustomer.setNumber(newNumber);
        }


        System.out.println("Would you like to confirm these changes?" + tempPrivateCustomer + "\nPress Y: for yes \nPress N: To remake the edit \nPress B: For going back to the Main Menu");
        String answer = input.next();
        if (answer.equalsIgnoreCase("y")) {
            fileHandler.getPeopleList().set(indexNumber, tempPrivateCustomer);
            System.out.println("Edited private customer: \n" + fileHandler.getPeopleList().get(indexNumber));
        }else if (answer.equalsIgnoreCase("N")) {
            editPerson(input,fileHandler,selectedID);
        }else if (answer.equalsIgnoreCase("B")) {
            showData(input, fileHandler);
        }else{
            System.out.println("Unknown input - Returning to main menu....");
            showData(input, fileHandler);
        }
    }

    public static void editFirm(Scanner input, FileHandler fileHandler, int selectedID){
        Firm tempFirm = new Firm();
        int indexNumber = 0;

        for (int i = 0; i <= fileHandler.getFirmList().size() - 1; i++){
            if (fileHandler.getFirmList().get(i).getCustomerId() == selectedID){
                tempFirm = fileHandler.getFirmList().get(i);
                indexNumber = i;
            }
        }

        System.out.println("Change the name from '" + tempFirm.getName() + "' to:");
        String newName = input.next();
        if(!newName.equalsIgnoreCase("0")){
            tempFirm.setName(newName);
        }
        System.out.println("Change the email from '"+ tempFirm.getEmail() +"' to:");
        String newEmail = input.next();
        if(!newEmail.equalsIgnoreCase("0")){
            tempFirm.setEmail(newEmail);
        }
        System.out.println("Change the CVR from '" + tempFirm.getCVR() + "' to");
        int newCVR = input.nextInt();
        if (newCVR != 0){
            tempFirm.setCVR(newCVR);
        }
        System.out.println("Change phone number from '" + tempFirm.getPhoneNumber() + "' to");
        int newPhoneNumber = input.nextInt();
        if (newCVR != 0){
            tempFirm.setPhoneNumber(newPhoneNumber);
        }
        System.out.println("Change the address from '"+ tempFirm.getAddress() +"' to:");
        String newAddress = input.next();
        if(!newAddress.equalsIgnoreCase("0")){
            tempFirm.setAddress(newAddress);
        }
        System.out.println("Would you like to confirm these changes?\n" + tempFirm + "\nPress Y: for yes \nPress N: To remake the edit \nPress B: For going back to the Main Menu");
        String yn = input.next();
        if (yn.equalsIgnoreCase("Y"))   {
            fileHandler.getFirmList().set(indexNumber, tempFirm);
            System.out.println("Edited firm: \n" + fileHandler.getFirmList().get(indexNumber));
        }else if (yn.equalsIgnoreCase("N")) {
            editFirm(input, fileHandler, selectedID);
        }else if (yn.equalsIgnoreCase("B")) {
            showData(input, fileHandler);
        }else{
            System.out.println("Unknown input - Returning to main menu....");
            showData(input, fileHandler);
        }


       /* fileHandler.getFirmList().set(indexNumber, tempFirm);
        System.out.println("Edited firm: \n" + fileHandler.getFirmList().get(indexNumber)); */
    }

    public static void editFacilitator(Scanner input, FileHandler fileHandler, int selectedID) {
        Facilitator tempFacilitator = new Facilitator();
        int indexNumber = 0;

        for (int i = 0; i <= fileHandler.getFacilitatorList().size() - 1; i++) {
            if (fileHandler.getFacilitatorList().get(i).getFacilitatorID() == selectedID) {
                tempFacilitator = fileHandler.getFacilitatorList().get(i);
                indexNumber = i;
            }
        }
        System.out.println("Change name from ' " + tempFacilitator.getName() + "' to: ");
        String newName = input.next();
        if (!newName.equalsIgnoreCase("0")){
            tempFacilitator.setName(newName);
        }
        System.out.println("Change phone number from '" + tempFacilitator.getPhoneNumber() + "' to: ");
        int newPhoneNumber = input.nextInt();
        if (newPhoneNumber != 0) {
            tempFacilitator.setPhoneNumber(newPhoneNumber);
        }
        System.out.println("Change email from '" + tempFacilitator.getEmail() + "' to: ");
        String newEmail = input.next();
        if (!newEmail.equalsIgnoreCase("0")) {
            tempFacilitator.setEmail(newEmail);
        }

        System.out.println("Would you like to confirm these changes?\n" + tempFacilitator + " \nPress Y: for yes \nPress N: To remake the edit \nPress B: For going back to the Main Menu");
        String ans = input.next();
        if (ans.equalsIgnoreCase("Y"))   {
            fileHandler.getFacilitatorList().set(indexNumber, tempFacilitator);
            System.out.println("Edited Facilitator: \n" + fileHandler.getFacilitatorList().get(indexNumber));
        }else if (ans.equalsIgnoreCase("N")) {
            editFacilitator(input, fileHandler, selectedID);
        }else if (ans.equalsIgnoreCase("B")) {
            showFacilitatorData(input, fileHandler);
        }else{
            System.out.println("Unknown input - Returning to main menu....");
            showFacilitatorData(input, fileHandler);
        }

    }

    public static void editEvent(Scanner input, FileHandler filehandler, int selectedID, int arrangementID) {
        Event tempEvent = new Event();
        int indexNumber = 0;

        for (int i = 0; i <= filehandler.getEventList().size() - 1; i++) {
            if (filehandler.getEventList().get(i).getID() == selectedID) {
                tempEvent = filehandler.getEventList().get(i);
                indexNumber = i;
            }
        }
        System.out.println("Change type from: " + tempEvent.getType() + " to: ");
        String newType = input.next();
        if (!newType.equalsIgnoreCase("0")) {
            tempEvent.setType(newType);
        }
        System.out.println("Change the duration from: " + tempEvent.getDuration() + " to: ");
        double newDuration = input.nextDouble();
        if (newDuration != 0)  {
            tempEvent.setDuration(newDuration);
        }
        System.out.println("Change the description from: " + tempEvent.getDescription() + " to: ");
        String newDesc = input.next();
        if (!newDesc.equals("0"))   {
            tempEvent.setDescription(newDesc);
        }
        System.out.println("Change the weekday from: " + tempEvent.getWeekDay() + " to: ");
        String newWeekDay = input.next();
        if (!newWeekDay.equalsIgnoreCase("0"))    {
            tempEvent.setWeekDay(newWeekDay);
        }
        System.out.println("Change the time form: " + tempEvent.getTime() + " to: ");
        double newTime = input.nextDouble();
        if (newTime != 0) {
            tempEvent.setTime(newTime);
        }
        System.out.println("Would you like to confirm these changes?\n" + tempEvent + "\nPress Y: for yes \nPress N: To remake the edit \nPress B: For going back to show the Arrangement");
        String ans = input.next();
        if (ans.equalsIgnoreCase("y"))  {
            filehandler.getEventList().set(indexNumber, tempEvent);
            System.out.println("Edited Event: \n" + filehandler.getEventList().get(indexNumber));
        }else if (ans.equalsIgnoreCase("N")) {
            editEvent(input, filehandler, selectedID, arrangementID);
        }else if (ans.equalsIgnoreCase("B")) {
            editArrangement(input, filehandler, arrangementID);
        }else{
            System.out.println("Unknown input - Returning to main menu....");
            mainMenu(input, filehandler);
            //showEventData(input, filehandler);
        }
    }


    public static void editArrangement(Scanner input, FileHandler filehandler, int selectedID) {
        Arrangement tempArrangement = new Arrangement();

        for (int i = 0; i<= filehandler.getArrangementList().size() -1; i++) {
            if(filehandler.getArrangementList().get(i).getId() == selectedID){
                tempArrangement = filehandler.getArrangementList().get(i);
            }
        }
        System.out.println("Arrangement ID: " + tempArrangement.getId() + " CustomerID " + tempArrangement.getCustomerID() + " Date: " + tempArrangement.getDate() + " The arrangements have " + tempArrangement.getEvents().size() + " events");

        System.out.println("A = Add new event | E = Edit an event | D = delete an event | B = Back");
        String option = input.next();
        if(option.equalsIgnoreCase("a")){
            int customerID = getFreeEventId(filehandler.getEventList());
            System.out.println("What type of event is it?: ");
            String newEventType = input.next();
            System.out.println("For how long will the event last?");
            double newEventDuration = input.nextDouble();
            System.out.println("Give an event description");
            String newEventDescription = input.next();
            System.out.println("Choose a Facilitator");
            // Show facilitators
            for (int i = 0; i <= filehandler.getFacilitatorList().size() -1; i++){
                System.out.println("ID: " + filehandler.getFacilitatorList().get(i).getID() + " Name: " + filehandler.getFacilitatorList().get(i).getName());
            }
            int newEventFacilitatorID = input.nextInt();
            System.out.println("What day will it be? (Example: mon, tue, wed)");
            String newEventWeekDay = input.next();
            System.out.println("What time on the day will the Event start?");
            double newEventStartTime = input.nextDouble();
            int eventID = getFreeEventId(filehandler.getEventList());
            filehandler.getEventList().add(addEvent(eventID, newEventType, newEventDuration, newEventDescription, customerID, newEventFacilitatorID, newEventWeekDay, newEventStartTime));
            tempArrangement.addEvent(eventID);
        }else if(option.equalsIgnoreCase("e")){
            for (int i = 0; i <= tempArrangement.getEvents().size()-1; i++){
                System.out.println(filehandler.getEventByID(tempArrangement.getEvents().get(i)));
            }
            System.out.println("Chose the event by ID");
            int chosenID = input.nextInt();
            editEvent(input, filehandler, chosenID, selectedID);
        }else if(option.equalsIgnoreCase("d")){
            for (int i = 0; i <= tempArrangement.getEvents().size()-1; i++){
                System.out.println(filehandler.getEventByID(tempArrangement.getEvents().get(i)));
            }
            System.out.println("Choose the ID of the event to delete or type '-1' to go back");
            int chosenID = input.nextInt();
            if(chosenID != -1){
                deleteEvent(input, filehandler, chosenID, selectedID);
                editArrangement(input, filehandler, selectedID);
            }else{
                editArrangement(input, filehandler, selectedID);
            }
        }else if(option.equalsIgnoreCase("b")){
            showArrangement(input, filehandler);
        }
        editArrangement(input, filehandler, selectedID);
    }

    public static void newPersonScanner(Scanner input, FileHandler filehandler)   {
        int cosID = getFreeCustumerId(filehandler.getPeopleList(), filehandler.getFirmList());

        System.out.println("Enter costumers firstname: ");
        String firstName = input.next();

        System.out.println("Enter costumers lastname: ");
        String lastName = input.next();

        System.out.println("Enter costumers contact mail: ");
        String mail = input.next();

        System.out.println("Enter costumers phonenumber: ");
        int phoneNumber = input.nextInt();

        filehandler.getPeopleList().add(addPerson(cosID, firstName, lastName, mail, phoneNumber));
        System.out.println(firstName + " has been added with ID: " + cosID);
        System.out.println("Would you like to create add another Person? (Y/N)");
        String option = input.next();
        if(option.toLowerCase().contains("y")){
            newPersonScanner(input, filehandler);
        }else{
            showPeopleData(input, filehandler);
        }
    }

    public static void newFirmScanner(Scanner input, FileHandler filehandler) {
        int cosID = getFreeCustumerId(filehandler.getPeopleList(), filehandler.getFirmList());

        System.out.println("Enter the name of the firm: ");
        String name = input.next();

        System.out.println("Enter the firm's contact email: ");
        String mail = input.next();

        System.out.println("Enter the CVR-number of the firm: ");
        int CVR = input.nextInt();

        System.out.println("Enter the firm's contact phonenumber: ");
        int phoneNumber = input.nextInt();

        System.out.println("Enter the firm's address: ");
        String address = input.next();

        filehandler.getFirmList().add(addFirm(cosID, name, mail, CVR, phoneNumber, address));
        System.out.println(name + " has been added with ID:" + cosID);
        System.out.println("Would you like to add another Firm? (y/n)");
        String option = input.next();
        if(option.toLowerCase().equals("y")){
            newFirmScanner(input, filehandler);
        }else{
            showFirmData(input, filehandler);
        }
    }

    public static void newArrangementScanner(Scanner input, FileHandler filehandler){
        int newArrangementID = getFreeArrangementId(filehandler.getArrangementList());
        int customerID = 0;
        ArrayList<Integer> tempArray = new ArrayList<Integer>();

        System.out.println("Would you like to create a new Customer or choose an already made one? (N = New / C = Choose)");
        String option = input.next();
        if(option.equalsIgnoreCase("n")){
            System.out.println("Would you like to create a Firm or Private Customer (F = Firm / P = Private Customer)");
            option = input.next();
            if(option.equalsIgnoreCase("f")){
                int cosID = getFreeCustumerId(filehandler.getPeopleList(), filehandler.getFirmList());

                System.out.println("Enter the name of the firm: ");
                String name = input.next();

                System.out.println("Enter the firm's contact email: ");
                String mail = input.next();

                System.out.println("Enter the CVR-number of the firm: ");
                int CVR = input.nextInt();

                System.out.println("Enter the firm's contact phonenumber: ");
                int phoneNumber = input.nextInt();

                System.out.println("Enter the firm's address: ");
                String address = input.next();

                filehandler.getFirmList().add(addFirm(cosID, name, mail, CVR, phoneNumber, address));
                System.out.println(name + " has been added with ID:" + cosID);
                customerID = cosID;
            }else if(option.equalsIgnoreCase("p")){
                int cosID = getFreeCustumerId(filehandler.getPeopleList(), filehandler.getFirmList());

                System.out.println("Enter costumers firstname: ");
                String firstName = input.next();

                System.out.println("Enter costumers lastname: ");
                String lastName = input.next();

                System.out.println("Enter costumers contact mail: ");
                String mail = input.next();

                System.out.println("Enter costumers phonenumber: ");
                int phoneNumber = input.nextInt();

                filehandler.getPeopleList().add(addPerson(cosID, firstName, lastName, mail, phoneNumber));
                System.out.println(firstName + " has been added with ID: " + cosID);
                customerID = cosID;
            }
        }else if(option.equalsIgnoreCase("c")){
            if (filehandler.getFirmList().size() > 0) {
                System.out.println("=== Firms ===");
                for (int i = 0; i <= filehandler.getFirmList().size() - 1; i++) {
                    System.out.println("ID: " + filehandler.getFirmList().get(i).getCustomerId() + " Name: " + filehandler.getFirmList().get(i).getName());
                }
            }
            if (filehandler.getPeopleList().size() > 0) {
                System.out.println("=== Private Customers ===");
                for (int i = 0; i <= filehandler.getPeopleList().size() - 1; i++) {
                    System.out.println("ID: " + filehandler.getPeopleList().get(i).getCustomerId() + " Name: " + filehandler.getPeopleList().get(i).getFirstName() + " " + filehandler.getPeopleList().get(i).getLastName());
                }
            }
            System.out.println("Give the ID of the chosen Customer: ");
            customerID = input.nextInt();
        }
        System.out.println("Give the date of the beginning of the arrangement (Example: 20/10/2020)");
        String newDate = input.next();

        Arrangement tempArrangement = new Arrangement(newArrangementID, customerID, newDate, tempArray);

        System.out.println("Create event(s) for the arrangement");
        String addingEvents = "y";
        while(addingEvents.equalsIgnoreCase("y")){
            System.out.println("What type of event is it?: ");
            String newEventType = input.next();
            System.out.println("For how long will the event last? (in hours. Ex: 8,5)");
            double newEventDuration = input.nextDouble();
            System.out.println("Give an event description");
            String newEventDescription = input.next();
            System.out.println("Choose a Facilitator");
            for (int i = 0; i <= filehandler.getFacilitatorList().size() -1; i++){
                System.out.println("ID: " + filehandler.getFacilitatorList().get(i).getID() + " Name: " + filehandler.getFacilitatorList().get(i).getName());
            }
            int newEventFacilitatorID = input.nextInt();
            System.out.println("What day will it be? (Example: mon, tue, wed)");
            String newEventWeekDay = input.next();
            System.out.println("What time on the day will the Event start? (Ex: 21,00)");
            double newEventStartTime = input.nextDouble();
            int eventID = getFreeEventId(filehandler.getEventList());
            filehandler.getEventList().add(addEvent(eventID, newEventType, newEventDuration, newEventDescription, customerID, newEventFacilitatorID, newEventWeekDay, newEventStartTime));
            tempArrangement.addEvent(eventID);

            System.out.println("The arrangement now have " + tempArrangement.getEvents().size() +" events, would you like to add more? (Y = Yes, N = No)");
            addingEvents = input.next();
        }
        System.out.println("Is this good? Y / N");
        System.out.println(tempArrangement);
        option = input.next();
        if(option.equalsIgnoreCase("y")){
            System.out.println("Arrangement has succesfully been created");
            filehandler.getArrangementList().add(tempArrangement);
            showArrangement(input, filehandler);
        }else{
            System.out.println("Canceled new Arrangement");
            showArrangement(input,filehandler);
        }
    }

    public static void newFacilitatorScanner(Scanner input, FileHandler filehandler){
        int cosID = getFreeFacilitatorId(filehandler.getFacilitatorList());

        System.out.println("Enter name: ");
        String name = input.next();

        System.out.println("Enter phonenumber");
        int phoneNumber = input.nextInt();

        System.out.println("Enter email");
        String email = input.next();

        filehandler.getFacilitatorList().add(addFacilitator(cosID, name, phoneNumber, email));
        System.out.println("New facilitator has been created: " + name + " with ID: " + cosID);

        System.out.println("Would you like to create another Facilitator? (Y/N)");
        String option = input.next();
        if(option.equalsIgnoreCase("y")){
            newFacilitatorScanner(input, filehandler);
        }else{
            showFacilitatorData(input, filehandler);
        }
    }

    public static Facilitator addFacilitator(int facilitatorID, String name, int phoneNumber, String email){
        //creates a new facilitator object
        Facilitator tempFacilitator = new Facilitator(facilitatorID, name, phoneNumber, email);

        return tempFacilitator;
    }

    public static Firm addFirm(int costumerID, String name, String email, int CVR, int phoneNumber, String address) {
        Firm tempFirm = new Firm(costumerID, name, email, CVR, phoneNumber, address);

        return tempFirm;
    }

    public static privateCustomer addPerson(int costumerID, String firstName, String lastName, String email, int number){
        //creates an new person object
        privateCustomer tempPrivateCustomer = new privateCustomer(costumerID, firstName, lastName, email, number);

        return tempPrivateCustomer;
    }

    public static Event addEvent(int id ,String type, double duration, String description, int customerID, int facilitatorID, String weekday, double time){
        //creates an new event object
        Event tempEvent = new Event(id ,type, duration, description, customerID, facilitatorID, weekday, time);

        return tempEvent;
    }

    public static Arrangement addArrangement(int id, int customerID, String date, ArrayList<Integer> eventIds){
        Arrangement tempArrangement = new Arrangement(id, customerID, date, eventIds);

        return tempArrangement;
    }

    public static void helpMenu(Scanner input, FileHandler fileHandler) {
        System.out.println("What would like to get some information about?");
        System.out.println("S: Show Data");
        System.out.println("C: Search Data");
        System.out.println("D: Save Data");
        System.out.println("Q: Quit");
        String info = input.next();

        if (info.equalsIgnoreCase("S")) {
            System.out.println("In the show data menu, it's possible to see all the information we got in the system. From here, it is possible to go further and edit, delete and add information.\nWhen you're editing, you can skip the current point by pressing 0. (This could be useful, if you want to edit name, but want to keep the rest of the information.)");
        }else if (info.equalsIgnoreCase("C"))   {
            System.out.println("In the search menu, it's possible to search for a keyword, and get all the outputs that contains this. If you dont type anything, you would get all the information we got in the system.");
        }else if (info.equalsIgnoreCase("D")) {
            System.out.println("In the save data menu, it's possible to save all the data, you just made into a txt file.");
        }else if (info.equalsIgnoreCase("Q"))   {
            System.out.println("By pressing 'Q', you would shut down the program.");
        }
        System.out.println("Do you need help with anything else? (Y = Help menu / N = Main Menu)");
        String option = input.next();
        if(option.equalsIgnoreCase("y")){
            helpMenu(input, fileHandler);
        }else if(option.equalsIgnoreCase("n")){
            mainMenu(input, fileHandler);
        }
    }

    //Search Function
    public static void searchList(Scanner input, FileHandler fileHandler)   {
        ArrayList<Object> searchResult = new ArrayList<Object>();
        System.out.println("What do you want to search for? ");
        String search = input.next().toLowerCase();

        for(int i = 0; i <= fileHandler.getPeopleList().size() - 1; i++){
            if(fileHandler.getPeopleList().get(i).getFirstName().toLowerCase().contains(search) || fileHandler.getPeopleList().get(i).getLastName().toLowerCase().contains(search) || fileHandler.getPeopleList().get(i).getEmail().toLowerCase().contains(search)){
                searchResult.add(fileHandler.getPeopleList().get(i));
            }
        }
        for(int i = 0; i <= fileHandler.getFirmList().size() - 1; i++){
            if(fileHandler.getFirmList().get(i).getName().toLowerCase().contains(search) || fileHandler.getFirmList().get(i).getEmail().toLowerCase().contains(search) || fileHandler.getFirmList().get(i).getAddress().toLowerCase().contains(search)) {
                searchResult.add(fileHandler.getFirmList().get(i));
            }
        }
        for(int i = 0; i <= fileHandler.getFacilitatorList().size() - 1; i++){
            if(fileHandler.getFacilitatorList().get(i).getName().toLowerCase().contains(search) || fileHandler.getFacilitatorList().get(i).getEmail().toLowerCase().contains(search)) {
                searchResult.add(fileHandler.getFacilitatorList().get(i));
            }
        }
        for (int i = 0; i <= fileHandler.getEventList().size() - 1; i++){
            if (fileHandler.getEventList().get(i).getType().toLowerCase().contains(search) || fileHandler.getEventList().get(i).getDescription().toLowerCase().contains(search) || fileHandler.getEventList().get(i).getWeekDay().toLowerCase().contains(search)){
                //Dens arrangement hvis event passer til eventet, bliver det smidt ind i Search Results
                searchResult.add(fileHandler.getEventList().get(i));
                if(fileHandler.getArrangementByEventID(fileHandler.getEventList().get(i).getID()) != null){
                    System.out.println(fileHandler.getArrangementByEventID(fileHandler.getEventList().get(i).getID()));
                }

                if(searchResult.contains(fileHandler.getArrangementByEventID(fileHandler.getEventList().get(i).getID()))){
                    searchResult.add(fileHandler.getArrangementByEventID(fileHandler.getEventList().get(i).getID()));
                }
            }
        }
        for(int i = 0; i <= searchResult.size() - 1; i++){
            System.out.println(searchResult.get(i) + "\n");
            //if(searchResult.get(i).getClass().getName() == "Facilitator"){
            //System.out.println(searchResult.get(i).get);


        }
        System.out.println("Press 'S' if you want to search again\nPress 'B' to go back to the main  menu.");
        String searchAns = input.next();
        if (searchAns.equalsIgnoreCase("S")){
            searchList(input, fileHandler);

        }else if (searchAns.equalsIgnoreCase("B")){
            mainMenu(input, fileHandler);
        }else{
            System.out.println("Invalid input");
            mainMenu(input, fileHandler);
        }
    }

    public static int getFreeEventId(ArrayList<Event> eventList){
        ArrayList<Integer> ids = new ArrayList<Integer>();

        if(eventList.size() > 0){
            for(int i = 0; i <= eventList.size() - 1; i++){
                ids.add(eventList.get(i).getID());
            }
        }

        int newID = 1;

        if(ids.size() != 0){
            newID = Collections.max(ids) + 1;
        }
        return newID;
    }

    // Get a unused ComputerID by finding the highest ID out of all costumer ID's
    public static int getFreeCustumerId(ArrayList<privateCustomer> peopleList, ArrayList<Firm> firmList){

        //Init new Integer array
        ArrayList<Integer> ids = new ArrayList<Integer>();

        // Populate array with current ids
        if(peopleList.size() > 0){ // checks if there's any indexes in the peopleList
            for (int i = 0; i <= peopleList.size() - 1; i++){
                ids.add(peopleList.get(i).getCustomerId()); // adds the ids of the peoples in the peopleList
            }
        }

        if(firmList.size() > 0){// checks if there's any indexes in the firmList
            for(int k = 0; k <= firmList.size() - 1; k++){
                ids.add(firmList.get(k).getCustomerId()); // adds the ids of the firms in the firmList
            }
        }

        int newID = 1; // initiate a new variable.

        // Finds the highest value in the array and adds one to it. Only happens if ids is populated by at least one ID.
        if(ids.size() != 0){ // if the ids Array is populated
            newID = Collections.max(ids) + 1; // find the largest number and add one to it.
        }

        return newID; // return the new ID.
    }

    // same as getFreeCostumerId
    public static int getFreeFacilitatorId(ArrayList<Facilitator> facilitatorList){
        ArrayList<Integer> ids = new ArrayList<Integer>();

        if(facilitatorList.size() > 0){
            for(int i = 0; i <= facilitatorList.size() - 1; i++){
                ids.add(facilitatorList.get(i).getID());
            }
        }

        int newID = 1;

        if(ids.size() != 0){
            newID = Collections.max(ids) + 1;
        }
        return newID;
    }

    public static int getFreeArrangementId(ArrayList<Arrangement> arrangementList){
        ArrayList<Integer> ids = new ArrayList<Integer>();

        if(arrangementList.size() > 0){
            for(int i = 0; i <= arrangementList.size() - 1; i++){
                ids.add(arrangementList.get(i).getId());
            }
        }

        int newID = 1;

        if(ids.size() != 0){
            newID = Collections.max(ids) + 1;
        }
        return newID;
    }

    // Takes an array and adds it to another array.
    public static ArrayList populateArray(ArrayList pasteInto, ArrayList copiedFrom){

        for (int i = 0; i <= copiedFrom.size() - 1; i++){ // runs through the array that's going to be copied from
            pasteInto.add(copiedFrom.get(i)); // add the indexes into the array that's getting pasted into.
        }

        return pasteInto; // return the pasted array;
    }
}