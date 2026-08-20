package controllers;

import interfaces.I_EmployeeList;
import model.Employee;
import utils.Inputter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList extends ArrayList<Employee> implements I_EmployeeList {
    private static final long serialVersionUID = 1L;

    private boolean modified;

    public Employee findById(String id) {
        if (id == null) {
            return null;
        }
        for (Employee employee : this) {
            if (employee.getId().equalsIgnoreCase(id.trim())) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addEmployee() {
        String id;
        while (true) {
            id = Inputter.getNonEmptyString("Employee ID (E followed by 3 digits): ").toUpperCase();
            if (!id.matches("E\\d{3}")) {
                System.out.println("Invalid employee ID format!");
                continue;
            }
            if (findById(id) != null) {
                System.out.println("This employee ID already exists!");
                continue;
            }
            break;
        }

        String name = Inputter.getNonEmptyString("Employee name: ");
        String role = Inputter.getRole("Role (Developer/Tester/Manager/HR): ");
        double baseSalary = Inputter.getDouble("Base salary: ", 0, false);
        int workingDays = Inputter.getInt("Working days (0-26): ", 0, 26);
        double bonus = Inputter.getDouble("Bonus: ", 0, true);
        String status = Inputter.getStatus("Status (active/inactive): ");

        add(DataManager.createEmployee(id, name, role, baseSalary, workingDays, bonus, status));
        modified = true;
        System.out.println("Add employee successfully!");
    }

    @Override
    public void updateEmployee() {
        String id = Inputter.getNonEmptyString("Employee ID to update: ").toUpperCase();
        Employee current = findById(id);
        if (current == null) {
            System.out.println("This employee does not exist!");
            return;
        }

        System.out.println("Press Enter to skip a field.");
        String name = Inputter.getOptionalString("New employee name: ");
        String role = Inputter.getOptionalRole("New role (Developer/Tester/Manager/HR): ");
        Double salary = Inputter.getOptionalDouble("New base salary: ", 0, false);
        Integer workingDays = Inputter.getOptionalInt("New working days (0-26): ", 0, 26);
        Double bonus = Inputter.getOptionalDouble("New bonus: ", 0, true);
        String status = Inputter.getOptionalStatus("New status (active/inactive): ");

        String updatedName = name.isEmpty() ? current.getName() : name;
        String updatedRole = role == null ? current.getRole() : role;
        double updatedSalary = salary == null ? current.getBaseSalary() : salary;
        int updatedWorkingDays = workingDays == null ? current.getWorkingDays() : workingDays;
        double updatedBonus = bonus == null ? current.getBonus() : bonus;
        String updatedStatus = status == null ? current.getStatus() : status;

        boolean changed = !updatedName.equals(current.getName())
                || !updatedRole.equals(current.getRole())
                || Double.compare(updatedSalary, current.getBaseSalary()) != 0
                || updatedWorkingDays != current.getWorkingDays()
                || Double.compare(updatedBonus, current.getBonus()) != 0
                || !updatedStatus.equals(current.getStatus());
        if (!changed) {
            System.out.println("No changes were made.");
            return;
        }

        Employee updated = DataManager.createEmployee(
                current.getId(), updatedName, updatedRole,
                updatedSalary, updatedWorkingDays, updatedBonus, updatedStatus);
        set(indexOf(current), updated);
        modified = true;
        System.out.println("Update employee successfully!");
    }

    @Override
    public void removeEmployee() {
        String id = Inputter.getNonEmptyString("Employee ID to remove: ").toUpperCase();
        Employee employee = findById(id);
        if (employee == null) {
            System.out.println("This employee does not exist!");
            return;
        }
        remove(employee);
        modified = true;
        System.out.println("Remove employee successfully!");
    }

    @Override
    public void searchEmployee() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by name");
        System.out.println("3. Search by role");
        System.out.println("4. Search by status");
        int choice = Inputter.getInt("Choose search attribute: ", 1, 4);
        String keyword = Inputter.getNonEmptyString("Search value: ");

        List<Employee> result = new ArrayList<Employee>();
        for (Employee employee : this) {
            boolean match = false;
            switch (choice) {
                case 1:
                    match = employee.getId().equalsIgnoreCase(keyword);
                    break;
                case 2:
                    match = employee.getName().toLowerCase().contains(keyword.toLowerCase());
                    break;
                case 3:
                    match = employee.getRole().equalsIgnoreCase(keyword);
                    break;
                case 4:
                    match = employee.getStatus().equalsIgnoreCase(keyword);
                    break;
                default:
                    break;
            }
            if (match) {
                result.add(employee);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No matching employee found!");
        } else {
            displayTable(result);
        }
    }

    @Override
    public void calculatePayroll() {
        boolean found = false;
        System.out.println("\n============================== MONTHLY PAYROLL ==============================");
        System.out.printf("%-6s %-22s %-11s %12s %8s %10s %14s%n",
                "ID", "Name", "Role", "Base Salary", "Days", "Bonus", "Total Salary");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Employee employee : this) {
            if ("active".equalsIgnoreCase(employee.getStatus())) {
                found = true;
                System.out.printf("%-6s %-22s %-11s %12.2f %8d %10.2f %14.2f%n",
                        employee.getId(), employee.getName(), employee.getRole(),
                        employee.getBaseSalary(), employee.getWorkingDays(),
                        employee.getBonus(), employee.calculateMonthlyPayroll());
            }
        }
        if (!found) {
            System.out.println("No active employee found!");
        }
    }

    @Override
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Employee list is empty!");
            return;
        }
        displayTable(this);
    }

    private void displayTable(List<Employee> employees) {
        System.out.println("\n================================ EMPLOYEE LIST ================================");
        System.out.printf("%-6s %-22s %-11s %12s %8s %10s %-10s%n",
                "ID", "Name", "Role", "Base Salary", "Days", "Bonus", "Status");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Employee employee : employees) {
            System.out.printf("%-6s %-22s %-11s %12.2f %8d %10.2f %-10s%n",
                    employee.getId(), employee.getName(), employee.getRole(),
                    employee.getBaseSalary(), employee.getWorkingDays(),
                    employee.getBonus(), employee.getStatus());
        }
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }
}
