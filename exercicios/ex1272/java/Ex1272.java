package ex1272.java;

import java.util.Scanner;

public class Ex1272{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantidade = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < quantidade; i++){

            String entrada = sc.nextLine();

            StringBuilder str = new StringBuilder();
            String partes[] = entrada.split("·");
        
            for(int j = 0; j < partes.length; j++){
                if(!partes[j].isEmpty()){
                char primeiraLetra = partes[j].charAt(0);
                str.append(primeiraLetra);
            }
         } 
    
            System.out.println(str.toString());

        }
        sc.close();
    }
}