package org.academiadecodigo.hackstreetboys;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String hostName = getName();
        int portNumber = getPort();
        String message;

        try {

            Socket clientSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            while(true) {
                if (getMessage().equals("exit")) {
                    return;
                }
                message = getMessage();
                out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMessage() {
        Scanner name = new Scanner(System.in);
        System.out.println("Message to Send? ");
        return name.nextLine();
    }

    private static String getName() {
        Scanner name = new Scanner(System.in);
        System.out.println("Server Name? ");
        return name.nextLine();
    }

    private static int getPort() {
        Scanner port = new Scanner(System.in);
        System.out.println("Server Port? ");
        return port.nextInt();
    }
}
