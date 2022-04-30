package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int coluna, linha;  // tabuleiro inicia no (0, 0), que representa o canto superior esquerdo.
	private char estado = ' '; // ' ' representa casas inacess�veis do tabuleiro; 'P' representa casas com pe�as; '-' representa casas vazias.
	private static Tabuleiro tabuleiro; // usado para conectar todas as pe�as ao tabuleiro.
	
	public Peca(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
		if (coluna == 2 || (coluna == 3 && linha != 3) || coluna == 4 || linha == 2 || (linha == 3 && coluna != 3) || linha == 4)
			estado = 'P';
		else if (coluna == 3 && linha == 3)
			estado = '-';
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public char getEstado() {
		return estado;
	}
	
	public static void setTabuleiro(Tabuleiro tabuleiro) {
		Peca.tabuleiro = tabuleiro; // conecta pe�as ao tabuleiro.
	}
	
	public void mover(int colunaf, int linhaf) {
		if (tabuleiro.podeMover(coluna, linha, colunaf, linhaf)) {
			estado = '-'; // atualiza casa atual.
			tabuleiro.getTabuleiro()[(linha + linhaf)/2][(coluna + colunaf)/2].estado = '-'; // remove pe�a da casa entre a origem e o destino.
			tabuleiro.getTabuleiro()[linhaf][colunaf].estado = 'P'; // atualiza destino.
		}
	}
}
