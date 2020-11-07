package main;



public class Player {

    private Player nextPlayer;
    
    private Deck deck;

    private Hand hand = new Hand();

    private int playerNumber ;
    
    
    
    


    public Player(int playerNumber){
        this.playerNumber = playerNumber;
    }

    public Player(Player nextPlayer, int playerNumber){
        this.playerNumber = playerNumber;
        this.nextPlayer = nextPlayer;
    }
    // constructor for the first player made (who can't point to anyone for the following turn)

    //setter for the next player attribute
    public void setNextPlayer (Player nextPlayer){
        this.nextPlayer = nextPlayer;
    }
    //getter for the next player attribute
    public Player getNextPlayer(){
        return this.nextPlayer;
    }
    //setter for the player's deck
    public void setDeck(Deck iDeck){
        this.deck = new Deck(iDeck);
    }
    //setter for the player's deck
    public Deck getDeck(){
        return this.deck;
    }
    //the players are the ones who's action can draw a card, so it makes sense to have it being called through them and not through the deck itself

    

    public void drawToHand(){

        hand.add(deck.drawTop());
    }

    public Hand getHand(){
        return hand;
    }
    //used alongside chooseCardFromHand to decide which card to discard
    public Card chooseCardFromHand(){

        //lazy implementation because hands only consist of 4 cards
        if (hand.get(0).getNumber() != playerNumber){
            return hand.get(0);
        }
        else if (hand.get(1).getNumber() != playerNumber){
            return hand.get(1);
        }
        else if (hand.get(2).getNumber() != playerNumber){
            return hand.get(2);
        }
        else if (hand.get(3).getNumber() != playerNumber){
            return hand.get(3);
        }
        else {
            System.out.println("You won");
            return hand.get(3);
        }
    }
    //puts card on the bottom of the next players deck
    public void giveCardFromHand(Card iCard){
        hand.remove(iCard);
        nextPlayer.getDeck().add(iCard);
    }


    //series of actions that complete a player's turn
    public void haveTurn(){
        drawToHand();
        giveCardFromHand(chooseCardFromHand());
    }
}
