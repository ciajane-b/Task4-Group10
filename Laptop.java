public class Laptop extends Hardware {
    public Laptop(int id, String brand, String model, int specValue) {
        super(id, brand, model, specValue);
    }

    @Override
    public String getSpecDisplay() {
        return specValue + "GB";
    }
}
