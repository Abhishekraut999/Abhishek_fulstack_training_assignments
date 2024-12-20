import java.util.List;

public interface PlayerOperations {
    void createPlayer(Player player);
    List<Player> readAllPlayers();
    void updatePlayer(int id, String field, Object newValue);
    void deletePlayer(int id);
    List<Player> sortPlayersBySkill();
    List<Player> listPlayersByCountry(String country);
    List<Player> listPlayersByExperience();
}
