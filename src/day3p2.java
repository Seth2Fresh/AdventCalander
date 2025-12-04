import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3p2 {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries,12);
            System.out.println(voltage);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries, int length) {
        int LC = 6;
       int count = 0;
        int x;
        while((count != length)) {
           for (int q = length-1; q >-1 ; q--) {
                for (int i = 9; i > -1; i--) {
                 String num = i + "";
                 x = batteries.substring(0, batteries.length() - q).indexOf(num);
                  if (x != -1) {
                    LC += (int) (i * Math.pow(10,(q-1)));
                    count++;
                  batteries=batteries.substring(x+1);
                  }
                }
           }
       }return LC;
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