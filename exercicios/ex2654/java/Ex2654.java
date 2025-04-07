package ex2654.java;

import java.util.Scanner;

class Candidato {
	private String name;
	private Integer power;
	private Integer deusesMatados;
	private Integer mortes;

	public Candidato() {
		this.name = "";
		this.power = 0;
		this.deusesMatados = 0;
		this.mortes = 0;
	}

	public Candidato(String name, Integer power, Integer deusesMatados, Integer mortes) {
		this.name = name;
		this.power = power;
		this.deusesMatados = deusesMatados;
		this.mortes = mortes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getPower() {
		return power;
	}

	public void setMortes(Integer mortes) {
		this.mortes = mortes;
	}

	public Integer getMortes() {
		return mortes;
	}

	public void setDeusesMatados(Integer deusesMatados) {
		this.deusesMatados = deusesMatados;
	}

	public Integer getDeusesMatados() {
		return deusesMatados;
	}
}

public class Ex2654 {
	public static Integer verificaPoder(Candidato[] array, Integer maior, Integer j) {
		Boolean v = false;
		Integer resp = 0;

		if (!v && array[maior].getPower() < array[j].getPower()) {
			resp = j;
			v = true;
		}

		if (!v && array[maior].getPower() != array[j].getPower()) {
			resp = maior;
			v = true;
		}

		if (!v && array[maior].getDeusesMatados() < array[j].getDeusesMatados()) {
			resp = j;
			v = true;
		}

		if (!v && array[maior].getDeusesMatados() != array[j].getDeusesMatados()) {
			resp = maior;
			v = true;
		}

		if (!v && array[maior].getMortes() > array[j].getMortes()) {
			resp = j;
			v = true;
		}

		if (!v && array[maior].getMortes() != array[j].getMortes()) {
			resp = maior;
			v = true;
		}

		if (!v && array[maior].getName().compareTo(array[j].getName()) > 0) {
			resp = j;
			v = true;
		}

		if (!v && array[maior].getName().compareTo(array[j].getName()) != 0) {
			resp = maior;
			v = true;
		}

		return resp;
	}

	public static void ordenaCandidato(Candidato[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			int maisPoderoso = i;

			for (int j = i + 1; j < len; j++) {

				maisPoderoso = verificaPoder(array, maisPoderoso, j);
			}

			Candidato aux = array[i];
			array[i] = array[maisPoderoso];
			array[maisPoderoso] = aux;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Integer quantidade = sc.nextInt();

		Candidato[] candidatos = new Candidato[quantidade];

		for (int i = 0; i < quantidade; i++) {
			String name = sc.next();
			Integer power = sc.nextInt();
			Integer deusesMatados = sc.nextInt();
			Integer mortes = sc.nextInt();

			candidatos[i] = new Candidato(name, power, deusesMatados, mortes);
		}

		ordenaCandidato(candidatos);

		System.out.println(candidatos[0].getName());

		sc.close();
	}
}
