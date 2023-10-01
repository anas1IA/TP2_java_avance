package Thread;

class JobTotoEtTiti implements Runnable {
	    
	    comptebank  compteCommun = new comptebank ();
	  
	   
	    @Override
	    public void run() {
	    	for(int i=0;i<=6;i++) {
	    	System.out.println("i= " +i);
	    	doRetrait(200);
	    	if( compteCommun.getSolde()<=0) {
	    		System.out.println("le system a decouverte!"+"->" + Thread.currentThread().getName());
	    	}
	         
	           }
	        
	    }
	    public synchronized void doRetrait(double som) {
	    	if(this.compteCommun.getSolde()<som) {
	    		System.out.println("pas assez d'argent pour: " + Thread.currentThread().getName());
	    	}
	    	else {
	    		System.out.println(Thread.currentThread().getName() + "est de point de retiret");
	    		try {
	    			System.out.println(Thread.currentThread().getName() + " en dort");
	    			Thread.sleep(1000);}
	    		catch(InterruptedException e) {
	    			System.out.println(e);
	    		}
	    		System.out.println(Thread.currentThread().getName() + "est de point de réveil");
	    		compteCommun.retirer(som);
	    		System.out.println(Thread.currentThread().getName() + "le retiret est complete");
	    		
	    	
	    	
	    }}}
	

