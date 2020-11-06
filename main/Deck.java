package main;


import java.util.ArrayList;


public class Deck extends ArrayList<Card> {

    //copy-constructor , makes a new deck out of an already existing one
    public  Deck(Deck iDeck){
      this.addAll(iDeck);
    }


    public  Deck(ArrayList<Integer> listOfInts, int numberOfPlayers){
        initialise(listOfInts, numberOfPlayers);

    }

    private void initialise(ArrayList<Integer> listInDeck, int numberOfPlayers){
		
		if(listInDeck.size() == numberOfPlayers*8)
		{
			for(int i = 0; i < listInDeck.size(); i++) {
				Card currentBottomCard = new Card(listInDeck.get(i));
				this.add(currentBottomCard);
			  }
		} else {
			System.out.println("//!\\ERROR//!\\: THE AMOUNT OF NUMBERS IN THE FILE IS NOT EQUAL TO, " + numberOfPlayers*8);
		}


    }

    public Card drawTop() {
        Card topCard = this.get(0);
        this.remove(0);
        return topCard;
    }

    

}
