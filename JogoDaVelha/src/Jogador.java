
public class Jogador {
	String nome; 
	char caractere;
	boolean vez;
	int vitorias; 
	
	public Jogador(String nome, char caractere) {
		this.nome = nome;
		this.caractere = caractere;
		this.vez = false; 
		this.vitorias = 0; 
	}
	
	public Jogador() {
		this.nome = " ";
		this.caractere = ' ';
		this.vez = false; 
		this.vitorias = 0; 
	}
	
	
	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public boolean isVez() {
		return vez;
	}

	public void setVez(boolean vez) {
		this.vez = vez;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getCaractere() {
		return caractere;
	}
	public void setCaractere(char caractere) {
		this.caractere = caractere;
	} 
	
	
}
