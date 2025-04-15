#include <iostream>

class Crianca{
	private:
		std::string nome;
		int valor;
	public:
		Crianca(){
			this->nome = "";
			this->valor = 0;
		}
		Crianca(std::string nome, int valor){
			this->nome = nome;
			this->valor = valor;
		}
		void setNome(std::string nome){
			this->nome = nome;
		}
		std::string getNome(){
			return this->nome;
		}
		void setValor(int valor){
			this->valor = valor;
		}
		int getValor(){
			return this->valor;
		}
};
class No{
	private: 
		Crianca elemento;
		No *prox;
		No *anterior;	
	public:
		No(){
			this->elemento = Crianca();
			this->prox = NULL;
			this->anterior = NULL;
		}
		No(Crianca elemento, No *prox, No *anterior){
			this->elemento = elemento;
			this->prox = prox;
			this->anterior = anterior;
		}
		void setElemento(Crianca elemento){
			this->elemento = elemento;
		}
		Crianca getElemento(){
			return this->elemento;
		}
		void setProx(No *prox){
			this->prox = prox;
		}
		No *getProx(){
			return this->prox;
		}
		void setAnterior(No *anterior){
			this->anterior = anterior;
		}
		No *getAnterior(){
			return this->anterior;
		}
};

int main(){

	int numCriancas;

	std::cin >> numCriancas;

	while(numCriancas > 0){
		No *criancas = new No[numCriancas];
		if(numCriancas > 1){
			std::string nome;
			int valor;
			std::cin >> nome >> valor;
			criancas[0].setElemento(Crianca(nome,valor));
			criancas[0].setAnterior(&criancas[numCriancas - 1]);
			criancas[0].setProx(&criancas[1]);
			std::cin >> nome >> valor;
			criancas[numCriancas - 1].setElemento(Crianca(nome,valor));
			criancas[numCriancas - 1].setAnterior(&criancas[numCriancas - 2]);
			criancas[numCriancas - 1].setProx(&criancas[0]);
			for(int i = 1; i < numCriancas - 1; i++){
				std::cin >> nome >> valor;
				criancas[i].setElemento(Crianca(nome,valor));
				criancas[i].setAnterior(&criancas[i - 1]);
				criancas[i].setProx(&criancas[i + 1]);
			}
		}else{
			std::string nome;
			int valor;
			std::cin >> nome >> valor;
			criancas[0].setElemento(Crianca(nome,valor));
			criancas[0].setAnterior(&criancas[0]);
			criancas[0].setProx(&criancas[0]);
		}
		No *selected = &criancas[0];
		while(numCriancas > 1){
			int value = selected->getElemento().getValor();
			if(value % 2 == 0){
				for(int i = 0; i < value; i++){
					selected = selected->getProx();
				}
				No *anterior = selected->getAnterior();
				No *prox = selected->getProx();
				anterior->setProx(prox);
				prox->setAnterior(anterior);
				numCriancas--;
			}else{
				for(int i = 0; i < value; i++){
					selected = selected->getAnterior();
				}
				No *anterior = selected->getAnterior();
				No *prox = selected->getProx();
				anterior->setProx(prox);
				prox->setAnterior(anterior);
				numCriancas--;
			}
		}
		std::string vencedor = selected->getProx()->getElemento().getNome();
		std::cout << "Vencedor(a): " << vencedor << std::endl;

		std::cin >> numCriancas;
	}

	return 0;
}

