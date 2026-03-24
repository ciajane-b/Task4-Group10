public class Phone extends Hardware {
    public Phone(int id, String brand, String model, int specValue) {
        super(id, brand, model, specValue);
    }

    @Override
    public String getSpecDisplay() { 
        return specValue + "MP";
    }
}
