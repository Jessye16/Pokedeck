package model;

public class PokemonCard extends Card {

	private int HP;
	private String name;
	private int collectorCardNumber;
	private PokemonType type;
	
	public PokemonCard() {
		
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCollectorCardNumber() {
		return collectorCardNumber;
	}

	public void setCollectorCardNumber(int collectorCardNumber) {
		this.collectorCardNumber = collectorCardNumber;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

}
