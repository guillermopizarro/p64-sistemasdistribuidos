package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private SharedObject sharedObject = new SharedObject();

    public ClientHandler(Socket socket, SharedObject sharedObject) {
        this.clientSocket = socket;
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

            // Recibir datos del cliente
            String data = (String) in.readObject();
            System.out.println("Received: " + data);

            // Actualizar el objeto compartido
            synchronized (this.sharedObject) {
                this.sharedObject.update(data);
            }
            
            // Enviar confirmación al cliente
            out.writeObject("Data received and processed");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
