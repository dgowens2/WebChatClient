package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by DTG2 on 09/12/16.
 */
public class WebChatClient {

    private String serverResponse;

    public static void main(String[] args) {
        WebChatClient myClient = new WebChatClient();
        myClient.sendMessage("message");
    }

    public String sendMessage(String message) {
        Scanner clientText = new Scanner(System.in);
        try {
            Socket clientSocket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                out.println(message);

                serverResponse = in.readLine();

                System.out.println(serverResponse);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
            return serverResponse;
    }
}
