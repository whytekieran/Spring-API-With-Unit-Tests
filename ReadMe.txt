Name: Ciaran Whyte

Ive built an API using Spring Framework, MVC, JPA an embedded derby database and combination of Spring Test and JUnit 5 for the 
additionan of some tests.

API Endpoints (localhost:8080)
GET /people = Returns all people
GET people/amount = Returns the amount of stored people
GET /people/{peopleId} = Returns the person with that Id
POST /people = Create a new person
PUT /people/{peopleId} = Update a person
DELETE /people/{peopleId} = Delete a person
GET /people/{personId}/address = Get person and each registed address for the person
GET /people/{personId}/address/{addressId} = Get a specific address for a specific person
POST /people/{personId}/address = Create a new address for a person
PUT /people/{personId}/address = Update address for a person
DELETE /people/{personIdId}/address/{addressId} = Delete an address related to a person

DB RULES
-Can create multiple people
-A new address must be associated with a person
-A person can have multiple addresses however an address can only be linked to one person. 
-To delete a person you would need to delete all associated addresses then delete the person.

API DATA can be used inside something like postman as body for post requests.
Id must change or its considered an update.
Address Data for posting
{"id":1,"street":"Moanbaun","city":"Athenry","state":"Galway","postalCode":"H65P268"}

Person Data for posting
{"id":2,"firstName":"btnfdsfvdshj","lastName":"fvvvvvvffe"}

HOW TO RUN
-Could import as a spring or maven project into an IDE of your choosing and use features of IDE to run it
OR
-Can run as an executable jar file. First do a clean install with maven. Go to project location. 
1. cd <project_file_location>
 ...you should be in the same location as the the pom.xml then do the command
2. maven clean install
 ...inside the target folder there should be an executable jar file. You can run it with the command
java -jar \target\<name_of_jar>.jar
3. You should then see it running as a Spring project and should be able to use postman to hit the endpoints
provided above under localhost post 8080.
4. You can also run the provided unit tests from this location using
mvn -Dtest=PersonApiDataApplicationTest test
...there are simple unit tests to check things loaded up correctly, a person is added correctly, and the amount of people
added endpoint is checked.

GITHUB
Can also be viewed from github here: https://github.com/whytekieran/Spring-API-With-Unit-Tests