package co.edu.unbosque.controller;

import co.edu.unbosque.model.UsuarioDAO;

public class Controller extends Thread {
	private UsuarioDAO user;
	private HiloServer[] servers;

	public Controller() {
		user = new UsuarioDAO();
		servers = new HiloServer[4];
		servers[0] = new HiloServer(7250, user);
		servers[1] = new HiloServer(7500, user);
		servers[2] = new HiloServer(7750, user);
		servers[3] = new HiloServer(8000, user);
	}

	@Override
	public void run() {
		for (int i = 0; i < servers.length; i++) {
			servers[i].start();
		}
		while (true) {
			for (int i = 0; i < servers.length; i++) {
				if (!servers[i].isAlive()) {
					servers[i].start();
				}
			}
		}
	}
}
