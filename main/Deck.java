package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Deck extends ArrayList<Card> {



    public  Deck(){
        Initialise();

    }

    private void Initialise(){
        FileManager reader = new FileManager();
		ArrayList<Integer> indexCards = new ArrayList<Integer>();
		ArrayList<Integer> listInDeck = reader.readDeckFile("resources/pack.txt");
		
		if(listInDeck.size() == CardGame.numberOfPlayersTotal*4)
		{
			for(int i = 0; i < listInDeck.size(); i++) {
				Card currentBottomCard = new Card(listInDeck.get(i));
				this.add(currentBottomCard);
			  }
		} else {
			System.out.println("//!\\ERROR//!\\: THE AMOUNT OF NUMBERS IN THE FILE IS NOT EQUAL TO, " + CardGame.numberOfPlayersTotal*4);
		}


    }

    public Card DrawTop() {
        Card topCard = this.get(0);
        this.remove(0);
        return topCard;
    }

    

}
