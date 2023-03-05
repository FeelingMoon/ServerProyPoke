package co.edu.unbosque.persistance;

/**
 * @author MiguelLinares
 * @author JohanSilva
 * @author MiguelRamirez
 * @author HaroldDuarte
 */

public class ArchivoPokemonDTO extends Archivo {

	/*
	 * Constructor method empty
	 */
	public ArchivoPokemonDTO() {
		super();
	}

	/**
	 * Constructor method
	 * 
	 * @param url Url of the Pokemons file
	 */
	public ArchivoPokemonDTO(String url) {
		super(url);
	}
}
