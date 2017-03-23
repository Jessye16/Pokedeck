package model;

public class EnergyCard extends Card{
	
	private PokemonType type;
	
	public EnergyCard(PokemonType cardType) {
		setCardType(CardType.ENERGY);
		setType(cardType);
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

}
