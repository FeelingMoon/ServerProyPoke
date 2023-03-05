package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.persistance.FileHandler;

public class UsuarioDAO {
	PokemonDAO pokes;
	MovimientoDAO movs;
	ArrayList<UsuarioDTO> users;

	@SuppressWarnings("unchecked")
	public UsuarioDAO() {
		pokes = new PokemonDAO((ArrayList<PokemonDTO>) FileHandler.loadSerializable("pokemon.pokes"));
		movs = new MovimientoDAO((ArrayList<MovimientosDTO>) FileHandler.loadSerializable("movimientos.movs"));
		users = (ArrayList<UsuarioDTO>) FileHandler.loadSerializable("users.usr");
	}
}
