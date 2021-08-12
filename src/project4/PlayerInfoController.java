
package project4;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class PlayerInfoController implements Initializable
{
    
    private boolean[] chosenCat = {false, false, false, false, false , 
                                            false, false, false};
    
    private String[] cats = {"LUNA", "BUSINESS CAT", "CURSED CAT", 
                            "ZED", "DIZZY", "SPOOKY", "GEOFF", "SALEM"};
    @FXML
    private Label headingLabel;
    @FXML
    private ImageView ZED;
    @FXML
    private ImageView DIZZY;
    @FXML
    private ImageView SPOOKY;
    @FXML
    private ImageView SALEM;
    @FXML
    private ImageView GEOFF;
    @FXML
    private ImageView LUNA;
    @FXML
    private ImageView CURSED_CAT;
    @FXML
    private ImageView BUSINESS_CAT;
    @FXML
    private Button okayButton;
    @FXML
    private Label playerNumberLabel;
    
    @FXML
    private Label catName;
    
    @FXML
    private GridPane borderGrid;
    
    @FXML
    private Label catNameClick;
    
    @FXML
    private Rectangle border;
    
    private ArrayList<Player> players; 
    
    private int playerCount;
    
    private int num = 1;
    
    //private String name;
    
    @FXML
    private GridPane avatarGrid;

     public PlayerInfoController()
    {
       playerCount = 0;
    }
     
    public PlayerInfoController(int number)
    {
        this.playerCount = number;
        setNumberOfPlayers(number);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        catNameClick.setVisible(false);
        setNumberOfPlayers(playerCount);
        okayButton.setDisable(true);
        border.setVisible(false);
        
     
        players  = new ArrayList<Player>(playerCount);
     
        playerNumberLabel.setText("Player " + num + ":");
        
        catName.setText("");
        LUNA.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("LUNA");
        });
        GEOFF.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("GEOFF");
        });
        SALEM.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("SALEM");
        });
        ZED.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("ZED");
        });
        SPOOKY.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("SPOOKY");
        });
        DIZZY.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("DIZZY");
        });
        BUSINESS_CAT.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("BUSINESS CAT");
        });
        CURSED_CAT.hoverProperty().addListener((ov, oldValue, newValue) -> {
            catName.setText("CURSED CAT");
        });
            
       

    }    

    @FXML
    private void avatarSelected(MouseEvent event) 
    {
        okayButton.setDisable(false);
        border.setVisible(true);
        catNameClick.setVisible(true);
       
       
        if (event.getSource() == LUNA && chosenCat[0] == false) 
         {
           catNameClick.setText("LUNA");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 0, 0);
         } 
         else if (event.getSource() == GEOFF && chosenCat[6] == false) 
         {
           catNameClick.setText("GEOFF");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 2, 1);
         }
         else if (event.getSource() == ZED && chosenCat[3] == false) 
         {
           catNameClick.setText("ZED");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 3, 0);
           
         }
        else if (event.getSource() == SPOOKY && chosenCat[5] == false) 
        {
           catNameClick.setText("SPOOKY");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 1, 1);
        }
        else if (event.getSource() == SALEM && chosenCat[7] == false) 
        {
           catNameClick.setText("SALEM");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 3, 1);
        }
        else if (event.getSource() == BUSINESS_CAT && chosenCat[1] == false) 
        {
           catNameClick.setText("BUSINESS CAT");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 1, 0);
        }
        else if (event.getSource() == CURSED_CAT && chosenCat[2] == false) 
        {
           catNameClick.setText("CURSED CAT");
           border.setStroke(Color.BLACK);
           borderGrid.add(border, 2, 0);
        }
        else if (event.getSource() == DIZZY && chosenCat[4] == false) 
        {
            catNameClick.setText("DIZZY");
            border.setStroke(Color.BLACK);
            borderGrid.add(border, 0, 1);
        }
        
      
    }
    
    //Display name while scrolling over avatars, only works when none are selected 
    @FXML
    public void displayCatName(MouseDragEvent event)
    {
      if (event.getSource() == LUNA) 
         {
           catName.setText("LUNA");
         } 
         else if (event.getSource() == GEOFF) 
         {
           catName.setText("GEOFF");
         }
         else if (event.getSource() == ZED ) 
         {
           catName.setText("ZED");
         }
        else if (event.getSource() == SPOOKY ) 
        {
           catName.setText("SPOOKY");
        }
        else if (event.getSource() == SALEM ) 
        {
           catName.setText("SALEM");
        }
        else if (event.getSource() == BUSINESS_CAT ) 
        {
           catName.setText("BUSINESS CAT");
        }
        else if (event.getSource() == CURSED_CAT ) 
        {
           catName.setText("CURSED CAT");
        }
        else if (event.getSource() == DIZZY ) 
        {
            catName.setText("DIZZY");
        }
       
    }
    
    
    @FXML
    private void okayButtonClicked(MouseEvent event)
    {
       String name = catNameClick.getText();
       
       disableAvatars(name);
       
       //Create new player 
       players.add(new Player(name));
       
       //Subtract player from the count 
       //playerCount--;
       
       //If all of the players were created, open the game 
       if (playerCount == num)
       {
           Stage stage = (Stage) okayButton.getScene().getWindow();
        
            try 
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
                
                Parent root = loader.load();
            
                GameController controller = loader.getController();
                
                controller.setPlayers(players);
                
                loader.setController(controller);
            
                Scene scene = new Scene(root);
            
                stage.setScene(scene);
                stage.show();
            
            }
            catch (Exception ex) 
            {
            
            }
        }
       //If more players need to choose avatars, reset the stage. 
       else
       {
          resetScene();
       }
        
    }
    
    //Set the number of players from the first screen 
    public void setNumberOfPlayers(int number)
    {
        playerCount = number;
    }

    //Reset scene so next player can choose their avatar 
    public void resetScene()
    {
        num++;
        playerNumberLabel.setText("Player " + num + ":");
        catNameClick.setVisible(false);
        border.setVisible(false);
        okayButton.setDisable(true);
        
    }
    
   
    
    //If the cats name was chosen, set chosen array to false, then disable
    //and lower opacity of the avatar, so no one else can choose it 
    public void disableAvatars(String name)
    {
        
        if(cats[0] == name)
        {
            chosenCat[0] = true;
            LUNA.setOpacity(.3);
            LUNA.setDisable(true);
        }
            else if(cats[1] == name)
            {
                chosenCat[1] = true;
                BUSINESS_CAT.setOpacity(.3);
                BUSINESS_CAT.setDisable(true);
            }
            else if(cats[2] == name)
            {
                chosenCat[2] = true;
                CURSED_CAT.setOpacity(.3);
                CURSED_CAT.setDisable(true);
            }
            else if(cats[3] == name)
            {
                chosenCat[3] = true;
                ZED.setOpacity(.3);
                ZED.setDisable(true);
            }
            else if(cats[4] == name)
            {
                chosenCat[4] = true;
                DIZZY.setOpacity(.3);
                DIZZY.setDisable(true);
            }
            else if(cats[5] == name)
            {
                chosenCat[5] = true;
                SPOOKY.setOpacity(.3);
                SPOOKY.setDisable(true);
            }
            else if(cats[6] == name)
            {
                chosenCat[6] = true;
                GEOFF.setOpacity(.3);
                GEOFF.setDisable(true);
            }
            else if(cats[7] == name)
            {
                chosenCat[7] = true;
                SALEM.setOpacity(.3);
                SALEM.setDisable(true);
            }
    }
    
 
 }

