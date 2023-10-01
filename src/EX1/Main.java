package Thread;

public class Main {
    public static void main(String[] args) {
    	

        JobTotoEtTiti r = new JobTotoEtTiti();
       

        Thread threadToto = new Thread(r);
        Thread threadTiti = new Thread(r);

        threadToto.setName("Toto");
        threadTiti.setName("Titi");

        threadToto.start();
        threadTiti.start();
    }
}





