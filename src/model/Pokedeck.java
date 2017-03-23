package model;
import java.util.ArrayList;

public class Pokedeck {
	
	private static ArrayList<Card> cards; //Le deck
	
	public Pokedeck() {
		//On initialise l'ArrayList pour la rendre utilisable
		cards = new ArrayList<>();
	}
	
	//add card to deck
	public static void addCard(Card card){
		cards.add(card);
		System.out.println(cards);
	}
	
	//remove card from deck
	public static void removeCard(int cardIndex){
		cards.remove(cardIndex); //On retire la carte du pokédex
		System.out.println(cards);
	}
	
	//get card at Index
	public static Card getCardAtIndex(int index){
		return cards.get(index);
	}

}
