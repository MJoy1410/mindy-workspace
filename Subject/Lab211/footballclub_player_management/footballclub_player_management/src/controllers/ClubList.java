package controllers;

import interfaces.I_ClubList;
import model.Club;
import utils.Inputter;

import java.util.ArrayList;
import java.util.List;

public class ClubList extends ArrayList<Club> implements I_ClubList {
    public Club findById(String id) {
        for (Club club : this) {
            if (club.getId().equalsIgnoreCase(id)) {
                return club;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        displayTable(this);
    }

    @Override
    public boolean addNewClub() {
        String id = Inputter.inputClubId("Club ID: ");
        if (findById(id) != null) {
            System.out.println("This club ID already exists!");
            System.out.println("Add club failed!");
            return false;
        }

        String name = Inputter.inputNotEmpty("Club name: ");
        String sponsor = Inputter.inputNotEmpty("Sponsor brand: ");
        double budget = Inputter.inputPositiveDouble("Budget (million EUR): ");
        add(new Club(id, name, sponsor, budget));
        System.out.println("Add club successfully!");
        return true;
    }

    @Override
    public void searchById() {
        String id = Inputter.input("Club ID: ");
        Club club = findById(id);
        if (club == null) {
            System.out.println("This club does not exist!");
            return;
        }
        List<Club> result = new ArrayList<Club>();
        result.add(club);
        displayTable(result);
    }

    @Override
    public boolean updateById() {
        String id = Inputter.input("Club ID: ");
        Club club = findById(id);
        if (club == null) {
            System.out.println("This club does not exist!");
            return false;
        }

        boolean changed = false;
        String name = Inputter.input("New club name (Enter to skip): ");
        if (!name.isEmpty() && !name.equals(club.getName())) {
            club.setName(name);
            changed = true;
        }

        String sponsor = Inputter.input("New sponsor brand (Enter to skip): ");
        if (!sponsor.isEmpty() && !sponsor.equals(club.getSponsorBrand())) {
            club.setSponsorBrand(sponsor);
            changed = true;
        }

        Double budget = Inputter.inputOptionalPositiveDouble("New budget (Enter to skip): ");
        if (budget != null && Double.compare(budget, club.getBudget()) != 0) {
            club.setBudget(budget);
            changed = true;
        }

        System.out.println(changed ? "Update club successfully!" : "No club information was changed.");
        return changed;
    }

    @Override
    public void displayByBudget() {
        double maxBudget = Inputter.inputPositiveDouble("Maximum budget (million EUR): ");
        List<Club> result = new ArrayList<Club>();
        for (Club club : this) {
            if (club.getBudget() <= maxBudget) {
                result.add(club);
            }
        }
        displayTable(result);
    }

    public void displayTable(List<Club> clubs) {
        if (clubs.isEmpty()) {
            System.out.println("No clubs found.");
            return;
        }
        System.out.println("+---------+------------------------------+--------------------+----------------+");
        System.out.printf("| %-7s | %-28s | %-18s | %14s |%n",
                "Club ID", "Club Name", "Sponsor Brand", "Budget (M EUR)");
        System.out.println("+---------+------------------------------+--------------------+----------------+");
        for (Club club : clubs) {
            System.out.printf("| %-7s | %-28s | %-18s | %14.2f |%n",
                    club.getId(), club.getName(), club.getSponsorBrand(), club.getBudget());
        }
        System.out.println("+---------+------------------------------+--------------------+----------------+");
    }
}
