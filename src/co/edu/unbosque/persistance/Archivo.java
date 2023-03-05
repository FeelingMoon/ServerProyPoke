package co.edu.unbosque.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MiguelLinares
 * @author JohanSilva
 * @author MiguelRamirez
 * @author HaroldDuarte
 */

public abstract class Archivo {

	private FileWriter guardado;
	private File guardadoFile;
	private Scanner guardadoScan;
	private String url;

	/**
	 * Empty constructor
	 */
	public Archivo() {
	}

	/**
	 * Constructor of method
	 * 
	 * @param url Save file url
	 */
	public Archivo(String url) {
		this.url = url;
		guardadoFile = new File(this.url);
	}

	/**
	 * Method in charge of saving the pokemon in the save file
	 * 
	 * 
	 * @param pokemon Name of the pokemon
	 * @throws IOException File handling exception
	 */

	public void guardar(String pokemon) throws IOException {
		guardado = new FileWriter(this.url, true);
		guardado.write("\n" + pokemon);
		guardado.close();
	}

	/**
	 * Method that loads from an array what is necessary for the program
	 * 
	 * @return Arreglo Array with the load
	 * @throws FileNotFoundException File not found exception
	 */
	public ArrayList<String> cargar() throws FileNotFoundException {
		guardadoScan = new Scanner(guardadoFile);
		ArrayList<String> cargado = new ArrayList<String>();
		while (guardadoScan.hasNextLine()) {
			cargado.add(guardadoScan.nextLine());
		}
		guardadoScan.close();
		return cargado;
	}

	/**
	 * Method that resets the file
	 * 
	 * @throws IOException File handling exception
	 */
	public void reiniciar() throws IOException {
		guardadoFile.delete();
		guardadoFile.createNewFile();
	}

	/**
	 * Method that gets the URL of the type
	 * 
	 * @param type Desired type name
	 * @return Url of the desired image
	 */
	public String getURLType(String type) {
		if (type.equalsIgnoreCase("Bug")) {
			return "src/co/edu/unbosque/util/img/Bug.png";
		} else if (type.equalsIgnoreCase("Dark")) {
			return "src/co/edu/unbosque/util/img/Dark.png";
		} else if (type.equalsIgnoreCase("Dragon")) {
			return "src/co/edu/unbosque/util/img/Dragon.png";
		} else if (type.equalsIgnoreCase("Electric")) {
			return "src/co/edu/unbosque/util/img/Electr.png";
		} else if (type.equalsIgnoreCase("Fairy")) {
			return "src/co/edu/unbosque/util/img/Fairy.png";
		} else if (type.equalsIgnoreCase("Fighting")) {
			return "src/co/edu/unbosque/util/img/Fight.png";
		} else if (type.equalsIgnoreCase("Fire")) {
			return "src/co/edu/unbosque/util/img/Fire.png";
		} else if (type.equalsIgnoreCase("Flying")) {
			return "src/co/edu/unbosque/util/img/Flying.png";
		} else if (type.equalsIgnoreCase("Ghost")) {
			return "src/co/edu/unbosque/util/img/Ghost.png";
		} else if (type.equalsIgnoreCase("Grass")) {
			return "src/co/edu/unbosque/util/img/Grass.png";
		} else if (type.equalsIgnoreCase("Ground")) {
			return "src/co/edu/unbosque/util/img/Ground.png";
		} else if (type.equalsIgnoreCase("Ice")) {
			return "src/co/edu/unbosque/util/img/Ice.png";
		} else if (type.equalsIgnoreCase("Normal")) {
			return "src/co/edu/unbosque/util/img/Normal.png";
		} else if (type.equalsIgnoreCase("Poison")) {
			return "src/co/edu/unbosque/util/img/Poison.png";
		} else if (type.equalsIgnoreCase("Psychic")) {
			return "src/co/edu/unbosque/util/img/Psychc.png";
		} else if (type.equalsIgnoreCase("Rock")) {
			return "src/co/edu/unbosque/util/img/Rock.png";
		} else if (type.equalsIgnoreCase("Steel")) {
			return "src/co/edu/unbosque/util/img/Steel.png";
		} else if (type.equalsIgnoreCase("water")) {
			return "src/co/edu/unbosque/util/img/Water.png";
		} else {
			return "src/co/edu/unbosque/util/img/Unknown.png";
		}
	}

	/**
	 * Method that gets the type and url of the image
	 * 
	 * @param type Desired type name
	 * @return Url of the desired image or "No"
	 */
	public String getType(String type) {
		if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Bug.png")) {
			return "Bug";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Dark.png")) {
			return "Dark";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Dragon.png")) {
			return "Dragon";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Electr.png")) {
			return "Electric";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Fairy.png")) {
			return "Fairy";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Fight.png")) {
			return "Fighting";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Fire.png")) {
			return "Fire";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Flying.png\"")) {
			return "Flying";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Ghost.png")) {
			return "Ghost";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Grass.png")) {
			return "Grass";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Ground.png")) {
			return "Ground";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Ice.png")) {
			return "Ice";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Normal.png")) {
			return "Normal";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Poison.png")) {
			return "Poison";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Psychc.png")) {
			return "Psychic";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Rock.png")) {
			return "Rock";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Steel.png")) {
			return "Steel";
		} else if (type.equalsIgnoreCase("src/co/edu/unbosque/util/img/Water.png")) {
			return "water";
		} else {
			return "no";
		}
	}
}
