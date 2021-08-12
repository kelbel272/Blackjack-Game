/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;




public class Deck {
    
    //52 Cards in a deck 
    public final int cardsInDeck = 52;
    
     // Contains all 52 cards
    private ArrayList<Card> deckOfCards; 
    
 
    Deck(int decks){
        
        //Create Deck of Cards from Card class 
        deckOfCards = new ArrayList<Card>(cardsInDeck);
        
        
        //Add cards to the deck 
        //6 decks in blackjack game 
        for (int i = 0; i < decks; i++)
        {
            for (Card.Face f  : Card.Face.values())
             for (Card.Suit s: Card.Suit.values())
                deckOfCards.add(new Card(f, s));
        }
        
        
        
       
    }
    
    public Card getRandomCard(){
        
        //Shuffle cards
        Collections.shuffle(deckOfCards);
        
        //Set the card
        Card card = deckOfCards.get(0);
        
        //Remove the card from the deck
        deckOfCards.remove(0);
        
        //Give card to player 
        return card;
        
    }
    
   
    
    
  
    
    
}

