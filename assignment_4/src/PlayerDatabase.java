import java.util.ArrayList;

public class PlayerDatabase {
    private ArrayList<Player> players = new ArrayList<>();

    public PlayerDatabase() {
    }
    public void add(Player p){
        players.add(p);
        System.out.println("You create account ");

    }
    public boolean login(Player p) {
        for (Player player : players) {
            if (player.getName().equals(p.getName()) && player.getCode().equals(p.getCode())) {
                System.out.println("You are login");
                return true;
            } else {
                System.out.println("Incorrect name or code");
                return false;
            }
        }
        return false;
    }
}
