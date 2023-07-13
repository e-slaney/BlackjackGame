# Blackjack Game

This is a simple implementation of the classic card game Blackjack, built using Java and Java Swing. The game allows the user to play against the computer dealer, following the standard rules of Blackjack.

![Blackjack Screenshot](./assets/screenshot.png)

## Features

- Interactive graphical user interface (GUI) built with Java Swing.
- User-friendly controls for placing bets, hitting, standing, and starting a new round.
- Game logic adheres to the standard rules of Blackjack.
- Dynamic display of cards and total values for the player and the dealer.
- Visual indication of the game outcome (win, loss, or tie) at the end of each round.
- Ability to reset the game and start a new session.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Java Swing library

## Getting Started

Follow the steps below to get a copy of the project and run it on your local machine.

### Installation

1. Clone the repository to your local machine:

   ```
   git clone https://github.com/your-username/blackjack-game.git
   ```

2. Change into the project directory:

   ```
   cd blackjack-game
   ```

### Running the Game

1. Compile the Java source files:

   ```
   javac *.java
   ```

2. Run the game:

   ```
   java Main
   ```

## How to Play

1. Launch the game by following the instructions in the "Running the Game" section.

2. The game window will appear, displaying a graphical representation of the game table.

3. To start a new round, click the "New Game" button.

4. You will be prompted to enter your bet amount. Enter a valid positive integer and click "OK."

5. The game will deal two cards to both the player and the dealer. Your cards will be face-up, and the dealer's first card will be face-up while the second card remains face-down.

6. You have two options: "Hit" or "Stand."
   - To request an additional card, click the "Hit" button. The game will deal you a new card.
   - To keep your current hand, click the "Stand" button. The dealer will then reveal their face-down card and proceed to draw cards according to the standard rules of Blackjack.

7. If the total value of your hand exceeds 21 at any point, you bust and lose the round.

8. Once you choose to stand, the dealer will play their hand automatically, following the standard rules of Blackjack. The game will reveal the dealer's cards and determine the outcome of the round.

9. After the round ends, the game will display the result (win, loss, or tie) and update your balance accordingly.

10. You can start a new round by clicking the "Play New Game!" button again, or quit the game by closing the window.


### Assets Used:
I do not own the playing card assets used in the Blackjack game.
Playing Card Assets provided by *https://code.google.com/p/vector-playing-cards/* (Google Code Archive)
