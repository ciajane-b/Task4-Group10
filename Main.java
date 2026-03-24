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

      for (Hardware item : hardwareList) {
          System.out.println(item.toString());

          // Count by type using separate maps
          if (item instanceof Laptop) {
              int specValue = item.getSpecValue();
              laptopCounts.put(specValue, laptopCounts.getOrDefault(specValue, 0) + 1);
          } else {
              int specValue = item.getSpecValue();
              phoneCounts.put(specValue, phoneCounts.getOrDefault(specValue, 0) + 1);
          }
        }
    
        System.out.println("=".repeat(50));

        // Display audit report
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              AUDIT REPORT");
        System.out.println("=".repeat(50));

        // Display laptops first (sorted by spec value)
        List<Integer> sortedLaptopSpecs = new ArrayList<>(laptopCounts.keySet());
        Collections.sort(sortedLaptopSpecs);
        for (int spec : sortedLaptopSpecs) {
            int count = laptopCounts.get(spec);
            System.out.printf("total number of %dGB Laptop : %d%n", spec, count);
        }

        // Display phones next (sorted by spec value)
        List<Integer> sortedPhoneSpecs = new ArrayList<>(phoneCounts.keySet());
        Collections.sort(sortedPhoneSpecs);
        for (int spec : sortedPhoneSpecs) {
            int count = phoneCounts.get(spec);
            System.out.printf("total number of %dMP Phone : %d%n", spec, count);
        }

        System.out.println("=".repeat(50));

        repository.close();
    }
}
