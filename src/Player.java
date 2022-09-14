public class Player {

    private String playerName;

    //Number of cards in player hand
    private Card[] hand = new Card[10]; // can be customized based on need

    private int numberOfCards;


    public Player(String name){
        this.playerName = name;
        this.emptyHand();
    }

    private void emptyHand() {
        for (int i = 0; i < 10 ; i++){
            this.hand[i] = null;
        }
        this. numberOfCards = 0;
    }

    //add card to player and check 21 bust logic
    public boolean addCard(Card card) {
        if(this.numberOfCards == 10)
        {
            System.err.println("Hand already have maximum 2 card " + this.playerName);
            System.exit(1);}
        this.hand[this.numberOfCards] = card;
        this.numberOfCards++;
        return (this.getTotalHandCards() <= 21);
    }

    /**
     * Calculate total cards in hand
     * @return int totalCardsInHand
     */
    public int getTotalHandCards() {
        int totalCardsInHand = 0;
        int cardNumber;
        int numberOfAces = 0;

        for(int i=0; i<this.numberOfCards; i++) {
            cardNumber = this.hand[i].getLocalNum();
            // Ace logic
            if(cardNumber == 1) {
            numberOfAces++;
            totalCardsInHand +=11;
            }
            // king, queen, jack logic
            else if (cardNumber>10) {
                totalCardsInHand += 10;
            }
            // any other card
            else {
                totalCardsInHand += cardNumber;
            }

            // logic to flip Ace 1 or 11, depending on situation
            while(totalCardsInHand > 21 && numberOfAces > 0) {
                totalCardsInHand -= 10;
                numberOfAces --;
            }

        }
        return totalCardsInHand;
    }

    // face down card only for dealer
    public void printHandCard(boolean showFirstCard) {
    System.out.printf("\n" + "Dealing to player, cards: "+ this.playerName);
    for(int i=0; i<numberOfCards; i++) {
        if(i==0 && !showFirstCard) {
            System.out.println("\n" + "face down");
        } else {
            System.out.printf("\n " + this.hand[i].toString());
        }
    }

    }

}
