package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author MiguelLinares
 * @author JohanSilva
 * @author MiguelRamirez
 * @author HaroldDuarte
 */
public class PokemonDAO {
	private ArrayList<PokemonDTO> pokemones;

	/**
	 * Empty constructor method
	 */
	public PokemonDAO() {
	}

	/**
	 * Constructor method
	 * 
	 * @param pokemones Array of the pokemons
	 */
	public PokemonDAO(ArrayList<PokemonDTO> pokemones) {
		this.pokemones = pokemones;
	}

	/**
	 * Gets method of the ArrayList
	 * 
	 * @return pokemon Array of pokemons
	 */
	public ArrayList<PokemonDTO> getArrayList() {
		return pokemones;
	}

	/**
	 * Method that convert the Array in to String
	 * 
	 * @return Array coverted
	 */
	public String[] getArrayString() {
		String[] tmp = new String[pokemones.size()];
		for (int i = 0; i < tmp.length; i++) {
			PokemonDTO tmpP = pokemones.get(i);
			tmp[i] = tmpP.getNum() + ". " + tmpP.getNom();
		}
		return tmp;
	}

	/**
	 * Method that gets the pokemon list using a for Each Loop
	 * 
	 * @param numero Number of pokemons
	 * @return Number of pokemons
	 */
	public PokemonDTO getPoke(int numero) {
		for (PokemonDTO a : pokemones) {
			if (a.getNum() == numero) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Method for search a pokemon
	 * 
	 * @param name Name of the pokemon
	 * @return Int 0
	 */
	public int buscarPoke(String name) {
		for (int i = 0; i < pokemones.size(); i++) {
			if (pokemones.get(i).getNom().equalsIgnoreCase(name)) {
				return pokemones.get(i).getNum();
			}
		}
		return 0;
	}
}
