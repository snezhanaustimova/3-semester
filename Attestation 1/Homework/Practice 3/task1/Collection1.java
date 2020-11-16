package task1;
import java.util.*;

public class Collection1 {
    public static <T> Collection<T> removeDuplicates(Collection<T> coll) {
        return new HashSet<>(coll);
    }
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(2);
        myList.add(9);
        myList.add(9);
        myList.add(9);
        myList.add(10);
        myList.add(4);
        myList.add(2);
        Collection<Integer> liist = Collection1.removeDuplicates(myList);
        System.out.println(liist);
    }
}
