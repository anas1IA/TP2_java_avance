package Exo2;

import java.net.*;
import java.io.*;
import java.util.*;


public class ServerQ3{

    static ServerSocket serverSocket;
    static Boolean Running = true;
    public static void main(String[] args) throws IOException{

        serverSocket = new ServerSocket(8000);

        System.out.println("server is waiting ....");

        Socket clientSocket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        Scanner fr = new Scanner(new FileReader("Exo2/index.html"));
        String html= "";

        while(fr.hasNextLine()){
            html += fr.nextLine();
        }
        
        out.write("HTTP/1.0 200 OK\n\n" + html);
        out.newLine();
        out.flush();

        System.out.println("server is cloed");

        serverSocket.close();
    }
}