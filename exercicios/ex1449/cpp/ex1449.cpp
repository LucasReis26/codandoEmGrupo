#include <iostream>

class Dicionario{
	private:
		std::string palavra;
		std::string traducao;
	public:
		Dicionario(){
			this->palavra = " ";
			this->traducao = " ";
		}
		Dicionario(std::string palavra, std::string traducao){
			this->palavra = palavra;
			this->traducao = traducao;
		}

		void setPalavra(std::string palavra) { this->palavra = palavra; }
		void setTraducao(std::string traducao) { this->traducao = traducao; }

		std::string getPalavra() { return this->palavra; }
		std::string getTraducao() { return this->traducao; }
};

int contaPalavras(std::string line){
	int count = 1;

	for(int i = 0; i < line.length(); i++){
		if(line[i] == ' ')
			count++;
	}

	return count;
}

void separaPalavras(std::string *letraMusica, std::string *palavrasMusica, int lines, int words){
	for(int i = 0, l = 0; i < lines && l < words; i++){
		for(int j = 0; j < letraMusica[i].length(); j++){
			if(letraMusica[i][j] != ' '){
				palavrasMusica[l] += letraMusica[i][j];
			}else{
				l++;
			}
			if(j == letraMusica[i].length() - 1){
				l++;
			}
		}
	}
}

int main(){
	int instancias;

	std::cin >> instancias;

	for(int i = 0; i < instancias; i++){
		int palavrasDir;
		int linhasLetra;

		std::cin >> palavrasDir >> linhasLetra;
		getchar();

		Dicionario *dicionario = new Dicionario[palavrasDir];
		std::string letraMusica[linhasLetra];

		int palavrasLinha[linhasLetra];
		int maxPalavras = 0;

		for(int j = 0; j < palavrasDir; j++){
			std::string palavra;
			std::string traducao;
			std::getline(std::cin,palavra);
			std::getline(std::cin,traducao);
			dicionario[j] = Dicionario(palavra,traducao);
		}

		for(int j = 0; j < linhasLetra; j++){
			std::string palavra;
			std::getline(std::cin,letraMusica[j]);
			palavrasLinha[j] = contaPalavras(letraMusica[j]);
			maxPalavras += palavrasLinha[j];
		}
		
		std::string palavrasMusica[maxPalavras];

		separaPalavras(letraMusica,palavrasMusica,linhasLetra,maxPalavras);

		for(int j = 0, l = 0, p = 0; j < maxPalavras; j++){
			bool find = false;
			for(int k = 0; k < palavrasDir; k++){
				if(palavrasMusica[j].compare(dicionario[k].getPalavra()) == 0){
					std::cout << dicionario[k].getTraducao();
					find = true;
				}
			}
			if(find == false){
				std::cout << palavrasMusica[j];
			}
			if(l != palavrasLinha[p] - 1){
				std::cout << " ";
			}
			l++;
			if(l == palavrasLinha[p]){
				l = 0;
				p++;
				std::cout << std::endl;
			}
		}
		std::cout << std::endl;
	}

	return 0;
}
