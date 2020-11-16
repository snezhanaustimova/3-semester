package task2;

public class Terminal {

    int priceOfPassage = 55;
    int passability;
    int earnedMoney;
    int pieceTrips;

    public Terminal (int passability, int earnedMoney, int pieceTrips) {
        this.passability = passability;
        this.earnedMoney = earnedMoney;
        this.pieceTrips = pieceTrips;
    }

    public void check(CardWithFixedPayment cardWithFixedPayment) {
        if (cardWithFixedPayment.active == true) {
            System.out.println("Проходите.\n");
            passability += 1;
        } else {
            System.out.println("Вы не оплатили данный месяц.\n");
        }
    }

    public void check(OneTimePaymentCard oneTimePaymentCard) {
        if (oneTimePaymentCard.availableTrips >= 1) {
            oneTimePaymentCard.availableTrips -= 1;
            System.out.println("Проходите.\n");
            passability += 1;
        } else if (oneTimePaymentCard.balance >= priceOfPassage) {
            oneTimePaymentCard.balance -= priceOfPassage;
            System.out.println("Списана сумма в 55 руб. Можете пройти.\n");
            passability += 1;
            earnedMoney += priceOfPassage;
            pieceTrips += 1;
        } else {
            System.out.println("На карте нет доступных поездок. " +
                    "Баланс карты недостаточный для оплаты 1 поездки.\n");
        }
    }

    public String statistic() {
        return "СТАТИСТИКА ТЕРМИНАЛА НА ТЕКУЩИЙ МОМЕНТ: \n" +
                "Проходимость: " + passability + "\nСнято поштучных: " + pieceTrips + "\nЗаработано денег: " + earnedMoney;
    }

}
