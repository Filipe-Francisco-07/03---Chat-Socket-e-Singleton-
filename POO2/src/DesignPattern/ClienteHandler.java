package DesignPattern;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHandler implements Runnable {
    private Socket cliente;

    public ClienteHandler(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            Scanner entrada = new Scanner(cliente.getInputStream());

            String texto = "";
            do {
                texto = entrada.nextLine();
                System.out.println(texto);
              
            } while (!"sair".equals(texto));

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}