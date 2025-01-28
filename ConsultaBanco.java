import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class ConsultaBanco {

    public static void main(String[] args) {
        try (Connection conexaoBanco = conexao.conectar()) {
            if (conexaoBanco != null) {
                String sql = "SELECT * FROM tarefas";
                PreparedStatement stmt = conexaoBanco.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                while (rs.next()) {

                    java.sql.Date dataLembrete = rs.getDate("data_lembrete");
                    java.sql.Date criadaEm = rs.getDate("criada_em");
                    java.sql.Date atualizadaEm = rs.getDate("atualizada_em");

                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Descrição: "+rs.getString("descricao"));
                    System.out.println("Status: "+rs.getString("status"));
                    System.out.println("Data do Lembrete: "+(dataLembrete != null ? formatter.format(dataLembrete) : "Não definido"));
                    System.out.println("Criada em: "+(criadaEm != null ? formatter.format(criadaEm) : "Não definido"));
                    System.out.println("Atualizada em: "+(atualizadaEm != null ? formatter.format(atualizadaEm) : "Não definido"));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar consulta: " + e.getMessage());
        }
    }
}
