package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBase {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public int jogoIniciado(String nom, String dif, String ini, String pal, String sta, String let) {
		try (Connection connection = Connections.openConnection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into jogo(player, dificuldade, data_inicio, palavra_palpite, data_fim, estado, letras_digitada) values (?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, dif);
			preparedStatement.setString(3, ini);
			preparedStatement.setString(4, pal);
			preparedStatement.setString(5, this.data());
			preparedStatement.setString(6, sta);
			preparedStatement.setString(7, let);

			int resultado = preparedStatement.executeUpdate();
			System.out.println("Registro inserido");
			
			ResultSet res = preparedStatement.getGeneratedKeys();
			if (res.first()) {
				System.out.println("Codigo gerado: " + res.getInt(1));
			}
			return resultado;
						
		} catch (SQLException e) {
			System.out.println("Conexao nao estabelecida.");
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	// REGISTRO DE DATA DE ENCERRAMENTO DO JOGO
	public String data() {
		Date data = new Date();
		String horaFim = sdf.format(data);
		return horaFim;
	}
}