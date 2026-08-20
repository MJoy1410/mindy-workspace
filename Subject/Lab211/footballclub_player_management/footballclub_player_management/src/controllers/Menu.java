package controllers;

import interfaces.I_Menu;
import utils.Inputter;

import java.util.ArrayList;

public class Menu extends ArrayList<String> implements I_Menu {
    @Override
    public void addItem(String item) {
        add(item);
    }

    @Override
    public void showMenu() {
        System.out.println("\n========== FOOTBALL CLUB & PLAYER MANAGEMENT ==========");
        for (int i = 0; i < size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, get(i));
        }
        System.out.println("=======================================================");
    }

    @Override
    public int getChoice() {
        return Inputter.inputInt("Choose an option: ", 1, size());
    }
}
