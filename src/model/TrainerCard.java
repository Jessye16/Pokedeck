package model;

public class TrainerCard extends Card {
	
	private String name;
	private TrainerType type;
	private String description;
	private String rule;
	
	public TrainerCard(String cardName,TrainerType cardType,String cardDesc,String cardRule) {
		setName(cardName);
		setType(cardType);
		setDescription(cardDesc);
		setRule(cardRule);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TrainerType getType() {
		return type;
	}
	
	public void setType(TrainerType type) {
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