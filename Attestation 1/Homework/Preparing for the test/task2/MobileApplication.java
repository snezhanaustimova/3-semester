package task2;

public class MobileApplication {

    public TransportCard replenishment(TransportCard transportCard, int money) {
        transportCard.balance = transportCard.balance + money;
        return transportCard;
    };

}
