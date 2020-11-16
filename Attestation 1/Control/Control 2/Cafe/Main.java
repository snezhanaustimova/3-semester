package Cafe;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Menu stopMenu = new Menu();
        Dish dish1 = new Dish("Tea", 270, "tea, water, sugar", "450 ml");
        Dish dish2 = new Dish("Soup", 300, "water, potato, meat, carrot, etc.", "300 ml");
        Dish dish3 = new Dish("Rice", 350, "rice, water, egg, solt, meat", "270 g");
        // добавляем блюдо в меню
        menu.add(dish1);
        menu.add(dish2);
        menu.add(dish3);
        // и одно в стоп-лист
        stopMenu.add(dish3);

        System.out.println("Добро пожаловать, вот наше меню:");
        menu.print();
        System.out.println("Блюда на стоп-листе:");
        stopMenu.print();
        System.out.println();

        // создаем заказ
        Order order = new Order(dish1, menu, stopMenu);
        order.append(dish1, menu, stopMenu);
        order.append(dish2, menu, stopMenu);
        order.append(dish3, menu, stopMenu);
        System.out.println("Заказ принят. Уже готовим!");
        System.out.println();
        System.out.println("Ваш чек на сумму " + order.cheque() + " руб.");
    }

}
