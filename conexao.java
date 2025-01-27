import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/euebia";
    private static final String USER = "Gabriel";
    private static final String PASSWORD = "3141";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

}
