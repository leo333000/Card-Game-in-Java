package main;


import java.util.ArrayList;


public class Deck extends ArrayList<Card> {

    //copy-constructor , makes a new deck out of an already existing one
    public  Deck(Deck iDeck){
      this.addAll(iDeck);
    }


    public Deck(ArrayList<Integer> listOfInts, int numberOfPlayers){
        initialise(listOfInts, numberOfPlayers);

    }

    public Deck(){
      this.clear();
      //create an empty list 
      }

    private void initialise(ArrayList<Integer> listInDeck, int numberOfPlayers){
			for(int i = 0; i < listInDeck.size(); i++) {
				Card currentBottomCard = new Card(listInDeck.get(i));
				this.add(currentBottomCard);
			  }
    }

    public Card drawTop() {
        Card topCard = this.get(0);
        this.remove(0);
        return topCard;
    }

    
    

}
