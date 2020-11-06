package main;
import java.util.ArrayList;


public class Player {

    Player nextPlayer;
    // private ArrayList <Card> hand =new ArrayList<>();
    


    public Player(){

    }

    public Player(Player nextPlayer){
        this.nextPlayer = nextPlayer;
    }
    // constructor for the first player made (who can't point to anyone for the following turn)



    public void SetNextPlayer (Player nextPlayer){
        this.nextPlayer = nextPlayer;
    }
    

    


}
