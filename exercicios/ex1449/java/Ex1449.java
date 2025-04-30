package ex1449.java;

import java.util.Scanner;

class Dicionario {
    String palavra; 
    String traducao;
    public Dicionario(String palavra, String traducao) {
        this.palavra = palavra;
        this.traducao = traducao;
    }
}

public class Ex1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int instancias = sc.nextInt();

        for(int i = 0; i < instancias; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();

            Dicionario dicionario[] = new Dicionario[m];
            
            // Esse loop é usado para ler as palavras e as suas respectivas traduções
            for(int j = 0; j < m; j++) {
                String palavra = sc.nextLine();
                String traducao = sc.nextLine();
                dicionario[j] = new Dicionario(palavra, traducao);
            }

            // Esse loop é usado para ler as linhas das músicas
            for(int k = 0; k < n; k++) {
                String linha = sc.nextLine();
                String partes[] = linha.split(" ");
                StringBuilder str = new StringBuilder();
                
                for(int x = 0; x < partes.length; x++) {
                    boolean encontrou = false;
                    
                    // Procurar tradução
                    for(Dicionario saida : dicionario) {
                        if(partes[x].equals(saida.palavra)) {
                            str.append(saida.traducao);
                            encontrou = true;
                            break;
                        }
                    }
                    
                    // Se não encontrou, usar a palavra original
                    if(!encontrou) {
                        str.append(partes[x]);
                    }
                    
                    // Adicionar espaço entre palavras, exceto na última
                    if(x < partes.length - 1) {
                        str.append(" ");
                    }
                }
                
                System.out.println(str.toString());
            }
            
            System.out.println(); // Linha em branco entre as instâncias
        }
        sc.close();
    }
}