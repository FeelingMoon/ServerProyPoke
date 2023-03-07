package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.UsuarioDAO;
import co.edu.unbosque.view.View;

public class HiloServer extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	private UsuarioDAO user;
	private View vi;

	public HiloServer(int port, UsuarioDAO user) {
		this.user = user;
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.vi = new View();
	}

	public int getPort() {
		return port;
	}

	@Override
	public void run() {
		String line = "";
		while (!line.equals("fin")) {
			try {
				this.server = new ServerSocket(this.port);
				vi.mostrarMensaje("Server started");
				vi.mostrarMensaje("Waiting for a client...");
				this.socket = server.accept();
				vi.mostrarMensaje("Client accepted");
				// takes input from the client socket
				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				line = in.readUTF();
				if (line.equals("Over")) {
					server.close();
					continue;
				}
				this.socketR = new Socket(this.socket.getInetAddress(), this.port + 1);
				this.out = new DataOutputStream(socketR.getOutputStream());
				this.out.writeUTF(user.doAction(line));
				this.out.close();
				this.socketR.close();
				this.in.close();
				this.server.close();
			} catch (IOException i) {
				vi.mostrarMensaje(i.toString());
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
