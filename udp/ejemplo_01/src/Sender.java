import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Sender {

    public Sender() {
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("");

            Scanner consola = new Scanner(System.in);
            System.out.print("Ingresar mensaje: ");
            String mensaje = consola.nextLine();
            byte[] buffer = mensaje.getBytes();

            InetAddress receiver_address = InetAddress.getByName("localhost");
            int receiver_port = 2020;
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiver_address, receiver_port);

            socket.send(packet);
            System.out.println("Enviado: " + mensaje);

            buffer = new byte[1500];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            mensaje = (new String(buffer)).trim();
            System.out.println("Recibido: " + mensaje);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Sender objeto = new Sender();
    }
}
