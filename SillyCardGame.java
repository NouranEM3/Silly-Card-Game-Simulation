/*
 * Nouran Mahfouz
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package nmahfouz_p3;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * The SillyCardGame class represents the main class for a simple two-player
 * card game. Players take turns playing cards to match the top card on the
 * discard pile and earn points. The game continues until one player runs out
 * of cards, and the player with the highest score wins.
 *
 * This class contains the main method to execute the game logic,
 * handle user input, and display game status and results.
 */

public class SillyCardGame
{
    /**
     * The main method initializes and runs the SillyCardGame.
     * Players take turns playing cards until the game is over, and the option
     * to play again is provided.
     *
     * Displays welcome and exit messages along with game status during
     * each turn.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args)
    {
        char repeat;     // Holds user decision if he wants to play again
        boolean gameOver;
        int result;

        Scanner keyboard = new Scanner(System.in);
        // Display welcome message
        GameModel.displayWelcomeMessage();

        do {
            // Initialize players, game model, and deal cards
            Queue<Integer> player1 = new Queue<>();
            Queue<Integer> player2 = new Queue<>();
            ArrayList<Queue<Integer>> players = new ArrayList<>(2);
            gameOver = false;
            GameModel game = new GameModel();
            players.add(player1);
            players.add(player2);
            game.dealCards(player1, player2);

            // Main game loop
           while(!gameOver){
               for(int i = 0; i < players.size(); i++)
               {
                   if (!player1.empty() && !player2.empty())
                   {
                       // Display game status and player's turn information
                       displayStatus(players);
                       System.out.printf("\nPlayer %d's turn.\n", i + 1);
                       System.out.println("Top of stack is " +
                               game.getTopOfDiscardStack());
                       // Compare the player's card with the top card on the
                       // discard pile
                       result = game.compare(players.get(i));
                       switch (result)
                       {
                           case -1:
                               System.out.printf("Your card %d is larger than" +
                                        " %d.", players.get(i).peek(),
                                         game.getTopOfDiscardStack());
                               System.out.println("\nGood job!");
                               break;
                           case 0:
                               System.out.printf("Your card %d equal to %d.",
                                       players.get(i).peek(),
                                       game.getTopOfDiscardStack());
                               System.out.println("\nYou pick 1 card.");
                               break;

                           case 1:
                               System.out.printf("Your card %d is less than %d.",
                                       players.get(i).peek(),
                                       game.getTopOfDiscardStack());
                               System.out.println("\nYou pick 2 cards.");
                               break;
                       }
                       // Update player's move and the discard pile
                       game.updatePlayer(players.get(i));
                   }
               }
               // Check for winners
               if (player1.empty())
               {
                   displayStatus(players);
                   System.out.println("\nPlayer 1 won!");
                   gameOver = true;
               }
               else if (player2.empty())
               {
                   displayStatus(players);
                   System.out.println("\nPlayer 2 won!");
                   gameOver = true;
               }
           }
            // Prompt the user to play again
           System.out.print("\nDo you want to play again? (y/n): ");
           repeat = keyboard.nextLine().toLowerCase().charAt(0);

        } while(repeat == 'y');

        // Display exit message when the user decides to exit the game
        GameModel.displayExitMessage();
    }

    /**
     * Displays the current status of each player's hand during the game.
     *
     * @param players ArrayList of player hands.
     */
    public static void displayStatus(ArrayList<Queue<Integer>> players)
    {
        System.out.println("\nCards in hand.");
        System.out.println("---------------\n");
        for(int i = 0; i < players.size(); i++ ) {
            System.out.printf("Player %d: " + players.get(i), i + 1);
            System.out.println();
        }
    }
}

