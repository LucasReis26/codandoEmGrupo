package ex3069.java;

import java.util.Scanner;

class Praia {
    int inicio;
    int fim;

    public Praia(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
}

public class Ex3069 {

    // Método para comparar dois intervalos (ordena pelo início)
    public static int compararPraias(Praia a, Praia b) {
        if (a.inicio < b.inicio) {
            return -1;
        } else if (a.inicio > b.inicio) {
            return 1;
        } else {
            return 0;
        }
    }

    // Ordenação por inserção baseada na comparação
    public static void ordenarInsercao(Praia[] praias) {
        for (int i = 1; i < praias.length; i++) {
            Praia tmp = praias[i];
            int j = i - 1;
            while (j >= 0 && compararPraias(praias[j], tmp) > 0) {
                praias[j + 1] = praias[j];
                j--;
            }
            praias[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int compPraia = sc.nextInt();
        int quantSorveteiros = sc.nextInt();
        int teste = 1;

        while (compPraia != 0 || quantSorveteiros != 0) {
            Praia[] praia = new Praia[quantSorveteiros];

            for (int i = 0; i < quantSorveteiros; i++) {
                int inicio = sc.nextInt();
                int fim = sc.nextInt();
                praia[i] = new Praia(inicio, fim);
            }

            // Ordena os intervalos usando ordenação por inserção
            ordenarInsercao(praia);

            System.out.println("Teste " + teste);

            if (quantSorveteiros > 0) {
                int inicioAtual = praia[0].inicio;
                int fimAtual = praia[0].fim;

                for (int i = 1; i < quantSorveteiros; i++) {
                    if (praia[i].inicio <= fimAtual) {
                        // Intervalos se sobrepõem ou são adjacentes - une eles
                        if (praia[i].fim > fimAtual) {
                            fimAtual = praia[i].fim;
                        }
                    } else {
                        // Imprime o intervalo atual e começa um novo
                        System.out.println(inicioAtual + " " + fimAtual);
                        inicioAtual = praia[i].inicio;
                        fimAtual = praia[i].fim;
                    }
                }
                // Imprime o último intervalo
                System.out.println(inicioAtual + " " + fimAtual);
            }

            compPraia = sc.nextInt();
            quantSorveteiros = sc.nextInt();
            teste++;
        }

        sc.close();
    }
}