package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca[][] tabuleiro = new Peca[7][7];
	
	public Tabuleiro() {
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++)
				tabuleiro[i][j] = new Peca(j, i);
	}
	
	public Peca[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public char[][] lerTabuleiro() { // Devolve tabuleiro como matriz de chars.
		char[][] matriz = new char[7][7];
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++)
				matriz[i][j] = tabuleiro[i][j].getEstado();
		return matriz;
	}
	
	public void mover(String posicaoi, String posicaof) {
		int colunai = Integer.valueOf(posicaoi.charAt(0)) - 97; // subtraiu-se valor de a na tabela ASCII.
		int linhai = Integer.valueOf(posicaoi.charAt(1)) - 49; // subtraiu-se valor de 1 na tabela ASCII.
		int colunaf = Integer.valueOf(posicaof.charAt(0)) - 97;
		int linhaf = Integer.valueOf(posicaof.charAt(1)) - 49;
		tabuleiro[linhai][colunai].mover(colunaf, linhaf);
	}
	
	public boolean podeMover(int colunai, int linhai, int colunaf, int linhaf) {
		if (Math.sqrt(Math.pow((colunaf - colunai), 2) + Math.pow((linhaf - linhai), 2)) == 2 && tabuleiro[linhaf][colunaf].getEstado() == '-' && tabuleiro[(linhai + linhaf) / 2][(colunai + colunaf) / 2].getEstado() == 'P')
			// Se a distância entre as peças for 2 e o destino tiver estado '-' e a peça entre as duas tiver estado 'P'.
			return true;
		return false;
	}
}
