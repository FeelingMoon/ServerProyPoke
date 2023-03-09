package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class UsuarioDTO implements Serializable {
	String user;
	ArrayList<ArrayList<PokemonDTO>> pokes;

	/*
	 * 0 = bolsillo - 1 = caja 1 - 2 = caja 2 - 3 = caja 3
	 */
	public UsuarioDTO(String user) {
		this.user = user;
		pokes = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			pokes.add(new ArrayList<>());
		}
		System.out.println(pokes.size());
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPokemon(int lugar, String nombre) {
		ArrayList<PokemonDTO> tmp = pokes.get(lugar);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).getMote().equalsIgnoreCase(nombre)) {
				return tmp.get(i).toString();
			}
		}
		return "error";
	}

	public String isFullPocket() {
		if (pokes.get(0).size() == 6) {
			return "logro";
		} else {
			return "error";
		}
	}

	public String compMote(String mote) {
		int cont = 0;
		for (int i = 0; i < pokes.size(); i++) {
			ArrayList<PokemonDTO> tmp = pokes.get(i);
			if (tmp.size() == 0) {
				return mote;
			} else {
				for (int j = 0; j < tmp.size(); j++) {
					if (tmp.get(i).getMote().equalsIgnoreCase(mote)) {
						cont++;
					}
				}
			}
		}
		if (cont > 0) {
			return mote + " " + cont;
		} else {
			return mote;
		}
	}

	public String capturarPoke(int lugar, PokemonDTO pokemon, String mote) {
		if (lugar == 0 && isFullPocket().equals("logro")) {
			return "error";
		} else {
			PokemonDTO pok = pokemon;
			if (mote.equals("Nothing")) {
				pok.setMote(compMote(pokemon.getNom()));
			} else {
				pok.setMote(compMote(mote));
			}
			pokes.get(lugar).add(pok);
			return "logro";
		}
	}

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

	public ArrayList<PokemonDTO> getPokemonArray(int lugar) {
		return pokes.get(lugar);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [user=" + user + ", pokes=" + pokes + "]";
	}

}
