package main;


public class CardGame {

    //global variable placeholder for the total amount of players.
    static int numberOfPlayersTotal = 4;


    public static void main(String[] args) {

        Deck p1sDeck = new Deck();
        System.out.println(p1sDeck.toString());
    }



        // int numberOfPlayers = 5;

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

