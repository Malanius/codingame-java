import java.nio.charset.Charset;
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
        String message = in.nextLine();

        System.err.println("Message: " + message);

        System.err.println("Converting message to binary:");
        StringBuilder binary = new StringBuilder();
        for (char c : message.toCharArray()) {
            String tempStr = String.valueOf(c);
            StringBuilder tempBin = new StringBuilder();

            byte[] bytes = tempStr.getBytes(Charset.forName("ASCII"));

            for (byte b : bytes) {
                int val = b;
                for (int i = 0; i < 8; i++) {
                    tempBin.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
            }
            tempBin.deleteCharAt(0);
            binary.append(tempBin);
        }
        System.err.println(binary.toString());


        System.err.println("Converting message to unary:");

        StringBuilder answer = new StringBuilder();
        int count = 1;
        char last = binary.charAt(0);

        for (int i = 1; i < binary.length(); i++) {
            if (last == binary.charAt(i)) {
                count++;
            } else {
                buildOutput(answer, count, last);
                answer.append(" ");
                count = 1;
                last = binary.charAt(i);
            }
        }
        if (last != binary.charAt(binary.length() - 1)) {
            count++;
        }
        buildOutput(answer, count, last);

        System.out.println(answer.toString().trim());


    }

    private static void buildOutput(StringBuilder answer, int count, char last) {
        answer.append((last == '1' ? "0" : "00"));
        answer.append(" ");
        for (int j = 0; j < count; j++) {
            answer.append("0");
        }
    }

}
