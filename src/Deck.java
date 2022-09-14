import java.util.Random;

public class Deck {
    private Card[] myCards;
    private int numberOfCards;

    // default contructor
    public Deck() {
        // one pack of card deck (52 cards)
    this(1, false);
    }

    /**
     * Overloading
     * @param numberOfDecks
     * @param shuffle
     */
    public Deck(int numberOfDecks, boolean shuffle) {
        this.numberOfCards = numberOfDecks * 52;
        this.myCards = new Card[this.numberOfCards];
        int cardCount = 0;

        // each deck
        for (int deck = 0; deck < numberOfDecks; deck++) {
            // each suit
            for (int suit = 0; suit < 4; suit++) {
                // each card
                for (int n = 1; n <= 13; n++) {
                    this.myCards[cardCount] = new Card(Suit.values()[suit], n);
                    cardCount++;
                }
            }
        }

        //Random Shuffling
        if (shuffle) {
            System.out.println("Shuffling");
            Random random = new Random();
            Card tempCard;

            int j;
            for (int i = 0; i < this.numberOfCards; i++) {
                j = random.nextInt(this.numberOfCards);

                tempCard = this.myCards[i];
                this.myCards[i] = this.myCards[j];
                this.myCards[j] = tempCard;
            }
        }
    }

    // fetch first top card and arrange the remaining
    public Card fetchNextCard() {
            Card topCard = this.myCards[0];
            //shift left by 1
            for (int i=1; i<this.numberOfCards; i++){
                this.myCards[i-1]= this.myCards[i];
            }
            this.myCards[this.numberOfCards -1]= null;

            //decrement the number of cards in deck
            this.numberOfCards--;
            return topCard;
        }

    public void printDeck(int numberToPrint) {
        for(int i=0; i<numberToPrint; i++) {
        System.out.println(this.myCards[i].toString()); // e.g. 2 Spades, 5 Diamonds
        }
    }
}
