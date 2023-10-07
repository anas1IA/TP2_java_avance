package Q2;
// Classe Serveur.java
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Serveur {
    public static void main(String[] args) {
        List<String> proverbes = lireProverbesDepuisFichier("Q2/proverbes.txt"); // Remplacez proverbes.txt par le nom de votre fichier de proverbes
        Random random = new Random();
        
        try {
            if (proverbes.isEmpty()) {
                System.out.println("Aucun proverbe n'a été trouvé dans le fichier.");
                return;
            }

            ServerSocket serverSocket = new ServerSocket(12347); // Port sur lequel le serveur écoute
            
            while (true) {
                System.out.println("En attente de connexion client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté.");

                // Sélection aléatoire d'un proverbe
                int indexProverbe = random.nextInt(proverbes.size());
                String selectedProverb = proverbes.get(indexProverbe);

                // Envoi du proverbe au client
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println(selectedProverb);

                clientSocket.close();
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
