/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.util.ArrayList;


public class BlackjackHand 
{
    
     private ArrayList<Card> cards;
     
     public BlackjackHand()
     {
         this.cards = new ArrayList<Card>();
     }
     
    //Add a card to the hand 
    public void addCard(Card card)
    {
        this.cards.add(new Card(card));
    }
    
    public int getTotal()
    {
        int total = 0;
        boolean ace = false; 
        
        //Get total of all the cards 
        for(int i = 0; i < cards.size(); i++)
        {
            //If Card is an ace and add 1
            if(checkAce(i))
            {
                ace = true;
                total += 1;
            }
            //Check if face 
            else if(checkFace(i))
            {
                total += 10;
            }
            else
            {
                total += (cards.get(i).getFace().ordinal() + 1);
            }
        }
        
        //If there is an ace and the total is 9 or less, 
        //Make the ace an 11 
        if(ace == true && total < 11)
        {
            total += 10;
        }
        
        return total;
    }
    
    //Display the cards the player has 
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" - ");
        
        for (Card card : cards)
        {
            stringBuilder.append(card.toString());
            stringBuilder.append(", ");
        }
        // trim the last 2 ,_ characters
        return stringBuilder.substring(0, stringBuilder.length()-2);
    }
    
    //Check if a card is an Ace 
    boolean checkAce(int i)
    {
       if(cards.get(i).getFace().ordinal() == 0 )
       {
           return true;
       }
       return false;
    }
    
    //Check if the card is a TEN, JACK, QUEEN, KING
    boolean checkFace(int i)
    {
       boolean isFace = false;
       
       if(cards.get(i).getFace().ordinal() > 8 &&
               cards.get(i).getFace().ordinal() < 13 )
       {
           isFace = true;
           
           return true;
       }
       
       return false;
    }
    
    //Clear the hand 
    public void clearHand()
    {
        this.cards.clear();
    }
    
  
}
