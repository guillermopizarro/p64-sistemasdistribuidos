package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Enviar datos al servidor
            String data = "Hello from client 4!";
            out.writeObject(data);
            
            // Recibir confirmación del servidor
            String response = (String) in.readObject();
            System.out.println("Server response: " + response);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
