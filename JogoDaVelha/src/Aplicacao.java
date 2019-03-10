import java.io.IOException;

import javax.swing.JOptionPane;

public class Aplicacao {
	
	public static void main(String[] args) throws IOException {
		
		
		Jogador player1; 
		Jogador player2;
		int controle = 0; 
		
		do {
			
			System.out.println("*********************  Jogo da Velha *************************");
			
			System.out.println("Informe a opção desejada");
			System.out.println("1 - Vs Player's \n2 - Vs Computador \n3 Sair");
			String valor = JOptionPane.showInputDialog("Digite"); 
			controle = Integer.parseInt(valor); 
			
			 if(controle == 1) {
				 String valor1 = JOptionPane.showInputDialog("Informe o nome do Player 1"); 
				 player1 = new Jogador(valor1, 'X'); 
				 valor1 = JOptionPane.showInputDialog("Informe o nome do Player 2"); 
				 player2 = new Jogador(valor1, 'O');
				 
				 System.out.println(" ");
				 
				 Gerenciador.jogoVS(player1, player2);
				 
				 
				 
			 }else if(controle == 2) {
				 String valor1 = JOptionPane.showInputDialog("Informe o nome do Player 1"); 
				 player1 = new Jogador(valor1, 'X'); 
				 player2 = new Jogador("Computador", 'O');
				 
				 System.out.println(" ");
				 
				 Gerenciador.jogoVSComp(player1, player2);
			 }
			 			
			 
			
		}while(controle != 3);
		
	}
	
}


