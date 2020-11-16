package task1;

public class EmployeeWithHourlyPay extends Employees {
    private double hourlyRate;
    private double salary;

    public EmployeeWithHourlyPay(String name, int id, double hourlyRate){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.salary = salary;
    }

    @Override
    int calculateSalary() {
        this.salary = 20.8 * 8 * hourlyRate;
        return (int) salary;
    }
}
