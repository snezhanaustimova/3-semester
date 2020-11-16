package task1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        List<Employees> employees = new ArrayList();
        employees.add(new EmployeeWithAFixedSalary("Попов", 111, 28000));
        employees.add(new EmployeeWithAFixedSalary("Иванов", 121, 35000));
        employees.add(new EmployeeWithAFixedSalary("Васильев", 110, 28000));
        employees.add(new EmployeeWithHourlyPay("Ромашкова", 211, 150));
        employees.add(new EmployeeWithHourlyPay("Цветкова", 210, 250));
        employees.add(new EmployeeWithHourlyPay("Киселева", 220, 230));

        System.out.println("Список сотрудников:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
        System.out.println();

        System.out.println("Отсортированный список в порядке уменьшения зарплаты:");
        Comparator salaryComparator = new MinSalaryComparator();
        Collections.sort(employees, salaryComparator);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
        System.out.println();

        System.out.println("Первые 5 фамилий из списка:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ") " + employees.get(i).getName());
        }
        System.out.println();

        System.out.println("Последние 3 идентификатора из списка:");
        for (int i = employees.size() - 1; i > employees.size() - 4; i--) {
            System.out.println("#" + employees.get(i).getId());
        }

        // запись жлементов коллеции в файл
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\JavaObjects.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < employees.size(); i++) {
                oos.writeObject(employees.get(i));
            }
            oos.close();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // чтение
        try {
            FileInputStream fis = new FileInputStream(new File("D:\\JavaObjects.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (int i = 0; i < employees.size(); i++) {
                Employees e1 = (Employees) ois.readObject();
                System.out.println(e1.toString());
            }
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
