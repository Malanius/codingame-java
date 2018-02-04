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

        System.err.println(strengths);

        List<Integer> diffs = new ArrayList<>();


        for (int i = 0; i < strengths.size(); i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < strengths.size(); j++) {
                    if (finalI != j) {
                        int diff = Math.abs(strengths.get(finalI) - strengths.get(j));
                        diffs.add(diff);
                    }
                }
            }).run();
        }
        diffs.sort(null);
        System.out.println(diffs.get(0));
    }

}
