package Car;

public class Lada extends Car {

    private String mark;

    public Lada (String color, int maxSpeed, String typeBox, int speed, int price, String mark) {
        super (color, maxSpeed, typeBox, speed, price);
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
