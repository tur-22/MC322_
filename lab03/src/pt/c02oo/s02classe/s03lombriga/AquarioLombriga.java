package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    int tamanhoAquario, tamanhoLombriga, posicaoInicial;
    char lado = 'e'; // e -> esquerda; d -> direita.
    String aquarioLombriga = "";
    
    AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoInicial) {
    	this.tamanhoAquario = tamanhoAquario;
    	this.tamanhoLombriga = tamanhoLombriga;
    	if (posicaoInicial + tamanhoLombriga - 1 > tamanhoAquario) // se a lombriga está para fora do aquário.
    		this.posicaoInicial = 1;
    	else
    		this.posicaoInicial = posicaoInicial;
    	for (int i = 1; i < this.posicaoInicial; i++)
    		aquarioLombriga += "#";
    	aquarioLombriga += "0";
    	for (int i = 1; i < tamanhoLombriga; i++)
    		aquarioLombriga += "@";
    	int tamanhoAtual = aquarioLombriga.length(); // preenche os espaços à direita da lombriga.
    	for (int i = 0; i < tamanhoAquario - tamanhoAtual; i++)
    		aquarioLombriga += "#";
    }
    
    void crescer() {
    	if (lado == 'e') {
    		int proximoLivre = posicaoInicial + tamanhoLombriga; // 1 + espaço em que deve ser inserido o caractere @ (posicaoInicial considera o começo da string como sendo 1).
    		if (proximoLivre <= tamanhoAquario) {
    			String novoAquarioLombriga = aquarioLombriga.substring(0, proximoLivre - 1);
    			novoAquarioLombriga += "@";
    			tamanhoLombriga++;
    			int tamanhoAtual = novoAquarioLombriga.length();
    	    	for (int i = 0; i < tamanhoAquario - tamanhoAtual; i++)
    	    		novoAquarioLombriga += "#";    
    	    	aquarioLombriga = novoAquarioLombriga;
    		}
    	}
    	else {
    		int proximoLivre = posicaoInicial - tamanhoLombriga;
    		if (proximoLivre > 0) {
    			String novoAquarioLombriga = aquarioLombriga.substring(0, proximoLivre - 1);
    	    	for (int i = 0; i < tamanhoLombriga; i++) // adiciona tamanhoLombriga (quantidade de @`s atual + 1) caracteres do tipo @
    	    		novoAquarioLombriga += "@";
    	    	novoAquarioLombriga += "0";
    	    	tamanhoLombriga++;
    	    	int tamanhoAtual = novoAquarioLombriga.length();
    	    	for (int i = 0; i < tamanhoAquario - tamanhoAtual; i++)
    	    		novoAquarioLombriga += "#";
    	    	aquarioLombriga = novoAquarioLombriga;
    		}
    	}
    }
    
    void virar() {
    	if (lado == 'e') {
    		String novoAquarioLombriga = aquarioLombriga.substring(0, posicaoInicial - 1); // copia #`s à esquerda da lombriga.
    		for (int i = 0; i < tamanhoLombriga - 1; i++)
	    		novoAquarioLombriga += "@";
    		novoAquarioLombriga += "0";
        	int tamanhoAtual = novoAquarioLombriga.length();
        	for (int i = 0; i < tamanhoAquario - tamanhoAtual; i++)
        		novoAquarioLombriga += "#";
    		lado = 'd';
    		posicaoInicial += tamanhoLombriga - 1;
        	aquarioLombriga = novoAquarioLombriga;
    	}
    	else {
    		String novoAquarioLombriga = aquarioLombriga.substring(0, posicaoInicial - tamanhoLombriga); // novamente, copia #`s à esquerda da lombriga.
    		novoAquarioLombriga += "0";
    		for (int i = 0; i < tamanhoLombriga - 1; i++)
	    		novoAquarioLombriga += "@";
    		int tamanhoAtual = novoAquarioLombriga.length();
        	for (int i = 0; i < tamanhoAquario - tamanhoAtual; i++)
        		novoAquarioLombriga += "#";
    		lado = 'e';
    		posicaoInicial -= tamanhoLombriga - 1;
        	aquarioLombriga = novoAquarioLombriga;
    	}
    }
    
    void mover() {
    	if (lado == 'e') {
    		if (posicaoInicial == 1)
    			this.virar();
    		else {
    			String novoAquarioLombriga = aquarioLombriga.substring(1, tamanhoAquario) + "#"; // tira o primeiro caractere da string e adiciona ele ao final.
    			posicaoInicial--;
    			aquarioLombriga = novoAquarioLombriga;
    		}
    	}
    	else {
    		if (posicaoInicial == tamanhoAquario)
    			this.virar();
    		else {
    			String novoAquarioLombriga = "#" + aquarioLombriga.substring(0, tamanhoAquario - 1); // tira o último caractere da string e adiciona ele ao começo. 
    			posicaoInicial++;
    			aquarioLombriga = novoAquarioLombriga;
    		}
    	}
    }
    
    String apresenta() {
    	return aquarioLombriga;
    }
}
