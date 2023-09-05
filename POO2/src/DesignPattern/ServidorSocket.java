package DesignPattern;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

	public static void main(String [] args) throws IOException {
		
		
		ServerSocket servidor = null;
		
		Socket conexao = null;
		
		 try {
	            servidor = new ServerSocket(7000);
	            while (true) {
	                conexao = servidor.accept();
	                System.out.println("cliente " + conexao.getInetAddress().getHostAddress()+ " entrou");

	                Thread clienteThread = new Thread(new ClienteHandler(conexao));
	                clienteThread.start();
	            }

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } finally {
	                servidor.close();
	        }
			
		}
	
	
}
