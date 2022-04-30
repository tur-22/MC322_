package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	int i = 6; // representa a posição do próximo comando a ser lido na String instrucoes.
	String instrucoes = "";
	AquarioLombriga aquarioLombriga = null;
	
	Animacao(String instrucoes) {
		int tamanhoAquario = Integer.parseInt(instrucoes.substring(0, 2));
		int tamanhoLombriga = Integer.parseInt(instrucoes.substring(2, 4));
		int posicaoInicial = Integer.parseInt(instrucoes.substring(4, 6));
		this.instrucoes = instrucoes;
		aquarioLombriga = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicaoInicial);
	}
	
	String apresenta() {
		return aquarioLombriga.apresenta();
	}
	
	void passo() {
		if (instrucoes.charAt(i) == 'C')
			aquarioLombriga.crescer();
		else if (instrucoes.charAt(i) == 'M')
			aquarioLombriga.mover();
		else
			aquarioLombriga.virar();
		i++;
	}
}