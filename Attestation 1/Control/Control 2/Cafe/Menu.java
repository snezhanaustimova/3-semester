package Cafe;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    ArrayList<Dish> menu = new ArrayList<>();

    void add(Dish dish) {
        menu.add(dish);
    }

    void remove(Dish dish) {
        menu.remove(dish);
    }

    void print() {
        for (Dish dish: menu) {
            System.out.println("Name: " + dish.name + ". Price: " + dish.price + ". Ingrediens: " + dish.ingrediens + ". Width: " + dish.width);
        }
    }

    boolean contains(Dish dish) {
        return menu.contains(dish);
    }

}
