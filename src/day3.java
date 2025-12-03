import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        int LC = 0;
        for (int i = 9; i > -1; i--) {
            String num = i + "";
            int x = batteries.substring(0, batteries.length() -1).indexOf(num);
            if (x != -1) {
                LC += i * 10;
                for (int p = 9; p > -1; p--) {
                    String num2 = p + "";
                    int y = batteries.substring(x+1, batteries.length()).indexOf(num2);
                    if (y != -1) {
                        LC += p;
                        System.out.println(LC+"");
                        return LC;
                    }
                }
            }
        }return 0;
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