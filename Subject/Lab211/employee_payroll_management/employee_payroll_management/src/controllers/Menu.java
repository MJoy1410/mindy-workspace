package controllers;

import interfaces.I_Menu;
import utils.Inputter;

import java.util.ArrayList;

public class Menu extends ArrayList<String> implements I_Menu {
    private static final long serialVersionUID = 1L;

    @Override
    public void addItem(String item) {
        add(item);
    }

    @Override
    public void display() {
        System.out.println("\n========== EMPLOYEE PAYROLL MANAGEMENT ==========");
        for (int i = 0; i < size(); i++) {
            System.out.printf("%d. %s%n", i + 1, get(i));
        }
        System.out.println("=================================================");
    }

    @Override
    public int getChoice() {
        return Inputter.getInt("Choose an option: ", 1, size());
    }
}
