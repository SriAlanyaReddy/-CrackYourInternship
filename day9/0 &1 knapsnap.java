import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class ItemComparator implements Comparator<Item> {
    public int compare(Item a, Item b) {
        double r1 = (double) a.value / a.weight;
        double r2 = (double) b.value / b.weight;
        // Sort in descending order
        if (r1 < r2) {
            return 1; // Return positive if a has a lower ratio than b
        } else if (r1 > r2) {
            return -1; // Return negative if a has a higher ratio than b
        }
        return 0; // Return 0 if they are equal
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> values, List<Integer> weights, int w) {
        // Create a list of items
        ArrayList<Item> l = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            l.add(new Item(values.get(i), weights.get(i)));
        }
        
        // Sort the items based on value/weight ratio
        Collections.sort(l, new ItemComparator());
        
        double cw = 0; // Current weight in the knapsack
        double finalWeight = 0.0; // Total value in the knapsack
        
        for (int i = 0; i < l.size(); i++) {
            if (cw + l.get(i).weight <= w) {
                // If the whole item can be added
                cw += l.get(i).weight;
                finalWeight += l.get(i).value;
            } else {
                // Take the fractional part of the item
                int remain = w - (int) cw; // Remaining capacity
                finalWeight += ((double) l.get(i).value / (double) l.get(i).weight) * (double) remain;
                break; // Exit as the knapsack is full
            }
        }
        return finalWeight; // Return the total value
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> values = Arrays.asList(60, 100, 120);
        List<Integer> weights = Arrays.asList(10, 20, 30);
        int W = 50; // Capacity of knapsack
        double maxValue = solution.fractionalKnapsack(values, weights, W);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
