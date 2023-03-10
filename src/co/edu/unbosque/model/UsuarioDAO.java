package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.persistance.FileHandler;

/**
 * 
 * @author JohanSilva
 * @author MiguelLinares
 *
 */
public class UsuarioDAO {
	private PokemonDAO pokes;
	private MovimientoDAO movs;
	private ArrayList<UsuarioDTO> users;
	private Random rand;

	/**
	 * Constructor method
	 */
	@SuppressWarnings("unchecked")
	public UsuarioDAO() {
		pokes = new PokemonDAO((ArrayList<PokemonDTO>) FileHandler.loadSerializable("pokemon.pokes"));
		movs = new MovimientoDAO((ArrayList<MovimientosDTO>) FileHandler.loadSerializable("movimientos.movs"));
		users = (ArrayList<UsuarioDTO>) FileHandler.loadSerializable("users.usr");
		rand = new Random();
	}

	/**
	 * Method in charge of checking if a user exists
	 * 
	 * @param name Username to check
	 * @return If it exists it returns the check
	 */
	public String compUser(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUser().equals(name)) {
				return "exist";
			}
		}
		return "logro";
	}

	/**
	 * Method in charge of adding a new user
	 * 
	 * @param name Name of the new user to add
	 * @return Returns if it was able to add the new user
	 */
	public synchronized String newUser(String name) {
		String tmp = compUser(name);
		if (tmp.equals("logro")) {
			users.add(new UsuarioDTO(name));
			FileHandler.writeSerializable(users, "users.usr");
			return "logro";
		} else {
			return tmp;
		}
	}

	/**
	 * Method in charge of randomly generating 4 numbers that will be the movements
	 * 
	 * @return Returns a list with the four numbers of the movements
	 */
	public int[] generateMovs() {
		int[] tmp = new int[4];
		boolean conf = true;
		int tmpN;
		for (int i = 0; i < 4; i++) {
			while (true) {
				tmpN = rand.nextInt(1, 850);
				for (int j = 0; j < tmp.length; j++) {
					if (tmp[j] != 0) {
						if (tmpN == tmp[j]) {
							conf = false;
							break;
						}
					}
				}
				if (conf) {
					tmp[i] = tmpN;
					break;
				}
			}
		}
		return tmp;
	}

	/**
	 * Method in charge of capturing a pokemon
	 * 
	 * @param num   Number of the pokedex that corresponds to the pokemon
	 * @param mote  Nickname that you want to assign to the pokemon
	 * @param user  User who wants to capture the pokemon
	 * @param lugar Where you want to save it
	 * @return Returns whether or not he was able to save the pokemon
	 */
	public synchronized String captuPoke(String num, String mote, String user, int lugar) {
		try {
			PokemonDTO tmp = pokes.getPoke(Integer.parseInt(num));
			int[] mov = generateMovs();
			tmp.setMov1(mov[0]);
			tmp.setMov2(mov[1]);
			tmp.setMov3(mov[2]);
			tmp.setMov4(mov[3]);
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals(user)) {
					String tmpS = users.get(i).capturarPoke(lugar, tmp, mote);
					FileHandler.writeSerializable(users, "users.usr");
					return tmpS;
				}
			}
			return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Method in charge of releasing a pokemon
	 * 
	 * @param user  User who wants to release the pokemon
	 * @param lugar Where the pokemon is
	 * @param mote  Pokemon nickname
	 * @return Returns whether or not it was able to release the pokemon
	 */
	public synchronized String liberarPoke(String user, int lugar, String mote) {
		try {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals(user)) {
					String tmp = users.get(i).liberarPoke(lugar, mote);
					FileHandler.writeSerializable(users, "users.usr");
					return tmp;
				}
			}
			return "error";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * Method in charge of obtaining all the pokemons of the pokedex
	 * 
	 * @return Text that contains all the information in a specified format
	 */
	public synchronized String getAllPokes() {
		ArrayList<PokemonDTO> tmp = pokes.getArrayList();
		String tmpS = "";
		for (int i = 0; i < tmp.size(); i++) {
			tmpS += tmp.get(i).toString2() + "%";
		}
		return tmpS;
	}

	/**
	 * Method in charge of obtaining the pokemons that a user has per place
	 * 
	 * @param lugar Place which you want to get
	 * @param user  User who wants to do the action
	 * @return Returns the list of pokemons with a specific format
	 */
	public synchronized String getPokes(int lugar, String user) {
		try {
			ArrayList<PokemonDTO> tmp = null;
			String tmpS;
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals(user)) {
					tmpS = "";
					tmp = users.get(i).getPokemonArray(lugar);
					for (int j = 0; j < tmp.size(); j++) {
						PokemonDTO tmpP = tmp.get(j);
						String stats = tmpP.toString().split("&")[0];
						String mov1 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[1])).toString();
						String mov2 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[2])).toString();
						String mov3 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[3])).toString();
						String mov4 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[4])).toString();
						String info = tmpP.toString().split("&")[5];
						tmpS += stats + "&" + mov1 + "&" + mov2 + "&" + mov3 + "&" + mov4 + "&" + info + "%!%";
					}
					return tmpS;
				}
			}
			return "error";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * Gets a pokemon by the nickname
	 * 
	 * @param lugar Where is the pokemon located?
	 * @param user  User who wants to do the action
	 * @param mote  pokemon nickname
	 * @return Returns the information of the pokemon
	 */
	public synchronized String getPokeMote(int lugar, String user, String mote) {
		try {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals(user)) {
					ArrayList<PokemonDTO> tmp = users.get(i).getPokemonArray(lugar);
					for (int j = 0; j < tmp.size(); j++) {
						if (tmp.get(j).getMote().equals(mote)) {
							PokemonDTO tmpP = tmp.get(j);
							String stats = tmpP.toString().split("&")[0];
							String mov1 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[1])).toString();
							String mov2 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[2])).toString();
							String mov3 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[3])).toString();
							String mov4 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[4])).toString();
							String info = tmpP.toString().split("&")[5];
							return stats + "&" + mov1 + "&" + mov2 + "&" + mov3 + "&" + mov4 + "&" + info + "%!%";
						}
					}
					return "NoExist";
				}
			}
			return "error";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * Method in charge of obtaining a box of pokemons next to the pocket
	 * 
	 * @param lugar The box you want to get
	 * @param user  User requesting the action
	 * @return User requesting the action
	 */

	public synchronized String getPokesConBolsillo(int lugar, String user) {
		try {
			ArrayList<PokemonDTO> tmp = null;
			String tmpS;
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals(user)) {
					tmpS = "";
					tmp = users.get(i).getPokemonArray(0);
					for (int j = 0; j < tmp.size(); j++) {
						PokemonDTO tmpP = tmp.get(j);
						String stats = tmpP.toString().split("&")[0];
						String mov1 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[1])).toString();
						String mov2 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[2])).toString();
						String mov3 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[3])).toString();
						String mov4 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[4])).toString();
						String info = tmpP.toString().split("&")[5];
						System.out.println(info);
						tmpS += stats + "&" + mov1 + "&" + mov2 + "&" + mov3 + "&" + mov4 + "&" + info + "%!%";
					}
					tmpS += "@";
					tmp = users.get(i).getPokemonArray(lugar);
					for (int j = 0; j < tmp.size(); j++) {
						PokemonDTO tmpP = tmp.get(j);
						String stats = tmpP.toString().split("&")[0];
						String mov1 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[1])).toString();
						String mov2 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[2])).toString();
						String mov3 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[3])).toString();
						String mov4 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[4])).toString();
						String info = tmpP.toString().split("&")[5];
						System.out.println(info);
						tmpS += stats + "&" + mov1 + "&" + mov2 + "&" + mov3 + "&" + mov4 + "&" + info + "%!%";
					}
					return tmpS;
				}
			}
			return "error";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * Method in charge of verifying if the user exists
	 * 
	 * @param user User requesting the action
	 * @return Returns whether or not it exists
	 */
	public synchronized String inicioUser(String user) {
		for (UsuarioDTO us : users) {
			if (us.getUser().equals(user)) {
				return "logro";
			}
		}
		return "error";
	}

	/**
	 * Method in charge of moving a pokemon between boxes and pocket
	 * 
	 * @param user     User requesting the action
	 * @param lugarIni Place where the pokemon is initially
	 * @param lugarFin Where the pokemon will move to
	 * @param mote     pokemon nickname
	 * @return
	 */
	public synchronized String movePoke(String user, int lugarIni, int lugarFin, String mote) {
		try {
			if (lugarFin == lugarIni) {
				return "error";
			} else {
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUser().equals(user)) {
						return users.get(i).moverPoke(lugarIni, lugarFin, mote);
					}
				}
			}
			return "error";
		} catch (Exception e) {
			return "error";
		}
	}

//	public static void main(String[] args) {
//		@SuppressWarnings("unchecked")
//		ArrayList<UsuarioDTO> user = (ArrayList<UsuarioDTO>) FileHandler.loadSerializable("users.usr");
//		for (int i = 0; i < user.size(); i++) {
//			if (user.get(i).getUser().equals("true")) {
//				System.out.println("eliminado");
//				user.remove(i);
//				break;
//			}
//		}
//		FileHandler.writeSerializable(user, "users.usr");
//	}
}
