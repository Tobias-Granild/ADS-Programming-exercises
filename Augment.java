// Version: 20200917
// Handin done by:
//   <202407171> <Tobias Granild>
//   <202408036> <Kasper Frost>
//   <202408288> <Kristian Rasmussen>
// Contributions:
//   <name 1> <contribution>
//   <name 2> <contribution>
//   <name 3> <contribution>

public class Augment {
    public int minGap;
    public int min;
    public int max;
    // If you need any additional fields, you can add them here

    public static Augment combine(Augment left, Augment right, int key) {
        Augment res = new Augment();
        // Implement your method here to combine the augmented data from
        // the left and right child with the node's key
        if (left.min != Integer.MAX_VALUE) {
            res.min = left.min;
        } else {
            res.min = key;
        }

        if (right.max != Integer.MIN_VALUE) {
            res.max = right.max;
        } else {
            res.max = key;
        }

        res.minGap = Math.min(left.minGap, right.minGap);

        if (left.max != Integer.MIN_VALUE) {
            res.minGap = Math.min(res.minGap, key - left.max);
        }

        if (right.min != Integer.MAX_VALUE) {
            res.minGap = Math.min(res.minGap, right.min - key);
        }

        return res;
    }

    public static Augment leaf() {
        Augment res = new Augment();
        // Implement your method here to return the augmented data of a leaf
        res.minGap = Integer.MAX_VALUE;
        res.min = Integer.MAX_VALUE;
        res.max = Integer.MIN_VALUE;
        return res;
    }
}
