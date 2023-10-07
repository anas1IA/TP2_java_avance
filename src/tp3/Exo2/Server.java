package Exo2;

import java.net.*;
import java.io.*;
import java.util.*;


class ClientsHandle implements Runnable{

    Socket clientSocket;
    String html= "";

    public ClientsHandle(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void run(){

        try{

            Scanner fr = new Scanner(new FileReader("Exo2/index.html"));

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    
            while(fr.hasNextLine()){
                html += fr.nextLine();
            }
            
            out.write("HTTP/1.0 200 OK\n\n" + html);
            out.newLine();
            out.flush();
        }catch(IOException e){
            
        }
    }

}

public class Server{

    static ServerSocket serverSocket;
    static Boolean Running = true;
    public static void main(String[] args) throws IOException{

        serverSocket = new ServerSocket(8000);

        /*
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        */
        /*============ Q1 ===================
        out.write("HTTP/1.0 200 OK\n\n" + "<html><title>Mon serveur</title><body>Cette page a été envoyée par mon <b>Serveur
        </b></body></html>");
        out.newLine();
        out.flush();
        System.out.println("server is cloed");
        */

        
        /*======= Q2 ==============
        Scanner fr = new Scanner(new FileReader("Exo2/index.html"));
        String html= "";

        while(fr.hasNextLine()){
            html += fr.nextLine();
        }
        
        out.write("HTTP/1.0 200 OK\n\n" + html);
        out.newLine();
        out.flush();
        */
       
       while(true){
            System.out.println("Server is waiting ...");

            Socket clientSocket = serverSocket.accept();
            
            Runnable client = new ClientsHandle(clientSocket);
            new Thread(client).start();
       }
    }
}
