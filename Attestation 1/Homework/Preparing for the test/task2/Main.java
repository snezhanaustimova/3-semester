package task2;

public class Main {
    public static void main(String[] args) {

        // создадим 3 карты: 2 с фикс. оплатой и 1 с разовой
        CardWithFixedPayment card1 = new CardWithFixedPayment("С фикс. оплатой", 250, "Социальная", false);
        CardWithFixedPayment card2 = new CardWithFixedPayment("С фикс. оплатой", 180, "Школьная", false);
        OneTimePaymentCard card3 = new OneTimePaymentCard("Карта с раз. оплатой", 1000, 2);
        // вывод на экран
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());

        // создаем банкомат для пополнения счета
        // *прим.: банкомат может пополнять баланс, вносить ежемесячную плату за поездки и пополнять кол-во поездок для разовых карт
        // моб. приложение может только пополнять баланс
        Atm atm = new Atm();

        // вносим 100 рублей на первую карту
        atm.replenishment(card1, 100);
        // проверим, изменился ли ее баланс
        System.out.println(card1.toString()); // да. Было 250, стало 350

        // создаем терминал. Как я поняла, это что-то в роде турникета.
        // изначально проходимость и т.д. равны 0
        Terminal terminal = new Terminal(0, 0, 0);

        // у первой карты есть средства, но месяц не проплачен. Проверим, сможет ли она пройти
        terminal.check(card1); // нет

        // теперь вносим месячную плату
        atm.payForMonth(card1);

        // проверим вход
        terminal.check(card1); // ура, теперь мы можем пройти

        // проверим, действительно ли у нас списались деньги со счета
        System.out.println(card1.balance); // да
        System.out.println();

        // теперь то же самое, но с разовой картой
        terminal.check(card3); // мы сразу можем пройти, т.к. у нас есть доступные поездки

        // проверим списание поездок
        System.out.println(card3.toString()); // стало на 1 меньше

        // истратим все поездки, затем попробуем 1 раз пройти за меньший приоритет - денежную оплату
        // после этого приобретем еще 5 поездок
        terminal.check(card3);
        terminal.check(card3);
        System.out.println(card3.toString());

        atm.addTrips(card3, 5);
        System.out.println(card3.toString());
        terminal.check(card3);
        System.out.println(card3.toString()); // все работает

        // выведем статистику терминала на данный момент
        System.out.println(terminal.statistic());
    }
}
