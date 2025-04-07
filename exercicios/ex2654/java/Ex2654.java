//package ex2654.java;

import java.util.Scanner;
class Godofor{
    String nome;
    int poder; 
    int quantDeMortes;
    int vezesMortes;
    
    public Godofor(String nome, int poder, int quantDeMortes, int vezesMortes){
        this.nome = nome;
        this.poder = poder;
        this.quantDeMortes = quantDeMortes;
        this.vezesMortes = vezesMortes;
    }
}
public class Ex2654{
    public static int compararDeus(Godofor a, Godofor b){
        //Métodos para comparar pelo poder
        int compPoder;
        if(a.poder == b.poder){
            compPoder = 0;
        } else if(a.poder > b.poder){
            compPoder = -1;
        } else {
            compPoder = 1;
        }
        if(compPoder != 0){
            return compPoder;
        }

        //Métodos para comparar pela quantidade de mortes de Deuses
        int compMortes;
        if(a.quantDeMortes == b.quantDeMortes){
            compMortes = 0;
        } else if(a.quantDeMortes > b.quantDeMortes){
            compMortes = -1;
        } else {
            compMortes = 1;
        }
        if(compMortes != 0){
            return compMortes;
        }

        //Métodos para comparar pela quantidade de vezes que ele morreu
        int compVezes;
        if(a.vezesMortes == b.vezesMortes){
            compVezes = 0;
        } else if(a.vezesMortes < b.vezesMortes){
            compVezes = -1;
        } else {
            compVezes = 1;
        }
        if(compVezes != 0){
            return compVezes;
        }

        return a.nome.compareTo(b.nome);
    }

    public static void ordenarInsercao(Godofor[] deus){
        for(int i = 1; i < deus.length; i++){
            Godofor tmp = deus[i];
            int j = i - 1;
            while(j >= 0 && compararDeus(deus[j], tmp) > 0){
                deus[j + 1] = deus[j];
                j--;
            }
            deus[j + 1] = tmp;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        Godofor godofor[] = new Godofor[quantidade];

        for(int i = 0; i < quantidade; i++){
            String nome = sc.next();
            int poder = sc.nextInt();
            int quantDeMortes = sc.nextInt();
            int vezesMortes = sc.nextInt();
            godofor[i] = new Godofor(nome, poder, quantDeMortes, vezesMortes);
        }

        ordenarInsercao(godofor);

        System.out.println(godofor[0].nome);

        sc.close();
    }
}