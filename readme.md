# Vadym Tilihuzov

## Art installation auction

***
## General Info:

Its a model of electronic auction, namely, First-price sealed-bid auction.

Project status: 80% is ready.
### Screenshot
![Image text](https://github.com/OOP-FIIT/oop-2022-str-17-c-dakic-Real-4339/tree/master/Documentation/prototypes)
***

## Table of Contents

1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Installation](#installation)
4. [Collaboration](#collaboration)
5. [Fulfillment of criteria](#fulfillment-of-criteria)
6. [Certain implementations](#Certain-implementations)
7. [Main criteria](#Main-criteria)
8. [Secondary criteria](#Secondary-criteria)
9. [FAQs](#faqs)

***

* [Project documentation](Documentation/000_project_documentation.md)
  * [JavaDoc documentation](Documentation/000_project_documentation.md)
* [UML diagrams](Documentation/001_uml_diagrams.md)
* [Versions](Documentation/002_versions.md)
* [Technical details](Documentation/003_tech_details.md)
* [Simulation and demonstration](Documentation/004_simulation_and_demonstration.md)  
  * [Video demonstration](Documentation/004_simulation_and_demonstration.md)

## Technologies
***
A list of technologies used within the project:
* [SQLite](https://sqlite.org/index.html): Version 3.3.3 
* [Java Language](https://www.oracle.com/java/technologies/downloads/): Version 4.23.0
* [JavaFX](https://openjfx.io/): Version 18, SDK, x64, Windows

## Installation
***
A little intro about the installation. 
```
$ git clone https://github.com/OOP-FIIT/oop-2022-str-17-c-dakic-Real-4339.git
$ cd ../oop-2022-str-17-c-dakic-Real-4339/Project/

```
## Collaboration
***
Make a pull request
> Im open to all new. 

## Certain implementations

###In version v1.0.1:

I used polymorphism in class User to be able to take from database user information in all needed conditions, (60 - 112 lines)
Aggregation in CancelAuctionController class to make a local copy of User. (28 line)

## Main criteria

•	polymorphism and aggregation
- SqlDB.java #11 # 12 
- Storage.java # 16 
- CancelAuctionController.java # 28
-	User.java # from (60 - 112) AdHoc

•	inheritance
-	CannotDeleteYourself.java # 3
-	Main.java # 18

### Secondary criteria

•	Observer
- User.java # 18
•	RTTI
- Main.java # 34

## FAQs
***
A list of frequently asked questions
1. **This is a question in bold**
Answer to the first question with _italic words_. 
2. __Second question in bold__ 
To answer this question, we use an unordered list:
* First point
* Second Point
* Third point
3. **Third question in bold**
Answer to the third question with *italic words*.
4. **Fourth question in bold**
| Headline 1 in the tablehead | Headline 2 in the tablehead | Headline 3 in the tablehead |
|:--------------|:-------------:|--------------:|
| text-align left | text-align center | text-align right |

