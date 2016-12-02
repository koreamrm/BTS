/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;




/**
 * 
 * 
 *
 * @author BS-PARK
 */
public class Program extends Application {
    
    
    public static Stage stage;
    public static Stage stageNewTank;
   
    private static BorderPane mainLayout;
  //  private static TabPane mainLayout;
    
    private static BorderPane newTankpop;

   
    
    
//    @Override
//        public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        
//        
//      //  stage.setMaximized(true);
//        stage.show();
//           
           
                
               
        
       
//    }
 @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        
         Program.stage = primaryStage;
        
         Program.stage.setMaximized(true);
         Program.stage.setTitle("My Application");
         
        
        
        
        
         Program.showMain();
         Program.showTankIn();
        
          
//         
//        
//         
//         
//      
   } 
//     
      public static void showMain() throws IOException{
           FXMLLoader  loader = new FXMLLoader();
           loader.setLocation(Program.class.getResource("Main.fxml"));
           mainLayout = loader.load();
           Scene scene = new Scene(mainLayout);
           stage.setScene(scene);
           stage.show();
  
    }
     public static void showTankIn() throws IOException{
            FXMLLoader loader = new  FXMLLoader();
            loader.setLocation(Program.class.getResource("TankIn.fxml"));
            BorderPane mainItems = loader.load();
            mainLayout.setCenter(mainItems);
            mainLayout.setBottom(null);
           
           
            
            
      
        }
     public static void showTest() throws IOException{
            FXMLLoader loader = new  FXMLLoader();
            loader.setLocation(Program.class.getResource("Test.fxml"));
            BorderPane mainItems = loader.load();
            mainLayout.setCenter(mainItems);
           
           
            
            
      
        }
     
     
      public static void showTest_app() throws IOException{
            FXMLLoader loader = new  FXMLLoader();
            loader.setLocation(Program.class.getResource("Test_App.fxml"));
            BorderPane mainItems = loader.load();
            mainLayout.setBottom(mainItems);
            
           
           
            
            
      
        }
     
    public static void showNewTankAdd() throws IOException{
          
           FXMLLoader loader = new FXMLLoader();
           Stage newStage = new Stage();
            
           loader.setLocation(Program.class.getResource("NewTank.fxml"));
           newTankpop = loader.load();


            Scene stageScene = new Scene(newTankpop);
            newStage.setTitle("New tank information");
            
    
            newStage.initModality(Modality.APPLICATION_MODAL);
            
            newStage.setScene(stageScene);
            newStage.showAndWait();
            
    }
    
    
    
    
    public static void showInformationAlertBox(String message){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialoge");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            
        }
    
       public static void showErrorName(String msg){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
            
        }
    
       
       
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
