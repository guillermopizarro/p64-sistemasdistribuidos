import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private int PUERTO = 2020;

    public Servidor() {

    }

    public void conectar() {
        try {
            ServerSocket server = new ServerSocket(PUERTO);
            System.out.println("Esperando a que se conecten los clientes.");

            Socket socket;

            while (true) {
                socket = server.accept();
                System.out.println("Cliente conectado.");
                HiloSocket hilo = new HiloSocket(socket);
                hilo.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.conectar();
    }
}
