package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public CreateDB () {
        String url = "jdbc:sqlite:armazenamento.db";

        try (
                Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão com o banco de dados SQLite estabelecida.");

                // Criar a tabela carros
                Statement stmt = conn.createStatement();
                String createCarrosTable = "CREATE TABLE IF NOT EXISTS carros (id INTEGER PRIMARY KEY AUTOINCREMENT, marca TEXT, ano TEXT, modelo TEXT, preco INT, nPortas INT)";
                stmt.execute(createCarrosTable);

                // Criar a tabela motos
                String createMotosTable = "CREATE TABLE IF NOT EXISTS motos (id INTEGER PRIMARY KEY AUTOINCREMENT, marca TEXT, ano TEXT, modelo TEXT, preco INT, cilindradas INT)";
                stmt.execute(createMotosTable);

                System.out.println("Tabelas 'carros' e 'motos' criadas (se não existirem).");

                // Fechar a conexão com o banco de dados
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar ou conectar ao banco de dados SQLite: " + e.getMessage());
        }
    }
}
