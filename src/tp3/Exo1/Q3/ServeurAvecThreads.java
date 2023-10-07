package Q3;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServeurAvecThreads {
    public static void main(String[] args) {
        List<String> proverbes = lireProverbesDepuisFichier("Q3/proverbes.txt"); // Remplacez proverbes.txt par le nom de votre fichier de proverbes
        
        if (proverbes.isEmpty()) {
            System.out.println("Aucun proverbe n'a été trouvé dans le fichier.");
            return;
        }

        try {
            ServerSocket serverSocket = new ServerSocket(12348); // Port sur lequel le serveur écoute
            
            while (true) {
                System.out.println("En attente de connexion client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté.");

                // Créer un nouveau thread pour gérer la connexion du client
                Thread clientThread = new ClientHandlerThread(clientSocket, proverbes);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> lireProverbesDepuisFichier(String nomFichier) {
        List<String> proverbes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                proverbes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proverbes;
    }
}