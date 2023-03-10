package co.edu.unbosque.persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author JohanSilva
 * @author MiguelLinares
 *
 */
public class FileHandler {
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	/**
	 * Method in charge of serializing an object
	 * 
	 * @param o   object to serialize
	 * @param url where the file is located where it will be written
	 */

	public static void writeSerializable(Object o, String url) {
		try {
			fos = new FileOutputStream("src/co/edu/unbosque/persistance/" + url);
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			System.out.println("File not found (serializable)");
			System.out.println(e.getMessage());
		}
		try {
			oos.writeObject(o);
			fos.close();
			oos.close();
		} catch (IOException e) {
			System.out.println("Error on writing (serializable)");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Method responsible for loading serialized objects
	 * 
	 * @param url Where the file to read is located
	 * @return Returns the object read
	 */

	public static Object loadSerializable(String url) {
		Object tmp = null;
		try {
			fis = new FileInputStream("src/co/edu/unbosque/persistance/" + url);
			ois = new ObjectInputStream(fis);
			tmp = ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}

//	public static void main(String[] args) {
//		ArrayList<UsuarioDTO> user = new ArrayList<>();
//		user.add(new UsuarioDTO("FeelingMoon"));
//		user.add(new UsuarioDTO("MikaNiatsu"));
//		writeSerializable(user, "users.usr");
//	}
}
