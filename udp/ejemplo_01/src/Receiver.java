import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Receiver {

    public static final int PORT = 2020;

    public Receiver() {
        try {
            DatagramSocket socket = new DatagramSocket( PORT );
            System.out.println("Receiver se encuentra funcionando.");
            
            // Recibir solicitud
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String mensaje = (new String(buffer)).trim();
            System.out.println( "Recibido: " + mensaje );

            // Enviar respuesta
            Scanner consola = new Scanner(System.in);
            System.out.print("Ingresar mensaje: ");
            mensaje = consola.nextLine();

            InetAddress sender_address = packet.getAddress();
            int sender_port = packet.getPort();
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, sender_address, sender_port);
            socket.send( packet );

            System.out.println("Enviado: " + mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Receiver objeto = new Receiver();
    }
}
