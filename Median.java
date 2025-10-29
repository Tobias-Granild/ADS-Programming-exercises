// Version: 20200917
// Handin done by:
//   <202407171> <Tobias Granild>
//   <202408036> <Kasper Frost>
//   <202408288> <Kristian Rasmussen>
// Contributions:
//   <name 1> <contribution>
//   <name 2> <contribution>
//   <name 3> <contribution>

import java.io.*;
import java.util.*;

public class Median {
    // Max-heap for den mindre halvdel af numrene
    private PriorityQueue<Integer> left;
    // Min-heap for den større halvdel
    private PriorityQueue<Integer> right;

    public Median() {
        // Max-heap - største element har største prioritet
        left = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap
        right = new PriorityQueue<>();
    }

    public void add(int x) {
        // Tilføj til højre heap
        right.add(x);

        // flyt den mindste fra højre heap til venstre heap
        left.add(right.poll());

        // Hvis venstre har flere elementer, rebalancerer vi
        if (left.size() > right.size()) {
            right.add(left.poll());
        }
    }

    public int median() {
        // medianen er minimum af højre heap.
        return right.peek();
    }
}
