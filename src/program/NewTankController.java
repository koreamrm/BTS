/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author BS-PARK
 */
public class NewTankController implements Initializable {
@FXML Button addBtn;
@FXML ComboBox <String> customerComBox;
@FXML TextField tankNoBox;
@FXML TextField lastCargoBox;
@FXML DatePicker tankInDateBox;
@FXML ComboBox<String> sortComBox;
@FXML TextArea remarkCustomerBox;
@FXML TextArea remarkCompanyBox;
@FXML Label tankNoCheck;

@FXML TextField trackerCompanyBox;
@FXML TextField trackerNameBox;
@FXML TextField trackerNoBox;
@FXML TextField trackerHPBox;

@FXML CheckBox urgentCheckBox;







 @FXML private javafx.scene.control.Button closeButton; 
 
   Connection conn = DB.LoginConnector();
   PreparedStatement preparedStatement = null;
   ResultSet rs = null;
   
    TankInController loaddDate = new TankInController();
 
    
  //Combobox list
  
   final ObservableList<String> customerList = FXCollections.observableArrayList(); // 고객사 리스트
    final ObservableList<String> sortList = FXCollections.observableArrayList("크리닝"); //  
    
    
    
    
    
    @FXML
private void closeButtonAction(){
   
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
    loaddDate.loadDatabaseData();
    
    
}
 
    
    
    
    @FXML
private void tankNoCheck(){
   
   //tankNo 자릿수 확인
        int tankNo = tankNoBox.getLength();
        
        if(tankNo != 10){
            tankNoCheck.setText("X");
            
            
        }else
        tankNoCheck.setText("OK");
    
}  

    
    
    
    
    
 public void AddNewGasket() throws SQLException, ParseException{
    
     String tankNo = tankNoBox.getText();
     
     
     
      String query = "INSERT INTO gasket(TankNo)  VALUES(?)";
      preparedStatement = null;
      
      
      try{
         preparedStatement=conn.prepareStatement(query);
          preparedStatement.setString(1,tankNo);
          
         
      } 
      catch(SQLException e){
          System.out.println(e.getErrorCode());
      }
      finally{
          preparedStatement.execute();
          preparedStatement.close();
      }
     
      
      
     
      
 
         
     }
    



@FXML
public void AddNew() throws SQLException, ParseException{
    if(urgentCheckBox.isSelected()){
        AddNewUserUrgent();
    }else
        AddNewUserNomal();
}
   

 public void AddNewUserNomal() throws SQLException, ParseException{
    
     
     
    
     String tankNo = tankNoBox.getText();
     String customer = customerComBox.getValue();
     String lastCargoName = lastCargoBox.getText();
     String tankInDate = tankInDateBox.getEditor().getText();
     String sort = sortComBox.getValue();
     
     String remarkCustomer= remarkCustomerBox.getText();
     String remarkCompany= remarkCompanyBox.getText();
     
     String trackerCompany = trackerCompanyBox.getText();
     String trackerName = trackerNameBox.getText();
     String trackerHP = trackerHPBox.getText();
     String trackerNo = trackerNoBox.getText();
     
     
     
          
     
    
     
     
     if(tankNo.equals("")){
         Program.showErrorName("TankNo. requreid");
     }
     else if(customer.equals("Customer")){
         Program.showErrorName("customer reureid");
         
     }
     else if(lastCargoName.equals("")){
         Program.showErrorName("LastCargoName reureid");
     }   
        else if(lastCargoName.equals("Sort")){
         Program.showErrorName("Sort reureid");
          
     }
     
        else {
      String query = "INSERT INTO table1(TankNo, UserId, lastCargo, InDate, sort, Require, Remark,In_Truck_Company,  In_Truck_HP, In_Truck_Name, In_Truck_No  ) "
              + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
      preparedStatement = null;
      
      
      try{
         preparedStatement=conn.prepareStatement(query);
          preparedStatement.setString(1,tankNo);
          preparedStatement.setString(2,customer);
          preparedStatement.setString(3,lastCargoName);
         preparedStatement.setString(4,tankInDate);
         preparedStatement.setString(5,sort);
        
         preparedStatement.setString(6,remarkCustomer);
         preparedStatement.setString(7,remarkCompany);
         
         preparedStatement.setString(8,trackerCompany);
         preparedStatement.setString(9,trackerHP);
         preparedStatement.setString(10,trackerName);
         preparedStatement.setString(11,trackerNo);
//         
         
          
          
          
         
      } 
      catch(SQLException e){
          System.out.println(e.getErrorCode());
      }
      finally{
          preparedStatement.execute();
          
          preparedStatement.close();
          AddNewGasket();
      }
     
      
      
      customerComBox.setValue(null);
      tankNoBox.clear();
      lastCargoBox.clear();
      
      tankInDateBox.setValue(LocalDate.now());
      sortComBox.setValue(null);
      remarkCustomerBox.clear();
      remarkCompanyBox.clear();
      trackerCompanyBox.clear();
      trackerHPBox.clear();
      trackerNameBox.clear();
      trackerNoBox.clear();
      tankNoCheck.setText(null);
      
      
      
      
      
      Program.showInformationAlertBox(tankNo + "일반 크리닝으로 입력되었습니다.");
         
     }
    


 }

 
 public void AddNewUserUrgent() throws SQLException, ParseException{
    
     
     
    
     String tankNo = tankNoBox.getText();
     String customer = customerComBox.getValue();
     String lastCargoName = lastCargoBox.getText();
     String tankInDate = tankInDateBox.getEditor().getText();
     String sort = sortComBox.getValue();
     
     String remarkCustomer= remarkCustomerBox.getText();
     String remarkCompany= remarkCompanyBox.getText();
     
     String trackerCompany = trackerCompanyBox.getText();
     String trackerName = trackerNameBox.getText();
     String trackerHP = trackerHPBox.getText();
     String trackerNo = trackerNoBox.getText();
     
     
     
          
     
    
     
     
     if(tankNo.equals("")){
         Program.showErrorName("TankNo. requreid");
     }
     else if(customer.equals("Customer")){
         Program.showErrorName("customer reureid");
         
     }
     else if(lastCargoName.equals("")){
         Program.showErrorName("LastCargoName reureid");
     }   
        else if(lastCargoName.equals("Sort")){
         Program.showErrorName("Sort reureid");
          
     }
     
        else {
      String query = "INSERT INTO table1(TankNo, UserId, lastCargo, InDate, sort, Require, Remark,In_Truck_Company,  In_Truck_HP, In_Truck_Name, In_Truck_No,Urgent  ) "
              + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
      preparedStatement = null;
      
      
      try{
         preparedStatement=conn.prepareStatement(query);
          preparedStatement.setString(1,tankNo);
          preparedStatement.setString(2,customer);
          preparedStatement.setString(3,lastCargoName);
         preparedStatement.setString(4,tankInDate);
         preparedStatement.setString(5,sort);
        
         preparedStatement.setString(6,remarkCustomer);
         preparedStatement.setString(7,remarkCompany);
         
         preparedStatement.setString(8,trackerCompany);
         preparedStatement.setString(9,trackerHP);
         preparedStatement.setString(10,trackerName);
         preparedStatement.setString(11,trackerNo);
         preparedStatement.setString(12,"Urgent");
//         
         
          
          
          
         
      } 
      catch(SQLException e){
          System.out.println(e.getErrorCode());
      }
      finally{
          preparedStatement.execute();
          
          preparedStatement.close();
          AddNewGasket();
      }
     
      
      
      customerComBox.setValue(null);
      tankNoBox.clear();
      lastCargoBox.clear();
      
      tankInDateBox.setValue(LocalDate.now());
      sortComBox.setValue(null);
      remarkCustomerBox.clear();
      remarkCompanyBox.clear();
      trackerCompanyBox.clear();
      trackerHPBox.clear();
      trackerNameBox.clear();
      trackerNoBox.clear();
      tankNoCheck.setText(null);
      
      
      
      
      
      Program.showInformationAlertBox(tankNo+ "긴급 크리닝으로 입력되었습니다.");
         
     }
    


 }
 
 

 
 public void CustomerComboBox(){
         String query = "select * from Customer";
        try{
           
            customerList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            
            while(rs.next()){
                customerList.add(rs.getString("Customer"));
                customerComBox.setItems(customerList);
               
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
 
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        

        
        CustomerComboBox();
        sortComBox.setItems(sortList);
          
        // 대문자로 변환
        tankNoBox.textProperty().addListener((ov, oldValue, newValue) -> {
        tankNoBox.setText(newValue.toUpperCase());
});
        
        
        lastCargoBox.textProperty().addListener((ov, oldValue, newValue) -> {
        lastCargoBox.setText(newValue.toUpperCase());
});
        
        
     
        
        // TODO
         String pattern = "yyyy-MM-dd";
        //format in datepicker
        Locale.setDefault(Locale.US);
        tankInDateBox.setValue(LocalDate.now());
       tankInDateBox.setPromptText("dd-mm-yyyy");

       tankInDateBox.setConverter(new StringConverter<LocalDate>() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
        
        
        

     @Override 
     public String toString(LocalDate date) {
         if (date != null) {
             return dateFormatter.format(date);
         } else {
             return "";
         }
     }

     @Override 
     public LocalDate fromString(String string) {
         if (string != null && !string.isEmpty()) {
             return LocalDate.parse(string, dateFormatter);
         } else {
             return null;
         }
     }
 });
        
         
    }    
    
}
