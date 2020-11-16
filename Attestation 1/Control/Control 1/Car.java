package Car;

public class Car {

    private String color;
    private int maxSpeed;
    private String typeBox;
    private int speed;
    private int price;

    public Car(String color, int maxSpeed, String typeBox, int speed, int price) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.typeBox = typeBox;
        this.speed = speed;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getTypeBox() {
        return typeBox;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }

    public String start() {
        return ("Запуск автомобиля.");
    }

    public String stop() {
        return ("Машина остановлена.");
    }

    public int accelerate(int speed) {
        speed = maxSpeed;
        return speed;
    }
}
