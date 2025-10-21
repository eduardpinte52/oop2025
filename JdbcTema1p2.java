package tema1p2;

import java.sql.*;
import java.util.Properties;

public class JdbcTema1p2 {

    public static void main(String[] args) {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");

        String url = "jdbc:mysql://localhost:8889/t1p2"; 

        try (Connection conn = DriverManager.getConnection(url, connectionProps)) {
           
                   createProdus(conn, 55, "lanterna", "china");
       
            readProduse(conn);
            updateProdus(conn, "lanterna", 60);
            readProduse(conn);
            deleteProdus(conn, "lanterna");
            readProduse(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createProdus(Connection conn, double pret, String produs, String tara) throws SQLException {
        String insertQuery = "INSERT INTO tb_t1p2 (pret, produs, tara) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setDouble(1, pret);
            ps.setString(2, produs);
            ps.setString(3, tara);
            int rows = ps.executeUpdate();
            System.out.println(" Rânduri inserate: " + rows);
        }
    }

    private static void readProduse(Connection conn) throws SQLException {
        String selectQuery = "SELECT * FROM tb_t1p2";
        try (Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(selectQuery)) {

            System.out.println(" Lista produselor:");
            while (rs.next()) {
                int id = rs.getInt("id");
                double pret = rs.getDouble("pret");
                String produs = rs.getString("produs");
                String tara = rs.getString("tara");
                System.out.println(id + "  " + produs + "  " + pret + "  " + tara);
            }
           
        }
    }

    private static void updateProdus(Connection conn, String produs, double pretNou) throws SQLException {
        String updateQuery = "UPDATE tb_t1p2 SET pret = ? WHERE produs = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
            ps.setDouble(1, pretNou);
            ps.setString(2, produs);
            int rows = ps.executeUpdate();
            System.out.println("Rânduri modificate: " + rows);
        }
    }

    private static void deleteProdus(Connection conn, String produs) throws SQLException {
        String deleteQuery = "DELETE FROM tb_t1p2 WHERE produs = ?";
        try (PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
            ps.setString(1, produs);
            int rows = ps.executeUpdate();
            System.out.println(" Rânduri șterse: " + rows);
        }
    }
}
