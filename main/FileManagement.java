package main;

import java.io.*;
import java.util.ArrayList;

public class FileManagement
{   
    public static ArrayList<Card> readFile(String packPath){  
        ArrayList<Card> cardDeck = new ArrayList<>();
        int cardNumber;
        try {
            BufferedReader in = new BufferedReader(new FileReader (packPath));
            String line = in.readLine();
            while(line!= null){
                cardNumber = Integer.parseInt(line);
                if (cardNumber > 0) {
                    cardDeck.add(new Card(cardNumber));
                    line = in.readLine();
                }else {//If found invalid card stop immediately and clear cardDeck
                    System.out.println("[Message] : Integer must be positive");
                    cardDeck.clear();
                    line = null;
                }
            }
            in.close();//Close file reader
            } catch (IOException e) {//Can't find the file
                System.out.println("[Message] : Invalid file path.");
                cardDeck.clear();
        } catch(NumberFormatException e) { //If file content contain something other than int
            System.out.println("[Message] : Content is not an integer.");
            cardDeck.clear();
        }
        return cardDeck;
    }
    
    public static void clearFile(String filePath){
        File file = new File(filePath);
        file.delete();
    }
    
    public static void writeFile(String text, String playerPath) {
        try {
            File file = new File(playerPath);
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.write(text);
            output.newLine();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
