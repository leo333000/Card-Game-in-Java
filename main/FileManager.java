package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager{


    public static ArrayList<Integer> readDeckFile(String path) {

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
            
            System.out.println("//!\\ERROR//!\\: THE CHARACTER IN THE FILE IS NOT A INT " + nfe.getMessage());
            ArrayList<Integer> emptyList = new ArrayList<Integer>();
            return emptyList;   
        }catch (FileNotFoundException e) {
            System.out.println("//!\\ERROR//!\\: FILE NOT FOUND WITH PATH, " + path);
            e.printStackTrace();
            ArrayList<Integer> emptyList = new ArrayList<Integer>();
            return emptyList;
            }
        if(indexCards.isEmpty()){
            System.out.println("//!\\ERROR//!\\: THE FILE IS EMPTY ");
            ArrayList<Integer> emptyList = new ArrayList<Integer>();
            return emptyList;
            }

        return indexCards;

        }


    public static void writeFile(String text, String playerPath) {
        try {
            File file = new File(playerPath);
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.write(text);
            output.newLine();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

