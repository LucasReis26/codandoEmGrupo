package ex1861.java;

import java.util.Scanner;

class Pessoa {

    String assassino;
    boolean morreu;
    int quant;

    public Pessoa(String assassino, int quant) {
        this.assassino = assassino;
        this.quant = quant;
        morreu = false;
    }
}

public class Ex1861 {

    public static int comparar(Pessoa a, Pessoa b) {
        return a.assassino.compareTo(b.assassino);
    }

    public static void ordenarAssassinos(Pessoa[] pessoa, int tam) {
        for (int i = 1; i < tam; i++) {
            Pessoa tmp = pessoa[i];
            int j = i - 1;
            while (j >= 0 && comparar(pessoa[j], tmp) > 0) {
                pessoa[j + 1] = pessoa[j];
                j--;
            }
            pessoa[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa[] assassinos = new Pessoa[100000];
        String[] assassinados = new String[100000];
        int contador = 0;
        int vitimasCount = 0;
    
        while (sc.hasNext()) {
            String assassino = sc.next();
            String assassinado = sc.next();
            if (sc.hasNextLine()) sc.nextLine();
    
            // Registrar assassinato
            boolean existe = false;
            for (int i = 0; i < contador; i++) {
                if (assassinos[i].assassino.equals(assassino)) {
                    assassinos[i].quant++;
                    existe = true;
                    break;
                }
            }
    
            if (!existe) {
                assassinos[contador] = new Pessoa(assassino, 1);
                contador++;
            }
    
            // Registrar vítima
            assassinados[vitimasCount++] = assassinado;
        }
    
        // Marcar quem morreu
        for (int i = 0; i < contador; i++) {
            for (int j = 0; j < vitimasCount; j++) {
                if (assassinos[i].assassino.equals(assassinados[j])) {
                    assassinos[i].morreu = true;
                    break;
                }
            }
        }
    
        ordenarAssassinos(assassinos, contador);
    
        System.out.println("HALL OF MURDERERS");
        for (int i = 0; i < contador; i++) {
            if (!assassinos[i].morreu) {
                System.out.println(assassinos[i].assassino + " " + assassinos[i].quant);
            }
        }
    }
}
