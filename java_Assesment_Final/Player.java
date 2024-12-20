import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player extends AbstractPlayer implements PlayerOperations {

    public Player(int id, String name, String skill, int experience, String country, double overallScore) {
        super(id, name, skill, experience, country, overallScore);
    }

    @Override
    public void createPlayer(Player player) {
        try (Connection conn = DBUtil.getConnection()) {
            String query = "INSERT INTO players (name, skill, exp, country, overall_score) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, player.name);
            pstmt.setString(2, player.skill);
            pstmt.setInt(3, player.experience);
            pstmt.setString(4, player.country);
            pstmt.setDouble(5, player.overallScore);
            pstmt.executeUpdate();
            System.out.println("Player added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> readAllPlayers() {
        List<Player> players = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM players";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                players.add(new Player(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("skill"),
                    rs.getInt("exp"),
                    rs.getString("country"),
                    rs.getDouble("overall_score")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public void updatePlayer(int id, String field, Object newValue) {
        try (Connection conn = DBUtil.getConnection()) {
            String query = "UPDATE players SET " + field + " = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setObject(1, newValue);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Player updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(int id) {
        try (Connection conn = DBUtil.getConnection()) {
            String query = "DELETE FROM players WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Player deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> sortPlayersBySkill() {
        List<Player> players = readAllPlayers();
        players.sort(Comparator.comparing(p -> p.skill));
        return players;
    }

    @Override
    public List<Player> listPlayersByCountry(String country) {
        List<Player> players = new ArrayList<>();
        for (Player player : readAllPlayers()) {
            if (player.country.equalsIgnoreCase(country)) {
                players.add(player);
            }
        }
        return players;
    }

    @Override
    public List<Player> listPlayersByExperience() {
        List<Player> players = readAllPlayers();
        players.sort(Comparator.comparingInt((Player p) -> p.experience).reversed());
        return players;
    }
}
