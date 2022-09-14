import java.util.Scanner;

public class MainPlay {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deck deckOne = new Deck(1, true);

        // Players
        Player ashutosh01 = new Player ("Ashutosh01");
        Player ashutosh02 = new Player ("Ashutosh02");
        Player dealer = new Player("Dealer");

        // Adding one card each to player and dealer
        ashutosh01.addCard(deckOne.fetchNextCard());
        ashutosh02.addCard(deckOne.fetchNextCard());
        dealer.addCard(deckOne.fetchNextCard());

        // Adding second card each to player and dealer
        ashutosh01.addCard(deckOne.fetchNextCard());
        ashutosh02.addCard(deckOne.fetchNextCard());
        dealer.addCard(deckOne.fetchNextCard());

        // GAME Start ->
        System.out.println("Starting Game with 2 players \n");
        ashutosh01.printHandCard(true);
        ashutosh02.printHandCard(true);
        dealer.printHandCard(false);

        // Each Player finished the Hits
        boolean ashutosh01Done = false;
        boolean ashutosh02Done = false;
        boolean dealerDone = false;
        String keyPressAnswer;

        while (!ashutosh01Done || !ashutosh01Done || !dealerDone) {

            // Player 1
            if(!ashutosh01Done) {
                System.out.println("\n" + "Hit or Stand?> H/S");
                keyPressAnswer = scanner.next();
                // Logic to handle H and do nothing for S
                if(keyPressAnswer.compareToIgnoreCase("H") == 0) {
                    // add card and validate internally if player is busted >21
                    ashutosh01Done = !ashutosh01.addCard(deckOne.fetchNextCard());
                    ashutosh01.printHandCard(true);
                } else {
                    ashutosh01Done = true;
                }
            }

            // Player 2
            if(!ashutosh02Done) {
                // same logic as above
            }

            // dealer play logic
            if(!dealerDone) {
                if(dealer.getTotalHandCards() < 17) {
                    System.out.println("\n" +" Dealer Hits");
                    dealerDone = !dealer.addCard(deckOne.fetchNextCard());
                    dealer.printHandCard(false); // face down
                } else {
                    System.out.println("\n" +" Dealer Stands");
                    dealerDone = true;
                }
            }

        }
        // close scanner
        scanner.close();

        // final hand card count
        ashutosh01.printHandCard(true);
        dealer.printHandCard(true);

        int playerSum = ashutosh01.getTotalHandCards();
        int dealerSum = dealer.getTotalHandCards();

        if(playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) {
            System.out.println("\n" + "PLAYER WON");
        } else {
            System.out.println("\n" + "DEALER WON");
        }

    }

}
