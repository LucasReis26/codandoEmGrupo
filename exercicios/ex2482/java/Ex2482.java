//package ex2482.java;

import java.util.Scanner;

class Pais{
    String idioma;
    String traducao;
    public Pais(String idioma, String traducao){
        this.idioma = idioma;
        this.traducao = traducao;
    }
}
public class Ex2482{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantTraducoes = sc.nextInt();
        sc.nextLine();

        Pais pais[] = new Pais[quantTraducoes];

        for(int i = 0; i < quantTraducoes; i++){
            String lingua = sc.nextLine();
            String traducao = sc.nextLine();

            pais[i] = new Pais(lingua, traducao);
        }

        int quantCriancas = sc.nextInt();
        sc.nextLine();

        String nome[] = new String[quantCriancas];
        String idioma[] = new String[quantCriancas];

        for(int i = 0; i < quantCriancas; i++){
            nome[i] = sc.nextLine();
            idioma[i] = sc.nextLine();
        }

            for(int j = 0; j < quantCriancas; j++){
                System.out.println(nome[j]);
                for(Pais valores : pais){
                if(idioma[j].equals(valores.idioma)){
                    System.out.println(valores.traducao);
                    System.out.println();
                }
            }
        }

        sc.close();
    }
}