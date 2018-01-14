import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        int actualTX = initialTX; //Thor's actual X position
        int actualTY = initialTY; //Thor's actual X position

        System.err.printf("Light at: %dx%d%n", lightX, lightY);
        System.err.printf("Thor at: %dx%d%n", initialTX, initialTY);

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            String dirX = "";
            String dirY = "";

            //Determine X direction
            if (actualTX > lightX) {
                dirX = "W";
                actualTX += 1;
            } else if (actualTX < lightX) {
                dirX = "E";
                actualTX += 1;
            }
            //Determine Y direction
            if (actualTY > lightY) {
                dirY = "N";
                actualTY -= 1;
            } else if (actualTY < lightY) {
                dirY = "S";
                actualTY += 1;
            }

            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(dirY + dirX);
        }
    }
}
