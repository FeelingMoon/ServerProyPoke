package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.UsuarioDAO;

public class HiloServer extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	private UsuarioDAO user;

	public HiloServer(int port, UsuarioDAO user) {
		this.user = user;
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;

	}

	@Override
	public void run() {
		String line = "";
		while (!line.equals("Over")) {
			try {
				this.server = new ServerSocket(this.port);
				System.out.println("Server started");
				System.out.println("Waiting for a client ...");
				this.socket = server.accept();
				System.out.println("Client accepted");
				// takes input from the client socket
				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				line = in.readUTF();
				this.socketR = new Socket(this.socket.getInetAddress(), this.port + 1);
				this.out = new DataOutputStream(socketR.getOutputStream());
				this.out.writeUTF(user.doAction(line));
				this.out.close();
				this.socketR.close();
				this.in.close();
				this.server.close();
			} catch (IOException i) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println("Closing connection");

		try {
			socket.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
