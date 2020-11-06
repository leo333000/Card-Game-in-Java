package main;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;




public class FileManagerTest {
    @Test
    public void ReadFileDeckTest() {
        FileManager read = new FileManager();
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(0);
        System.out.println(read.readDeckFile("resources/pack.txt").toString());
        assertEquals(test, read.readDeckFile("resources/pack.txt"));
    
    }


    @Test
    public void ReadFileTest(){
        try {
            File myObj = new File("resource/pack.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}