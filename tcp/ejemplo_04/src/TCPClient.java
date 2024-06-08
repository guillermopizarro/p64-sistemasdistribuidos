import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Enviar solicitud al servidor
            String request = "Send me the object list";
            out.writeObject(request);

            // Recibir colección de objetos del servidor
            List<CustomObject> objectList = (List<CustomObject>) in.readObject();
            System.out.println("Received object list from server:");

            // Imprimir los objetos recibidos
            for (CustomObject obj : objectList) {
                System.out.println(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}