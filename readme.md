__# planOrgan

## classes
- Event
- Facilitator
- FileHandler
- Firm
- privateCustomer
- Arrangement
#
## Methods
- populateArray(pasteInto, copiedFrom)
- filehandler.writePeopleToFile(ArrayList) // Skriver array ud i fil
- filehandler.readPeopleFromFile() // Retunere array med personer fra filen
- Arrengement.getPrice() // giver udregnet beløb
- addPerson(customerID ,firstName, lastName, mail, number)

#
### todo

- addFacilitator(name, phoneNumber, email)
- addEvent(type, duration, description, customer, facilitator, weekday, time)
- getFreeCostumerid()
- getCustomerByID(ID) // Skal tjekke både peopleList og firmList
- getFreeCostumerID()

#
### todo interface
- addPerson(id, firstName, lastName, email, number)
- deletePerson(id)
- addFacilitator()
- deleteFacilitator()

#
#### noteworhty notes
#### - I addEvent skal customer enten være en privateCustomer eller Firm
#### - weekday skal være; man, tir, tue ect. Fri, Sat og Sun retunere weekends pris
#

### Todo fixes
Arrangement.java
- Skal lave constuctor til hvis costumer er privat privateCustomer
#
# todo opgaver
- Lav interface som kan add privateCustomer med addPerson() som der efter tilføjer den nye privateCustomer ind i arrayet peopleList (Brug peopleList.add(addPeson(parameters)))

- lav interface som kan delete privateCustomer, en metode kunne eksempelvis være deletePerson(1), denne metode vil tage fat i filehandler.getPeopleList, treverse arrayet ind til den finder den privateCustomer med den ID. Hvad end den index i arryet er skal fjernes fra arryet med filehandler.getPeopleList.remove(index)