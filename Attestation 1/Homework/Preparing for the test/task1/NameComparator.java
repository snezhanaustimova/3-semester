package task1;

import java.util.Comparator;

public class NameComparator implements Comparator<Employees> {

    @Override

    public int compare(Employees employee1, Employees employee2) {
        return employee1.getName().compareTo(employee2.getName());
    }
}
