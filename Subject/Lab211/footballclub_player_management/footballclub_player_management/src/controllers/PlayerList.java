package controllers;

import interfaces.I_PlayerList;
import model.Club;
import model.Player;
import utils.Inputter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerList extends ArrayList<Player> implements I_PlayerList {
    private final ClubList clubList;

    public PlayerList(ClubList clubList) {
        this.clubList = clubList;
    }

    public Player findById(String id) {
        for (Player player : this) {
            if (player.getId().equalsIgnoreCase(id)) {
                return player;
            }
        }
        return null;
    }

    public boolean isShirtNumberUsed(String clubId, int shirtNumber, String ignoredPlayerId) {
        for (Player player : this) {
            boolean sameClub = player.getClubId().equalsIgnoreCase(clubId);
            boolean sameShirt = player.getShirtNumber() == shirtNumber;
            boolean ignored = ignoredPlayerId != null && player.getId().equalsIgnoreCase(ignoredPlayerId);
            if (sameClub && sameShirt && !ignored) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displaySortedByClubName() {
        List<Player> sorted = new ArrayList<Player>(this);
        Collections.sort(sorted, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                String clubName1 = getClubName(p1.getClubId());
                String clubName2 = getClubName(p2.getClubId());
                int byClubName = clubName1.compareToIgnoreCase(clubName2);
                if (byClubName != 0) {
                    return byClubName;
                }
                return Integer.compare(p1.getShirtNumber(), p2.getShirtNumber());
            }
        });
        displayTable(sorted);
    }

    @Override
    public void searchByPartialName() {
        String keyword = Inputter.inputNotEmpty("Partial player name: ").toLowerCase();
        List<Player> result = new ArrayList<Player>();
        for (Player player : this) {
            if (player.getName().toLowerCase().contains(keyword)) {
                result.add(player);
            }
        }
        displayTable(result);
    }

    @Override
    public boolean addNewPlayer() {
        String id = Inputter.inputPlayerId("Player ID: ");
        if (findById(id) != null) {
            System.out.println("This player ID already exists!");
            System.out.println("Add player failed!");
            return false;
        }

        clubList.displayAll();
        String clubId = Inputter.inputClubId("Club ID: ");
        if (clubList.findById(clubId) == null) {
            System.out.println("This club does not exist!");
            System.out.println("Add player failed!");
            return false;
        }

        String name = Inputter.inputNotEmpty("Player name: ");
        String position = Inputter.inputPosition("Position: ");
        int shirtNumber = Inputter.inputInt("Shirt number: ", 1, 99);
        if (isShirtNumberUsed(clubId, shirtNumber, null)) {
            System.out.println("This shirt number already exists in this club!");
            System.out.println("Add player failed!");
            return false;
        }

        add(new Player(id, clubId, name, position, shirtNumber));
        System.out.println("Add player successfully!");
        return true;
    }

    @Override
    public boolean removeById() {
        String id = Inputter.input("Player ID: ");
        Player player = findById(id);
        if (player == null) {
            System.out.println("This player does not exist!");
            return false;
        }
        remove(player);
        System.out.println("Remove player successfully!");
        return true;
    }

    @Override
    public boolean updateById() {
        String id = Inputter.input("Player ID: ");
        Player player = findById(id);
        if (player == null) {
            System.out.println("This player does not exist!");
            return false;
        }

        String name = Inputter.input("New player name (Enter to skip): ");
        String position = Inputter.inputOptionalPosition("New position (Enter to skip): ");
        Integer shirtNumber = Inputter.inputOptionalInt("New shirt number (Enter to skip): ", 1, 99);

        // Validate the new shirt number before changing any field, so an invalid update is atomic.
        if (shirtNumber != null
                && isShirtNumberUsed(player.getClubId(), shirtNumber, player.getId())) {
            System.out.println("This shirt number already exists in this club!");
            return false;
        }

        boolean changed = false;
        if (!name.isEmpty() && !name.equals(player.getName())) {
            player.setName(name);
            changed = true;
        }
        if (position != null && !position.equals(player.getPosition())) {
            player.setPosition(position);
            changed = true;
        }
        if (shirtNumber != null && shirtNumber != player.getShirtNumber()) {
            player.setShirtNumber(shirtNumber);
            changed = true;
        }

        System.out.println(changed ? "Update player successfully!" : "No player information was changed.");
        return changed;
    }

    @Override
    public void displayByPosition() {
        String position = Inputter.inputPosition("Position: ");
        List<Player> result = new ArrayList<Player>();
        for (Player player : this) {
            if (player.getPosition().equalsIgnoreCase(position)) {
                result.add(player);
            }
        }
        displayTable(result);
    }

    public void displayTable(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
        System.out.println("+-----------+---------+------------------------------+----------------------------+-------------+----------+");
        System.out.printf("| %-9s | %-7s | %-28s | %-26s | %-11s | %8s |%n",
                "Player ID", "Club ID", "Club Name", "Player Name", "Position", "Shirt No");
        System.out.println("+-----------+---------+------------------------------+----------------------------+-------------+----------+");
        for (Player player : players) {
            System.out.printf("| %-9s | %-7s | %-28s | %-26s | %-11s | %8d |%n",
                    player.getId(), player.getClubId(), getClubName(player.getClubId()),
                    player.getName(), player.getPosition(), player.getShirtNumber());
        }
        System.out.println("+-----------+---------+------------------------------+----------------------------+-------------+----------+");
    }

    private String getClubName(String clubId) {
        Club club = clubList.findById(clubId);
        return club == null ? "" : club.getName();
    }
}
