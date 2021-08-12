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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ChoosePlayersFXMLController implements Initializable
{
    private int playerCount;
    
    @FXML
    private Label textLabel;
    
    @FXML
    private Button playerButton1;
    @FXML
    private Button playerButton2;
    @FXML
    private Button playerButton3;
    @FXML
    private Button playerButton4;

       
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void playerButtonClicked(ActionEvent event)
    {
        if(event.getSource() == playerButton1)
        {
              playerCount = 1;
            Stage stage = (Stage) playerButton1.getScene().getWindow();
             try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerInfo.fxml"));
            
                
                Parent root = loader.load();
            
                PlayerInfoController avatarController = loader.getController();
                
                avatarController.setNumberOfPlayers(playerCount);
                 
                loader.setController(avatarController);
            
                Scene scene = new Scene(root);
            
                stage.setScene(scene);
                stage.show();
               
            
            }
            catch (Exception ex) {
            
            }
          
        }
        else if(event.getSource() == playerButton2)
        {
            playerCount = 2;
            Stage stage = (Stage) playerButton2.getScene().getWindow();
            
              try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerInfo.fxml"));
            
                
                Parent root = loader.load();
            
                PlayerInfoController avatarController = loader.getController();
                
                avatarController.setNumberOfPlayers(playerCount);
                 
                loader.setController(avatarController);
            
                Scene scene = new Scene(root);
            
                stage.setScene(scene);
                stage.show();
               
            
            }
            catch (Exception ex) {
            
            }
           
        }
        else if(event.getSource() == playerButton3)
        {
            playerCount = 3;
            Stage stage = (Stage) playerButton3.getScene().getWindow();
             try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerInfo.fxml"));
            
                
                Parent root = loader.load();
            
                PlayerInfoController avatarController = loader.getController();
                
                avatarController.setNumberOfPlayers(playerCount);
                 
                loader.setController(avatarController);
            
                Scene scene = new Scene(root);
            
                stage.setScene(scene);
                stage.show();
               
            
            }
            catch (Exception ex) {
            
            }
            
        }
        else if (event.getSource() == playerButton4)
        {
            playerCount = 4;
            Stage stage = (Stage) playerButton4.getScene().getWindow();
              try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerInfo.fxml"));
            
                
                Parent root = loader.load();
            
                PlayerInfoController avatarController = loader.getController();
                
                avatarController.setNumberOfPlayers(playerCount);
                 
                loader.setController(avatarController);
            
                Scene scene = new Scene(root);
            
                stage.setScene(scene);
                stage.show();
               
            
            }
            catch (Exception ex) {
            
            }
        }
           

        
    }

}
