package task2;

public class CardWithFixedPayment extends TransportCard {

    String name;
    boolean active;

    public CardWithFixedPayment (String type, int balance, String name, boolean active) {
        super(type, balance);
        this.name = name;
        this.active = active;
    }

    @Override
    public void pay() {

    }

    public String toString (){
        if (active == true) {
            return "Тип карты: " + type + "\nВид: " + name + "\nБаланс: " + balance + "\nМесяц оплачен.\n";
        } else {
            return "Тип карты: " + type + "\nВид: " + name + "\nБаланс: " + balance + "\nМесяц не оплачен.\n";
        }
    }
    /*@Override
    public void replenishment() {

    }*/

}
