package task1;

import java.util.Comparator;
import java.io.*;

public abstract class Employees implements java.io.Serializable  {
    private String name;
    private int id;
    abstract int calculateSalary();

    public Employees(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: #" + getId() + ". Name: " + getName() + ". Salary: " + calculateSalary();
    }
}
