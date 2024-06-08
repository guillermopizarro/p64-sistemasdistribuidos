import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

            // Recibir solicitud del cliente
            String request = (String) in.readObject();
            System.out.println("Received request: " + request);

            // Crear una colección de objetos para enviar al cliente
            List<CustomObject> objectList = new ArrayList<>();
            objectList.add(new CustomObject(1, "Object 1"));
            objectList.add(new CustomObject(2, "Object 2"));
            objectList.add(new CustomObject(3, "Object 3"));

            // Enviar la colección de objetos al cliente
            out.writeObject(objectList);
            System.out.println("Sent object list to client.");

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