package student;
import java.util.*;

public class Deck {

    /**
     * initializes ranRandom() for later use.
     */
    private Random rand = new Random();

    /**
     * stores the entire set of cards.
     */
    private Card[] cardDeck = new Card[52];

    /**
     * keeps track of what cards are used.
     */
    private int deckIndex = 0;

    /**
     * constructor, shuffles deck of cards.
     */
    public Deck() {
        int idx = 0;
        for (int i = 1; i < 14; i++) { //per card
            for (int j = 1; j < 5; j++) { //per suit
                cardDeck[idx] = new Card(i, j);
                idx++;
            }
        }
        shuffle();
    }

    /**
     * shuffles cards randomly.
     */
    public void shuffle() {
        for (int i = cardDeck.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cardDeck[i];
            cardDeck[i] = cardDeck[j];
            cardDeck[j] = temp;
        }
    }

    /**
     * draws a card from the deck, creates and shuffles new deck if empty.
     * @return next card from the deck
     */
    public Card draw() {
        if (isEmpty()) {
            deckIndex = 1;
            Deck newDeck = new Deck();
            newDeck.shuffle();
            Card lastCard = cardDeck[51];
            cardDeck = newDeck.getDeck();

            return lastCard;
        } else {
            deckIndex++;
            return cardDeck[deckIndex - 1];
        }
    }

    /**
     * returns the deck.
     * @return array of cards representing the deck
     */
    public Card[] getDeck() {
        return cardDeck;
    }

    /**
     * returnss number of cards unused in the deck.
     * @return int cards left
     */
    public int cardsRemaining() {
        return 52 - deckIndex;
    }

    /**
     * returns true if the deck is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        return deckIndex >= 52;
    }


}
