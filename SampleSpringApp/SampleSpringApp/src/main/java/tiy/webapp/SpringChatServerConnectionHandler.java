package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by DTG2 on 09/16/16.
 */
public class SpringChatServerConnectionHandler implements Runnable {

    Socket connection;

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
//        PrintWriter outputToClient = new PrintWriter(connection.getOutputStream(), true);

        try {
            conversationHandler(inputFromClient, connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void conversationHandler(BufferedReader inputFromClient, Socket connection) throws IOException {
        String clientText;

        if ((clientText = inputFromClient.readLine()) != null);{
            System.out.println("Client: " + clientText);
        }

        connection.close();
        System.out.println("Connection closed.");
    }
}

