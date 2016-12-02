/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javax.swing.ListSelectionModel;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static program.Test_AppController.testTempUsername;

/**
 * FXML Controller class
 *
 * @author BS-PARK
 */
public class TestController implements Initializable {
    MainController main = new MainController();
      Connection conn = DB.LoginConnector();

    ObservableList<test> testdata = FXCollections.observableArrayList(); // 테이블 생성
    


  PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    
@FXML private TableView<test> testtable;
    @FXML private TableColumn<? , ?> testnoCol;
    @FXML private TableColumn<? , ?> testownerCol;
    
    @FXML private TableColumn<? , ?> testIdCol;
    @FXML  private TableColumn<? , ?> testuserIdCol;
    
    @FXML private TableColumn<? , ?> testtankNoCol;
    @FXML private TableColumn<? , ?> testlastCargoCol;
    @FXML private TableColumn<? , ?> testinDateCol;
    @FXML private TableColumn<? , ?> testsortCol;
    @FXML private TableColumn<? , ?> testmfdCol;
    @FXML private TableColumn<? , ?> testl2_5YrCol;
    @FXML private TableColumn<? , ?> testl5YrCol;
    @FXML  private TableColumn<? , ?> testlastTestCol;
    
    @FXML private TableColumn<? , ?> testpTestCol;
    @FXML private TableColumn<? , ?> testCompanyCol;
    @FXML private TableColumn<? , ?> testremarkCustomerCol;
    @FXML private TableColumn<? , ?> testremarkCompanyCol;
    
    @FXML private TableColumn<? , ?> testEstDateCol;
    @FXML private TableColumn<? , ?> testEstAppCol;
    
    
     @FXML private TableColumn<? , ?> testExtDateCol;
    @FXML private TableColumn<? , ?> testTestComCol;
    @FXML private TableColumn<? , ?> testAirTestComCol;
    @FXML private TableColumn<? , ?> testCleaningComCol;
    @FXML private TableColumn<? , ?> testRepairComCol;
    
    @FXML private MenuItem menuNon;
    @FXML private MenuItem menu25yr;
    @FXML private MenuItem menu5yr;
    
    
    
    //@FXML private ContextMenu testmenu;
    @FXML private Menu testCompanymenu;
    @FXML private Menu pTestmenu;
    @FXML private Button testBefore_afterExchangeButton;
    @FXML private Button testEstButton;
    @FXML private Button makeingEstTestingButton;
    
    
    @FXML private ComboBox<String> testBeforeEst;
    @FXML private ComboBox<String> pTestCompany;
    @FXML private ComboBox<String> testOwnerCompany;
    
    
    
    
    @FXML private DatePicker beforeEstDate;
    @FXML private DatePicker afterEstDate;
    
    
    final ObservableList<String> testbeforeEstList = FXCollections.observableArrayList("작성 전","승인 전"); 
      final ObservableList<String> pTestCompanyList = FXCollections.observableArrayList(); 
    final ObservableList<String> testOnwerList = FXCollections.observableArrayList(); 
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          testnoCol.setCellValueFactory(new PropertyValueFactory<>("testno"));
       testIdCol.setCellValueFactory(new PropertyValueFactory<>("testId"));
       testownerCol.setCellValueFactory(new PropertyValueFactory<>("testowner"));
       testuserIdCol.setCellValueFactory(new PropertyValueFactory<>("testuserId"));
       
       testtankNoCol.setCellValueFactory(new PropertyValueFactory<>("testtankNo"));
       testlastCargoCol.setCellValueFactory(new PropertyValueFactory<>("testlastcargo"));
       testinDateCol.setCellValueFactory(new PropertyValueFactory<>("testindate"));
       testsortCol.setCellValueFactory(new PropertyValueFactory<>("testsort"));
       
       testmfdCol.setCellValueFactory(new PropertyValueFactory<>("testmfd"));
       testl2_5YrCol.setCellValueFactory(new PropertyValueFactory<>("testl2_5yr"));
       testl5YrCol.setCellValueFactory(new PropertyValueFactory<>("testl5yr"));
       testlastTestCol.setCellValueFactory(new PropertyValueFactory<>("testlasttest"));
       
       testpTestCol.setCellValueFactory(new PropertyValueFactory<>("testptest"));
       testEstDateCol.setCellValueFactory(new PropertyValueFactory<>("testEstDate"));
       testCompanyCol.setCellValueFactory(new PropertyValueFactory<>("testCompany"));
       testEstAppCol.setCellValueFactory(new PropertyValueFactory<>("testEstApp"));
       
       testExtDateCol.setCellValueFactory(new PropertyValueFactory<>("testExtdate"));
       testTestComCol.setCellValueFactory(new PropertyValueFactory<>("testtestcom"));
       testAirTestComCol.setCellValueFactory(new PropertyValueFactory<>("testairtestcom"));
       testCleaningComCol.setCellValueFactory(new PropertyValueFactory<>("testcleaningcom"));
       testRepairComCol.setCellValueFactory(new PropertyValueFactory<>("testrepaircom"));
       testremarkCustomerCol.setCellValueFactory(new PropertyValueFactory<>("testremarkcustomer"));
       testremarkCompanyCol.setCellValueFactory(new PropertyValueFactory<>("testremarkcompany"));
       
       
     
       // testBeforeEst.setValue("작성 전");
        
        
        loadDatabaseDataTest();
        ptestCompany();
        testOwner();
//        
//        
       // testComBoBox.setItems(testList);
       // sortComBoBox.setItems(sortList);
       
        testBeforeEst.setItems(testbeforeEstList);
        
        
           String pattern = "yyyy-MM-dd";
        //format in datepicker
        Locale.setDefault(Locale.US);
       // tankInDateBox.setPromptText("dd-mm-yyyy");

       beforeEstDate.setConverter(new StringConverter<LocalDate>() {
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
       
       
       afterEstDate.setConverter(new StringConverter<LocalDate>() {
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
    public void loadDatabaseDataTest() {
        String query = null;
       
        if (testBeforeEst.getValue() == null){
            System.out.println("1");
            query = "select * from Table1 WHERE (([Ptest] = '2.5Yr' or [Ptest] = '5Yr') AND ([TEstDate] = '')) OR (([Ptest] = '2.5Yr' or [Ptest] = '5Yr') AND ([TEstDate] Is Null))";
            testBeforeEst.setValue("작성 전");
            
        }else if(testBeforeEst.getValue().equals("작성 전")){
            System.out.println("2");
            query = "select * from Table1 WHERE (([Ptest] = '2.5Yr' or [Ptest] = '5Yr') AND ([TEstDate] = '')) OR (([Ptest] = '2.5Yr' or [Ptest] = '5Yr') AND ([TEstDate] Is Null))";
        }else if(testBeforeEst.getValue().equals("승인 전")){
            System.out.println("3");
            query = "select * from Table1 WHERE (([Ptest] = '2.5Yr' OR [Ptest] = '5Yr') AND  [TestDate]<>'' And [Test_A_Date] = '' AND Test_Reject_Date = '') OR  (([Ptest] = '2.5Yr' OR [Ptest] = '5Yr') AND  [TestDate] Is Not Null And [Test_A_Date] Is Null AND [Test_Reject_Date] Is Null) ";
        
            
        }
        try{
            testdata.clear();
            //inDateBox.setValue(LocalDate.now());
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                testdata.add(new test(
                        rs.getRow(),
                       rs.getString("Id"),
                        rs.getString("owner"),
                       rs.getString("userId"),
                       rs.getString("tankNo"),
                       rs.getString("lastCargo"),
                       rs.getString("inDate"),        
                       rs.getString("sort"),
                       rs.getString("mfg"),
                       rs.getString("l2_5Yr"),
                       rs.getString("l5Yr"),
                       rs.getString("lastTest"),       
                       rs.getString("pTest"),        
                        rs.getString("t_com"),     
                       rs.getString("testdate"),       
                       rs.getString("test_a_date"),        
                        
                        rs.getString("Ext_Date"),
                        rs.getString("remark"),
                        rs.getString("remark"),
                        rs.getString("remark"),
                        rs.getString("remark"),
                       rs.getString("remark"),
                       rs.getString("require"),
                        rs.getString("test_qt"),
                        rs.getString("hydro")
                ));
                testtable.setItems(testdata);
            }
                preparedStatement.close();
                rs.close();
                beforeEstDate.setValue(null);
                testTempUsername = "";
        
        }
        catch(Exception e){
            
            System.out. println("문제1");
            
        }
        
    }
     static String testTempUsername;
 static String testTempPtest;
 static String testTankNo;
 static String testCompany;
 
 public void showonClickTestPage1(){
        
        
 
 try{
    test user = (test)testtable.getSelectionModel().getSelectedItem();
            
            String query ="SELECT * From Table1";
            preparedStatement=conn.prepareStatement(query);
            testTempUsername = user.getTestId();
         
            testTankNo = user.getTesttankNo();
            testTempPtest = user.getTestptest();
            testCompany = user.getTestCompany();
          
            beforeEstDate.setValue(LocalDate.parse(user.getTestEstDate()));
            
           // ptestCompany();
            switch(testTempPtest){
                case "Non": menuNon.setVisible(false);
                            menu25yr.setVisible(true);
                            menu5yr.setVisible(true);
                            break;
                            
                case "2.5YR": menuNon.setVisible(true);
                            menu25yr.setVisible(false);
                            menu5yr.setVisible(true);
                            break;            
                case "5YR": menuNon.setVisible(true);
                            menu25yr.setVisible(true);
                            menu5yr.setVisible(false);
                            break;
                            
            }
//       
            preparedStatement.close(); 
            rs.close( );      
            
}
 catch(SQLException e){
            System.out.println(e);
            System.out.println("show click");
}     
 
 
 } 
  
  
 @FXML
  public void testPtestToNon() {
      preparedStatement = null;
         try{
            String sql = "update table1 set  ptest = ? where ID = "+ testTempUsername +"";
             preparedStatement =conn.prepareStatement(sql);
             
             
                preparedStatement.setString(1,"Non");
                preparedStatement.executeUpdate();
             preparedStatement.close();
         Program.showInformationAlertBox(testTankNo +   "  Non 으로 " + "수정 되었습니다.......");
       loadDatabaseDataTest();
         
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
     }
        
     }
  
   @FXML
  public void testPtestTo25YR() {
      preparedStatement = null;
         try{
            String sql = "update table1 set  ptest = ? where ID = "+ testTempUsername +"";
             preparedStatement =conn.prepareStatement(sql);
             
             
                preparedStatement.setString(1,"2.5YR");
                preparedStatement.executeUpdate();
                preparedStatement.close();
         Program.showInformationAlertBox(testTankNo + " 수정 되었습니다.......");
       loadDatabaseDataTest();
         
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
         System.out.println("ptest");
     }
        
     }
  
   @FXML
  public void testPtestTo5YR() {
      preparedStatement = null;
         try{
            String sql = "update table1 set  ptest = ? where ID = "+ testTempUsername +"";
             preparedStatement =conn.prepareStatement(sql);
             
             
                preparedStatement.setString(1,"5YR");
                preparedStatement.executeUpdate();
                preparedStatement.close();
                Program.showInformationAlertBox(testTankNo + " 수정 되었습니다.......");
                loadDatabaseDataTest();
         
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
         System.out.println("5");
     }
        
     }
  
  
  ///주기검사 페이지 주기검사 업체 
   public void ptestCompany(){
         String query = "select * from testcom ORDER by testcom";
         
        try{
               pTestCompanyList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                
                //if(!testCompany.equals(rs.getString("testcom")))  {
                 
                    
               // testCompanymenu.getItems().add(new MenuItem(rs.getString("testcom")));
                pTestCompanyList.add(rs.getString("testcom"));
                pTestCompany.setItems(pTestCompanyList);
            //}
            }
                    
                    
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
            System.out.println("ptestcompany");
        }
     
   }
  public void testOwner(){
         String query = "select * from owner ORDER by owner";
         
        try{
               testOnwerList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                
                //if(!testCompany.equals(rs.getString("testcom")))  {
                 
                    
               // testCompanymenu.getItems().add(new MenuItem(rs.getString("testcom")));
                testOnwerList.add(rs.getString("owner"));
                testOwnerCompany.setItems(testOnwerList);
            //}
            }
                    
                    
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
            System.out.println("owner");
        }
     
   }
  
        
         @FXML
  public void testCompanyEdit() {
      
  
             if(pTestCompany.getValue() != null) {
                    preparedStatement = null;
         try{
                    String sql = "update table1 set  t_com = ? where ID = "+ testTempUsername +"";
                      preparedStatement =conn.prepareStatement(sql);


                    preparedStatement.setString(1,pTestCompany.getValue());
                    pTestCompany.setValue(null);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                   // Program.showInformationAlertBox(testTankNo + " 수정 되었습니다.......");
                    
                    loadDatabaseDataTest();
                    
         
             }  
                    catch(SQLException e){
                        System.out.println(e.getMessage());
                        System.out.println("testcompanyedit");
                    }
         
        
//             
            }else{
                 
             }
                 
  }
  
  @FXML
  public void testOwnerEdit() {
      
           if(testOwnerCompany.getValue() != null) {
                   preparedStatement = null;
           
             
         try{
                    String sql = "update table1 set  owner = ? where ID = "+ testTempUsername +"";
                  
                      preparedStatement =conn.prepareStatement(sql);


                    preparedStatement.setString(1,testOwnerCompany.getValue());
                    
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                   // Program.showInformationAlertBox(testTankNo + " 수정 되었습니다.......");
                    
                    loadDatabaseDataTest();
                    testOwnerCompany.setValue(null);
         
             }  
                    catch(SQLException e){
                        System.out.println(e.getMessage());
                        System.out.println("testownereidt");
                    }
         
        
           }
            
                 
             }
  
  
  
  
   @FXML
  public void beforeEstDateEdit() throws IOException {
      if (testTempUsername.equals("")){
          Program.showErrorName("번호 선택후 수정하세요!");
                  } else if(beforeEstDate.getValue()==null){
                      Program.showErrorName("날짜를 선택후 수정하세요!");
                  }else{
         try{
                    String sql = "update table1 set  testdate = ?, test_a_date = ? where ID = "+ testTempUsername +"";
                    preparedStatement =conn.prepareStatement(sql);
                    preparedStatement.setString(1,beforeEstDate.getEditor().getText());
                    preparedStatement.setString(2,afterEstDate.getEditor().getText());
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    Program.showInformationAlertBox(testTankNo + " 수정 되었습니다.......");
                    
                    loadDatabaseDataTest();
                    main.testApp();
                    beforeEstDate.getEditor().clear();
                    afterEstDate.getEditor().clear();
         
             }  
                    catch(SQLException e){
                        System.out.println(e.getMessage());
                        System.out.println("testownereidt");
                    }
      
                              }
        
           }
            
      @FXML
      public void loadingToghter() throws IOException {
          
          
          
          
          loadDatabaseDataTest();
          main.testApp();
                   
          
            
           
          
             
}
      
      
}