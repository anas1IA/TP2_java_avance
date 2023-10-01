package my_tp2;

import my_tp2.Banque;
import my_tp2.Transfert;

public class MainClass {

	public static void main(String[] args) 
	{
		Banque banque = new Banque(100,1000) ;
		
		for ( int de = 0 ; de < 100 ; de++)
		{
			Runnable r = new Transfert(banque,de);
			//new Thread(r).start();
			Thread th = new Thread(r) ; 
			th.start();
		}
	}

}