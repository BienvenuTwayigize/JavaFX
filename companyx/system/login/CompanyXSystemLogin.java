/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyx.system.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
public class CompanyXSystemLogin extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 
        //labels
        Text username_lbl = new Text("User Name");
         Text password_lbl = new Text("Password");
        
        
          //textfields
        TextField username_tf = new TextField();
        //Passwordfield
        PasswordField password_tf = new PasswordField();
        
           //Buttons
        Button login_btn = new Button("Login");
        Button register_btn= new Button("Register"); 
        // buttons handling
        login_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                String  username = username_tf.getText();
                String password = password_tf.getText();}
        } ));
              //Event Handler for the Register_button 
        register_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                String  username = username_tf.getText();
                String password = password_tf.getText();
                
             try{
          Class.forName("com.mysql.cj.jdbc.Driver"); //step one
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");//Establishing connection
          Statement st_object=con.createStatement();   //step three
          String statement =  "INSERT INTO `users` (`user`, `password`) VALUES ('"+username_tf.getText()+"', '"+password_tf.getText()+"')";
          st_object.executeUpdate(statement);
           Alert al = new Alert(Alert.AlertType.CONFIRMATION);
           al.setContentText("User Successfuly Registered");
           al.show();
            //You can add the code to open HomePage (after successful login)          
          con.close();
           
        }
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");
          System.out.println("Wee msee");
         Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("User NOT Successfuly Registered");
                    a.show();
               }
            }
            
            
  }
            ));
        
        //Event Handler for the login_button    
    login_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {        
        String username = username_tf .getText();
        String password = password_tf.getText();     
        try{
          Class.forName("com.mysql.cj.jdbc.Driver"); //step one
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");//Establishing connection
          //Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/testdb?autoReconnect=true&useSSL=false","root","root");  //step two
         
          Statement st=con.createStatement();   //step three
          String statement = "SELECT * FROM testdb.users Where user = '"+username_tf.getText()+"' AND password = '"+password_tf.getText()+"' ";
          ResultSet rs = st.executeQuery(statement); //step four
          System.out.println(rs);
         
          if(rs.next()){                  
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Login");
                    al.show();
                    //You can add the code to open HomePage (after successful login)

                    home h = new home();
                    h.start(h.homeStage);
                    
  }
          else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("Invalid User Name or Password");
                    a.show();
  }
          con.close();
           
        }
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
     
       
        }
    }));
        
        
        //container
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        
        //add nodes to container
        
          gridPane.add(username_lbl,1,2);
          gridPane.add(username_tf,2,2,2,1);
          
          gridPane.add(password_lbl,1,3);
          gridPane.add(password_tf,2,3,2,1);
          
          
      
        gridPane.add(login_btn, 2, 4);
        gridPane.add(register_btn, 3, 4);
     
        
        primaryStage.setTitle("CompanyX System Login");
         //Creating the scene
         Scene myscene = new Scene(gridPane);
         //Adding the scene to the stage
        primaryStage.setScene(myscene);
         //Showing the stage
        primaryStage.show();
    
            }
          
  
    /**
     * @param args the command line arguments
     */
          
    public static void main(String[] args) {
        launch(args);
    }
}  
