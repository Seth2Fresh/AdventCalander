import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class day1p2 {
    public static void main(String[] args) {


        // get a list of Strings from the data file we created
        ArrayList<String> fileData = getFileData("src/data");


        // go through the list line by line
        System.out.println("The dial starts by pointing at 50");
        int pos = 50;
        int count = 0;

        for (String current : fileData) {
            int steps = Integer.parseInt(current.substring(1));
            boolean left = current.startsWith("L");

            for (int i = 0; i < steps; i++) {
                if (left) {
                    pos--;
                    if (pos < 0) pos = 99;
                } else {
                    pos++;
                    if (pos > 99) pos = 0;
                }

                if (pos == 0) {
                    count++;
                }
            }

            System.out.println("The dial is rotated " + current + " to point at " + pos);
        }

        System.out.println("The total number of times the dial pointed to or passed 0 was " + count);
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}


