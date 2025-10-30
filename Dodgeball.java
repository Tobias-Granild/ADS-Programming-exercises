// Version: 20200917
// Handin done by:
//   <id 1> <name 1>
//   <id 2> <name 2>
//   <id 3> <name 3>
// Contributions:
//   <name 1> <contribution>
//   <name 2> <contribution>
//   <name 3> <contribution>

import java.util.TreeSet;
public class Dodgeball {
    // Add any private fields you might need here
    private TreeSet<Integer> players = new TreeSet<>();

    public void addPlayer(int x) {
        // Implement your code here to add a player to the line
        players.add(x);
    }

    public int throwBall(int x) {
        // Implement your code here to update the line of players and return the distance
        if (players.contains(x)) {
            players.remove(x);
            return 0;
        }

        Integer lower = players.floor(x);
        Integer upper = players.ceiling(x);

        int chosen;
        int distance;

        if  (lower == null) {
            chosen = upper;
            distance = Math.abs(upper - x);
        } else if (upper == null) {
            chosen = lower;
            distance = Math.abs(lower - x);
        } else {
            int distLow = Math.abs(x - lower);
            int distUp = Math.abs(upper - x);

            if (distLow <= distUp) {
                chosen = lower;
                distance = distLow;
            } else {
                chosen = upper;
                distance = distUp;
            }
        }

        players.remove(chosen);
        players.add(x);

        return distance;
    }
}
