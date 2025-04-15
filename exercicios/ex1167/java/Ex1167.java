package ex1167.java;
import java.util.Scanner;

class Crianca {
    String nome;
    int valor;

    public Crianca(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }
}

class FilaCircular {
    Crianca[] fila;
    int tam;
    int total;

    public FilaCircular(int tamanho) {
        tam = tamanho;
        fila = new Crianca[tam];
        total = 0;
    }

    public void enfileirar(String nome, int valor) {
        fila[total++] = new Crianca(nome, valor);
    }

    public Crianca remover(int pos) {
        Crianca removida = fila[pos];
        for (int i = pos; i < total - 1; i++) {
            fila[i] = fila[i + 1];
        }
        total--;
        return removida;
    }

    public Crianca get(int pos) {
        return fila[pos];
    }

    public int tamanho() {
        return total;
    }
}

public class Ex1167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();

        while (entrada != 0) {
            FilaCircular fila = new FilaCircular(entrada);

            for (int i = 0; i < entrada; i++) {
                String nome = sc.next();
                int valor = sc.nextInt();
                fila.enfileirar(nome, valor);
            }

            int idx = 0;
            int passo = fila.get(idx).valor;

            while (fila.tamanho() > 1) {
                // Determina a direção: 1 para horário (par), -1 para anti-horário (ímpar)
                int direcao = (passo % 2 == 0) ? -1 : 1;
                
                // Calcula a posição da criança a ser eliminada
                int eliminar = (idx + direcao * (passo - 1)) % fila.tamanho();
                if (eliminar < 0) {
                    eliminar += fila.tamanho();
                }

                Crianca removida = fila.remover(eliminar);
                passo = removida.valor;
                
                // Atualiza o índice para a próxima rodada
                if (direcao == 1) {
                    idx = eliminar % fila.tamanho();
                } else {
                    idx = (eliminar - 1 + fila.tamanho()) % fila.tamanho();
                }
                
                // Ajuste para evitar índice negativo
                if (idx < 0) {
                    idx += fila.tamanho();
                }
            }

            System.out.println("Vencedor(a): " + fila.get(0).nome);
            entrada = sc.nextInt();
        }

        sc.close();
    }
}