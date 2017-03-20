import controller.PokedeckController;
import model.Pokedeck;

public class Main {

	public static void main(String[] args) {
		Pokedeck deck = new Pokedeck(); //New instance of a deck
		PokedeckController ctrl = new PokedeckController(deck); //Methods for new instance 'deck'
	}

}
