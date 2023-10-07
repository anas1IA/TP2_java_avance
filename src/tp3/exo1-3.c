#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int max(int a, int b)
{
	if(a<b)  return b;
	 else if(b<a) return a;
	         else return a;
}
int min(int a, int b)
{
	if(a<b)  return a;
	 else if(b<a) return b;
	         else return a;
}
int main()
{
	int nb1 , nb2;
	printf("donner le 1ere nombre : ");
	scanf("%d",&nb1);
	printf("donner le 2ere nombre : ");
	scanf("%d",&nb2);
	printf("-le max est: %d",max(nb1,nb2));
	printf("\n-le min est: %d",min(nb1,nb2));
	return 0;
}

