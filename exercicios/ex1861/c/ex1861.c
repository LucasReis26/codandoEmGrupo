#include <stdio.h>
#include <stdbool.h>
#include <string.h>

typedef struct{
	char nome[11];
	int assassinatos;
	bool isAlive;
}ASSASSINO;

typedef struct{
	ASSASSINO assassinos[200000];
	int tam;
}HALL;

void swap(ASSASSINO *a, ASSASSINO *b){
	ASSASSINO aux = *a;
	*a = *b;
	*b = aux;
}

void quicksort(ASSASSINO *array, int esq, int dir){
	int i = esq;
	int j = dir;
	ASSASSINO pivo = array[(esq + dir)/2];
	while(i <= j){
		while(strcmp(array[i].nome,pivo.nome) < 0){
			i++;
		}
		while(strcmp(array[j].nome,pivo.nome) > 0){
			j--;
		}
		if(i <= j){
			swap(&array[i],&array[j]);
			i++;
			j--;
		}
	}
	if(i < dir){
		quicksort(array,i,dir);
	}
	if(j > esq){
		quicksort(array, esq, j);
	}
}

int main(){
	HALL hall; 
	hall.tam = 0;
	
	for(int i = 0; i < 255; i++){
		strcpy(hall.assassinos[i].nome,"Sem nome");
		hall.assassinos[i].assassinatos = 0;
		hall.assassinos[i].isAlive = true;
	}

	int i = 0;
	char nome1[11];
	char nome2[11];

	while(scanf("%s %s",nome1,nome2) == 2){
		for(int j = 1; j <= 2; j++){
			if(j == 1){
				for(int i = 0; i < hall.tam + 1; i++){
					if(strcmp(hall.assassinos[i].nome,nome1) == 0){
						hall.assassinos[i].assassinatos++;
						i = hall.tam + 1;
					}else if(strcmp(hall.assassinos[i].nome,"Sem nome") == 0){
						hall.tam++;
						strcpy(hall.assassinos[i].nome,nome1);
						hall.assassinos[i].assassinatos++;
						i = hall.tam + 1;
					}
				}
			}else{
				for(int i = 0; i < hall.tam + 1; i++){
					if(strcmp(hall.assassinos[i].nome,nome2) == 0){
						hall.assassinos[i].isAlive = false;
						i = hall.tam + 1;
					}else if(strcmp(hall.assassinos[i].nome,"Sem nome") == 0){
						hall.tam++;
						strcpy(hall.assassinos[i].nome,nome2);
						hall.assassinos[i].isAlive = false;
						i = hall.tam + 1;
					}
				}
			}
		}
	}

	quicksort(hall.assassinos,0,hall.tam - 1);

	printf("HALL OF MURDERERS\n");

	for(int i = 0; i < hall.tam; i++){
		if(hall.assassinos[i].isAlive){
			printf("%s %d\n",hall.assassinos[i].nome,hall.assassinos[i].assassinatos);
		}
	}



	return 0;
}
