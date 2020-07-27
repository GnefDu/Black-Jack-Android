The app plays a simplified version of blackjack with the following rules:

1) The deck is shuffled
2) Dealer is dealt a card then the player is dealt a card (x2)
3) The first card dealt to the dealer is face down
4) The player can then choose to hit as many times as they want until they bust (and lose) or choose to stand
5) Hitting will cause the player to draw a card
6) Standing will keep the player at their current card value
7) The dealer will continue to hit until their card value reaches >16 or they bust
8) If the dealer busts, the player wins
9) If the dealer does not bust the values of the cards are compared and a winner is chosen
10) Ties are possible if both the dealer and player have the same value in hand
11) The player can then click deal to deal another hand which repeats the steps from 1

Card values:

1) 2-10 are equal to their value
2) Face cards are equal to 10
3) Aces are equal to 1 or 11 depending on which is more advantageous

Extra black jack rules:

1) There is currently money/betting implemented
2) No splitting, doubling, or blackjack implmented


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

