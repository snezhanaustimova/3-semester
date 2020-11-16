package Cafe;

import java.util.ArrayList;

public class Order {
    Dish dish;
    Menu menu;
    Menu stopMenu;

    public Order (Dish dish, Menu menu, Menu stopMenu) {
        this.dish = dish;
        this.menu = menu;
        this.stopMenu = stopMenu;
    }
    ArrayList<Dish> order = new ArrayList<>();

    public void append(Dish dish, Menu menu, Menu stopMenu) {
        // проверка на нахождение блюда в меню в принципе и в стоп-листе кафе
        if ((menu.contains(dish)) && (!stopMenu.contains(dish))){
            order.add(dish);
        } else {
            System.out.println("К сожалению, данного блюда нет в меню или оно находится в стоп-листе.");
        }
    }

    public int cheque() {
        int summ = 0;
        for (Dish dish: order) {
            summ = summ + dish.price;
        }
        System.out.println("Чек выписан. Стол закрыт. Приходите еще!");
        return summ;
    }

}
