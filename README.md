This web app provides a few RESTful services for basic CRUD operations on User and BankAccount objects.

The objects are saved in memory in HashMaps.

Most of the provided REST services can be accessed via a very basic and not styled HTML interface with the following structure:

Home
* Users page
  * User details page
  * User bank accounts page
* Bank accounts page

The REST api has the following routes:
* GET /users (Shows all users)
* GET /users/{id} (Shows user with id)
* POST /users/{id} (Creates new user)
* PUT /users/{id} (Updates existing user)
* DELETE /users/{id} (Deletes user)
* GET /bankaccounts (Shows all bank accounts)
* GET /users/{userId}/bankaccounts (Shows bank accounts of user)
* POST /users/{userId}/bankaccounts (Creates new bank account for user)
* POST /users/{userId}/bankaccounts/list (Creates a list of new bank accounts for user)
* PUT /users/{userId}/bankaccounts/{id}	(Updates existing bank account)
* DELETE /bankaccounts/{id} (Deletes bank account)

Used technologies/frameworks are
* JAVA 8
* Spring
* Spring MVC
* Maven
*­ JUnit
* Mockito
*­ jQuery
* Jackson

Tested on Pivotal tc Server
