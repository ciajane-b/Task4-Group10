import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HardwareRepository {
    private List<Hardware> hardwareList;
    private static final String DB_URL = "jdbc:sqlite:hardware.db";

    public HardwareRepository() {
        hardwareList = new ArrayList<>();
        initializeDatabase();
    }

private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Create table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS hardware (" +
                    "id INTEGER PRIMARY KEY, " +
                    "brand TEXT NOT NULL, " +
                    "model TEXT NOT NULL, " +
                    "specValue INTEGER NOT NULL, " +
                    "type TEXT NOT NULL)";
            stmt.executeUpdate(createTableSQL);

            // Check if table is empty before inserting
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM hardware");
            int count = rs.getInt(1);

            if (count == 0) {
                String insertSQL = "INSERT INTO hardware (id, brand, model, specValue, type) VALUES " +
                        "(1, 'Dell', 'XPS 13', 16, 'Laptop'), " +
                        "(2, 'Samsung', 'S24', 50, 'Phone'), " +
                        "(3, 'Apple', 'MacBook Pro', 32, 'Laptop'), " +
                        "(4, 'Apple', 'iPhone 15', 48, 'Phone'), " +
                        "(5, 'ASUS', 'Zenbook', 16, 'Laptop'), " +
                        "(6, 'Google', 'Pixel 8', 50, 'Phone'), " +
                        "(7, 'Lenovo', 'Legion', 32, 'Laptop'), " +
                        "(8, 'Huawei', 'P60', 48, 'Phone'), " +
                        "(9, 'HP', 'Spectre', 16, 'Laptop'), " +
                        "(10, 'Sony', 'Xperia', 16, 'Phone')";
                stmt.executeUpdate(insertSQL);
                System.out.println("Database initialized with sample data.");
            }

    } catch (SQLException e) {
            System.err.println("Database initialization error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Hardware> fetchData() {
        hardwareList.clear();

        String query = "SELECT * FROM hardware ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int specValue = rs.getInt("specValue");
                String type = rs.getString("type");

                Hardware hardware;
                if ("Laptop".equalsIgnoreCase(type)) {
                    hardware = new Laptop(id, brand, model, specValue);
                } else {
                    hardware = new Phone(id, brand, model, specValue);
                }

                hardwareList.add(hardware);
            }

            System.out.println("Fetched " + hardwareList.size() + " records from database.");

         } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }

        return hardwareList;
    }

    public void close() {
        System.out.println("Database connection closed.");
    }
}
