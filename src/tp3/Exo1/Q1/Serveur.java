package Q1;
import java.io.*;
import java.net.*;
import java.util.Random;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur prêt à accepter les connexions...");
            int i = 0;
            while (true) {
                Socket clientSocket = serverSocket.accept();
                
                System.out.println("Client connecté depuis " + i);

                i+=1;
                
                // Générer un proverbe aléatoire et l'envoyer au client
                String[] proverbes = {
                    "Quand la pauvreté entre par la porte, l'amour s'en va par la fenêtre",
                    "On ne peut empêcher le chien d'aboyer, ni le menteur de mentir",
                    "Aime-toi et tu auras des amis",
                    "Un bon père de famille doit être partout, dernier couché premier debout",
                    "La douceur du miel ne console pas de la piqûre de l'abeille",
                    "Avec du temps et de la patience, on vient à bout de tout",
                    "Vieille amitié ne craint pas la rouille",
                    "Il n'y a pas de grenouille qui ne trouve son crapaud",
                    "Plus on désire une chose, plus elle se fait attendre",
                    "Celui qui sème l'injustice moissonne le malheur"
                };
                Random random = new Random();
                int index = random.nextInt(proverbes.length);
                String proverbe = proverbes[index];
                
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(proverbe);
                
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
