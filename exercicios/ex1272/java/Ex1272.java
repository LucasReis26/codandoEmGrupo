package ex1272.java;

import java.util.Scanner;

public class Ex1272{
	public static String mensagemOculta(String mensagem){
		StringBuilder sb = new StringBuilder();
		int len = mensagem.length();
		boolean firstFound = false;
		for(int i = 0; i < len; i++){
			if(!(len == 1 && mensagem.charAt(0) == ' ')){
				if(mensagem.charAt(i) != ' ' && firstFound == false){
					sb.append(mensagem.charAt(i));
					firstFound = true;
				}else if(mensagem.charAt(i) == ' '){
					firstFound = false;
				}

			}
		}

		return new String(sb);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Integer testes = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < testes; i++){
			String mensagem = sc.nextLine();
			System.out.println(mensagemOculta(mensagem));
		}

		sc.close();
	}
}
