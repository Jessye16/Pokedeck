package model;

public class PokemonCard extends Card {

	private int HP;
	private String name;
	private PokemonType type;
	private String stage;
	private String evolution;
	private String description;
	
	public PokemonCard(String cardName,PokemonType cardType,int cardHP,String cardStage,String cardEvolution, String cardDesc) {
		setCardType(CardType.POKEMON);
		setHP(cardHP);
		setName(cardName);
		setType(cardType);
		setStage(cardStage);
		setEvolution(cardEvolution);
		setDescription(cardDesc);
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hp) {
		HP = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}
	
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public String getEvolution() {
		return evolution;
	}

	public void setEvolution(String evolution) {
		this.evolution = evolution;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
