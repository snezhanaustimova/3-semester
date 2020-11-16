package task1;

public class EmployeeWithAFixedSalary extends Employees {
    double fixedSalary;
    double salary;

    public EmployeeWithAFixedSalary(String name, int id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
        this.salary = salary;
    }

    @Override
    int calculateSalary() {
        this.salary = fixedSalary;
        return (int) fixedSalary;
    }
}
