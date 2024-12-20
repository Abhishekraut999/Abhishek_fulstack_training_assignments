import java.util.List;

public class PlayerApp {
    public static void main(String[] args) {
        PlayerOperations operations = new Player(0, null, null, 0, null, 0.0);

        // Add players
        operations.createPlayer(new Player(0, "John", "Batsman", 5, "USA", 80.5));
        operations.createPlayer(new Player(0, "Doe", "Bowler", 7, "India", 85.0));

        // Read players
        List<Player> players = operations.readAllPlayers();
        players.forEach(p -> System.out.println(p.name));

        // Update a player
        operations.updatePlayer(1, "skill", "All-Rounder");

        // Delete a player
        operations.deletePlayer(2);

        // List by country
        List<Player> playersByCountry = operations.listPlayersByCountry("USA");
        playersByCountry.forEach(p -> System.out.println(p.name));

        // Sort by experience
        List<Player> playersByExperience = operations.listPlayersByExperience();
        playersByExperience.forEach(p -> System.out.println(p.name + " - " + p.experience));
    }
}
