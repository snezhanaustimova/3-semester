package task2;

public class Atm {

    int costOfOneTrip = 40;
    int paymentPerMonth1 = 265;
    int paymentPerMonth2 = 250;
    int paymentPerMonth3 = 200;

    public TransportCard replenishment(TransportCard transportCard, int money) {
        transportCard.balance = transportCard.balance + money;
        return transportCard;
    };

    public OneTimePaymentCard addTrips(OneTimePaymentCard oneTimePaymentCard, int trips) {
        if (costOfOneTrip * trips <= oneTimePaymentCard.balance) {
            oneTimePaymentCard.availableTrips += trips;
            oneTimePaymentCard.balance -= (costOfOneTrip * trips);
            System.out.println("Кол-во доступных поездок: " + oneTimePaymentCard.availableTrips);
            System.out.println("Баланс: " + oneTimePaymentCard.balance + "\n");
            return oneTimePaymentCard;
        } else {
            System.out.println("На вашем счете недостаточно средств для покупки поездок." +
                    "Пожалуйста, пополните баланс любым удобным для вас способом.");
            return oneTimePaymentCard;
        }
    }

    public CardWithFixedPayment payForMonth(CardWithFixedPayment cardWithFixedPayment) {

        if (cardWithFixedPayment.name == "Социальная") {
            if (cardWithFixedPayment.balance >= paymentPerMonth1) {
                cardWithFixedPayment.balance -= paymentPerMonth1;
                cardWithFixedPayment.active = true;
                System.out.println("Внесена оплата за месяц.");
                System.out.println("Баланс: " + cardWithFixedPayment.balance);
                return cardWithFixedPayment;
            } else {
                System.out.println("На вашем счете недостаточно средств для покупки поездок." +
                        "Пожалуйста, пополните баланс любым удобным для вас способом.");
                return cardWithFixedPayment;
            }

        } else if (cardWithFixedPayment.name == "Школьная") {
            if (cardWithFixedPayment.balance >= paymentPerMonth2) {
                cardWithFixedPayment.balance -= paymentPerMonth2;
                cardWithFixedPayment.active = true;
                System.out.println("Внесена оплата за месяц.");
                System.out.println("Баланс: " + cardWithFixedPayment.balance);
                return cardWithFixedPayment;
            } else {
                System.out.println("На вашем счете недостаточно средств для покупки поездок." +
                        "Пожалуйста, пополните баланс любым удобным для вас способом.");
                return cardWithFixedPayment;
            }

        } else {
            if (cardWithFixedPayment.balance >= paymentPerMonth3) {
                cardWithFixedPayment.balance -= paymentPerMonth3;
                cardWithFixedPayment.active = true;
                System.out.println("Внесена оплата за месяц.");
                System.out.println("Баланс: " + cardWithFixedPayment.balance);
                return cardWithFixedPayment;
            } else {
                System.out.println("На вашем счете недостаточно средств для покупки поездок." +
                        "Пожалуйста, пополните баланс любым удобным для вас способом.");
                return cardWithFixedPayment;
            }
        }
    }
}
