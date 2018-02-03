import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        Map<String, String> types = new HashMap<>(); //Map for storing MIME types for extensions

        System.err.println("MIME types:");
        for (int i = 0; i < N; i++) {
            String extension = in.next().toLowerCase(); // File extension, converted to lowercase
            String mimeType = in.next(); // MIME type, required to be in the case as provided
            System.err.println(extension + " : " + mimeType);
            types.put(extension, mimeType);
        }

        in.nextLine();

        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.

        System.err.println("Files:");
        for (int i = 0; i < Q; i++) {
            String fileName = in.nextLine().toLowerCase(); // One file name per line, lowercase only as case in file name doesn't matter
            String fileExtension = "";
            if (fileName.contains(".")) { //Check for dot, otherwise no point to searching for extension
                fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length()); //Get the file extension
            }
            System.err.println(fileName + " - " + fileExtension);
            String type = types.get(fileExtension); //Retrieve thy MIME type
            System.out.println((type != null) ? type : "UNKNOWN");
        }

    }
}
