package edu.cibertec.sockets.mensaje.cliente;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteMensaje {

	public static void enviarMensaje(String host, int puerto, String mensaje) throws IOException {
		OutputStream stream = null;
		PrintWriter escritor = null;
		
		try (Socket cliente = new Socket(host,puerto)) {
			stream = cliente.getOutputStream();
			escritor = new PrintWriter(stream,true);
			escritor.println(mensaje);
			System.out.println("Mensaje enviado al servidor");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (escritor != null) {				
					escritor.close();				
		}
	}
	}
	public static void main(String[] args) throws IOException {
		ClienteMensaje.enviarMensaje("localhost", 2292, "Hola servidor :D");

	}

}
