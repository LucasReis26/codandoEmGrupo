package ex1167.java;

import java.util.Scanner;

public class Ex1167{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);


		int pessoas = sc.nextInt();

		while(pessoas != 0){
			Lista lista = new Lista();
			for(int i = 0; i < pessoas; i++){
				String nome = sc.next();
				int value = sc.nextInt();
				lista.inserirFim(new Pessoa(nome,value));
			}
			// lista.mostrar();
			lista.playGame();
			pessoas = sc.nextInt();
		}

		sc.close();
	}
}

class Lista{
	private CelulaDupla primeiro;
	private CelulaDupla ultimo;
	private int tam;

	public Lista(){
		this.primeiro = this.ultimo = null;
		tam = 0;
	}

	public void inserirFim(Pessoa x){
		tam++;
		CelulaDupla tmp = new CelulaDupla(x);
		if(this.primeiro == null && this.ultimo == null){
			tmp.setProx(tmp);
			tmp.setAnt(tmp);
			this.primeiro = tmp;
			this.ultimo = tmp;
		}else{
			this.ultimo.setProx(tmp);
			this.primeiro.setAnt(tmp);
			tmp.setProx(primeiro);
			tmp.setAnt(ultimo);
			ultimo = tmp;
		}
		tmp = null;
	}

	public void mostrar(){
		System.out.print("[ ");
		for(CelulaDupla i = primeiro; i.getProx() != primeiro; i = i.getProx()){
			System.out.print(i.getElemento().getNome() + ", ");
			if(i.getProx().getProx() == primeiro){
				System.out.print(i.getProx().getElemento().getNome() + ", ");
			}
		}
		System.out.println("]");
	}

public void playGame(){
		CelulaDupla target = primeiro;
		int value = primeiro.getElemento().getValue();
		while(tam > 1){
			if(value % 2 == 0){
				// System.out.println("PAR" + value);
				for(CelulaDupla i = target; value >= 0; value--, i = i.getAnt()){
					target = i;
					// System.out.println(value + " " + target.getElemento().getNome());
				}
			}else{
				// System.out.println("IMPAR" + value);
				for(CelulaDupla i = target; value >= 0; value--, i = i.getProx()){
					target = i;
					// System.out.println(value + " " + target.getElemento().getNome());
				}
			}
			tam--;
			target.getProx().setAnt(target.getAnt());
			target.getAnt().setProx(target.getProx());
			value = target.getElemento().getValue();
		}
		System.out.println("Vencedor(a): " + target.getProx().getElemento().getNome());

	}

	public CelulaDupla getUltimo() { return ultimo; }
	public CelulaDupla getPrimeiro() { return primeiro; }

	public void setUltimo(CelulaDupla ultimo) { this.ultimo = ultimo; }
	public void setPrimeiro(CelulaDupla primeiro) { this.primeiro = primeiro; }
}

class CelulaDupla{
	private Pessoa elemento;
	private CelulaDupla ant;
	private CelulaDupla prox;

	public CelulaDupla(){
		this.elemento = new Pessoa();
		this.ant = this.prox = null;
	}

	public CelulaDupla(Pessoa elemento){
		this.elemento = elemento;
		this.ant = this.prox = null;
	}

	public Pessoa getElemento() { return elemento; }
	public CelulaDupla getAnt() { return ant; }
	public CelulaDupla getProx() { return prox; }

	public void setAnt(CelulaDupla ant) { this.ant = ant; }
	public void setProx(CelulaDupla prox) { this.prox = prox; }
	public void setElemento(Pessoa elemento) { this.elemento = elemento; }
}

class Pessoa{
	private String nome;
	private int value;

	public Pessoa(){
		this.nome = "Sem nome";
		this.value = 0;
	}

	public Pessoa(String nome, int value){
		this.nome = nome;
		this.value = value;
	}

	public String getNome() { return nome; }
	public int getValue() { return value; }

	public void setValue(int value) { this.value = value; }
	public void setNome(String nome) { this.nome = nome; }
}
