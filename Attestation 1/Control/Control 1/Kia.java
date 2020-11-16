package Car;

public class Kia extends Car {

    private int fuelConsumption;

    public Kia (String color, int maxSpeed, String typeBox, int speed, int price, int fuelConsumption) {
        super (color, maxSpeed, typeBox, speed, price);
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }
}

