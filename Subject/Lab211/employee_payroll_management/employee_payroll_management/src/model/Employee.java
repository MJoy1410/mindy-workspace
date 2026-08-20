package model;

import java.util.Locale;

public abstract class Employee {
    private String id;
    private String name;
    private double baseSalary;
    private int workingDays;
    private double bonus;
    private String status;

    public Employee(String id, String name, double baseSalary, int workingDays, double bonus, String status) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.workingDays = workingDays;
        this.bonus = bonus;
        this.status = status;
    }

    public abstract String getRole();

    public double calculateMonthlyPayroll() {
        if (!"active".equalsIgnoreCase(status)) {
            return 0;
        }
        return (baseSalary / 26.0) * workingDays + bonus;
    }

    public String toDataLine() {
        return String.format(Locale.US, "%s, %s, %s, %.2f, %d, %.2f, %s",
                id, name, getRole(), baseSalary, workingDays, bonus, status);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
