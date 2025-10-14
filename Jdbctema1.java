package tema1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbctema1 {

    public static void main(String[] args) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "root");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:8889/tema1",
                connectionProps);

        // Ștergere rânduri cu id = 2 și 3
        Statement sDelete = conn.createStatement();
        String deleteQuery = "DELETE FROM tb_tema1 WHERE id IN (2, 3, 4, 5)";
        int rowsDeleted = sDelete.executeUpdate(deleteQuery);
        System.out.println("Rânduri șterse: " + rowsDeleted);
        sDelete.close();

        // Primul INSERT
        Statement s1 = conn.createStatement();
        String insertQuery1 = "INSERT INTO tb_tema1 (id, varsta, nume, oras) VALUES (2, 25, 'Andreea', 'Cluj')";
        int rowsInserted1 = s1.executeUpdate(insertQuery1);
        System.out.println("Rânduri inserate: " + rowsInserted1);
        s1.close();
        

        // Al doilea INSERT
        Statement s2 = conn.createStatement();
        String insertQuery2 = "INSERT INTO tb_tema1 (id, varsta, nume, oras) VALUES (3, 15, 'Marcus', 'Gherla')";
        int rowsInserted2 = s2.executeUpdate(insertQuery2);
        System.out.println("Rânduri inserate: " + rowsInserted2);
        s2.close();
        
        Statement s3= conn.createStatement();
        String insertQuery3 = "INSERT INTO tb_tema1 (id, varsta, nume, oras) VALUES (4, 33, 'Alex', 'Viena')";
        int rowsInserted3 = s3.executeUpdate(insertQuery3);
        System.out.println("Rânduri inserate: " + rowsInserted3);
        s3.close(); 

        Statement s4= conn.createStatement();
        String insertQuery4 = "INSERT INTO tb_tema1 (id, varsta, nume, oras) VALUES (5, 44, 'Ghita', 'Varfurile')";
        int rowsInserted4 = s4.executeUpdate(insertQuery4);
        System.out.println("Rânduri inserate: " + rowsInserted4);
        s4.close();
        
        Statement s5 = conn.createStatement();
        String updateQuery = "UPDATE tb_tema1 SET oras = 'Satu Mare' WHERE id = 2";
        int rowsUpdated = s5.executeUpdate(updateQuery);
        System.out.println("Rânduri actualizate: " + rowsUpdated);
        s5.close();
        conn.close();
    }
}
