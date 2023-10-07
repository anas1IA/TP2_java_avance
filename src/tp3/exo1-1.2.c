#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
//Question 1:
	void mentionBac( float note )
{
     if(note >= 16) printf("Tres bien");
	  else
		if(note < 16 && note >=14 )printf("Bien");
		 else
		   if( note < 14 && note >=12 ) printf("Assez bien");
			else
			  if(note < 12 && note >= 10 ) printf("Passable");
			   else
				 printf("Echoue");
	
}
//Question 2:
int A,B;
   void lecture()
{
	 printf("Donner un entier A: ");
	 scanf("%d",&A);
	 printf("Donner un entier B: ");
	 scanf("%d",&B);
}
   int somme(int a , int b)
{
	return a+b;
}
int produit(int a, int b)
{
	return a*b;
}
int main()
{
	lecture();
	printf("La somme: %d + %d= %d",A,B,somme(A,B));
	printf("\nle produit :%d * %d= %d",A,B,produit(A,B));
}



