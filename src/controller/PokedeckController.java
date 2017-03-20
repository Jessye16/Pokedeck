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
	
	public void addTrainerCard(String cardName,PokemonType cardType,String cardDesc,String cardRule){
		TrainerCard trainer = new TrainerCard(cardName,cardType,cardDesc,cardRule);
		deck.addCard(trainer);
	}
	
	public void addEnergyCard(){
		
	}
}
