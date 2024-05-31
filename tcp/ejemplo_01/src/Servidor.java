import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    public Servidor() {

    }

    public void conectar() {
        try {
            ServerSocket serverSocket = new ServerSocket( 2020 );
            System.out.println( "Puerto 2020 se encuentra abierto." );

            Socket socket = serverSocket.accept();
            System.out.println( "Cliente " + socket.getInetAddress() + "se ha conectado." );

            // I/O Buffers
            // In - Request
            InputStreamReader in_reader = new InputStreamReader(socket.getInputStream());
            BufferedReader in_socket = new BufferedReader(in_reader);

            // Out - Response
            OutputStreamWriter out_writer = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter(out_writer, true);

            out_socket.println("¡Bienvenido!");

            String mensaje = in_socket.readLine();
            System.out.println( "Cliente dice " + mensaje );

            socket.close();
            System.out.println("Servidor se encuentra cerrado.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }
}
