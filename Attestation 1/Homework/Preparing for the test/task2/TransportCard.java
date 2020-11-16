package task2;

public abstract class TransportCard {

    String type;
    int balance;

    public TransportCard(String type, int balance) {
        this.type = type;
        this.balance = balance;
    }

    public abstract void pay();
    // public abstract void replenishment();

}

