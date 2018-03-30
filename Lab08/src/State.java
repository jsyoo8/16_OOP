import java.io.Serializable;
import java.util.Vector;

public class State implements Serializable {
	int money; // Amount of money the user has.
	int bet; // Amount user bets on a game.
	Vector<Card> dealerHand;
	Vector<Card> userHand;
	Card[] deck;

	public State() {
		money = 100;
		bet = 0;
		dealerHand = new Vector<Card>();
		userHand = new Vector<Card>();
		deck = new Card[52];
	}
}
