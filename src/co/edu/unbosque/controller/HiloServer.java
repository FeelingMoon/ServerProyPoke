package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.UsuarioDAO;
import co.edu.unbosque.view.View;

/**
 * Class where the server actions are done
 * 
 * @author JohanSilva
 * @author MiguelLinares
 *
 */

public class HiloServer extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	private UsuarioDAO user;
	private View vi;
	private String res;

	/**
	 * Constructor method
	 * 
	 * @param port Port to open
	 * @param user List of users to manage
	 */
	public HiloServer(int port, UsuarioDAO user) {
		this.user = user;
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.vi = new View();
		this.res = "";
	}

	@Override
	public void run() {
		String line = "";
		while (!line.equals("fin")) {
			try {
				if (res.equals("")) {
					this.server = new ServerSocket(this.port);
					vi.mostrarMensaje("Server started");
					vi.mostrarMensaje("Waiting for a client...");
					this.socket = server.accept();
					vi.mostrarMensaje("Client accepted");
					// takes input from the client socket
					this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
					line = in.readUTF();
					try {
						int tmp = 0;
						String accion = line.split("@")[0].split("-")[1], userN = line.split("@")[0].split("-")[0];
						String info = line.split("@")[1];
						if (accion.equals("iniciar")) {
							res = user.inicioUser(userN);
						} else if (accion.equals("getAll")) {
							res = user.getAllPokes();
						} else if (accion.equals("capturar")) {
							if (info.split("-")[2].equals("0")) {
								tmp = 0;
							} else {
								tmp = Integer.parseInt(info.split("-")[2]);
							}
							res = user.captuPoke(info.split("-")[0], info.split("-")[1], userN, tmp);
						} else if (accion.equals("liberar")) {
							if (info.split("-")[0].equals("0")) {
								tmp = 0;
							} else {
								tmp = Integer.parseInt(info.split("-")[0]);
							}
							res = user.liberarPoke(userN, tmp, info.split("-")[1]);
						} else if (accion.equals("get")) {
							if (info.equals("0")) {
								tmp = 0;
							} else {
								tmp = Integer.parseInt(info);
							}
							res = user.getPokes(tmp, userN);
						} else if (accion.equals("nuevo")) {
							res = user.newUser(info);
						} else if (accion.equals("getCB")) {
							if (info.equals("0")) {
								tmp = 0;
							} else {
								tmp = Integer.parseInt(info);
							}
							res = user.getPokesConBolsillo(tmp, userN);
						} else if (accion.equals("getMote")) {
							if (info.split("-")[0].equals("0")) {
								tmp = 0;
							} else {
								tmp = Integer.parseInt(info.split("-")[0]);
							}
							res = user.getPokeMote(tmp, userN, info.split("-")[1]);
						} else if (accion.equals("mover")) {
							int tmpF = 0;
							if (info.split("-")[0].equals("0")) {
								tmp = 0;
							} else {
								tmp = Integer.parseInt(info.split("-")[0]);
							}
							if (info.split("-")[1].equals("0")) {
								tmpF = 0;
							} else {
								tmpF = Integer.parseInt(info.split("-")[1]);
							}
							res = user.movePoke(userN, tmp, tmpF, info.split("-")[2]);
						} else {
							res = "error";
						}
					} catch (Exception e) {
						res = "error";
					}
				}
				this.socketR = new Socket(this.socket.getInetAddress(), this.port + 1);
				this.out = new DataOutputStream(socketR.getOutputStream());
				this.out.writeUTF(res);
				res = "";
				this.out.close();
				this.socketR.close();
				this.in.close();
				this.server.close();
			} catch (IOException i) {
				vi.mostrarMensaje(i.getMessage());
				if (i.getMessage().equals("Connection reset")) {
					continue;
				} else if (i.getMessage().equals("Address already in use: bind")) {
					try {
						server.close();
					} catch (IOException e) {
						System.out.println("imposible cerrar el server");
					}
					continue;
				} else {
					this.socketR = null;
				}
			}
		}
		vi.mostrarMensaje("Closing connection");
		try {
			socket.close();
			in.close();
		} catch (IOException e) {
			vi.mostrarMensaje(e.toString());
		}
	}
}
