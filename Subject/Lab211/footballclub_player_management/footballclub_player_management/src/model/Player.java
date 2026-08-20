package model;

public class Player extends FootballEntity {
    private String clubId;
    private String name;
    private String position;
    private int shirtNumber;

    public Player(String id, String clubId, String name, String position, int shirtNumber) {
        super(id);
        this.clubId = clubId;
        this.name = name;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Override
    public String toDataString() {
        return getId() + ", " + clubId + ", " + name + ", " + position + ", " + shirtNumber;
    }
}
