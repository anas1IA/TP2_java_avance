#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void carre(int* a)
{
  *a = (*a) * (*a) ;
}
int main(){

int nbr1;
printf("\nDonner le nombre : ");scanf("%d",&nbr1);
carre(&nbr1);

printf("\n  - Carre : %d ",nbr1);
	return 0;
}
