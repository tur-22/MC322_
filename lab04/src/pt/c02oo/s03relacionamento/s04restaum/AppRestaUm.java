package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      for (int l = 0; l < commands.length; l++)
         System.out.println(commands[l]);
      
      Tabuleiro tabuleiro = new Tabuleiro();
      Peca.setTabuleiro(tabuleiro); // estabelece comunicação entre peças e tabuleiro.
      char board[][] = tabuleiro.lerTabuleiro();
            
      tk.writeBoard("Tabuleiro inicial", board);
      
      for (int l = 0; l < commands.length; l++) {
    	  String[] pecas = commands[l].split(":");
    	  tabuleiro.mover(pecas[0], pecas[1]);
    	  board = tabuleiro.lerTabuleiro(); // atualiza board após movimento.
    	  tk.writeBoard("source: " + pecas[0] + "; target: " + pecas[1], board);
      }
      
      tk.stop();
   }

}
