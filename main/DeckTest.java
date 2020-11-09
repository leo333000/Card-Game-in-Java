package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;




public class DeckTest {
    @Test
    public void shouldReadDeckFromFileTest() {
        
        int numberOfPlayers = 4;
        String testPath = "./test_resources/TestPack4Players.txt";

        Deck deck1 = new Deck(FileManager.readDeckFile(testPath),numberOfPlayers);

        assertEquals(3,deck1.drawTop().getNumber());
        assertEquals(2,deck1.drawTop().getNumber());
    
    }
    @Test
    public void shouldReadTopCard() {
        
        int numberOfPlayers = 0;
        
        ArrayList<Integer> emptyIntegerList = new ArrayList<Integer>();
        Deck deck1 = new Deck(emptyIntegerList,numberOfPlayers);

        Card topCard = new Card(1);

        deck1.add(0, topCard);
        
        assertEquals(1,deck1.drawTop().getNumber());
    
    }
    @Test
    public void shouldCheckErrorConditions() {

    }
}
