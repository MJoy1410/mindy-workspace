package interfaces;

public interface I_PlayerList {
    void displaySortedByClubName();
    void searchByPartialName();
    boolean addNewPlayer();
    boolean removeById();
    boolean updateById();
    void displayByPosition();
}
