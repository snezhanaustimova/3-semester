package Car;

public class Main {
    public static void main(String[] args) {
        Lada lada = new Lada("green", 170, "manual gearbox", 90, 200000, "kalina");
        System.out.println("Модель Lada: " + lada.getMark());
        Kia kia = new Kia("red", 200, "automatic transmission", 75, 350000, 11);
        System.out.println("Расход топлива Kia: " + kia.getFuelConsumption());
    }
}
