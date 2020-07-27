User Stories:

Player opens app and presses hit or stand before dealing results in message asking player to deal

Player opens app and presses deal resulting in the game starting.

Player wins and text appears indicating that the user has won

Player busts and text appears indicating that user has busted

Dealer busts and text appears indicating that the dealer has busted


To compile:

1) Load the project into android studio
2) Build the apk

Architecture:

The app is made up of two main components:

1) Game.java
2) MainActivity.java
3) activity_main.xml

Game.java contains is a class which contains everything required to play a game of black jack. All methods are included within
the class.

MainActivity.java and activity_main.xml creates a mobile interface that uses an instance of Game.java to play a game of blackjack.

The two java files are located in app/src/main

XML file is located in app/src/main/res/layout



State diagram along with umple code are included as files in the top level of the github repository.

