/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class FXMLController implements Initializable
{
   
    
    @FXML
    private Button newGameButton;

    @FXML
    private Label textField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }    
    @FXML
    private void newGameClicked(ActionEvent event) 
    {
        Stage stage = (Stage) newGameButton.getScene().getWindow();
        
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChoosePlayers.fxml"));
            
            Parent root = loader.load();
            
            ChoosePlayersFXMLController controller = loader.getController();
            
              
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }
        catch (Exception ex) {
            
        }
       
    }
    
    
    //Home Screen //(if no saved games) New Game 
    
    //How many players 
    
    //Table scene 
    
    //When chip is clicked, move to area
    
    //Click Deal
    
    //Stand greys out cards 
    
    //Hit button gives another card 
    
    //Dealing cards 
    
    //Save Game
    
    //Load game 

    

}
