package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    private static final int PORT = 12345;
    private static SharedObject sharedObject = new SharedObject();
    
    public static void main(String[] args) {
        //ExecutorService executor = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread hilo = new Thread(new ClientHandler(clientSocket, sharedObject));
                hilo.start();
                System.out.println(sharedObject.getData());
                //executor.execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //executor.shutdown();
        }
    }
}