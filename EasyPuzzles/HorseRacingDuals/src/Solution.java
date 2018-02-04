import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.err.println("Total horses: " + N);

        List<Integer> strengths = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            strengths.add(pi);
        }

        strengths.sort(null);
        System.err.println(strengths);

        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < strengths.size(); i++) {
            for (int j = 0; j < strengths.size(); j++) {
                if (i != j) {
                    System.err.printf("Computing diff: %d, %d%n", strengths.get(i), strengths.get(j));
                    int diff = Math.abs(strengths.get(i) - strengths.get(j));
                    System.err.println("Current diff: " + diff);
                    if (diff < closest) {
                        closest = diff;
                        System.err.println("Closest diff: " + closest);
                    }
                }
            }
        }


        System.out.println(closest);
    }

}
