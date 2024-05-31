import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    private String ip;
    private int puerto;

    public Cliente(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public void conectar() {
        try {
            Socket socket = new Socket(this.ip, this.puerto);
            System.out.println( "Conexion exitosa con el servidor." );

            // I/O Buffers
            // In - Request
            InputStreamReader in_reader = new InputStreamReader(socket.getInputStream());
            BufferedReader in_socket = new BufferedReader(in_reader);

            // Out - Response
            OutputStreamWriter out_writer = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter(out_writer, true);

            String mensaje = in_socket.readLine();
            System.out.println("El servidor dice: " + mensaje);

            out_socket.println("Gracias.");

            socket.close();
            System.out.println("Socket cerrado.");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingresar ip: ");
        String ip = consola.nextLine();
        System.out.println("Ingresar puerto: ");
        int puerto = Integer.parseInt( consola.nextLine() );

        Cliente objeto = new Cliente(ip, puerto);
        objeto.conectar();
    }
}
