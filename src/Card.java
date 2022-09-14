public class Card {

    private Suit localSuit;
    private int localNum;

    //getter
    public int getLocalNum() {
        return localNum;
    }

    /**
     * Parameterized constructor
     */
    public Card (Suit suit, int num){
        this.localSuit =suit;

        // card number validation
        if(num>=1 && num <=13){
            this.localNum = num;
        } else {
            System.err.println(num + "is not valid");
            System.exit( 1);
        }
    }


    public String toString(){
        String numStr = "Error";

        switch(this.localNum){

            case 1 : numStr = "Ace";
                     break;
            case 2 : numStr = "2";
                     break;
            case 3 :  numStr = "3";
                    break;
            case 4 : numStr = "4";
                    break;
            case 5 : numStr = "5";
                    break;
            case 6: numStr = "6";
                    break;
            case 7 : numStr = "7";
                    break;
            case 8 : numStr = "8";
                    break;
            case 9 : numStr = "9";
                    break;
            case 10: numStr = "10";
                    break;
            case 11: numStr = "King";
                    break;
            case 12: numStr = "Queen";
                break;
            case 13: numStr = "Jack";
                break;

        }
        return numStr + " " + localSuit.toString();
    }
}
