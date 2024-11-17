# Silly-Card-Game-Simulation

# Overview
  This project is a Java-based card game simulation for a game called "Silly Card Game," developed as a learning exercise when I started   programming. It demonstrates key programming concepts like object-oriented design, generics, custom data structures, and algorithm       implementation.

# Game Rules
  The game simulates a card game for two players:
  1. The deck contains cards numbered 1 to 13, with four copies of each card.
  2. Players are dealt 7 cards each, and the remaining cards form the deal stack.
  3. The discard stack starts with one card from the deal stack.
  4. On their turn, each player:
       - Plays the next card from their hand (queue).
       - Compares the card with the top of the discard stack:
            - Higher card: No penalty, turn ends.
            - Equal card: Player draws 1 card, turn ends.
            - Lower card: Player draws 2 cards, turn ends.
  5. If the deal stack runs out, the discard stack is turned over to form a new deal stack (keeping the top discard card in place).
  6. The first player to run out of cards wins.
     
# Features
  - Custom Data Structures:
        Implemented generic stack and queue using Java.
  - Fisher-Yates Shuffle Algorithm:
        Randomizes the deck for a fair game.
  - Modular Design:
        Clear separation of game logic (GameModel) and user interface (SillyCardGame).
  - Error Handling:
        Proper handling of empty stacks and queues.
  
# How to Play
  1. Run the SillyCardGame class.
  2. Follow the instructions on the console to play the game.
  3. Decide whether to play again after the game ends.
     
# Project Structure
  - GameModel: Core game logic, including dealing cards, shuffling, and turn mechanics.
  - Queue and Stack: Custom generic implementations of queue and stack data structures.
  - SillyCardGame: Main class handling the user interface and game flow.
  - Custom Shuffle Algorithm: Implements the Fisher-Yates algorithm for shuffling the deck.

# Skills and Concepts Learned
  - Basic understanding of object-oriented programming (OOP).
  - Creating and using generic classes.
  - Managing data structures like stacks and queues.
  - Implementing and understanding a shuffle algorithm.
  - Building a console-based game with a clean and user-friendly interface.

