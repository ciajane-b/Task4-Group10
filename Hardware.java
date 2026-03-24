public abstract class Hardware {
    protected int id;
    protected String brand;
    protected String model;
    protected int specValue;

    public Hardware(int id, String brand, String model, int specValue) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.specValue = specValue;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSpecValue() {
        return specValue;
    }

    public abstract String getSpecDisplay();

    @Override
    public String toString() {
        return String.format("| %-3d | %-12s | %-15s | %-15s |",
                id, brand, model, getSpecDisplay());
    }
}

