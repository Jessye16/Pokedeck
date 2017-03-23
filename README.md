# Pokedeck project - UPMC

> This project is a very light Pokedeck version that allows users to manually **add**, **remove** or **consult** pokemon cards they created themselves.


## Quick start

> **Main.java** : Initialize and runs program.
> From this file, users will be able to access to very functionnality of the program.
> #Added runnable "pokedeckLauncher" jar for quick demo.

## Architecture

This project is split into 3 main parts :

* **models** -> package that contains all the files that define the properties of every cards and the way they are to be build.

* **controller** -> package that contains an only file, which is the main link between models files and GUI files.

* **GUI** -> package that contains all the files that makes the graphic layout.

## Files
  #### Controller
* PokedeckController.java : Main controller that has methods to open the different views, add cards, remove cards, consult cards, according to the models.

  #### Models
* Card.java : Class that defines the properties -methods and variables- common to every card.

* Pokedeck.java : Class that initialize the list of the cards, and add/remove a card in the table.

* PokemonCard.java : Gathers the different variables, getters & setters for Pokemon cards.

* EnergyCard.java : Gathers the different variables, getters & setters for Energy cards.

* TrainerCard.java : Gathers the different variables, getters & setters for Trainer cards.

* CardType.java : Define the types of the differents cards -Trainer/Energy/Pokemon-.

* PokemonType.java : Define the different types of Pokemons/Energy cards.

* TrainerType.java : Define the different types of Trainer cards.

  #### GUI
* DeckListWindow.java : Main window that contains the table with cards list and add/remove/consult buttons.

* AddCardWindow.java : Window with form to add either Pokemon, Trainer or Energy card.

* ViewEnergyCard.java : Window to display details of energy cards.

* ViewPokemonCard.java : Window to display details of pokemon cards.

* ViewTrainerCard.java : Window to display details of trainer cards.

  #### Resources
* pictures -> a package that contains all the images used for GUI.

------------------------------------

## Notes

I used *SwingBuilder* and *Eclipse* for this project to gain efficiency and to have an attractive GUI.

##### @author Jessye
