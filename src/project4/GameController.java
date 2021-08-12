/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameController implements Initializable 
{

    @FXML
    private Circle avatar2;
    @FXML
    private Circle avatar3;
    @FXML
    private Circle avatar1;
    @FXML
    private Circle avatar4;
    @FXML
    private Button betButton;
    @FXML
    private Circle fiveChip;
    @FXML
    private Circle oneChip;
    @FXML
    private Circle tenChip;
    @FXML
    private Circle fiftyChip;
    @FXML
    private Circle hundredChip;
    @FXML
    private Button clearBetButton;
    @FXML
    private Circle twentyFiveChip;
    
    private ArrayList<Player> players;
    @FXML
    private Label avatar2NameLabel;
    @FXML
    private Label avatar4Bank;
    @FXML
    private Label avatar3NameLabel;
    @FXML
    private Label avatar4NameLabel;
    @FXML
    private Label avatar1NameLabel;
    @FXML
    private Label avatar2Bank;
    @FXML
    private Label avatar1Bank;
    @FXML
    private Label avatar3Bank;
    
    @FXML
    private Label placeBetsLabel;
    
    @FXML
    private Label playerTurnLabel;  //Displays the players name who is betting 
    
    private int initialBank;        //Value of the bank before bets were places, used for reset function also 
    
    private int num = 0;            //Iterator for going through player array to get all player bets 
    
    private int playerBank;         //Temporary bank value for the player 
    
    private int betTotal = 0;       //Total amount bet 
    
    @FXML
    private Label playerBetTotal;
    @FXML
    private Rectangle player3spot;

     public GameController()
    {
       
    }
     
    public GameController(ArrayList<Player> players)
    {
        this.players = players;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
      //Hide all of the icons 
      avatar1.setVisible(false);
      avatar2.setVisible(false);
      avatar3.setVisible(false);
      avatar4.setVisible(false);
      
      //Grey out all of the icons 
      ColorAdjust colorAdjust = new ColorAdjust();
      colorAdjust.setBrightness(-.5);
      
      avatar1.setEffect(colorAdjust);
      avatar2.setEffect(colorAdjust);
      avatar3.setEffect(colorAdjust);
      avatar4.setEffect(colorAdjust);
      
      //Hide all of the names 
      avatar1NameLabel.setVisible(false);
      avatar2NameLabel.setVisible(false);
      avatar3NameLabel.setVisible(false);
      avatar4NameLabel.setVisible(false);
      
      //Hide all of the bank fields 
      avatar1Bank.setVisible(false);
      avatar2Bank.setVisible(false);
      avatar3Bank.setVisible(false);
      avatar4Bank.setVisible(false);
      
      DropShadow shadow = new DropShadow();
      
      //Add images to the chips 
      Image image = new Image("/images/1Chip.png");
      oneChip.setFill(new ImagePattern(image));
      
      image = new Image("/images/5CHIP.png");
      fiveChip.setFill(new ImagePattern(image));
      
      image = new Image("/images/10CHIP.png");
      tenChip.setFill(new ImagePattern(image));
      
       image = new Image("/images/25CHIP.png");
      twentyFiveChip.setFill(new ImagePattern(image));
      
      image = new Image("/images/50CHIP.png");
      fiftyChip.setFill(new ImagePattern(image));
      
      image = new Image("/images/100CHIP.png");
      hundredChip.setFill(new ImagePattern(image));
      
      
      
    }
    
    
    //Get players from the selection menu 
    public void setPlayers(ArrayList<Player> people)
    {
       players = people;
       
       
       //Display Player 1's name 
       playerTurnLabel.setText(players.get(num).getName() + "'s Turn");
       
       //Set Player 1's initial bank total to the variable 
       initialBank = players.get(num).getBank();
       
       //Set temp bank value 
       playerBank = initialBank;
       
       //Checks what chips can be used 
       checkBankBet();
       
       //Enable players
       enablePlayers();
       
       /******  Set Position 2 for Player 1  *****/
       //Set the avatar icon 
       Image image = setAvatarIcon(0);
       avatar2.setVisible(true);
       avatar2.setFill(new ImagePattern(image));
       
            
       //Show the players name  
       avatar2NameLabel.setVisible(true);
       avatar2NameLabel.setText(players.get(0).getName());
            
       //Show the amount in the bank 
       avatar2Bank.setVisible(true);
       avatar2Bank.setText("Bank: $" + players.get(0).getBank());
            
       //If there are more than one players, position them accordingly 
       /******  Set Position 3 for Player 2  *****/
       if(players.size() > 1)
       {
            //Set avatar icon 
            image = setAvatarIcon(1);
            avatar3.setVisible(true);
            avatar3.setFill(new ImagePattern(image));
            
            //Show the players name  
            avatar3NameLabel.setVisible(true);
            avatar3NameLabel.setText(players.get(1).getName());
            
            //Show the amount in the bank 
            avatar3Bank.setVisible(true);
            avatar3Bank.setText("Bank: $" + players.get(1).getBank());
            
            /******  Set Position 4 for Player 3  *****/
            if(players.size() > 2)
            {
                //Set avatar icon 
                image = setAvatarIcon(2);
                avatar4.setVisible(true);
                avatar4.setFill(new ImagePattern(image));
            
                //Show the players name  
                avatar4NameLabel.setVisible(true);
                avatar4NameLabel.setText(players.get(2).getName());
            
                 //Show the amount in the bank 
                avatar4Bank.setVisible(true);
                avatar4Bank.setText("Bank: $" + players.get(2).getBank());
                
                /******  Set Position 1 for Player 4  *****/
                if (players.size() > 3)
                {
                    //Set avatar icon 
                    image = setAvatarIcon(3);
                    avatar1.setVisible(true);
                    avatar1.setFill(new ImagePattern(image));
            
                    //Show the players name  
                    avatar1NameLabel.setVisible(true);
                    avatar1NameLabel.setText(players.get(3).getName());
            
                    //Show the amount in the bank 
                    avatar1Bank.setVisible(true);
                    avatar1Bank.setText("Bank: $" + players.get(3).getBank());
                    
                        
                }
            }
        }     
    }
    
    public Image setAvatarIcon(int num)
    {
            if(players.get(num).getName() == "LUNA")
            {
                Image image = new Image("/images/LUNA.png", false);
                
                return image;
            }
            else if(players.get(num).getName() == "BUSINESS CAT")
            {
                Image image = new Image("/images/BUSINESS_CAT.png", false);
                
                return image;
            }
            else if(players.get(num).getName() == "CURSED CAT")
            {
                Image image = new Image("/images/CURSED.png", false);
                
                return image;
            }
            else if(players.get(num).getName() == "ZED")
            {
                Image image = new Image("/images/ZED.png", false);
                
                return image;
            }
            else if(players.get(num).getName() == "DIZZY")
            {
                Image image = new Image("/images/DIZZY.png", false);
                
                return image;
            }
            else if(players.get(num).getName() == "SPOOKY")
            {
                Image image = new Image("/images/BOO.png", false);
                
                return image;
            }
            else if(players.get(num).getName() == "GEOFF")
            {
                Image image = new Image("/images/GEOFF.png", false);
                
               
                return image;
            }
            else if(players.get(num).getName() == "SALEM")
            {
                Image image = new Image("/images/SALEM.png", false);
                
                return image;
            }
            
            Image image = new Image("/images/SALEM.png", false);
            return image;
    }

    @FXML
    private void oneRelease(MouseEvent event) 
    {
        oneChip.setEffect(null);
        checkBankBet();
    }

    @FXML
    private void onePress(MouseEvent event)
    {
       //Add one to the bet total 
       betTotal += 1;
       
       //Update the label 
       playerBetTotal.setText("$"+ betTotal);
       
       DropShadow shadow = new DropShadow();
        
       shadow.setRadius(20);
       
       //Add border to show click 
       oneChip.setEffect(shadow);
       
       //Set new bank total display, dont finalize unless bet is confirmed 
       playerBank -= 1;
       
       updateBankLabel();
       
       
    }

    @FXML
    private void fiveRelease(MouseEvent event) 
    {
        fiveChip.setEffect(null);
        
        checkBankBet();
    }

    @FXML
    private void fivePress(MouseEvent event) 
    {
        DropShadow shadow = new DropShadow();
        
        shadow.setRadius(20);
       //Add one to the bet total 
       betTotal += 5;
       
       //Add border to show click 
       //fiveChip.setStrokeWidth(4);
       fiveChip.setEffect(shadow);
       
       
       //Update the label 
       playerBetTotal.setText("$"+ betTotal);
               
       //Set new bank total display, dont finalize unless bet is confirmed 
       playerBank -= 5;
       
       updateBankLabel();
       
    }
    
    //Updates the Bank total for the player who is betting 
    private void updateBankLabel()
    {
        if(num == 0)
        {
            avatar2Bank.setText("Bank: $" + playerBank);
        }
        else if(num == 1)
        {
            avatar3Bank.setText("Bank: $" + playerBank);
        }
        else if(num == 2)
        {
            avatar4Bank.setText("Bank: $" + playerBank);
        }
        else if(num == 3)
        {
            avatar1Bank.setText("Bank: $" + playerBank);
        }
    }
    
    //Checks after ever bet and before first bet
    private void checkBankBet()
    {
        checkHundredBet();
        checkFiftyBet();
        checkTwentyFiveBet();
        checkTenBet();
        checkFiveBet();
        checkOneBet();
    }
    
    private void checkHundredBet()
    {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-.5);
        hundredChip.setEffect(null);
        hundredChip.setDisable(false);
        
        if(playerBank - 100 < 0)
        {
            hundredChip.setDisable(true);
            hundredChip.setEffect(colorAdjust);
        }
    }
    
    private void checkFiftyBet()
    {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-.5);
        fiftyChip.setEffect(null);
        fiftyChip.setDisable(false);
        
        if(playerBank - 50 < 0)
        {
            fiftyChip.setDisable(true);
            fiftyChip.setEffect(colorAdjust);
        }
    }
    
    private void checkTwentyFiveBet()
    {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-.5);
        twentyFiveChip.setEffect(null);
        twentyFiveChip.setDisable(false);
       
        if(playerBank - 25 < 0)
        {
            twentyFiveChip.setDisable(true);
            twentyFiveChip.setEffect(colorAdjust);
        }
    }
    
    private void checkTenBet()
    {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-.5);
        tenChip.setEffect(null);
        tenChip.setDisable(false);
        
        if(playerBank - 10 < 0)
        {
            tenChip.setDisable(true);
            tenChip.setEffect(colorAdjust);
        }
    }
    
    private void checkFiveBet()
    {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-.5);
        fiveChip.setEffect(null);
        fiveChip.setDisable(false);
        
        if(playerBank - 5 < 0)
        {
            fiveChip.setDisable(true);
            fiveChip.setEffect(colorAdjust);
        }
    }
    
    private void checkOneBet()
    {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-.5);
        oneChip.setEffect(null);
        oneChip.setDisable(false);
        
        if(playerBank - 1 < 0)
        {
            oneChip.setDisable(true);
            oneChip.setEffect(colorAdjust);
        }
    }

    @FXML
    private void betButtonClicked(ActionEvent event) 
    {
        //Set the bet for the player 
        players.get(num).setBet(betTotal);
        
        //Set correct bank total 
        players.get(num).setBank(playerBank);
        
        //Display the correct bank
        updateBankLabel();
        
        //Move on to the next player 
        num++;
        
        //Enable Players
        enablePlayers();
       
        //Move to next stage if done 
        if(players.size() == num)
        {
            
            
        }
        else
        {
            resetBet();
            
        }
        
    }

    @FXML
    private void tenRelease(MouseEvent event) 
    {
        tenChip.setEffect(null);
        
        checkBankBet();
    }

    @FXML
    private void tenPress(MouseEvent event) 
    {
        //Add one to the bet total 
       betTotal += 10;
       
       //Update the label 
       playerBetTotal.setText("$"+ betTotal);
       
       DropShadow shadow = new DropShadow();
        
       shadow.setRadius(20);
       
       //Add border to show click 
       tenChip.setEffect(shadow);
       
       //Set new bank total display, dont finalize unless bet is confirmed 
       playerBank -= 10;
       
       updateBankLabel();
       
       //checkBankBet();
    }

    @FXML
    private void fiftyRelease(MouseEvent event)
    {
        fiftyChip.setEffect(null);
        
        checkBankBet();
    }

    @FXML
    private void fiftyPress(MouseEvent event) 
    {
        //Add one to the bet total 
       betTotal += 50;
       
       //Update the label 
       playerBetTotal.setText("$"+ betTotal);
       
       DropShadow shadow = new DropShadow();
        
       shadow.setRadius(20);
       
       //Add border to show click 
       fiftyChip.setEffect(shadow);
       
       //Set new bank total display, dont finalize unless bet is confirmed 
       playerBank -= 50;
       
       updateBankLabel();
       
       //checkBankBet();
    }

    @FXML
    private void hundredRelease(MouseEvent event) 
    {
        hundredChip.setEffect(null);
        
        checkBankBet();
    }

    @FXML
    private void hundredPress(MouseEvent event) 
    {
        //Add one to the bet total 
       betTotal += 100;
       
       //Update the label 
       playerBetTotal.setText("$"+ betTotal);
       
       DropShadow shadow = new DropShadow();
        
       shadow.setRadius(20);
       
       //Add border to show click 
       hundredChip.setEffect(shadow);
       
       //Set new bank total display, dont finalize unless bet is confirmed 
       playerBank -= 100;
       
       updateBankLabel();
       
       //checkBankBet();
    }

    @FXML
    private void clearBetClicked(ActionEvent event)
    {
        resetBet();
    }

    @FXML
    private void twentyFiveRelease(MouseEvent event) 
    {
        twentyFiveChip.setEffect(null);
        
        checkBankBet();
    }

    @FXML
    private void twentyFivePress(MouseEvent event) 
    {
        //Add one to the bet total 
       betTotal += 25;
       
       //Update the label 
       playerBetTotal.setText("$"+ betTotal);
       
       DropShadow shadow = new DropShadow();
        
       shadow.setRadius(20);
       
       //Add border to show click 
       twentyFiveChip.setEffect(shadow);
       
       //Set new bank total display, dont finalize unless bet is confirmed 
       playerBank -= 25;
       
       updateBankLabel();
       
    }
    
    public void resetBet()
    {
        //Display Players name 
        playerTurnLabel.setText(players.get(num).getName() + "'s Turn");
        
        //Set Players initial bank total to the variable 
        initialBank = players.get(num).getBank();
        
        //Set playerBank back to the initialAmount 
        playerBank = initialBank;
        
        //Reset the bet total to 0
        betTotal = 0;
        
        //Display $0 Bet 
        playerBetTotal.setText("$"+ betTotal);
        
        //Update the bank label for the player 
        updateBankLabel();
        
        enablePlayers();
       
        checkBankBet();
    }
    
    private void enablePlayers()
    {
      //Grey out all of the icons 
      ColorAdjust colorAdjust = new ColorAdjust();
      colorAdjust.setBrightness(-.5);
      
      
        if(num == 0)
        {
            avatar2.setEffect(null);
            avatar2.setStrokeWidth(4);
          
        }
        else if(num == 1)
        {
            avatar2.setStrokeWidth(1);
            avatar2.setEffect(colorAdjust);
            avatar3.setStrokeWidth(4);
            avatar3.setEffect(null);
            playerBetTotal.setTranslateX(142);
        }
        else if(num == 2)
        {
            avatar3.setStrokeWidth(1);
            avatar3.setEffect(colorAdjust);
            avatar4.setStrokeWidth(4);
            avatar4.setEffect(null);
            playerBetTotal.setTranslateX(302);
            playerBetTotal.setTranslateY(-30);
        }
        else if(num == 3)
        {
            avatar4.setEffect(colorAdjust);
            avatar1.setEffect(null);
        }
    }
   
}
