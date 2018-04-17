package PJ4;

import java.util.*;
import java.util.Scanner;

/* This is the main poker game class.
 * It uses Decks and Card objects to implement poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */
public class MyPokerGame {

    // default constant values
    private static final int startingBalance = 1000;
    private static final int numberOfCards = 5;
    // default constant payout value and currentHand types
    private static final int[] multipliers = {1, 2, 3, 5, 6, 9, 25, 50, 250};
    private static final String[] goodHandTypes = {
        "Royal Pair", "Two Pairs", "Three of a Kind", "Straight", "Flush	",
        "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};
    // must use only one deck
    private static final Decks oneDeck = new Decks(1);
    // holding current poker 5-card hand, balance, bet    
    private List<Card> currentHand;
    private int balance;
    private int bet;

    /**
     * default constructor, set balance = startingBalance
     */
    public MyPokerGame() {
        this(startingBalance);
    }

    public MyPokerGame(int balance) {
        this.balance = balance;
    }

    private void showPayoutTable() {
        System.out.println("\n\n");
        System.out.println("Payout Table   	      Multiplier   ");
        System.out.println("=======================================");
        int size = multipliers.length;
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(goodHandTypes[i] + "\t|\t" + multipliers[i]);
        }
        System.out.println("\n\n");
    }

    /**
     * Check current currentHand using multipliers and goodHandTypes arrays Must
     * print yourHandType (default is "Sorry, you lost") at the end of function.
     * This can be checked by testCheckHands() and main() method.
     */
    private void checkHands() {
        int rank = 0;
        String ranks;
        if (isRoyalPair() == true) {
            rank = 1;
        } else if (isTwoPair() == true) {
            rank = 2;
        }
        if (isThreeOfAKind() == true) {
            rank = 3;
        }
        if (isStraight() == true) {
            rank = 4;
        }
        if (isFlush() == true) {
            rank = 5;
        }
        if (isFullHouse() == true) {
            rank = 6;
        }
        if (isFourOfAKind() == true) {
            rank = 7;
        }
        if (isStraightFlush() == true) {
            rank = 8;
        }
        if (isRoyalFlush() == true) {
            rank = 9;
        }
        rank -= 1;
        if (rank < 0) {
            ranks = "Sorry, you lost!";
        } else {
            ranks = goodHandTypes[rank];

        }

        System.out.println("" + ranks);

        switch (ranks) {
            case "Royal Pair":
                this.balance += (this.bet * multipliers[0]);
                break;
            case "Two Pairs":
                this.balance += (this.bet * multipliers[1]);
                break;
            case "Three of a Kind":
                this.balance += (this.bet * multipliers[2]);
                break;
            case "Straight":
                this.balance += (this.bet * multipliers[3]);
                break;
            case "Flush":
                this.balance += (this.bet * multipliers[4]);
                break;
            case "Full House":
                this.balance += (this.bet * multipliers[5]);
                break;
            case "Four of a Kind":
                this.balance += (this.bet * multipliers[6]);
                break;
            case "Straight Flush":
                this.balance += (this.bet * multipliers[7]);
                break;
            case "Royal Flush":
                this.balance += (this.bet * multipliers[8]);
                break;
            default:
                break;
        }

    }

    private boolean isFlush() {

        for (int i = 0; i < numberOfCards - 1; i++) {
            if (currentHand.get(i).getSuit() != currentHand.get(i + 1).getSuit()) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraightFlush() {
        if (isStraight() == true && isFlush() == true) {
            return true;
        }
        return false;
    }

    private boolean isRoyalFlush() {
        if (isFlush() == false || isStraight() == false) {
            return false;
        } else {
            if (currentHand.get(0).getRank() == 1 && currentHand.get(1).getRank() == 10) {
                return true;
            }
            return false;
        }

    }

    private boolean isFourOfAKind() {
        int i, j, count = 1;
        for (i = 0; i < numberOfCards; i++) {
            for (j = i + 1; j < numberOfCards; j++) {
                if (currentHand.get(i).getRank() == currentHand.get(j).getRank()) {
                    count++;
                }

            }
            if (count == 4) {
                return true;
            }
            count = 1;
        }
        return false;
    }

    private boolean isFullHouse() {
        List<Integer> sortedHand = new ArrayList<Integer>();
        for (int count = 0; count < numberOfCards; count++) {
            sortedHand.add(currentHand.get(count).getRank());
        }
        Collections.sort(sortedHand);
        if ((sortedHand.get(0) == sortedHand.get(1)) && (sortedHand.get(1) == sortedHand.get(2)) && (sortedHand.get(3) == sortedHand.get(4))) {
            return true;
        }
        if ((sortedHand.get(2) == sortedHand.get(3)) && (sortedHand.get(3) == sortedHand.get(4)) && (sortedHand.get(0) == sortedHand.get(1))) {
            return true;
        }

        return false;

    }

    private boolean isThreeOfAKind() {
        if (isFourOfAKind() == true) {

            return false;
        }
        int i, j, count = 1;
        for (i = 0; i < numberOfCards; i++) {
            for (j = i + 1; j < numberOfCards; j++) {
                if (currentHand.get(i).getRank() == currentHand.get(j).getRank()) {
                    count++;

                }
               
            }
                   if (count == 3) {
                    return true;
                }
                count = 1;
        }
        return false;
    }

    private boolean isTwoPair() {
        if (isFullHouse() == true || isThreeOfAKind() == true || isFourOfAKind() == true) {
            return false;
        }
        int sum = 0;
        int counter = 0;
        for (int x = 0; x < numberOfCards; x++) {
            for (int y = x + 1; y < numberOfCards; y++) {
                if (currentHand.get(x).getRank() == currentHand.get(y).getRank()) {
                    counter++;

                }

            }
            if (counter > 1) {
                sum++;
                counter = 0;
            }
            if (sum == 2) {
                return true;
            }
        }


        return false;
    }

    private boolean isOnePair() {
        for (int x = 0; x < numberOfCards; x++) {
            for (int y = x + 1; y < numberOfCards; y++) {
                if (currentHand.get(x).getRank() == currentHand.get(y).getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isRoyalPair() {
        if (isTwoPair() == true) {
            return false;
        }
        int i, j;
        for (i = 0; i < numberOfCards; i++) {
            for (j = i + 1; j < numberOfCards; j++) {
                if ((currentHand.get(i).getRank() == currentHand.get(j).getRank()) && (currentHand.get(i).getRank() > 10)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isStraight() {
        List<Integer> sortedHand = new ArrayList<Integer>();
        for (int count = 0; count < numberOfCards; count++) {
            sortedHand.add(currentHand.get(count).getRank());
        }
        Collections.sort(sortedHand);
        if (sortedHand.get(0) == 1 && sortedHand.get(1) == 10) {
            return true;
        }
        for (int count = 1; count < numberOfCards; count++) {
            if (sortedHand.get(count) != (sortedHand.get(count - 1) + 1)) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        /**
         * The main algorithm for single player poker game
         *
         * Steps: showPayoutTable()
         *
         * ++ show balance, get bet verify bet value, update balance reset deck,
         * shuffle deck, deal cards and display cards ask for position of cards
         * to keep get positions in one input line update cards check hands,
         * display proper messages update balance if there is a payout if
         * balance = O: end of program else ask if the player wants to play a
         * new game if the answer is "no" : end of program else :
         * showPayoutTable() if user wants to see it goto ++
         */
        Scanner input = new Scanner(System.in);
        List<Card> keepCard = new ArrayList<>();

        boolean newGame = true;
        boolean rightBet = false;
        while (newGame) {
            int counter = 0;
            oneDeck.shuffle();

            showPayoutTable();
            System.out.println("Balance:" + balance + "\n");
            while (!rightBet) {
                System.out.println("Please, enter a bet:");
                bet = Integer.parseInt(input.nextLine());
                if (bet > balance) {
                    System.out.println("Sorry, not enough funds!");
                    rightBet = false;
                } else {
                    rightBet = true;
                }

            }

            balance = balance - bet;

            try {
                currentHand = oneDeck.deal(5);
            } catch (PlayingCardException e) {
                System.out.println("Exception dealing a new hand" + e.getMessage());
            }
            System.out.println("" + currentHand.toString());
            System.out.print("Enter positions to keep:");
            keepCard.clear();
            String s = input.nextLine();

            input = new Scanner(s);
            input = input.useDelimiter("\\s*");
            while (input.hasNext()) {
                keepCard.add(currentHand.get((input.nextInt()) - 1));
                counter++;

            }


            currentHand = keepCard;
            try {
                currentHand.addAll(oneDeck.deal(5 - counter));
            } catch (PlayingCardException e) {
                System.out.println("Exception in dealing second hand" + e.getMessage());

            }
            System.out.println("" + currentHand.toString());
            checkHands();



            if (balance == 0) {
                newGame = false;
                break;
            }
            System.out.println("Your balance is:   " + balance + "  Want to play another game? (y/n)");
            input = new Scanner(System.in);
            s = input.nextLine();
            if ("y".equals(s)) {
                newGame = true;
            } else {
                newGame = false;
            }
            System.out.println("Want to see the payout table? (y/n)");
            s = input.nextLine();
            if ("y".equals(s)) {
                showPayoutTable();

            }
            oneDeck.reset();








        }
        System.out.print("Goodbye.");


    }

    /**
     * Do not modify this. It is used to test checkHands() method checkHands()
     * should print your current hand type
     */
    public void testCheckHands() {
        try {
            currentHand = new ArrayList<Card>();

            // set Royal Flush
            currentHand.add(new Card(1, 3));
            currentHand.add(new Card(10, 3));
            currentHand.add(new Card(12, 3));
            currentHand.add(new Card(11, 3));
            currentHand.add(new Card(13, 3));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Straight Flush
            currentHand.set(0, new Card(9, 3));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Straight
            currentHand.set(4, new Card(8, 1));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Flush 
            currentHand.set(4, new Card(5, 3));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush	", 
            // "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

            // set Four of a Kind
            currentHand.clear();
            currentHand.add(new Card(8, 3));
            currentHand.add(new Card(8, 0));
            currentHand.add(new Card(12, 3));
            currentHand.add(new Card(8, 1));
            currentHand.add(new Card(8, 2));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Three of a Kind
            currentHand.set(4, new Card(11, 3));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Full House
            currentHand.set(2, new Card(11, 1));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Two Pairs
            currentHand.set(1, new Card(9, 1));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // set Royal Pair
            currentHand.set(0, new Card(3, 1));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");

            // non Royal Pair
            currentHand.set(2, new Card(3, 3));
            System.out.println(currentHand);
            checkHands();
            System.out.println("-----------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* Quick testCheckHands() */
    public static void main(String args[]) {
        MyPokerGame mypokergame = new MyPokerGame();
        mypokergame.testCheckHands();
    }
}
