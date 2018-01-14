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
        int charWidth = in.nextInt();
        int charHeight = in.nextInt();

        System.err.printf("Char size is: %dx%d%n", charWidth, charHeight);

        if (in.hasNextLine()) {
            in.nextLine();
        }


        String text = in.nextLine().toUpperCase();
        System.err.printf("Text is: %s%n%n", text);

        List<String> asciRows = new LinkedList<>();
        for (int i = 0; i < charHeight; i++) {
            String row = in.nextLine();
            System.err.println(row);
            asciRows.add(row);
        }
        System.err.println();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < charHeight; i++) {
            for (char c : text.toCharArray()) {
                int index = getAsciiIndex(c);
                int start = index * charWidth;
                int end = index * charWidth + charWidth;
                String part = asciRows.get(i).substring(start, end);
                answer.append(part);
            }
            answer.append("\n");
        }

        System.err.println(getAsciiIndex('E'));
        System.out.println(answer.toString());
    }

    private static int getAsciiIndex(char c) {
        int index = 26; //Default to last ? if unknown
        if (c >= 'A' && c <= 'Z') {
            index = (int) c - (int) 'A';
        }
        return index;
    }
}
