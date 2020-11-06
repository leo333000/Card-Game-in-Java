package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager{


    public ArrayList<Integer> readDeckFile(String path) {

        ArrayList<Integer> indexCards = new ArrayList<Integer>();

    try {
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();

                int i = Integer.parseInt(data.trim());
                if(i < 1) {

                    System.out.println("//!\\ERROR//!\\: THE CHARACTER IN THE FILE IS EITHER NEGATIVE OR NOT EQUAL TO 1 ");

                }else{
                     indexCards.add(i);
                     }
            }
        myReader.close();
    }catch (NumberFormatException nfe){
        {
       System.out.println("//!\\ERROR//!\\: THE CHARACTER IN THE FILE IS NOT A INT " + nfe.getMessage());
        }
    }catch (FileNotFoundException e) {
        System.out.println("//!\\ERROR//!\\: FILE NOT FOUND WITH PATH, " + path);
        e.printStackTrace();
        }

        return indexCards;

        }

}
