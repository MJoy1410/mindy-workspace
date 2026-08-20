package controllers;

import model.Club;
import model.FootballEntity;
import model.Player;
import utils.Inputter;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private final ClubList clubs;
    private final PlayerList players;
    private final Path clubFile;
    private final Path playerFile;

    public DataManager(ClubList clubs, PlayerList players, String clubFileName, String playerFileName) {
        this.clubs = clubs;
        this.players = players;
        this.clubFile = Paths.get(clubFileName);
        this.playerFile = Paths.get(playerFileName);
    }

    public boolean saveData() {
        try {
            Utils.writeFile(clubFile, serialize(clubs));
            Utils.writeFile(playerFile, serialize(players));
            System.out.println("Save data successfully!");
            return true;
        } catch (IOException e) {
            System.out.println("Save data failed!");
            return false;
        }
    }

    public boolean loadData() {
        ClubList loadedClubs = new ClubList();
        PlayerList loadedPlayers = new PlayerList(loadedClubs);
        try {
            loadClubsStrict(loadedClubs);
            loadPlayersStrict(loadedClubs, loadedPlayers);

            // Replace current data only after every line in both files passes strict validation.
            clubs.clear();
            clubs.addAll(loadedClubs);
            players.clear();
            players.addAll(loadedPlayers);
            System.out.println("Load data successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("Load data failed!");
            return false;
        }
    }

    private void loadClubsStrict(ClubList target) throws IOException {
        for (String line : Utils.readFile(clubFile)) {
            if (line.trim().isEmpty()) {
                throw new IllegalArgumentException("Empty club line");
            }
            String[] parts = line.split(",", -1);
            if (parts.length != 4) {
                throw new IllegalArgumentException("Invalid club line");
            }
            String id = parts[0].trim();
            String name = parts[1].trim();
            String sponsor = parts[2].trim();
            double budget = parsePositiveDouble(parts[3].trim());

            if (!Inputter.isValidClubId(id) || name.isEmpty() || sponsor.isEmpty() || target.findById(id) != null) {
                throw new IllegalArgumentException("Invalid club data");
            }
            target.add(new Club(id, name, sponsor, budget));
        }
    }

    private void loadPlayersStrict(ClubList loadedClubs, PlayerList target) throws IOException {
        for (String line : Utils.readFile(playerFile)) {
            if (line.trim().isEmpty()) {
                throw new IllegalArgumentException("Empty player line");
            }
            String[] parts = line.split(",", -1);
            if (parts.length != 5) {
                throw new IllegalArgumentException("Invalid player line");
            }
            String id = parts[0].trim();
            String clubId = parts[1].trim();
            String name = parts[2].trim();
            String position = Inputter.normalizePosition(parts[3].trim());
            int shirtNumber = parseShirtNumber(parts[4].trim());

            if (!Inputter.isValidPlayerId(id) || target.findById(id) != null
                    || loadedClubs.findById(clubId) == null || name.isEmpty() || position == null
                    || target.isShirtNumberUsed(clubId, shirtNumber, null)) {
                throw new IllegalArgumentException("Invalid player data");
            }
            target.add(new Player(id, clubId, name, position, shirtNumber));
        }
    }

    private List<String> serialize(Iterable<? extends FootballEntity> entities) {
        List<String> lines = new ArrayList<String>();
        for (FootballEntity entity : entities) {
            lines.add(entity.toDataString());
        }
        return lines;
    }

    private double parsePositiveDouble(String value) {
        double number = Double.parseDouble(value);
        if (!Double.isFinite(number) || number <= 0) {
            throw new IllegalArgumentException("Budget must be positive");
        }
        return number;
    }

    private int parseShirtNumber(String value) {
        int number = Integer.parseInt(value);
        if (number < 1 || number > 99) {
            throw new IllegalArgumentException("Invalid shirt number");
        }
        return number;
    }
}
