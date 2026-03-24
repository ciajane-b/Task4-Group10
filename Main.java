import java.util.*;

Public class Main {
  public static void main(String[] args) {
        System.out.println("=== Hardware Inventory System ===\n");

        // Create repository and fetch data
        HardwareRepository repository = new HardwareRepository();
        List<Hardware> hardwareList = repository.fetchData();

        // Separate maps for laptops and phones
        Map<Integer, Integer> laptopCounts = new HashMap<>();
        Map<Integer, Integer> phoneCounts = new HashMap<>();

        // Display hardware inventory as a formatted table
        System.out.println("\n" + "=".repeat(50));
        System.out.println("| ID | Brand        | Model          | Spec |");
        System.out.println("=".repeat(50));
}
