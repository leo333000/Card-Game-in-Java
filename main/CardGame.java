package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

    //standard global path to the pack.txt, used only for tests, will be overwritten in main
    static String packFilePath = "resources/pack.txt";

    //importance of the volatile keyword to make sure they all end the game in sync
    static volatile Boolean gameFinished = false;

    //-1 is the default value and only works if, when printed, is a positive int, relevant to a player's name
    static volatile int winningPlayerNumber = -1;



    public static ArrayList<Player> setupPlayers(int iNumberOfPlayers){
        Player firstPlayer  =  new Player(1);
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(firstPlayer);

        //the first player is already created so make the rest of the players
        for (int i = 1; i < (iNumberOfPlayers); i++) {

            //the player number is i+1 (since you don't count player numbers starting from 0) and it's next player is the player before him
            //in the list so of index i-1.
            Player extraPlayer  =  new Player(playerList.get(i-1),i+1);
            playerList.add(extraPlayer);
          }
          //finally this sets the first player of the list nextPlayer to point to the last player of the list
          playerList.get(0).setNextPlayer(playerList.get(playerList.size()-1));


          return playerList;
        }




    public static ArrayList<Player> givePlayersTheirDecks(ArrayList<Player> iPlayerList, String iPath, int iNumberOfPlayers){

        
        Deck aDeck = new Deck(FileManager.readDeckFile(iPath),iNumberOfPlayers);
        Deck cardsDealtToSpecificPlayer = new Deck();
        for (int i = 0; i < (iPlayerList.size()); i++){
            for (int j = i; j < aDeck.size(); j = j+iPlayerList.size()){
                cardsDealtToSpecificPlayer.add(aDeck.get(j));
            }

            //the way setDeck() works is that it will clone the deck, so they are not all pointing to the same memory slot
            iPlayerList.get(i).setDeck(cardsDealtToSpecificPlayer);
            cardsDealtToSpecificPlayer.clear();

        }

        return iPlayerList;
        
    }



    public static void playersDrawTheirInitialCards(ArrayList<Player> iPlayerList){
        for (int i = 0; i < (iPlayerList.size()); i++){

            // each player must draw it's first 4 cards
            iPlayerList.get(i).drawToHand();
            iPlayerList.get(i).drawToHand();
            iPlayerList.get(i).drawToHand();
            iPlayerList.get(i).drawToHand();
            
            if(iPlayerList.get(i).doIhaveFourCardTheSame()){
                CardGame.gameFinished = true;
                //the player 1 is in position 0 in the list
                CardGame.winningPlayerNumber = i+1;
            }
        }

    }




    public static void startTheGameForAllPlayers(ArrayList<Player> iPlayerList){
        for (int i = 0; i < (iPlayerList.size()); i++){
           
            iPlayerList.get(i).start();
        }
    }


    /*

        MAIN FUNCTION


    */
    public static void main(String[] args) {
    
        System.out.println("WELCOME! to the simplest card game: how many players are playing");
        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers = 4;
        Boolean inputMade = false;
        // get their input as a String
        //less elegant that scanner.nextInt() but allows the user to try again if fail
        while(inputMade == false)
        try {
            numberOfPlayers = Integer.parseInt(scanner.next());
            System.out.print("\n now enter the file path of the deck (for example: 'resources/pack.txt')");
            packFilePath = scanner.next();
            inputMade = true;
         }
         catch (NumberFormatException e)
         {
            System.out.print("please try again  :");
            numberOfPlayers = 0;
            continue;
         }
     
        System.out.print(numberOfPlayers);
        scanner.close();

        ArrayList<Player> PlayerList = setupPlayers(numberOfPlayers);
        givePlayersTheirDecks(PlayerList, packFilePath, numberOfPlayers);
        playersDrawTheirInitialCards(PlayerList);
        startTheGameForAllPlayers(PlayerList);

    }


}

