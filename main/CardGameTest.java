package main;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CardGameTest {
    @Test
    //tests if the players have been created, put into a list and are pointing to each other for the nextPlayer
    public void shouldCreateTwoPlayersWithRespectiveDecks(){
        int numberOfPlayers = 2;
        ArrayList<Player> mockPlayerList = CardGame.setupPlayers(numberOfPlayers);

        assertEquals(mockPlayerList.get(0), mockPlayerList.get(1).getNextPlayer());
        assertEquals(mockPlayerList.get(1), mockPlayerList.get(0).getNextPlayer());

        String path = "./test_resources/TestPack2Players.txt";

        ArrayList<Player> updatedMockPlayerList = CardGame.givePlayersTheirDecks(mockPlayerList, path, numberOfPlayers);

        updatedMockPlayerList.get(0).drawToHand();

    
        assertEquals( 3, updatedMockPlayerList.get(0).getHand().get(0).getNumber());

        //tests different location in memory for both players decks
        //drawing from one should not affect the other.
        assertEquals( 7, updatedMockPlayerList.get(0).getDeck().size());
        assertEquals( 8, updatedMockPlayerList.get(1).getDeck().size());

    }

 
    @Test

    public void shouldWinTheGameInstantly(){
        int numberOfPlayers = 1;
        String testPath = "./test_resources/TestPack1Player.txt";
        ArrayList<Player> PlayerList = CardGame.setupPlayers(numberOfPlayers);
        CardGame.givePlayersTheirDecks(PlayerList, testPath, numberOfPlayers);
        CardGame.playersDrawTheirInitialCards(PlayerList);
        assertEquals( 1, CardGame.winningPlayerNumber);
        assertEquals( true, CardGame.gameFinished);
        
            
    }
    
}