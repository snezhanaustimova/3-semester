package task2;

public class OneTimePaymentCard extends TransportCard {

    int availableTrips;

    public OneTimePaymentCard (String type, int balance, int availableTrips) {
        super(type, balance);
        this.availableTrips = availableTrips;
    }

    @Override
    public void pay() {

    }

    public String toString (){
        return "Тип карты: " + type + "\nБаланс: " + balance + "\nКол-во доступных поездок: " + availableTrips + "\n";
    }
    /*@Override
    public void replenishment() {

    }*/
}
