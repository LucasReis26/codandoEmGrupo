#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	char palavras[5000][255];
	int tam;
} DICIONARIO;

char toLowerCase(char a){
	if(a >= 'A' && a <= 'Z'){
		a += 32;
	}
	return a;
}

bool procuraDicionario(char *word, DICIONARIO *dicionario){
	bool encontrei = false;
	for(int i = 0; i < dicionario->tam; i++){
		if(strcmp(word,dicionario->palavras[i]) == 0){
			encontrei = true;
		}
	}
	return encontrei;
}

void adicionaAoDicionario(char *line, DICIONARIO *dicionario){
	int len = strlen(line);
	char newWords[len][255];

	int k = 0, j = 0;
	for(int i = 0 ; i < len; i++){
		if(toLowerCase(line[i]) >= 'a' && toLowerCase(line[i]) <= 'z'){
			newWords[k][j++] = toLowerCase(line[i]);
		}else{
			if(j > 0){
				newWords[k++][j] = '\0';
				j = 0;
			}
		}
	}
	if(j > 0){
		newWords[k++][j] = '\0';
	}

	for(int i = 0; i < k; i++){
		bool encontrei = procuraDicionario(newWords[i],dicionario);
		if(!encontrei){
			strcpy(dicionario->palavras[dicionario->tam++],newWords[i]);
		}
	}


}

bool readLine(char *line){
	if(fgets(line,255,stdin)){
		size_t len = strlen(line);
		if(line[len - 1] == '\n'){
			line[len - 1] = '\0';
		}
		return true;
	}else{
		return false;
	}
}

void swap(char a[255], char b[255]){
	char temp[255];
	strcpy(temp, a);
	strcpy(a, b);
	strcpy(b, temp);
}

void quicksort(DICIONARIO *dicionario, int esq, int dir){
	int i = esq;
	int j = dir;
	char *pivo = (char *)calloc(255,sizeof(char));
	strcpy(pivo,dicionario->palavras[(esq + dir)/2]);
	while(i <= j){
		while(strcmp(dicionario->palavras[i], pivo) < 0){
			i++;
		}
		while(strcmp(dicionario->palavras[j], pivo) > 0){
			j--;
		}
		if(i <= j){
			swap(dicionario->palavras[i],dicionario->palavras[j]);
			i++;
			j--;
		}
	}
	if(i < dir){
		quicksort(dicionario, i, dir);
	}
	if(esq < j){
		quicksort(dicionario,esq,j);
	}
	free(pivo);
}

int main(){
	char *line = (char *)malloc(255 * sizeof(char));
	DICIONARIO *dicionario = (DICIONARIO *)calloc(1 , sizeof(DICIONARIO));
	dicionario->tam = 0;

	while(readLine(line)){
		adicionaAoDicionario(line,dicionario);
	}

	quicksort(dicionario,0,dicionario->tam - 1);

	for(int i = 0; i < dicionario->tam; i++){
		printf("%s\n",dicionario->palavras[i]);
	}


	free(line);
	free(dicionario);

	return 0;
}
