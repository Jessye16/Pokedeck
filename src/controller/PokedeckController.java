package controller;

import model.*;
import pokedeckGUI.*;

public class PokedeckController {
	private Pokedeck deck;
	private DeckListWindow deckListWindow;
	private AddCardWindow addCardWindow;
	
	public PokedeckController(Pokedeck decklist){
		deck = decklist;
		openDeckListView(); //open deck view
	}
	
	public void openDeckListView(){
		deckListWindow = new DeckListWindow(this);
		deckListWindow.setVisible(true);
	}
	
	public void openAddCardView(){
		addCardWindow = new AddCardWindow(this);
		addCardWindow.setVisible(true);
	}
	
	public void addPokemonCard(){
		
	}
	
	public void addTrainerCard(String cardName,TrainerType cardType,String cardDesc,String cardRule){
		TrainerCard trainer = new TrainerCard(cardName,cardType,cardDesc,cardRule);
		deck.addCard(trainer);
		deckListWindow.addRowInTable(cardName, "Trainer");
	}
	
	public void addEnergyCard(){
		
	}
	
	public void removeCard(int cardIndex){
		//Supprimer la carte du deck (Pokedeck)
		deck.removeCard(cardIndex);
	}
}
