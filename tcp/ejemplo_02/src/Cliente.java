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

            BufferedReader teclado = new BufferedReader( new InputStreamReader( System.in ) );
            String consola = "", input = "";

            while (true) {
                while ((consola = teclado.readLine()) != null) {
                    if (consola != null) {
                        System.out.println("CLiente dice: " + consola);
                        out_socket.println(consola);
                        break;
                    }
                }

                while ((input = in_socket.readLine()) != null) {
                    System.out.println("Servidor dice: " + input);
                    break;
                }

                if (input!= null && input.equals("adios")) {
                    break;
                }
            }

            socket.close();
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
        
        Cliente cliente = new Cliente(ip, puerto);
        cliente.conectar();
    }
}
