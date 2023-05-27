
package calculatorgui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class CalculatorGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //labels
        Text num1_lbl = new Text("First Number");
        Text num2_lbl = new Text("Second Number");
        Text ans_lbl = new Text("Answer");
        Text op_lbl = new Text("Operations");
        
        //textfields
        TextField num1_tf = new TextField();
        TextField num2_tf = new TextField();
        
        //buttons
        Button sum_btn = new Button("Sum");
        Button difference_btn = new Button("Difference");
        Button average_btn = new Button("Average");
        Button divide_btn = new Button("Divide");
        
        //buttons handling
        sum_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                String num1 = num1_tf.getText();
                String num2 = num2_tf.getText();
                //convert string to int
                int num1_int = Integer.parseInt(num1);
                int num2_int = Integer.parseInt(num2);
                int sum_result = num1_int + num2_int;
               
                String sum_result_string = Integer.toString(sum_result);
                ans_lbl.setText(sum_result_string);
            }
        }));
 difference_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                String num1 = num1_tf.getText();
                String num2 = num2_tf.getText();
                //convert string to int
                int num1_int = Integer.parseInt(num1);
                int num2_int = Integer.parseInt(num2);
                int difference_result = num1_int - num2_int;
                String difference_result_string = Integer.toString(difference_result);
                ans_lbl.setText(difference_result_string);
            }
        }));
        
        average_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                String num1 = num1_tf.getText();
                String num2 = num2_tf.getText();
                //convert string to int
                int num1_int = Integer.parseInt(num1);
                int num2_int = Integer.parseInt(num2);
                int average_result = (num1_int + num2_int)/2;
                String average_result_string = Integer.toString(average_result);
                ans_lbl.setText(average_result_string);
            }
        }));
  divide_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                String num1 = num1_tf.getText();
                String num2 = num2_tf.getText();
                //convert string to int
                int num1_int = Integer.parseInt(num1);
                int num2_int = Integer.parseInt(num2);
                int divide_result = num1_int / num2_int;
                
                String divide_result_string = Integer.toString(divide_result);
                ans_lbl.setText(divide_result_string);
            }
        }));
        
        //container
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        //add nodes to container
        gridPane.add(num1_lbl, 1, 1);
        gridPane.add(num1_tf, 2, 1);
        gridPane.add(num2_lbl, 3, 1);
        gridPane.add(num2_tf, 4, 1);
        
        gridPane.add(ans_lbl, 1, 2);
 gridPane.add(op_lbl, 1, 3);
        gridPane.add(sum_btn, 2, 3);
        gridPane.add(difference_btn, 3, 3);
        gridPane.add(average_btn, 4, 3);
        gridPane.add(divide_btn, 5, 3);

        
        primaryStage.setTitle("Calculator");
         Scene myscene = new Scene(gridPane);
        primaryStage.setScene(myscene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
