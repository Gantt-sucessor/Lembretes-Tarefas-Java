import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class consulta {
    public static void main(String[] args) {
        try (Connection conexaoBanco = conexao.conectar()) {
            if (conexaoBanco != null) {
                String sql = "SELECT * FROM teste";
                PreparedStatement stmt = conexaoBanco.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    System.out.println("Nome: " + rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar consulta: " + e.getMessage());
        }
    }
}
