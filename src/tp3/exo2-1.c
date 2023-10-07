#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

//Lecture du tableau:

void lire(int *tab, int N)
{
	 int i;
	 printf("Remlissage de tableau :\n");
	 for(i=0;i<N;i++)
	 {
		printf(" - Tab[%d] : ",i);
		scanf("%d",tab+i);
	 }
}

//Affichage

void afficher(int *tab, int N)
{
	 int i;
	 printf("Affichage de tableau :\n");
	 for(i=0;i<N;i++)
		printf(" - Tab[%d] : %d ",i+1,tab[i]);
}

//Inverser le tableau:


void inverser(int *tab, int N)
{
	 int i,temp;
	 for(i=0;i<N/2;i++)
	 {
		temp = tab[i];
		tab[i] = tab[N-1-i];
		tab[N-1-i] = tab[i];
	 }
}

//Trie :

void trier(int *tab, int N)
{
	 int i,j,temp;
	 
	 for(i=1;i<N;i++)
	 {
		temp = tab[i];
		j = i-1;
		while( j>=0 && tab[j] > temp )
		{
		   tab[j+1] = tab[j];
		   j--;
        }
        tab[j+1] = temp;
	 }
}

//Premier:

int premier(int *tab,int N)
{
   int i,j,prem=1;
   for(i=0;i<N && prem == 1;i++)
   {
	 j=2;
	 while(j<N/2 && (tab[i]%j)!=0) j++;
	 if(j==(N/2)) prem = 0;
   }
   return prem;
}

//Recherche :

int recherche(int *tab, int N, int x)
{
	int i=0;
	while(i<N && tab[i]!=x) i++;
	if(i < N) return i;
	 else return -1;
}

//Recherche par dichotomie:

int recherche_dichotomie(int *tab, int N, int x)
{
	int ipremier = 0, idernier = N-1, trouve=0, imilieu;
	
	trier(tab,N);
	
	while( (ipremier <= idernier) && trouve == 0 )
	{
	   imilieu = (ipremier + idernier)/2 ;
	   if( tab[imilieu] == x  ) trouve = 1;
	   else
		 if(tab[imilieu] > x) idernier = imilieu-1;
		  else
			ipremier = imilieu+1;
    }
    if(!trouve) return -1;
      else return imilieu;
}

