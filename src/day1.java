import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class day1 {
    public static void main(String[] args) {


        // get a list of Strings from the data file we created
        ArrayList<String> fileData = getFileData("src/data");


        // go through the list line by line
        System.out.println("the dial starts by pointing at 50");
        int pos = 50;
        int pos1 = pos;
        int count = 0;
        int x;
        for (int i = 0; i < fileData.size(); i++) {
            String current = fileData.get(i);

            if (current.substring(0,1).equals("L")){
                x =  Integer.parseInt(current.substring(1));
                if(x>100){
                    while(x>100){
                        x-=100;

                    }
                }
                pos = pos - x;
                if (pos<0)
                {
                    pos=100-(x-pos1);
                    pos1=pos;
                }else{pos1=pos;}

            } else {
                x =  Integer.parseInt(current.substring(1));
                if(x>100){
                    while(x>100){
                        x-=100;
                    }
                }
                pos = pos + x;
                if (pos>=100)
                {
                    pos=(pos-100);
                    pos1=pos;

                }else{pos1=pos;}
            }
            if(pos==0){count++;}
            System.out.println("The dial is rotated " + current + " to point at " + pos);
        } System.out.println("the total number of times the dial pointed to 0 was " +count);
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


