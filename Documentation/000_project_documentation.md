# Vadym Tilihuzov

## ArtInstallation$Auction

Project description:

This project is being developed in Java in Eclipse IDE using javaFx,  JFoenix, sqlite, libraries.
Brief description of my project: I created a model of electronic auction, and specifically First-price sealed-bid auction.
First-price sealed-bid auctions are when a single bid is made by all bidding parties and the single highest bidder wins and pays what they bid. The main difference between this and English auctions is that bids are not openly viewable or announced.
My auction intends to sell famous installations of artists and designers
Installations can differ in size, they are suitable for people who just want to beautifully equip their apartment or house, and firms, private companies or others can buy an installation from us to decorate their institutions.

---------------------------------------------
## Fulfillment of criteria

-Pattern [Observer]
-Exeption
-Multi-threads
-RTTI
-Lambda
-GUI

----------------------------------------------
## Certain implementations

###In version v1.0.1:

I used polymorphism in class User to be able to take from database user information in all needed conditions, (60 - 112 lines)
Aggregation in CancelAuctionController class to make a local copy of User. (28 line)

## Main criteria

•	polymorphism and aggregation
– SqlDB.java #11 # 12 
– Storage.java # 16 
– CancelAuctionController.java # 28
–	User.java # from (60 - 112) AdHoc

•	inheritance
–	CannotDeleteYourself.java # 3
–	Main.java # 18

### Secondary criteria
Example:
•	Observer
–	User.java # 18
•	RTTI
–	Main.java # 34

## List of features for current version v1.0.1

- Delete/Add/View System
- Multi-level Access Privilege
- Elegant UI and Robust Visualization
- Database Oriented System
- Multi-threads
- Exeptions
- Lambda expressions
- RTTI
- Polymorfism, etc.

## UML diagram

All diagrams can be found at the following [link](Documentation/001_uml_diagrams).

## Project Skeleton
Current active UML Class diagram:

![Example change this](https://github.com/OOP-FIIT/oop-2022-str-17-c-dakic-Real-4339/blob/master/Documentation/uml/umlet.png)

Brief demonstration of key functionality - Main Prototype:
![](https://github.com/OOP-FIIT/oop-2022-str-17-c-dakic-Real-4339/blob/master/Documentation/prototypes/Home.PNG)
