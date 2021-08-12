/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

public class Card 
{
    //List of the numeric value of the cards 
    enum Face 
    {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING
    };

    enum Suit 
    {
        CLUBS, HEARTS, SPADES, DIAMONDS
    };

    Card(Face face, Suit suit)
    {
        this.face = face;
        this.suit = suit;
    }

    Card(Card card) 
    {
        face = card.face;
        suit = card.suit;
    }

    private Suit suit;
    private Face face;

    
    public Face getFace() 
    {
        return face;
    }

    public Suit getSuit() 
    {
        return suit;
    }

    @Override
    public String toString()
    {
        return this.face.toString() + " of " + this.suit.toString();
    }

}
