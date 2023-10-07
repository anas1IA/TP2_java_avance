package Q2;
// Classe Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12347); // Remplacez localhost et 12345 par l'adresse et le port du serveur

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String proverb = reader.readLine();
            
            System.out.println("Proverbe reçu du serveur : " + proverb);
            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
