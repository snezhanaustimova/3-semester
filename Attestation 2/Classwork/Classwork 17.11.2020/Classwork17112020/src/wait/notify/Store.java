package wait.notify;

public class Store {
    private int product = 0;
    public synchronized void get() {
        while(product < 1) {
            try{
                wait();
            } catch (InterruptedException e) {}
        }
        product --;
        System.out.println("Клиент купил 1 товар");
        System.out.printf("Товаров на складке %d \n", product);
        notify();
    }
    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch(InterruptedException e) {}
        }
        product ++;
        System.out.println("Производтель добавил твоар");
        notify();
    }
}

