/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author BS-PARK
 */
public class MainController implements Initializable {
@FXML Button tankInPage;
@FXML Button testPage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
    @FXML
    public void tankIn() throws IOException{
        Program.showTankIn();
}
    
     @FXML
    public void test() throws IOException{
        Program.showTest();
        Program.showTest_app();
}
      @FXML
    public void testApp() throws IOException{
        
        Program.showTest_app();
}
}
