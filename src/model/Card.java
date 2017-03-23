package model;

public class Card {
	
	private CardType tcgCardType;
	
	public void CardType(){}
	
	public CardType getCardType(){
		return tcgCardType;
	}
	
	void setCardType(CardType type){
		this.tcgCardType = type;
	}
}
