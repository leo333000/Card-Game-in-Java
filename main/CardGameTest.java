package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CardGameTest {
    @Test
    //tests if the players have been created, put into a list and are pointing to each other for the nextPlayer
    public void shouldCreateTwoPlayersWithRespectiveDecks(){
        ArrayList<Player> mockPlayerList = CardGame.setupPlayers(2);

        assertEquals(mockPlayerList.get(0), mockPlayerList.get(1).getNextPlayer());
        assertEquals(mockPlayerList.get(1), mockPlayerList.get(0).getNextPlayer());

        // ArrayList<Player> updatedPlayerList = CardGame.givePlayersTheirDecks(playerList,Path);


    }
    
}