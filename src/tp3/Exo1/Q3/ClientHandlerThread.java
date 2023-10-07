package Q3;

// Classe ClientHandlerThread.java
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Random;

public class ClientHandlerThread extends Thread {
    private Socket clientSocket;
    private List<String> proverbes;
    
    public ClientHandlerThread(Socket clientSocket, List<String> proverbes) {
        this.clientSocket = clientSocket;
        this.proverbes = proverbes;
    }
    
    @Override
    public void run() {
        try {
            // Sélection aléatoire d'un proverbe
            Random random = new Random();
            int indexProverbe = random.nextInt(proverbes.size());
            String selectedProverb = proverbes.get(indexProverbe);

            // Envoi du proverbe au client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(selectedProverb);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
