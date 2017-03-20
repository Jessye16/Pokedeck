package model;
import java.util.ArrayList;

public class Pokedeck {
	
	static ArrayList<Card> cards; //Le deck

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
	public static void removeCard(Card card){
		cards.remove(card); //On retire la carte du pokédex
	}

}
