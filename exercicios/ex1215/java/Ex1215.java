package ex1215.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1215 {
    public static String toLowerCase(String entrada) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < entrada.length(); i++) {
            char caracterAtual = entrada.charAt(i);
            if (caracterAtual >= 'A' && caracterAtual <= 'Z') {
                caracterAtual = (char) (caracterAtual + 32);
            }
            str.append(caracterAtual);
        }
        return str.toString();
    }

    public static void ordenarInsercao(List<String> palavras) {
        for (int i = 1; i < palavras.size(); i++) {
            String tmp = palavras.get(i);
            int j = i - 1;
            while (j >= 0 && palavras.get(j).compareTo(tmp) > 0) {
                palavras.set((j + 1), palavras.get(j));
                j--;
            }
            palavras.set((j + 1), tmp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> todasPalavras = new ArrayList<>();
        
        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            String minuscula = toLowerCase(entrada);

            StringBuilder str = new StringBuilder();
            
            for (int i = 0; i < minuscula.length(); i++) {
                char caracterAtual = minuscula.charAt(i);

                if (caracterAtual >= 'a' && caracterAtual <= 'z') {
                    str.append(caracterAtual);
                } else {
                    if (str.length() > 0) {
                        String palavra = str.toString();
                        if (!todasPalavras.contains(palavra)) {
                            todasPalavras.add(palavra);
                        }
                        str.setLength(0);
                    }
                }
            }

            if (!str.isEmpty()) {
                todasPalavras.add(str.toString());
            }
        }
        
        ordenarInsercao(todasPalavras);
        
        // Imprime todas as palavras ordenadas
        for (String palavra : todasPalavras) {
            System.out.println(palavra);
        }
        
        sc.close();
    }
}