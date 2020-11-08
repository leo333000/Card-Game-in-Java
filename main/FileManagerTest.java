package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


import org.junit.Test;




public class FileManagerTest {

    //tests the readDeckFile function
    @Test
    public void ReadFileDeckTest() {
        FileManager read = new FileManager();
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test, read.readDeckFile("./test_resources/testpackempty.txt"));
    
    }
}