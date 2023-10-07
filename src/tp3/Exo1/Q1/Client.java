package Q1;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            
            // Lire le proverbe envoyé par le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String proverbe = in.readLine();
            
            System.out.println("Proverbe reçu du serveur : " + proverbe);
            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
