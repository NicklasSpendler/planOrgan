# planOrgan

## classes
- Event
- Facilitator
- FileHandler
- Firm
- Person
- Arrangement
#
## Methods
- populateArray(pasteInto, copiedFrom)
- filehandler.writePeopleToFile(ArrayList) // Skriver array ud i fil
- filehandler.readPeopleFromFile() // Retunere array med personer fra filen
- getPrice()
- addPerson(id, firstName, lastName, email, number)

#
### todo
- addPerson(firstName, lastName, mail, number)
- addFacilitator(name, phoneNumber, email)
- addEvent(type, duration, description, customer, facilitator, weekday, time)
- getFreeCostumerid()

#
### todo interface
- addPerson(id, firstName, lastName, email, number)
- deletePerson(id)
- addFacilitator()
- deleteFacilitator()

#
#### noteworhty notes
#### - I addEvent skal customer enten være en Person eller Firm
#### - weekday skal være entenn man, tir, tue ect. Fri, Sat og Sun retunere weekends pris
#

### Todo fixes
Arrangement.java
- Skal lave constuctor til hvis costumer er privat person
#
# todo opgaver
- Lav interface som kan add Person med addPerson() som der efter tilføjer den nye person ind i arrayet peopleList (Brug peopleList.add(addPeson(parameters)))

- lav interface som kan delete person, en metode kunne eksempelvis være deletePerson(1), denne metode vil tage fat i filehandler.getPeopleList, treverse arrayet ind til den finder den person med den ID. Hvad end den index i arryet er skal fjernes fra arryet med filehandler.getPeopleList.remove(index)