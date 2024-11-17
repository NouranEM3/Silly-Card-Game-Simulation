/*
 * Nouran Mahfouz
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package nmahfouz_p3;
import java.util.Random;
import java.util.ArrayList;
/**
 * The GameModel class represents the model for a simple card game.
 * It manages the deck, player hands, and the discard pile.
 * The game is a two-player game where each player is dealt seven cards,
 * and they take turns playing a card from their hand to match the top
 * card on the discard pile.
 *
 * The cards in the game have values ranging from 1 to 13, and each value
 * has four copies. The deck is initially shuffled, and players take turns
 * playing cards until the deck is empty. Players earn points based on
 * successful plays, and the player with the highest score at the end wins.
 *
 * The GameModel class includes methods for initializing the game, shuffling
 * the cards, dealing cards to players, comparing played cards, and updating
 * the player hands and the discard pile. Additionally, it provides methods
 * to display welcome and exit messages for the game.
 *
 * @author Nouran Mahfouz
 * @version 1.0
 */
public class GameModel {
    private static final int CAPACITY = 52;
    private static final int CARDS_UPPER_BOUND = 13;
    private static final int NUMBER_OF_COPIES = 4;
    public static ArrayList<Integer> cards = new ArrayList<>(CAPACITY);
    private Stack<Integer> dealStack;
    private Stack<Integer> discardStack;


    /**
     * Constructor for the GameModel class. Initializes the deck of cards,
     * shuffles it, and sets up the deal and discard stacks.
     */
    public GameModel(){

        populateCards();
        shuffleDeck();

        dealStack = new Stack<>();
        for(Integer card: cards)
            dealStack.push(card);

        discardStack = new Stack<>();
    }

    /**
     * Displays a welcome message for the card game.
     */
    public static void displayWelcomeMessage(){
        System.out.println("Welcome to Silly Little Games' new Card Game!");
        System.out.println("In this two-player card game, each player starts" +
                        "with seven cards.");
        System.out.println("Take turns playing a card from your hand and" +
                " compare it with the top card on the discard pile.");
        System.out.println("Based on comparison results player either pick 2 " +
                "cards or one card or no cards.");
        System.out.println("The first player to run out of cards wins the " +
                "game.");
        System.out.println("\nGood Luck!!!!");
    }


    /**
     * Populates the deck of cards with the specified number of copies.
     */
    private static void populateCards(){
        for(int i = 0; i < NUMBER_OF_COPIES; i++){
            for (int j = 1; j <= CARDS_UPPER_BOUND; j++) {
                cards.add(j);
            }
        }
    }

    /**
     * Shuffles the cards using the Fisher-Yates algorithm
     */
    private static void shuffleDeck() {
        Random rand = new Random();
        for (int i = cards.size(); i > 1; i--) {
            int j = rand.nextInt(i);
            int temp = cards.get(i - 1);
            cards.set(i - 1, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * Deals a specified number of cards to each player from the deal stack.
     * The top card from the deal stack is pushed onto the discard stack.
     *
     * @param p1 The queue representing player 1.
     * @param p2 The queue representing player 2.
     */
    public void dealCards(Queue<Integer> p1, Queue<Integer> p2) {
        final int MAX_CARDS = 7;
        for (int i = 0; i < MAX_CARDS; i++) {
            p1.enqueue(dealStack.pop());
            p2.enqueue(dealStack.pop());
        }
        discardStack.push(dealStack.pop());
    }

    /**
     * Retrieves the value of the card at the top of the discard stack.
     *
     * @return The value of the card at the top of the discard stack.
     */
    public int getTopOfDiscardStack(){
        return discardStack.peek();
    }

   /**
    * Compares the player's top card with the card at the top of the discard stack.
    * Updates the game state based on the comparison result.
    *
    * @param player The queue representing the player's hand.
    * @return The result of the card comparison
    *           (0 for a match, 1 for a higher value, -1 for a lower value).
    */
    public int compare(Queue<Integer> player){
        int topOfStack;
        int playerCard;
        int result;
        topOfStack = discardStack.peek();
        playerCard = player.peek();
        result = Integer.compare(topOfStack, playerCard);

        if(dealStack.empty())
            repopulateDealStack();

        switch (result) {

            case 0:
                player.enqueue(dealStack.pop());
                break;

            case 1:
                player.enqueue(dealStack.pop());
                if(dealStack.empty())
                    repopulateDealStack();
                player.enqueue(dealStack.pop());
                break;

            case -1:
                break;
        }

        return result;
    }

    /**
     * Repopulates the deal stack by transferring cards from the discard stack.
     * The top card from the discard stack stays at the top.
     */
    public void repopulateDealStack(){
        int temp;
        temp = discardStack.pop();
        for(int i = 0; i < discardStack.size(); i++ ){
            dealStack.push(discardStack.pop());
        }
        dealStack.push(temp);
    }

    /**
     * Updates the player's move by pushing the top card onto the discard stack.
     *
     * @param player The queue representing the player's hand.
     */
    public void updatePlayer(Queue<Integer> player){
        discardStack.push(player.dequeue());
    }

    /**
     * Displays an exit message for the card game.
     */
    public static void displayExitMessage(){
        System.out.println("\nThanks for playing the Card Game!\n");
    }

}
