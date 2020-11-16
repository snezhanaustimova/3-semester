package task1;

import java.util.Comparator;

public class MinSalaryComparator implements Comparator<Employees> {

    @Override

    public int compare(Employees employee1, Employees employee2) {
        int flag = employee2.calculateSalary() - employee1.calculateSalary();

        // если зарплата равная, то сортируем по фамилии
        if (flag == 0) flag = employee1.getName().compareTo(employee2.getName());
        return flag;
    }
}
