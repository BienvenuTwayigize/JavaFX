


package companyx.system.login;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class home extends Application {
    
     static Stage homeStage = new Stage();
    @Override
    public void start(Stage my_Stage) {
         Text welcome_label = new Text("WELCOME TO NEW HOME");
         Button close_btn = new Button("Close");
       
        //GRIDPANE
        GridPane gridPane = new GridPane();
        gridPane.add(welcome_label,2,1);
        gridPane.add(close_btn,2,2);
       
        close_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         public void handle(MouseEvent event) {
          Stage stage = (Stage) close_btn.getScene().getWindow();            
            stage.close();            
         }
      }));
        gridPane.setMinSize(500,250);        
        gridPane.setVgap(10);        
        gridPane.setHgap(20);        
        gridPane.setAlignment(Pos.CENTER);
       
       
        //SCENE
        Scene my_scene = new Scene(gridPane);
       
        //STAGE
        my_Stage.setScene(my_scene);
        my_Stage.setTitle("Login Group C");
        my_Stage.show();
       
   
    }
    }
    

