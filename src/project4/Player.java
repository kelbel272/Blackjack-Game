/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;


public class Player 
{
    private BlackjackHand hand;
    private String name;
    private int bank;
    private double bet;
    
    //Player sets a name, starts out at 100, and gets a hand
    public Player(String n)
    {
        this.hand = new BlackjackHand();
        this.bank = 100;
        setName(n);
    }
    
    //Set the name of the player 
    public void setName(String n)
    {
        this.name = n;
    }
    
    //Add to the banks value 
    public void setBank(int b)
    {
        this.bank += b;
    }
    
    public void lose()
    {
        this.bank -= this.bet;
    }
    
    public void win()
    {
        this.bank += this.bet;
    }
    
    public void push()
    {
       
                
    }
    
    
    public void blackJack()
    {
        this.bet = (bet * 1.5);
        this.bank += this.bet;
    }
    
    public void setBet(double b)
    {
        this.bet = b;
    }
   
    //Get the name of the player 
    public String getName()
    {
        return this.name;
    }
    
    //Display the value of the bank 
    public int getBank()
    {
      return this.bank;
    }
    
    //Get players bet for game 
    public double getBet()
    {
        return this.bet;
    }
    
    //Interface 
    //Adds a card to the players hand 
    public void addCard(Card card)
    {
        this.hand.addCard(card);
    }
    
    //Interface?
    //Calculate the total of the cards 
    public int getTotal()
    {
        return this.hand.getTotal();
    }
    
    //Interface 
    //Display the cards the user has 
    public String displayCards()
    {
        return this.hand.toString();
    }
    
    //Interface 
    //Clear the hand 
    public void clearHand()
    {
        this.hand.clearHand();
    }
}
