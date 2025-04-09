#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	char lingua[255];
	char traducao[255];
} TRADUCAO;

typedef struct {
	char lingua[255];
	char nome[255];
} PESSOA;

void readLine(char *w){
	fgets(w,255,stdin);

	if(w[strlen(w) - 1] == '\n')
		w[strlen(w)- 1] = '\0';

}

int main() { 
	int quantidadeTrads,
		quantidadePessoas;

	scanf("%d",&quantidadeTrads);
	getchar();

	TRADUCAO *traducoes = (TRADUCAO *)malloc(quantidadeTrads * sizeof(TRADUCAO));

	for(int i = 0; i < quantidadeTrads; i++){
		readLine((traducoes + i)->lingua);
		readLine((traducoes + i)->traducao);
	}

	scanf("%d", &quantidadePessoas);
	getchar();

	PESSOA *pessoas = (PESSOA *)malloc(quantidadePessoas * sizeof(PESSOA));

	for(int i = 0; i < quantidadePessoas; i++){
		readLine((pessoas + i)->nome);
		readLine((pessoas + i)->lingua);
	}

	for(int i = 0; i < quantidadePessoas; i++){
		printf("%s\n",(pessoas + i)->nome);

		for(int j = 0; j < quantidadeTrads; j++){
			if(strcmp((pessoas + i)->lingua,(traducoes + j)->lingua) == 0){
				printf("%s\n",(traducoes + j)->traducao);
				j = quantidadeTrads;
			}
		}

		printf("\n");
	}

	free(traducoes);
	free(pessoas);

	return 0; 
}
