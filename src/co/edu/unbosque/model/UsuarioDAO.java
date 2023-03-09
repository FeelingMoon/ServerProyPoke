package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.persistance.FileHandler;

public class UsuarioDAO {
	private PokemonDAO pokes;
	private MovimientoDAO movs;
	private ArrayList<UsuarioDTO> users;
	private Random rand;

	@SuppressWarnings("unchecked")
	public UsuarioDAO() {
		pokes = new PokemonDAO((ArrayList<PokemonDTO>) FileHandler.loadSerializable("pokemon.pokes"));
		movs = new MovimientoDAO((ArrayList<MovimientosDTO>) FileHandler.loadSerializable("movimientos.movs"));
		users = (ArrayList<UsuarioDTO>) FileHandler.loadSerializable("users.usr");
		rand = new Random();
	}

	public String newUser(String name) {
		users.add(new UsuarioDTO(name));
		FileHandler.writeSerializable(users, "users.usr");
		return "logro";
	}

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

	public String captuPoke(String num, String mote, String user, int lugar) {
		try {
			PokemonDTO tmp = pokes.getPoke(Integer.parseInt(num));
			int[] mov = generateMovs();
			tmp.setMov1(mov[0]);
			tmp.setMov2(mov[1]);
			tmp.setMov3(mov[2]);
			tmp.setMov4(mov[3]);
			tmp.setMote(mote);
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

	public String liberarPoke(String user, int lugar, String mote) {
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

	// separacion linea "&%&"

	public String getAllPokes() {
		ArrayList<PokemonDTO> tmp = pokes.getArrayList();
		String tmpS = "";
		for (int i = 0; i < tmp.size(); i++) {
			tmpS += tmp.get(i).toString2() + "%";
		}
		return tmpS;
	}

	public String getPokes(int lugar, String user) {
		try {
			ArrayList<PokemonDTO> tmp = null;
			String tmpS = "";
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUser().equals(user)) {
					tmp = users.get(i).getPokemonArray(lugar);
					for (int j = 0; j < tmp.size(); j++) {
						PokemonDTO tmpP = tmp.get(i);
						String stats = tmpP.toString().split("&")[0];
						System.out.println(stats);
						String mov1 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[1])).toString();
						System.out.println(mov1);
						String mov2 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[2])).toString();
						System.out.println(mov2);
						String mov3 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[3])).toString();
						String mov4 = movs.getMov(Integer.parseInt(tmpP.toString().split("&")[4])).toString();
						String info = tmpP.toString().split("&")[5];
						tmpS += stats + "&" + mov1 + "&" + mov2 + "&" + mov3 + "&" + mov4 + "&" + info + "%";
					}
					return tmpS;
				}
			}
			return "error";
		} catch (Exception e) {
			return "error";
		}
	}

	public String inicioUser(String user) {
		for (UsuarioDTO us : users) {
			if (us.getUser().equals(user)) {
				return "logro";
			}
		}
		return "error";
	}

	// separacion "@"
	public synchronized String doAction(String mensaje) {
		try {
			int tmp = 0;
			String accion = mensaje.split("@")[0].split("-")[1], user = mensaje.split("@")[0].split("-")[0];
			String info = mensaje.split("@")[1];
			if (accion.equals("iniciar")) {
				return inicioUser(user);
			} else if (accion.equals("getAll")) {
				return getAllPokes();
			} else if (accion.equals("capturar")) {
				if (info.split("-")[2].equals("0")) {
					tmp = 0;
				} else {
					tmp = Integer.parseInt(info.split("-")[2]);
				}
				return captuPoke(info.split("-")[0], info.split("-")[1], user, tmp);
			} else if (accion.equals("liberar")) {
				if (info.split("-")[0].equals("0")) {
					tmp = 0;
				} else {
					tmp = Integer.parseInt(info.split("-")[0]);
				}
				return liberarPoke(user, tmp, info.split("-")[1]);
			} else if (accion.equals("get")) {
				if (info.equals("0")) {
					tmp = 0;
				} else {
					tmp = Integer.parseInt(info);
				}
				return getPokes(tmp, user);
			} else if (accion.equals("nuevo")) {
				return newUser(info);
			} else {
				return "error";
			}
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
