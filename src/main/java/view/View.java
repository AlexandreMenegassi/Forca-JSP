package view;

import controller.Test;

public class View {
	
	Test opcao = new Test();
	String level;
	int aux;
	
	public int telaInicial() {
		System.out.println("\n\n\n");
		System.out.println("=====================================");
		System.out.println("=    BEM VINDOS AO JOGO DA FORCA    =");
		System.out.println("=    ( 1 ) JOGAR                    =");
		System.out.println("=    ( 2 ) GERAR RELATORIO          =");
		System.out.println("=    ( 0 ) SAIR                     =");
		System.out.println("=====================================");
		aux = opcao.verificaOpcao(0, 3);
		return aux;
	}
	
	public void telaNomeJogador() {
		System.out.println("=====================================");
		System.out.println("=    DIGITE SEU NOME                =");
		System.out.println("=====================================");
	}
	
	public String telaDificuldade() {
		System.out.println("=====================================");
		System.out.println("=    ESCOLHA UM LEVEL               =");
		System.out.println("=    ( 1 ) FACIL                    =");
		System.out.println("=    ( 2 ) MEDIO                    =");
		System.out.println("=    ( 3 ) DIFICIL                  =");
		System.out.println("=====================================");
		aux = opcao.verificaOpcao(1, 3);
		level = opcao.level(aux);
		return level;
	}
	
	public void telaFimPrograma() {
		System.out.println("=====================================");
		System.out.println("=    PROGRAMA ENCERRADO             =");
		System.out.println("=====================================");
	}
	
	public void telaPalpite() {
		System.out.println("=====================================");
		System.out.println("=    DIGITE UMA PALAVRA             =");
		System.out.println("=====================================");
	}
	
	public void telaVitoria() {
		System.out.println("=====================================");
		System.out.println("=    VITORIA                        =");
		System.out.println("=====================================");
	}
	
	public void telaDerrota() {
		System.out.println("=====================================");
		System.out.println("=    DERROTA                        =");
		System.out.println("=====================================");
	}
	
	public void telaInterrompido() {
		System.out.println("=====================================");
		System.out.println("=    INTERROMPIDO                   =");
		System.out.println("=====================================");
	}

}