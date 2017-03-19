import java.util.ArrayList;

import cards.Card;

public class Pokedeck {
	
	static ArrayList<Card> cards; //Le deck

	public Pokedeck() {
		//On initialise l'ArrayList pour la rendre utilisable
		cards = new ArrayList<>();
	}
	
	//ajoute une description à la carte card
	public static void addDescription(Card card, String description) throws Exception {
		if(card.getDescription().length()!=0) //si la carte possède déjà  une description, on lance une exception (il y a erreur)
			throw new Exception("Description déjà  présente");
		card.setDescription(description); //On change la description de la carte
	}
	
	//retire la carte card du pokedex
	public static void removeCard(Card card){
		cards.remove(card); //On retire la carte du pokédex
	}
	
	//modifie la description de la carte card, par description
	public static void modifyDescription(Card card, String description) throws Exception {
		if(card.getDescription().length()==0) //Si la carte ne possède pas de description, on lance une exception
			throw new Exception("Pas de description");
		card.setDescription(description);
	}
	

}
