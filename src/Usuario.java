
public class Usuario {
	
	private String nome;
	private int anos;
	
	public Usuario(String nome, int anos) {
		this.nome = nome;
		this.anos = anos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnos() {
		return anos;
	}

	public void setAnos(int anos) {
		this.anos = anos;
	}
	
	public String toString() {
		return "Nome: "+nome +", Anos: "+ anos;
	}

}
