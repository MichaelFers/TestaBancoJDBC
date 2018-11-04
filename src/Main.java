import java.sql.*;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		ConexaoBancoJDBC conexao = new ConexaoBancoJDBC("sa", "123");
		try {

			conexao.conectar();
			conexao.comandoInsert("INSERT INTO UsersTeste (nome, anos) VALUES('Michael', '25')");
			
			List<Usuario> usuarios = conexao.comandoSelect("SELECT * FROM UsersTeste");
			
			for(Usuario u: usuarios) {
				System.out.println(u.getNome()+" "+u.getAnos());
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
