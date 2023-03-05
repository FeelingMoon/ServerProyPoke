package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * @author MiguelLinares
 * @author JohanSilva
 * @author MiguelRamirez
 * @author HaroldDuarte
 */

public class MovimientoDAO {
	/**
	 * ArrayList that creates a new object called "movement"
	 */
	private ArrayList<MovimientosDTO> movimientos;

	/**
	 * Empty constructor method
	 */
	public MovimientoDAO() {
	}

	/**
	 * Constructor method
	 * 
	 * @param movimientos Array of the moveset
	 */
	public MovimientoDAO(ArrayList<MovimientosDTO> movimientos) {
		this.movimientos = movimientos;
	}

	/**
	 * Method that gets the movements totality
	 * 
	 * @param numero Number of the move
	 * @return Number Number of the totality moves
	 */
	public MovimientosDTO getMov(int numero) {
		for (MovimientosDTO a : movimientos) {
			if (a.getNum() == numero) {
				return a;
			}
		}
		return new MovimientosDTO(0, 0, 0, "", "", "", "");
	}

	/**
	 * Method that gets the movement names on an array
	 * 
	 * @return Array with all moveset
	 */
	public String[] getArrayMov() {
		String[] tmp = new String[movimientos.size()];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = movimientos.get(i).getName();
		}
		return tmp;
	}
}
