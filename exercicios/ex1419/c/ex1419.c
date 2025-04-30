#include <stdio.h>
#include <stdbool.h>

int jogaGame(int *monstrosMark, int *monstrosLeti, int rodadas){
	int resp = 0;

	int pontosMark = 0;
	int lastMark = 0;
	int consecutivosMark = 0;
	int pontosLeti = 0;
	int lastLeti = 0;
	int consecutivosLeti = 0;

	bool taValendo = false;
	int rodadaBonus = 0;
	int bonus = 0;
	

	for(int i = 0;i < rodadas;i++){
		pontosMark += monstrosMark[i];
		pontosLeti += monstrosLeti[i];
		// printf("PONTOS MARK: %d\n",monstrosMark[i]);
		// printf("PONTOS LETI: %d\n",monstrosLeti[i]);

		if(consecutivosMark < 3){ 
			if(lastMark == monstrosMark[i]){
				consecutivosMark++;
			}else{
				lastMark = monstrosMark[i];
				consecutivosMark = 1;
			}
			
			if(!taValendo && bonus == 0 && consecutivosMark == 3){
				taValendo = true;
				bonus = 1;
				rodadaBonus = i;
			}
		}
		if(consecutivosLeti < 3){ 
			if(lastLeti == monstrosLeti[i]){
				consecutivosLeti++;
			}else{
				lastLeti = monstrosLeti[i];
				consecutivosLeti = 1;
			}

			if(taValendo && i == rodadaBonus && consecutivosLeti == 3){
				taValendo = false;
			}else if(!taValendo && bonus == 0 && consecutivosLeti == 3){
				taValendo = true;
				bonus = 2;
				rodadaBonus = i;
			}
		}

	}

	if(taValendo){
		if(bonus == 1){
			// printf("BONUS MARK\n");
			pontosMark += 30;
		}else if(bonus == 2){
			// printf("BONUS LETI\n");
			pontosLeti += 30;
		}
	}


	if(pontosMark != pontosLeti){
		resp = (pontosMark > pontosLeti) ? 1 : 2;
	}

	return resp;
}

int main(){

	int numRodadas;

	scanf("%d",&numRodadas);

	while(numRodadas > 0){
		int monstrosMark[numRodadas];
		int monstrosLeti[numRodadas];

		for(int i = 0; i < numRodadas; i++){
			scanf("%d",&monstrosMark[i]);
		}
		for(int i = 0; i < numRodadas; i++){
			scanf("%d",&monstrosLeti[i]);
		}

		int vencedor = jogaGame(monstrosMark,monstrosLeti,numRodadas);

		if(vencedor == 1){
			printf("M\n");
		}else if(vencedor == 2){
			printf("L\n");
		}else{
			printf("T\n");
		}

		scanf("%d",&numRodadas);
	}

	return 0;
}
