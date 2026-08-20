package view;

import controllers.DataManager;
import controllers.EmployeeList;
import controllers.Menu;
import utils.Inputter;

public class EmployeePayrollManagement {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        DataManager dataManager = new DataManager("employees.txt");
        Menu menu = createMenu();

        boolean running = true;
        while (running) {
            menu.display();
            int choice = menu.getChoice();

            switch (choice) {
                case 1:
                    if (employeeList.isModified()
                            && !Inputter.confirm("Unsaved changes will be replaced. Continue loading? (Y/N): ")) {
                        break;
                    }
                    dataManager.load(employeeList);
                    break;
                case 2:
                    employeeList.addEmployee();
                    break;
                case 3:
                    employeeList.updateEmployee();
                    break;
                case 4:
                    employeeList.removeEmployee();
                    break;
                case 5:
                    employeeList.searchEmployee();
                    break;
                case 6:
                    employeeList.calculatePayroll();
                    break;
                case 7:
                    employeeList.displayAll();
                    break;
                case 8:
                    dataManager.save(employeeList);
                    break;
                case 9:
                    if (employeeList.isModified()) {
                        boolean save = Inputter.confirm("Data has changed. Save before exit? (Y/N): ");
                        if (save && !dataManager.save(employeeList)) {
                            boolean exitAnyway = Inputter.confirm("Save failed. Exit anyway? (Y/N): ");
                            if (!exitAnyway) {
                                break;
                            }
                        }
                    }
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    break;
            }
        }
    }

    private static Menu createMenu() {
        Menu menu = new Menu();
        menu.addItem("Load employee data from file");
        menu.addItem("Add a new employee");
        menu.addItem("Update employee information");
        menu.addItem("Remove an employee by ID");
        menu.addItem("Search employees by attribute");
        menu.addItem("Calculate monthly payroll");
        menu.addItem("Display employee list");
        menu.addItem("Save data to file");
        menu.addItem("Quit program");
        return menu;
    }
}
