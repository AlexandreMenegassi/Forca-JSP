package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import base.DataBase;
import jogador.Player;
import view.View;

public class Controller extends Test {

	Scanner scan = new Scanner(System.in);
	DataBase db = new DataBase();
	Player player = new Player();
	View view = new View();
	Date data = new Date();
	boolean continua = true;
	int aux, tamPalavra, tamP, vidas, cont = 0, status;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String horaInicio = sdf.format(data), letrasDigitadas = "";

	public void menu() {
		while (continua) {
			aux = view.telaInicial();
			switch (aux) {

			// ENCERRAR
			case 0:
				view.telaFimPrograma();
				continua = false;
				break;

			// JOGAR
			case 1:
				view.telaNomeJogador();
				player.setNome(scan.nextLine().toUpperCase());
				player.setLevel(view.telaDificuldade());
				player.setDataInicio(horaInicio);
				view.telaPalpite();
				player.setPalpite(scan.nextLine().toUpperCase());
				tamPalavra = player.getPalpite().length();
				tamP = player.getPalpite().length();
				this.play();
				break;

			// GERAR RELATORIO
			case 2:

				break;
			}
		}
	}

	public void play() {

		System.out.println("\n\n\n\n");
		char[] traco = new char[tamPalavra];
		for (int i = 0; i < tamPalavra; i++) {
			traco[i] = '_';
		}

		if (player.getLevel() == "FACIL") {
			vidas = 7;
		} else if (player.getLevel() == "MEDIO") {
			vidas = 5;
		} else {
			vidas = 3;
		}

		aux = tamPalavra;

		while (tamPalavra > 0 && vidas > 0) {

			System.out.print("A Palavra é: ");
			for (int i = 0; i < tamP; i++) {
				System.out.print(" " + traco[i] + " ");
			}

			System.out.print("\nLetras informadas: " + letrasDigitadas);
			System.out.println("\nCanches Restante:  " + vidas);

			char letras;
			letras = scan.next().toUpperCase().charAt(0);
			letrasDigitadas += " " + letras;
			System.out.println("\n\nletras " + letrasDigitadas);

			boolean erro = false;
			for (int i = 0; i < traco.length; i++) {

				if (player.getPalpite().charAt(i) == letras) {
					traco[i] = letras;
					tamPalavra--;
					erro = true;
				}
			}
			if (!erro) {
				vidas--;
			}

		}
		player.setLetrasDigitadas(letrasDigitadas);
		System.out.print("A palavra era: ");
		for (int i = 0; i < tamP; i++) {
			System.out.print(" " + traco[i] + " ");
		}
		System.out.print("\nLetras informadas: " + letrasDigitadas);
		System.out.println("\nCanches Restante: " + vidas + "\n\n");
		System.out.println("A palavra é: " + player.getPalpite());
		status = this.verificaJogo(tamPalavra);
		
		this.statusJogo(status);
		this.dataBase();
		this.limpaCache();
	}

	public void dataBase() {
		db.jogoIniciado(player.getNome(), player.getLevel(), player.getDataInicio(), player.getPalpite(),
				player.getStatus(), player.getLetrasDigitadas());
	}

	public void statusJogo(int sta) {
		if (sta == 1) {
			view.telaVitoria();
			player.setStatus("VITORIA");
		} else if (sta == 2) {
			view.telaDerrota();
			player.setStatus("DERROTA");
		} else {
			view.telaInterrompido();
			player.setStatus("INTERROMPIDO");
		}
	}
	
	public void limpaCache(){
		player.setNome(null);
		player.setLevel(null);
		player.setDataInicio(null);
		player.setPalpite(null);
		player.setStatus(null);
		player.setLetrasDigitadas(null);
	}
}