package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

    //standard global path to the pack.txt
    static String packFilePath = "resources/pack.txt";

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




    }




        // //create a first player who has no one to point to for his nextPlayer variable, as he is so far alone in the list.
        // Player firstPlayer  =  new Player();
        // ArrayList<Player> playerList = new ArrayList<Player>();
        // playerList.add(firstPlayer);

        // //the first player is already created so make numberOfPlayers-1 more players
        // for (int i = 0; i < (numberOfPlayers-1); i++) {
        //     Player extraPlayer  =  new Player(firstPlayer);
        //     playerList.add(extraPlayer);
        //   }
        //   //finally this sets the first player of the list nextPlayer to point to the last player of the list
        //   playerList.get(0).SetNextPlayer(playerList.get(playerList.size()-1));

        // System.out.println(playerList.get(0).nextPlayer);
        

    }

