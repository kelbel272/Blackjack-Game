
package project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Project4 extends Application {
    
   
    
    public static void main(String[] args) {
      
        launch(args);
    }
   
    
    
    @Override
    public void start(Stage stage) throws Exception {
        // change the name of your fxml file to match
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("BlackCatJack");
        stage.setScene(scene);
        stage.show();
        
    }
    
    
}
