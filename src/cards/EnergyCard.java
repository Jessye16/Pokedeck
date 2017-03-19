package cards;

public class EnergyCard extends Card {
	
	private PokemonType type;
	
	public EnergyCard() {
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

}
