package org.academiadecodigo.hackstreetboys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        int portNumber = getPort();

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {

                String line = in.readLine();
                if(line == null || line.equals("exit")) {
                    System.out.println("Closed client");
                    break;
                }
                System.out.println(line);

            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static int getPort() {
        Scanner port = new Scanner(System.in);
        System.out.println("Port? ");
        return port.nextInt();
    }
}
