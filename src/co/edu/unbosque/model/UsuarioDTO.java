package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author JohanSilva
 * @author MiguelLinares
 *
 */
@SuppressWarnings("serial")
public class UsuarioDTO implements Serializable {
	String user;
	ArrayList<ArrayList<PokemonDTO>> pokes;

//	 0 = bolsillo - 1 = caja 1 - 2 = caja 2 - 3 = caja 3
	/**
	 * constructor method
	 * 
	 * @param user User name
	 */
	public UsuarioDTO(String user) {
		this.user = user;
		pokes = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			pokes.add(new ArrayList<>());
		}
		System.out.println(pokes.size());
	}

	/**
	 * method to get username
	 * 
	 * @return User name
	 */
	public String getUser() {
		return user;
	}

	/**
	 * method in charge of changing the username
	 * 
	 * @param user User name
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Method in charge of obtaining the information of a pokemon
	 * 
	 * @param lugar  Where is the pokemon
	 * @param nombre pokemon name
	 * @return Returns the information of the pokemon
	 */
	public String getPokemon(int lugar, String nombre) {
		ArrayList<PokemonDTO> tmp = pokes.get(lugar);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).getMote().equalsIgnoreCase(nombre)) {
				return tmp.get(i).toString();
			}
		}
		return "error";
	}

	/**
	 * Method in charge of checking that the pocket is full
	 * 
	 * @return returns the confirmation if it is full or not
	 */
	public String isFullPocket() {
		if (pokes.get(0).size() == 6) {
			return "logro";
		} else {
			return "error";
		}
	}

	/**
	 * Method to check if a nickname is not repeated
	 * 
	 * @param mote nickname to verify
	 * @return returns the confirmation
	 */
	public String compMote(String mote) {
		for (int i = 0; i < pokes.size(); i++) {
			ArrayList<PokemonDTO> tmp = pokes.get(i);
			if (tmp.size() == 0) {
				continue;
			} else {
				for (int j = 0; j < tmp.size(); j++) {
					if (tmp.get(j).getMote().equals(mote)) {
						return "exist";
					}
				}
			}
		}
		return mote;
	}

	/**
	 * Method in charge of assigning a nickname when the user does not enter a
	 * custom nickname
	 * 
	 * @param nombre pokemon name
	 * @return returns the number that should be given to the nickname of the
	 *         pokemon to avoid errors
	 */
	public int contNothing(String nombre) {
		int cont = 0;
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < pokes.size(); i++) {
			ArrayList<PokemonDTO> tmp = pokes.get(i);
			if (tmp.size() > 0) {
				for (int j = 0; j < tmp.size(); j++) {
					if (tmp.get(j).getNom().equals(nombre)) {
						if (!tmp.get(j).getMote().equals(nombre)) {
							nums.add(Integer.parseInt(tmp.get(j).getMote().split("_")[1]));
						} else {
							nums.add(0);
						}
					}
				}
			}
		}
		Collections.sort(nums);
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == cont) {
				cont++;
			} else {
				return cont;
			}
		}
		return cont;
	}

	/**
	 * Method in charge of capturing a pokemon
	 * 
	 * @param lugar   place where you want to save the pokemon
	 * @param pokemon pokemon you want to save
	 * @param mote    nickname chosen by the user
	 * @return returns the confirmation if the action could be done
	 */
	public String capturarPoke(int lugar, PokemonDTO pokemon, String mote) {
		int cont = 0;
		String tmp = "";
		if (lugar == 0 && isFullPocket().equals("logro")) {
			return "lleno";
		} else {
			if (mote.equals("Nothing")) {
				cont = contNothing(pokemon.getNom());
				if (!(cont > 0)) {
					tmp = pokemon.getNom();
				} else {
					tmp = pokemon.getNom() + "_" + cont;
				}
			} else {
				tmp = compMote(mote);
				if (!tmp.equals("exist")) {
					tmp = compMote(mote);
				} else {
					return tmp;
				}
			}
			pokes.get(lugar)
					.add(new PokemonDTO(pokemon.getNum(), pokemon.getHp(), pokemon.getAttack(), pokemon.getDefense(),
							pokemon.getSpAtk(), pokemon.getSpDef(), pokemon.getSpeed(), pokemon.getMov1(),
							pokemon.getMov2(), pokemon.getMov3(), pokemon.getMov4(), tmp, pokemon.getNom(),
							pokemon.getType1(), pokemon.getType2(), pokemon.getDesc(), pokemon.getHab1(),
							pokemon.getHab2(), pokemon.getHab3(), pokemon.getGif(), pokemon.getWav()));
			return "logro";
		}
	}

	/**
	 * method in charge of releasing a pokemon
	 * 
	 * @param lugar  where is the pokemon
	 * @param nombre pokemon nickname
	 * @return returns the confirmation of the action performed
	 */
	public String liberarPoke(int lugar, String nombre) {
		ArrayList<PokemonDTO> tmp = pokes.get(lugar);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).getMote().equalsIgnoreCase(nombre)) {
				tmp.remove(i);
				return "logro";
			}
		}
		return "error";
	}

	/**
	 * Method in charge of moving a pokemon from one place to another
	 * 
	 * @param lugarIni starting place
	 * @param lugarFin place where you want to move
	 * @param mote     pokemon nickname
	 * @return returns the confirmation
	 */
	public String moverPoke(int lugarIni, int lugarFin, String mote) {
		if (lugarFin == 0 && isFullPocket().equals("logro")) {
			return "lleno";
		} else {
			ArrayList<PokemonDTO> tmp = pokes.get(lugarIni);
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.get(i).getMote().equals(mote)) {
					pokes.get(lugarFin).add(pokes.get(lugarIni).remove(i));
					return "logro";
				}
			}
			return "error";
		}
	}

	/**
	 * method to get the list of pokemons in a place
	 * 
	 * @param lugar pokemon place
	 * @return returns the requested list
	 */
	public ArrayList<PokemonDTO> getPokemonArray(int lugar) {
		return pokes.get(lugar);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [user=" + user + ", pokes=" + pokes + "]";
	}

}
