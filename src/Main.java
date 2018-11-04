import java.sql.*;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String login = "sa";
		String senha = "123";
		ConexaoBancoJDBC conexao = new ConexaoBancoJDBC(login, senha);
		try {

			conexao.conectar();
			conexao.comandoInsert("INSERT INTO UsersTeste (nome, anos) VALUES('Michael', 25)");
			
			conexao.conectar();
			List<Usuario> usuarios = conexao.comandoSelect("SELECT * FROM UsersTeste");
			
			for(Usuario u: usuarios) {
				System.out.println(u);
			}
			

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

}
