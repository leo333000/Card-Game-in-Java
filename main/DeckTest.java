package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;




public class DeckTest {
    @Test
    public void DrawCardFromTopOfDeckTest() {
        
        Deck deck1 = new Deck();
        Card topCard = new Card(1);
        Card bottomCard = new Card (0);

        deck1.add(topCard);
        deck1.add(bottomCard);
        
        assertEquals(topCard,deck1.DrawTop());
    
    }
}
