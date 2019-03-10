public class JogoDaVelha {
	
	String grade[][] = new String[3][3];
	int condicaoVitoria[] = new int[8]; 

	public JogoDaVelha() {
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade.length; j++) {
				this.grade[i][j] = " "; 
			}
		}
		
		for (int i = 0; i < condicaoVitoria.length; i++) {
			this.condicaoVitoria[i] = 0; 
		}
	}
	
	public void imprimeMatriz() {
		
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade.length; j++) {
				if(j < 2) {
					System.out.print(" " + this.grade[i][j] + " | ");
				}else {
					System.out.print(" " + this.grade[i][j] + " ");
				}
				
			}
			System.out.println("");
			if(i < 2) {
				System.out.println("-------------");
			}
		}
	}
	
	public boolean verificaGradeCompleta() {
		
	 
		int contadorCaractere = 0;
		
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade.length; j++) {
				if(this.grade[i][j].equals(" ")) {
					contadorCaractere += 1; 
				}
			}
		}
		
		if(contadorCaractere > 0) {
			return false; 
		}else {
			return true; 
		}
		
	}
	
	public boolean verificaVazio(int linha, int coluna) {
		
		boolean validador = false; 
		
		if(linha <= grade.length && linha >= 0 && coluna <= grade.length && coluna >= 0) {
			if(this.grade[linha][coluna] == " ") {
				validador = true;
			}
		}
		
		return validador; 
	}
	
	public Boolean verificaVitoria(Jogador jogadorAtual) {
		boolean validaVitoria = false;
		
		for (int i = 0; i < condicaoVitoria.length; i++) {
			this.condicaoVitoria[i] = 0; 
		}
			
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade.length; j++) {
	
				if(i == 0 && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[0] += 1; 
				}
				if(i == 1 && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[1] += 1; 
				}
				if(i == 2 && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[2] += 1; 
				}
				if(j == 0 && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[3] += 1; 
				}
				if(j == 1 && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[4] += 1; 
				}
				if(j == 2 && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[5] += 1; 
				}
				if(i == j && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[6] += 1; 
				}
				if((i + j == 2) && jogadorAtual.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[7] += 1; 
				}
			}
			
			if(verificaGanhou()) {
				validaVitoria = true; 
				break; 
			}
		}
		
		
			
		
		return validaVitoria; 
	}
	
	public boolean verificaGanhou() {
		
		
		
		boolean validador = false; 
		
		for (int i = 0; i < condicaoVitoria.length; i++) {
			if(this.condicaoVitoria[i] == 3) {
				validador = true; 
				break; 
			}
		}
		
		
		
		return validador;
	}
	
	
	public boolean verificaEmpate() {
		boolean validador = false; 
		
		if(verificaGradeCompleta()) {
			if(!verificaGanhou()) {
				validador = true; 
				
			}
		}
		
		return validador; 
	}
	
	public String melhorJogada(Jogador player) {
		
		for (int i = 0; i < condicaoVitoria.length; i++) {
			this.condicaoVitoria[i] = 0; 
		}
		
		String posicao = null;
			
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade.length; j++) {
	
				if(i == 0 && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[0] += 1; 
				}
				if(i == 1 && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[1] += 1; 
				}
				if(i == 2 && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[2] += 1; 
				}
				if(j == 0 && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[3] += 1; 
				}
				if(j == 1 && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[4] += 1; 
				}
				if(j == 2 && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[5] += 1; 
				}
				if(i == j && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[6] += 1; 
				}
				if((i + j == 2) && player.getCaractere() == this.grade[i][j].charAt(0)) {
					this.condicaoVitoria[7] += 1; 
				}
			}
			
	}
		
		int maior = -1; 
		
		for (int i = 0; i < condicaoVitoria.length; i++) {
			
			if(condicaoVitoria[i] >= maior) {
				switch (i) {
				case 0:
					if(!(this.grade[0][0].charAt(0) == 'X' || this.grade[0][1].charAt(0) == 'X' || this.grade[0][2].charAt(0) == 'X')) {
						maior = i; 
					}
					break;
				case 1:
					if(!(this.grade[1][0].charAt(0) == 'X' || this.grade[1][1].charAt(0) == 'X' || this.grade[1][2].charAt(0) == 'X')) {
						maior = i; 
					}
					break;
				case 2:
					if(!(this.grade[2][0].charAt(0) == 'X' || this.grade[2][1].charAt(0) == 'X' || this.grade[2][2].charAt(0) == 'X')) {
						maior = i; 
					}
					break; 
				case 3:
					if(!(this.grade[0][0].charAt(0) == 'X' || this.grade[1][0].charAt(0) == 'X' || this.grade[2][0].charAt(0) == 'X')) {
						maior = i; 
					}
					break; 
				case 4:
					if(!(this.grade[0][1].charAt(0) == 'X' || this.grade[1][1].charAt(0) == 'X' || this.grade[2][1].charAt(0) == 'X')) {
						maior = i; 
					}
					break; 
				case 5:
					if(!(this.grade[0][2].charAt(0) == 'X' || this.grade[1][2].charAt(0) == 'X' || this.grade[2][2].charAt(0) == 'X')) {
						maior = i; 
					}
					break; 
				case 6:
					if(!(this.grade[0][0].charAt(0) == 'X' || this.grade[1][1].charAt(0) == 'X' || this.grade[2][2].charAt(0) == 'X')) {
						maior = i; 
					}
					break; 
				case 7:
					if((this.grade[0][2].charAt(0) == 'X' || this.grade[1][1].charAt(0) == 'X' || this.grade[2][0].charAt(0) == 'X')) {
						maior = i;
					}
					break; 
				default:
					break;
				}
			}
			
		}
		
		if(maior < 0) {
			for (int i = 0; i < grade.length; i++) {
				for (int j = 0; j < grade.length; j++) {
					if(verificaVazio(i, j)) {
						posicao =  String.valueOf(i)+String.valueOf(j); 
					}
				}
			}
		}else {
			switch (maior) {
			case 0:
				if(verificaVazio(0, 0)) {
					posicao = String.valueOf(0)+String.valueOf(0);
				}else if(verificaVazio(0, 1)){
					posicao = String.valueOf(0)+String.valueOf(1);
				}else {
					posicao =  String.valueOf(0)+String.valueOf(2);
				}
				break;
			case 1:
				if(verificaVazio(1, 0)) {
					posicao = String.valueOf(1)+String.valueOf(0);
				}else if(verificaVazio(1, 1)){
					posicao = String.valueOf(1)+String.valueOf(1);
				}else {
					posicao =  String.valueOf(1)+String.valueOf(2);
				}
				break;
			case 2:
				if(verificaVazio(2, 0)) {
					posicao = String.valueOf(2)+String.valueOf(0);
				}else if(verificaVazio(2, 1)){
					posicao = String.valueOf(2)+String.valueOf(1);
				}else {
					posicao =  String.valueOf(2)+String.valueOf(2);
				}
			case 3:
				if(verificaVazio(0, 0)) {
					posicao = String.valueOf(0)+String.valueOf(0);
				}else if(verificaVazio(1, 0)){
					posicao = String.valueOf(1)+String.valueOf(0);
				}else {
					posicao =  String.valueOf(2)+String.valueOf(0);
				}
				break;
			case 4:
				if(verificaVazio(0, 1)) {
					posicao = String.valueOf(0)+String.valueOf(1);
				}else if(verificaVazio(1, 1)){
					posicao = String.valueOf(1)+String.valueOf(1);
				}else {
					posicao =  String.valueOf(2)+String.valueOf(1);
				}
				break;
			case 5:
				if(verificaVazio(0, 2)) {
					posicao = String.valueOf(0)+String.valueOf(2);
				}else if(verificaVazio(1, 2)){
					posicao = String.valueOf(1)+String.valueOf(2);
				}else {
					posicao =  String.valueOf(2)+String.valueOf(2);
				}
				break;
			case 6:
				if(verificaVazio(0, 0)) {
					posicao = String.valueOf(0)+String.valueOf(0);
				}else if(verificaVazio(1, 1)){
					posicao = String.valueOf(1)+String.valueOf(1);
				}else {
					posicao =  String.valueOf(2)+String.valueOf(2);
				}
				break;
			case 7:
				if(verificaVazio(0, 2)) {
					posicao = String.valueOf(0)+String.valueOf(2);
				}else if(verificaVazio(1, 1)){
					posicao = String.valueOf(1)+String.valueOf(1);
				}else {
					posicao =  String.valueOf(2)+String.valueOf(0);
				}
				break;
			default:
				break;
			}
		}
	
	return posicao; 
		
	}
	
	
}
