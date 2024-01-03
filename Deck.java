import java.util.Arrays;
import java.util.Collections;

class Deck {
    private Card[] cards;
    private int currentCardIndex;

    public Deck() {
        cards = new Card[52];
        initializeDeck();
        shuffle();
        currentCardIndex = 0;
    }

    private void initializeDeck() {
        String[] suits = {"H", "D", "C", "S"};//simplified card names
        String[] names = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int index = 0;
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                int value = (i < 10) ? i + 2 : 10; //aces are 11 because its easier in our game
                cards[index++] = new Card(suit, names[i], value);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(cards)); //not sure if you wanted us to manually write this
    }
//shuffle system needs out of bounds check
    public Card drawCard() {
        if (currentCardIndex == cards.length) {
            System.out.println("Deck is empty. Reshuffling.");
            shuffle();
            currentCardIndex = 0;
        }
        return cards[currentCardIndex++];
    }
}
