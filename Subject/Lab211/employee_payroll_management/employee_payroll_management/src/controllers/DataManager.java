package controllers;

import model.Developer;
import model.Employee;
import model.HR;
import model.Manager;
import model.Tester;
import utils.Inputter;
import utils.Utils;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private final String fileName;

    public DataManager(String fileName) {
        this.fileName = fileName;
    }

    public void load(EmployeeList employeeList) {
        List<String> lines;
        try {
            lines = Utils.readFile(fileName);
        } catch (NoSuchFileException ex) {
            System.out.println("File not found: " + fileName);
            return;
        } catch (IOException ex) {
            System.out.println("Load data failed: " + ex.getMessage());
            return;
        }

        EmployeeList loaded = new EmployeeList();
        int validCount = 0;
        int invalidCount = 0;
        int lineNumber = 0;

        for (String line : lines) {
            lineNumber++;
            if (line.trim().isEmpty()) {
                continue;
            }

            try {
                Employee employee = parseLine(line, loaded);
                loaded.add(employee);
                validCount++;
            } catch (IllegalArgumentException ex) {
                invalidCount++;
                System.out.printf("Invalid line %d: %s%n", lineNumber, ex.getMessage());
            }
        }

        employeeList.clear();
        employeeList.addAll(loaded);
        employeeList.setModified(false);
        System.out.printf("Load completed: %d valid employee(s), %d invalid line(s) skipped.%n",
                validCount, invalidCount);
    }

    private Employee parseLine(String line, EmployeeList loaded) {
        String[] parts = line.split(",", -1);
        if (parts.length != 7) {
            throw new IllegalArgumentException("Expected 7 comma-separated fields.");
        }

        String id = parts[0].trim().toUpperCase();
        String name = parts[1].trim();
        String role = Inputter.normalizeRole(parts[2].trim());
        String status = Inputter.normalizeStatus(parts[6].trim());

        if (!id.matches("E\\d{3}")) {
            throw new IllegalArgumentException("Invalid employee ID format.");
        }
        if (loaded.findById(id) != null) {
            throw new IllegalArgumentException("Duplicate employee ID: " + id);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }
        if (role == null) {
            throw new IllegalArgumentException("Invalid role.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Invalid status.");
        }

        double baseSalary;
        int workingDays;
        double bonus;
        try {
            baseSalary = Double.parseDouble(parts[3].trim());
            workingDays = Integer.parseInt(parts[4].trim());
            bonus = Double.parseDouble(parts[5].trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Salary, working days, or bonus is not numeric.");
        }

        if (Double.isNaN(baseSalary) || Double.isInfinite(baseSalary) || baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be positive.");
        }
        if (workingDays < 0 || workingDays > 26) {
            throw new IllegalArgumentException("Working days must be from 0 to 26.");
        }
        if (Double.isNaN(bonus) || Double.isInfinite(bonus) || bonus < 0) {
            throw new IllegalArgumentException("Bonus must be greater than or equal to 0.");
        }

        return createEmployee(id, name, role, baseSalary, workingDays, bonus, status);
    }

    public boolean save(EmployeeList employeeList) {
        List<String> lines = new ArrayList<String>();
        for (Employee employee : employeeList) {
            lines.add(employee.toDataLine());
        }

        try {
            Utils.writeFile(fileName, lines);
            employeeList.setModified(false);
            System.out.println("Save data successfully!");
            return true;
        } catch (IOException ex) {
            System.out.println("Save data failed: " + ex.getMessage());
            return false;
        }
    }

    public static Employee createEmployee(String id, String name, String role,
                                          double baseSalary, int workingDays,
                                          double bonus, String status) {
        if ("Developer".equalsIgnoreCase(role)) {
            return new Developer(id, name, baseSalary, workingDays, bonus, status);
        }
        if ("Tester".equalsIgnoreCase(role)) {
            return new Tester(id, name, baseSalary, workingDays, bonus, status);
        }
        if ("Manager".equalsIgnoreCase(role)) {
            return new Manager(id, name, baseSalary, workingDays, bonus, status);
        }
        if ("HR".equalsIgnoreCase(role)) {
            return new HR(id, name, baseSalary, workingDays, bonus, status);
        }
        throw new IllegalArgumentException("Unsupported role: " + role);
    }
}
