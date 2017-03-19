package cards;

public class TrainerCard extends Card {
	
	private String name;
	private PokemonType type;
	private String description;
	private String rule;
	
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRule() {
		return rule;
	}
	
	public void setRule(String rule) {
		this.rule = rule;
	}
}