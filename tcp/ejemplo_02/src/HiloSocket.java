import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class HiloSocket extends Thread {
    
    private Socket socket;

    public HiloSocket(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // I/O Buffers
            // In - Request
            InputStreamReader in_reader = new InputStreamReader(this.socket.getInputStream());
            BufferedReader in_socket = new BufferedReader(in_reader);

            // Out - Response
            OutputStreamWriter out_writer = new OutputStreamWriter(this.socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter(out_writer, true);

            String input, output = "";
            while((input = in_socket.readLine()) != null) {
                System.out.println(input);

                if (input.equals("hola")) {
                    output = "Saludos.";
                } else if (input.equals("hora")) {
                    output = (new Date()).toString();
                } else if (input.equals("adios")) {
                    output = "Que te vaya bien.";
                    out_socket.println(output);
                    out_socket.flush();
                    break;
                }

                out_socket.println(output);
                out_socket.flush();
            }
            
            this.socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
