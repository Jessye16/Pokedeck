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
	
	// Add pokemon card to table
	public void addPokemonCard(String pkmnName,PokemonType pkmnType,String pkmnHp,String stage,String pkmnEvolution,String pkmnDesc){
		PokemonCard pkmn = new PokemonCard(pkmnName,pkmnType,Integer.parseInt(pkmnHp),stage,pkmnEvolution,pkmnDesc);
		deck.addCard(pkmn);
		deckListWindow.addRowInTable(pkmnName, pkmn.getCardType().toString());
	}
	
	//Add trainer card to table
	public void addTrainerCard(String cardName,TrainerType cardType,String cardDesc,String cardRule){
		TrainerCard trainer = new TrainerCard(cardName,cardType,cardDesc,cardRule);
		deck.addCard(trainer);
		deckListWindow.addRowInTable(cardName, trainer.getCardType().toString());
	}
	
	//Add energy card to table
	public void addEnergyCard(PokemonType cardType){
		EnergyCard energy = new EnergyCard(cardType);
		deck.addCard(energy);
		deckListWindow.addRowInTable(cardType.toString(), energy.getCardType().toString());
	}
	
	public void removeCard(int cardIndex){
		//Remove card from deck
		deck.removeCard(cardIndex);
	}
	
	public void openCardView(int cardIndex){
		//Get card from deck according to returned index in param
		Card card = deck.getCardAtIndex(cardIndex);
		
		//Find card type, and display each window according to the corresponding type
		switch(card.getCardType())
		{
			case POKEMON :
				//Cast card into EnergyCard
				PokemonCard pcard = (PokemonCard)card;
				
				//Create the view
				ViewPokemonCard pcardWindow = new ViewPokemonCard(this, pcard.getName(), pcard.getType().toString(), pcard.getHP(), pcard.getStage(), pcard.getEvolution(), pcard.getDescription());
				pcardWindow.setVisible(true);
			break;
			
			case TRAINER :
				TrainerCard tcard = (TrainerCard)card;
				
				ViewTrainerCard tcardWindow = new ViewTrainerCard(this, tcard.getName(), tcard.getType().toString(), tcard.getDescription(), tcard.getRule());
				tcardWindow.setVisible(true);
			break;
			
			case ENERGY :
				EnergyCard ecard = (EnergyCard)card;
				
				ViewEnergyCard ecardWindow = new ViewEnergyCard(this,ecard.getType().toString());
				ecardWindow.setVisible(true);
			break;
		}
		
	}
}
