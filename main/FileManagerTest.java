package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


import org.junit.Test;




public class FileManagerTest {

    //tests the readDeckFile function
    @Test
    public void shouldGiveErrorOfEmptyFile() {
        
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test, FileManager.readDeckFile("./test_resources/TestPackEmpty.txt"));
    }
    @Test
    public void shouldGiveErrorOfIllegalPackChar() {
        
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test, FileManager.readDeckFile("./test_resources/TestPackIllegal.txt"));
    }
    @Test
    public void shouldGiveErrorOfNegativeInt() {
        
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test, FileManager.readDeckFile("./test_resources/TestPackIllegalNegative.txt"));
    }
    @Test
    public void shouldNotFindFile() {
        
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test, FileManager.readDeckFile("./test_resources/DoesNotExist.txt"));
    }
    
  }
