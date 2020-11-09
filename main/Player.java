package main;

import java.util.ArrayList;

public class Player extends Thread {

    private Player nextPlayer;
    
    private Deck deck;

    private ArrayList<Card> hand = new ArrayList<Card>() ;

    private int playerNumber ;

    private String playerLogPath;

    private String playerRemainingDeckPath;
    
    
    
    


    public Player(int playerNumber){
        this.playerNumber = playerNumber;

        //make the file locations for the output with their player number
        this.playerLogPath = "log_files/player" + playerNumber +".txt";
        this.playerRemainingDeckPath = "log_files/playerDeck" + playerNumber +".txt";

    }

    public Player(Player nextPlayer, int playerNumber){
        this.playerNumber = playerNumber;
        this.nextPlayer = nextPlayer;

        //make the file locations for the output with their player number
        this.playerLogPath = "log_files/player" + playerNumber +".txt";
        this.playerRemainingDeckPath = "log_files/playerDeck" + playerNumber +".txt";
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
        if(iDeck.size() != 8){
			System.out.println("//!\\ERROR//!\\: THE AMOUNT OF NUMBERS IN THE DECK IS NOT EQUAL TO, " + 8 + "it is, of size "+ iDeck.size() + " instead");
		    }
        }


    //getter for the player's deck
    public Deck getDeck(){
        return this.deck;
    }

    //a method to see if the player has all cards dealt to him at the beginning of the game equal, thus winning the game
    public Boolean doIhaveFourCardTheSame(){
        if (hand.get(0).getNumber()== hand.get(1).getNumber() && hand.get(1).getNumber() == hand.get(2).getNumber() && hand.get(2).getNumber() == hand.get(3).getNumber()){
            return true;
        }else{
            return false;
        }          
    }

    //the players are the ones who's action can draw a card, so it makes sense to have it being called through them and not through the deck itself
    public void drawToHand(){
        Card aCardGoingToHand = deck.drawTop();
        hand.add(aCardGoingToHand);
        String log  = "Player number " + playerNumber + " has added a " + aCardGoingToHand.getNumber()+ " to his hand.";
        FileManager.writeFile(log, playerLogPath);

    }



    public ArrayList<Card> getHand(){
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
            CardGame.gameFinished = true;
            CardGame.winningPlayerNumber = playerNumber;

            //logging
            String log  = "Game Finished, I win";
            FileManager.writeFile(log, playerLogPath);

            //since this method must still return a card
            Card ghostCard = new Card(-1);
            return ghostCard;
        }
    }



    //puts card on the bottom of the next players deck
    public void giveCardFromHand(Card iCard){
        hand.remove(iCard);
        nextPlayer.getDeck().add(iCard);
        String log  = "Player number " + playerNumber + " has added a " + iCard.getNumber() + " to player number " + nextPlayer.playerNumber + "'s deck'.";
        FileManager.writeFile(log, playerLogPath);
    }





    //series of actions that complete a player's turn
    public void haveTurn(){
        if(chooseCardFromHand().getNumber() != -1){
        
        giveCardFromHand(chooseCardFromHand());
        drawToHand();
        FileManager.writeFile("\n", playerLogPath);
        }
    }



    public void run(){
        System.out.println("Running player number" + playerNumber );
            while(CardGame.gameFinished == false){
                if(!deck.isEmpty()){
                    haveTurn();
                }
            }
        // logging the end of the game
        String log = "the winning player is player number " + CardGame.winningPlayerNumber;
        FileManager.writeFile(log , playerLogPath);
        
        log = "current hand:  ";
        for(int i=0; i<hand.size();i++){
            log = log + hand.get(i).getNumber();
        }
        FileManager.writeFile(log , playerLogPath);

        log = "current deck contents:  ";
        for(int i=0; i<deck.size();i++){
            log = log + deck.get(i).getNumber();
        }
        FileManager.writeFile(log , playerRemainingDeckPath);
        
        System.out.println("Thread " +  playerNumber + " exiting.");
        FileManager.writeFile("Thread " +  playerNumber + " exiting.", playerLogPath);
     }
     
}


