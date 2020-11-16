package task1;
import java.util.*;

public class Collection2 {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(random.nextInt(10));
            linkedList.add(random.nextInt(10));
        }

       long start1 = System.currentTimeMillis();
       for (int i = 0; i < 100000; i++) {
            arrayList.get(random.nextInt(arrayList.size()));
       }
       long finish1 = System.currentTimeMillis();
       long elapsed1 = finish1 - start1;
       System.out.println("Прошло времени, мс: " + elapsed1); // 24

       long start2 = System.currentTimeMillis();
       for (int i = 0; i < 100000; i++) {
           linkedList.get(random.nextInt(linkedList.size()));
       }
       long finish2 = System.currentTimeMillis();
       long elapsed2 = finish2 - start2;
       System.out.println("Прошло времени, мс: " + elapsed2); // 228333
    }
}
/*
У меня по результатам замера получилось, что выбор элемента в arrayList произошел за 24 мс,
а в linkedList за 228333 мс. Быстрее, очевидно, arrayList, т.к. это список на основе массива,
а linkedList - связанный список. В первом случае выбор элемента происходит за константное время,
а во втором - путем перебора с начала или конца до нужного элемента.
 */