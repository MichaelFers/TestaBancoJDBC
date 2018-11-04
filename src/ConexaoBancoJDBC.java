import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBancoJDBC {

	private String login, senha;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public ConexaoBancoJDBC(String login, String senha) {

		this.login = login;
		this.senha = senha;
		
	}

	public boolean conectar() throws SQLException, Exception {

		// Estabelece conexão local
		String url = "jdbc:sqlserver://localhost:1433;databaseName=estudo";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		con = DriverManager.getConnection(url, login, senha);
		st = con.createStatement();
		return true;
	}

	public boolean comandoInsert(String comando) throws SQLException {
		st.executeUpdate(comando);
		con.commit();
		return true;
	}

	public List<Usuario> comandoSelect(String comando) throws SQLException { 
		
		
		rs = st.executeQuery(comando);
		
		List<Usuario> usuarios = new ArrayList<>();
		
		//System.out.println(rs.getString("nome"));
		while (rs.next()) {
			usuarios.add(new Usuario(rs.getString(1), rs.getString(2)));
		}
		return usuarios;
	}
}
