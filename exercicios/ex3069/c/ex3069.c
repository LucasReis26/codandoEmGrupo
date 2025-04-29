#include <stdio.h>
#include <stdbool.h>

typedef struct{
	int inicio;
	int fim;
}Sorveteiro;

int main(){
	int s, p;
	int i = 1;
	
	scanf("%d %d",&p,&s);

	while(s != 0 && p != 0){
		Sorveteiro array[s];

		for(int i = 0; i < s; i++){
			scanf("%d %d",&array[i].inicio,&array[i].fim);
		}

		printf("Teste %d\n",i++);

		
		for(int k = 0; k < s; k++){
			int lista[] = {array[k].inicio,array[k].fim};

			while((k + 1) < s && lista[1] >= array[k + 1].inicio){
				k++;
			}

			lista[1] = array[k].fim;

			printf("%d %d\n",lista[0],lista[1]);
		}
		

		scanf("%d %d",&p,&s);
	}

	return 0;
}
