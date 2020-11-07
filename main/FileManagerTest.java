package main;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;




public class FileManagerTest {

    //tests the readDeckFile function
    @Test
    public void ReadFileDeckTest() {
        FileManager read = new FileManager();
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test, read.readDeckFile("./test_resources/testpackempty.txt"));
    
    }

    @Test
  public void currentDirTest(){
    System.out.println("Working Directory = " + System.getProperty("user.dir"));   
  }
}