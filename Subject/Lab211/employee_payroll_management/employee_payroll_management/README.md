# Employee Payroll Management System

LAB211 assignment J1.L.P0037 implemented as a Java 8 console application.

## Source structure

```text
src/
├── controllers/
│   ├── DataManager.java
│   ├── EmployeeList.java
│   └── Menu.java
├── interfaces/
│   ├── I_EmployeeList.java
│   └── I_Menu.java
├── model/
│   ├── Developer.java
│   ├── Employee.java
│   ├── HR.java
│   ├── Manager.java
│   └── Tester.java
├── utils/
│   ├── Inputter.java
│   └── Utils.java
└── view/
    └── EmployeePayrollManagement.java
```

There is intentionally **no `sample` package**. The five main packages are placed directly under `src`.

`Inputter` handles console input and input normalization. `Utils` is responsible for reading and writing files.

## Functions

1. Load employee data from `employees.txt`
2. Add a new employee
3. Update employee name, role, base salary, working days, bonus, or status
4. Remove an employee by ID
5. Search by ID, name, role, or status
6. Calculate monthly payroll for active employees
7. Display employee list
8. Save data to `employees.txt`
9. Quit and ask to save when data changed

## File validation

Invalid lines are skipped and reported with their line number. Duplicate employee IDs in the input file are also treated as invalid. This is important because the supplied data file intentionally contains malformed and duplicate records.

Non-finite numeric values such as `NaN` and `Infinity` are rejected. Numeric data is always saved with a dot decimal separator so files remain portable across system locales. Loading a file while the in-memory employee list has unsaved changes requires confirmation.

## Payroll formula assumption

The assignment requires payroll calculation but does not state a formula. This implementation uses:

```text
monthlyPayroll = (baseSalary / 26) * workingDays + bonus
```

Only employees whose status is `active` are included in the payroll report. Inactive employees have a calculated payroll of `0`.

## OOP

- **Encapsulation:** Employee fields are private and accessed through methods.
- **Abstraction:** `Employee` is an abstract class.
- **Inheritance:** `Developer`, `Tester`, `Manager`, and `HR` extend `Employee`.
- **Polymorphism:** `EmployeeList` stores all role-specific objects through the `Employee` type, while `getRole()` is overridden by each subclass.
- **Interfaces:** `EmployeeList` and `Menu` implement `I_EmployeeList` and `I_Menu`.

## Entry point

Run:

```text
view.EmployeePayrollManagement
```

## Diagrams

PlantUML sources are included in `docs/ClassDiagram.puml` and `docs/ProgramFlow.puml`.
