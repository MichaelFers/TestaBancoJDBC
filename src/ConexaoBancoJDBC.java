import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBancoJDBC {

	private String login, senha;
	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;

	public ConexaoBancoJDBC(String login, String senha) {

		this.login = login;
		this.senha = senha;

	}

	public boolean conectar() throws SQLException, Exception {

		// Estabelece conexão local
		String url = "jdbc:sqlserver://localhost:1433;databaseName=estudo";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url, login, senha);

		return true;
	}

	public boolean comandoInsert(String comando) throws SQLException {
		st = con.prepareStatement(comando);
		st.execute();

		fecharConexao();
		return true;
	}

	public List<Usuario> comandoSelect(String comando) throws SQLException {
		st = con.prepareStatement(comando);

		rs = st.executeQuery();

		List<Usuario> usuarios = new ArrayList<>();

		while (rs.next()) {
			usuarios.add(new Usuario(rs.getString(2), rs.getInt(3)));
		}
		fecharConexao();
		return usuarios;
	}

	private void fecharConexao() throws SQLException {
		st.close();
		con.close();
	}
}
