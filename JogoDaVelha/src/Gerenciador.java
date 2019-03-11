import java.util.Random;

import javax.swing.JOptionPane;

public class Gerenciador {
	
	public static void jogoVS(Jogador player1, Jogador player2) {
		
		JogoDaVelha jogo = new JogoDaVelha();
				 
		 Random r = new Random(); 
		 int i = r.nextInt(2); 
		 if(i == 1) {
			 player1.setVez(true);
		 }else {
			 player2.setVez(true);
		 }
		 
		 
		 
		 while(true) {
			 					 
			 System.out.println("*********************  Jogo da Velha *************************");
			 System.out.println(" ");
			 System.out.println(player1.getCaractere() + " : " + player1.getNome() + " - Vitória: " + player1.getVitorias() + (player1.isVez()? " [ Sua Vez ]" : "  [ Aguarde Sua Vez ]"));
			 System.out.println(player2.getCaractere() +  " : " + player2.getNome() + " - Vitória: " + player2.getVitorias() + (player2.isVez()? " [ Sua Vez ]" : " [ Aguarde Sua Vez ]"));
			 int linha = 0; 
			 int coluna = 0; 
			 
			 System.out.println(" ");
			 
			 jogo.imprimeMatriz();
			 
			 System.out.println(" ");
			 
			 do {
				 
				 String valor2 = JOptionPane.showInputDialog("Digte o valor da linha"); 
				 linha = Integer.parseInt(valor2); 
				 valor2 = JOptionPane.showInputDialog("Digte o valor Coluna"); 
				 coluna = Integer.parseInt(valor2); 
				 
				 if(!jogo.verificaVazio(linha, coluna)) {
					 JOptionPane.showMessageDialog(null, "Esta posição já foi preenchida/ou não existe, favor informar uma ainda não preenchida");
				 }
				 
			 }while(!jogo.verificaVazio(linha, coluna));
			 
			 jogo.grade[linha][coluna] = player1.isVez()? String.valueOf(player1.getCaractere()) : String.valueOf(player2.getCaractere());
					
			 
			 
			 if(jogo.verificaVitoria(player1)) {
				 System.out.println("Fim de Jogo");
				 jogo.imprimeMatriz();
				 System.out.println(" ");
				 JOptionPane.showMessageDialog(null, "O Jogador: " + player1.getNome() + " ganhou");
				 player1.setVitorias(player1.getVitorias()+1);
				 
			 }else if(jogo.verificaVitoria(player2)) {
				 System.out.println("Fim de Jogo");
				 jogo.imprimeMatriz();
				 System.out.println(" ");
				 JOptionPane.showMessageDialog(null, "O Jogador: " + player2.getNome() + " ganhou"); 
				 player2.setVitorias(player2.getVitorias()+1);

			 }else if(jogo.verificaEmpate()) {
				 System.out.println("Fim de Jogo");
				 jogo.imprimeMatriz();
				 System.out.println(" "); 
				 JOptionPane.showMessageDialog(null, "O Jogo terminou empatado"); 
				
			  }
			 
			 if(player1.isVez()) {
				 
				 player1.setVez(false);
				 player2.setVez(true);
			 }else {
				 
				 player2.setVez(false);
				 player1.setVez(true);
			 }
			 
			 if(jogo.verificaVitoria(player1) || jogo.verificaVitoria(player2) || jogo.verificaEmpate()) {
				 
				 String string = JOptionPane.showInputDialog("Digite S para jogar novamente"); 
					if(string.equals("S")) {
						jogo = new JogoDaVelha();
					}else {
						break; 
					}
			 }
			 
	}
	
	
 }
	
	
public static void jogoVSComp(Jogador player1, Jogador player2) {
		
		JogoDaVelha jogo = new JogoDaVelha();
				 
		 Random r = new Random(); 
		 int i = r.nextInt(2); 
		 if(i == 1) {
			 player1.setVez(true);
		 }else {
			 player2.setVez(true);
		 }
		 
		 
		 
		 while(true) {
			 					 
			 System.out.println("*********************  Jogo da Velha *************************");
			 System.out.println(" ");
			 System.out.println(player1.getCaractere() + " : " + player1.getNome() + " - Vitória: " + player1.getVitorias() + (player1.isVez()? " [ Sua Vez ]" : "  [ Aguarde Sua Vez ]"));
			 System.out.println(player2.getCaractere() +  " : " + player2.getNome() + " - Vitória: " + player2.getVitorias() + (player2.isVez()? " [ Sua Vez ]" : " [ Aguarde Sua Vez ]"));
			 int linha = 0; 
			 int coluna = 0; 
			 
			 System.out.println(" ");
			 
			 jogo.imprimeMatriz();
			 
			 System.out.println(" ");
			 
			 if(player2.getNome().equals("Computador") && player2.isVez() == true) {
				 String posicao =  jogo.melhorJogada(player2); 
				 linha = Integer.parseInt(posicao.substring(0, 1));
				 coluna = Integer.parseInt(posicao.substring(1));
				 
				
				 
			 }else {
				 do {
					 
					 
					 String valor2 = JOptionPane.showInputDialog("Digte o valor da linha"); 
					 linha = Integer.parseInt(valor2); 
					 valor2 = JOptionPane.showInputDialog("Digte o valor Coluna"); 
					 coluna = Integer.parseInt(valor2); 
				 
				 
				 if(!jogo.verificaVazio(linha, coluna)) {
					 JOptionPane.showMessageDialog(null, "Esta posição já foi preenchida/ou não existe, favor informar uma ainda não preenchida");
				 }
				 
				 }while(!jogo.verificaVazio(linha, coluna));
			 }
			 			 
			 jogo.grade[linha][coluna] = player1.isVez()? String.valueOf(player1.getCaractere()) : String.valueOf(player2.getCaractere());
					
			 if(jogo.verificaVitoria(player1)) {
				 System.out.println("Fim de Jogo");
				 jogo.imprimeMatriz();
				 System.out.println(" ");
				 JOptionPane.showMessageDialog(null, "O Jogador: " + player1.getNome() + " ganhou");
				 player1.setVitorias(player1.getVitorias()+1);
				 
			 }else if(jogo.verificaVitoria(player2)) {
				 System.out.println("Fim de Jogo");
				 jogo.imprimeMatriz();
				 System.out.println(" ");
				 JOptionPane.showMessageDialog(null, "O Jogador: " + player2.getNome() + " ganhou"); 
				 player2.setVitorias(player2.getVitorias()+1);

			 }else if(jogo.verificaEmpate()) {
				 System.out.println("Fim de Jogo");
				 jogo.imprimeMatriz();
				 System.out.println(" "); 
				 JOptionPane.showMessageDialog(null, "O Jogo terminou empatado"); 
				
			  }
			 
			 if(player1.isVez()) {
				 
				 player1.setVez(false);
				 player2.setVez(true);
			 }else {
				 
				 player2.setVez(false);
				 player1.setVez(true);
			 }
			 				 
			
			 
			 if(jogo.verificaVitoria(player1) || jogo.verificaVitoria(player2) || jogo.verificaEmpate()) {
				 
				 String string = JOptionPane.showInputDialog("Digite S para jogar novamente"); 
					if(string.equals("S")) {
						jogo = new JogoDaVelha();
					}else {
						break; 
					}
			 }
			 
	}
	
	
 }
	
}
