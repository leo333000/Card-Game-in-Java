package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    //tests the setDeck() function and deck attribute
    @Test
    public void shouldGivePlayerHisOwnDeck(){

        Player person = new Player(1);

        int numberOfPlayers = 1;

        String testPath = "./test_resources/TestPack1Player.txt";
        Deck aDeck = new Deck(FileManager.readDeckFile(testPath),numberOfPlayers);

        assertEquals(8,aDeck.size());

        person.setDeck(aDeck);

        //these tests ensure that the deck is a clone and not pointing to a common memory space
        assertEquals(1, person.getDeck().drawTop().getNumber());
        assertEquals(8, aDeck.size());
        assertEquals(7, person.getDeck().size());
    }

    //Tests the drawToHand(), giveCardFromHand() and ChooseCardFromHand() functions
    @Test
    public void shouldPickAndGiveACardFromHand(){

        //initialise mock 2 player game
        Player p1 = new Player(1);
        Player p2 = new Player(p1,2);
        p1.setNextPlayer(p2);

        int numberOfPlayers = 2;

        String testPath = "./test_resources/TestPack2Players.txt";
        Deck aDeck = new Deck(FileManager.readDeckFile(testPath),numberOfPlayers);

        p1.setDeck(aDeck);
        p2.setDeck(aDeck);

        //end of initialisation 

        p1.drawToHand();
        assertEquals(3, p1.getHand().get(0).getNumber());
        p1.giveCardFromHand(p1.chooseCardFromHand());
        assertEquals(17 , p2.getDeck().size());



    }
    //tests the haveTurn() function
    @Test
    public void shouldHaveACompleteTurn(){

        //initialise mock 2 player game
        Player p1 = new Player(1);
        Player p2 = new Player(p1,2);
        p1.setNextPlayer(p2);

        int numberOfPlayers = 2;

        String testPath = "./test_resources/TestPack2Players.txt";
        Deck aDeck = new Deck(FileManager.readDeckFile(testPath),numberOfPlayers);

        p1.setDeck(aDeck);
        p2.setDeck(aDeck);

        //end of initialisation
        p1.drawToHand();
        assertEquals(15, p1.getDeck().size());
        p1.haveTurn();
        assertEquals(14, p1.getDeck().size());
        assertEquals(17, p2.getDeck().size());

    }
    

}
