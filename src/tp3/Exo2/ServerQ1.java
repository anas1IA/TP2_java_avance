package Exo2;

import java.net.*;
import java.io.*;
import java.util.*;


public class ServerQ1{

    static ServerSocket serverSocket;
    static Boolean Running = true;
    public static void main(String[] args) throws IOException{

        serverSocket = new ServerSocket(8000);

        System.out.println("server is waiting ....");

        Socket clientSocket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        out.write("HTTP/1.0 200 OK\n\n" + "<html><title>Mon serveur</title><body>Cette page a été envoyée par mon <b>Serveur</b></body></html>");
        out.newLine();
        out.flush();
        System.out.println("server is cloed");

        serverSocket.close();
    }
}