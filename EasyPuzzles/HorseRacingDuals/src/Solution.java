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
        //System.err.println(strengths);

        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < strengths.size() - 1; i++) {
            int strengthA = strengths.get(i);
            int strengthB = strengths.get(i + 1);
            //System.err.printf("Computing diff: %d - %d%n", strengthA, strengthB);
            int diff = Math.abs(strengthA - strengthB);
            //System.err.println("Diff: " + diff);
            if (diff < closest) {
                closest = diff;
                //System.err.println("Closest diff is: " + closest);
            }
        }

        System.out.println(closest);
    }

}
