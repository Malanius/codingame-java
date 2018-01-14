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
        int n = in.nextInt(); // the number of temperatures to analyse
        System.err.printf("Reading %d temperatures...%n", n);

        int result = 0;
        int closestTemp = 65535;

        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            System.err.print(t + " ");

            if (Math.abs(t) < Math.abs(closestTemp)) {
                closestTemp = t;
                result = t;
            } else if (Math.abs(t) == Math.abs(closestTemp)) {
                if (t > closestTemp) {
                    closestTemp = t;
                    result = t;
                }
            }
        }

        System.err.println();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
}
