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
