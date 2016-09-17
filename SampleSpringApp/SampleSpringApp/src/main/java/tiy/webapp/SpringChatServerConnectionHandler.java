package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by DTG2 on 09/16/16.
 */
public class SpringChatServerConnectionHandler implements Runnable {

    Socket connection;
    String response = null;

    public void run(){
        try{
            handleIncomingConnection(connection);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public SpringChatServerConnectionHandler(Socket connection) {
        this.connection = connection;
    }

    private void handleIncomingConnection (Socket connection) throws IOException {

        System.out.println("Incoming connection to server from clientSocket: " + connection.getInetAddress().getHostAddress());

        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        PrintWriter outputToClient = new PrintWriter(connection.getOutputStream(), true);

        try {
            conversationHandler(outputToClient, inputFromClient, response);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void conversationHandler(PrintWriter outputToClient, BufferedReader inputFromClient, String response) throws IOException {
        String clientText;

        if ((clientText = inputFromClient.readLine()) != null){
            System.out.println("Client: " + clientText);
        }
        outputToClient.println(response);
        System.out.println(response);

    }
}

