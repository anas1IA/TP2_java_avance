package Thread;

public class comptebank {


	public comptebank() {
		// TODO Auto-generated constructor stub
	}
	private double sold=1000 ;
	 public void retirer(double montant) {
	this.sold-=montant ;
	System.out.println("---------------Sold=" + this.sold);
		 	
	}
	 public double getSolde() {
	        return sold;
	    }}