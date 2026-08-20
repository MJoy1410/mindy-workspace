package view;

import controllers.ClubList;
import controllers.DataManager;
import controllers.Menu;
import controllers.PlayerList;

public class FootballClubPlayerManagement {
    public static void main(String[] args) {
        ClubList clubs = new ClubList();
        PlayerList players = new PlayerList(clubs);
        DataManager dataManager = new DataManager(clubs, players, "clubs.txt", "players.txt");
        Menu menu = buildMenu();
        boolean changed = false;

        // Requirement: data is loaded automatically when the program starts.
        dataManager.loadData();

        boolean running = true;
        while (running) {
            menu.showMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    clubs.displayAll();
                    break;
                case 2:
                    changed |= clubs.addNewClub();
                    break;
                case 3:
                    clubs.searchById();
                    break;
                case 4:
                    changed |= clubs.updateById();
                    break;
                case 5:
                    clubs.displayByBudget();
                    break;
                case 6:
                    players.displaySortedByClubName();
                    break;
                case 7:
                    players.searchByPartialName();
                    break;
                case 8:
                    changed |= players.addNewPlayer();
                    break;
                case 9:
                    changed |= players.removeById();
                    break;
                case 10:
                    changed |= players.updateById();
                    break;
                case 11:
                    players.displayByPosition();
                    break;
                case 12:
                    if (dataManager.saveData()) {
                        changed = false;
                    }
                    break;
                case 13:
                    if (dataManager.loadData()) {
                        changed = false;
                    }
                    break;
                case 14:
                    if (changed) {
                        dataManager.saveData();
                    }
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    break;
            }
        }
    }

    private static Menu buildMenu() {
        Menu menu = new Menu();
        menu.addItem("List of all clubs");
        menu.addItem("Add a new club");
        menu.addItem("Search for a club by ID");
        menu.addItem("Update a club by ID");
        menu.addItem("List of all clubs with budget <= input value");
        menu.addItem("List all players sorted by club name, then shirt number");
        menu.addItem("Search players by partial player name");
        menu.addItem("Add a new player");
        menu.addItem("Remove a player with ID");
        menu.addItem("Update a player with an ID");
        menu.addItem("List all players by a specific position");
        menu.addItem("Save data to files");
        menu.addItem("Load data from files");
        menu.addItem("Quit program");
        return menu;
    }
}
