package controller;

import java.util.Scanner;

public class Test {

	Scanner scan = new Scanner(System.in);
	int aux;
	String dif;

	public int verificaOpcao(int inicio, int fim) {

		boolean ok = true;
		System.out.println("Escolha uma Opcao: ");
		aux = scan.nextInt();

		while (ok) {
			if ((aux < inicio) || (aux > fim)) {
				System.out.println("Opcao invalida digite novamente");
				aux = scan.nextInt();
			} else {
				ok = false;
			}
		}
		return aux;
	}

	public String level(int op) {
		switch (op) {
		case 1:
			dif = "FACIL";
			break;
		case 2:
			dif = "MEDIO";
			break;
		case 3:
			dif = "DIFICIL";
			break;
		}
		return dif;
	}

	public int verificaJogo(int tamPalavra) {
		if (tamPalavra == 0) {
			return 1;

		} else {
			return 2;
		}
	}
}