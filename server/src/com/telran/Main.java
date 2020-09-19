package com.telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Main {
    static final String SERVER_HOST = "localhost";
    static final int SERVER_PORT = 3000;
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket(SERVER_HOST,SERVER_PORT);

        BufferedReader consoledReader =
                new BufferedReader(new InputStreamReader(System.in));
        PrintStream socketOut = new PrintStream(socket.getOutputStream());
        BufferedReader socketInput =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = consoledReader.readLine())!=null && !line.equals("exit")){
            socketOut.println(line);
            System.out.println("from the server: " + socketInput.readLine());
        }
        socket.close();
    }
}
