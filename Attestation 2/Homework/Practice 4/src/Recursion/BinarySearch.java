package Recursion;

import java.util.Arrays;

public class BinarySearch {

    // реализация рекурсивного двоичного поиска
    public static int binarySearch(int array[], int start, int end, int item) {

        // условие остановки
        if (end >= start) {

            // находим середину массива
            int median = start + (end - start) / 2;

            // если середина явл-ся искомым элементом, то возвращаем его индекс
            if (array[median] == item) {
                return median;
            }

            // если середина больше искомого элемента,
            // то повторно вызываем метод с меньшей половиной массива
            if (array[median] > item) {
                return binarySearch(array, start, median - 1, item);
            }

            // иначе с большей
            return binarySearch(array, median + 1, end, item);
        }

        // если искомого элемента вообще нет в массиве, то -1
        return -1;
    }

    // поиск методом перебора - линейный поиск
    public static int linearSearch(int array[], int item) {

        for (int i = 0; i < array.length; i++) {
            // обычное поэтапное сравнивание элементов
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    // вывод
    public static void print(int item, int index) {
        if (index == -1){
            System.out.println("Элемент " + item + " не найден.");
        }
        else {
            System.out.println("Элемент " + item + " найден под номером " + index);
        }
    }

    public static void main(String[] args) {
        int size = 1000000; // размер массива
        int item = 35;      // искомое число

        // генерация целочисленного массива в интервале от -10000 до 10000
        int[] myarray = new int[size];
        for (int i = 0; i < myarray.length; i++) {
            myarray[i] = (int) (Math.random() * 20001) - 10000;
        }

        // без сортировки двоичный поиск работать не будет, поэтому:
        Arrays.sort(myarray);

        // замеряем время на отведенную операцию в наносекунах - так точнее
        long start1 = System.nanoTime();
        int index1 = binarySearch(myarray, 0, size, item);
        long finish1 = System.nanoTime();
        long elapsed1 = finish1 - start1;
        System.out.println("Прошло времени, нс: " + elapsed1);
        print(item, index1);
        System.out.println();

        long start2 = System.nanoTime();
        int index2 = linearSearch(myarray, item);
        long finish2 = System.nanoTime();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени, нс: " + elapsed2);
        print(item, index2);
    }
}
