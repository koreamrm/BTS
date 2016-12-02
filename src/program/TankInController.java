/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;


/**
 * FXML Controller class
 *
 * @author BS-PARK
 */
public class TankInController implements Initializable {
/// 콤보박스
    final ObservableList<String> customerList = FXCollections.observableArrayList(); // 고객사 리스트
    final ObservableList<String> sortList = FXCollections.observableArrayList("크리닝"); // 
    final ObservableList<String> testList = FXCollections.observableArrayList("Non","2.5yr", "5yr"); // testlist
    final ObservableList<String> airList = FXCollections.observableArrayList(); 
    final ObservableList<String> topList = FXCollections.observableArrayList(); 
    final ObservableList<String> frameList = FXCollections.observableArrayList(); 
    final ObservableList<String> gaugeList = FXCollections.observableArrayList(); 
    final ObservableList<String> spillboxList = FXCollections.observableArrayList(); 
    final ObservableList<String> walkwayList = FXCollections.observableArrayList(); 
    final ObservableList<String> bottomList = FXCollections.observableArrayList(); 
    final ObservableList<String> documentList = FXCollections.observableArrayList(); 
    
    
    Connection conn = DB.LoginConnector();
    ObservableList<tankIn> data = FXCollections.observableArrayList(); // 테이블 생성
    
     
    PreparedStatement preparedStatement = null;
    
    ResultSet rs = null;
    
    
     @FXML private DatePicker inDateBox; 
   @FXML private TextField tankNoBox;
   @FXML private TextField lastCargoBox;
   @FXML private TextField capacityBox;
   @FXML private TextField tareWeightBox;
   @FXML private TextField mgwBox;
   @FXML private TextField mfdBox;
   @FXML private TextField l2_5yrBox;
   @FXML private TextField l5yrBox;
   
   @FXML private TextArea remarkCustomerBox;
   @FXML private TextArea remarkCompanyBox;
   
   
   @FXML private ComboBox<String> customerComBoBox;
   @FXML private ComboBox<String> sortComBoBox;
   @FXML private ComboBox<String> testComBoBox;
   @FXML private ComboBox<String> airlineComBoBox;
   @FXML private ComboBox<String> topComBoBox;
   @FXML private ComboBox<String> frameComBoBox;
   @FXML private ComboBox<String> gaugeComBoBox;
   @FXML private ComboBox<String> walkWayComBoBox;
   @FXML private ComboBox<String> bottomComBoBox;
   @FXML private ComboBox<String> documentComBoBox;
   @FXML private ComboBox<String> spillBoxComBoBox;
   @FXML  TableView<tankIn> table;
    @FXML private TableColumn<? , ?> IdCol;
    @FXML private TableColumn<? , ?> userIdCol;
    @FXML private TableColumn<? , ?> faketankNoCol;
    @FXML private TableColumn<? , ?> tankNoCol;
    @FXML private TableColumn<? , ?> lastCargoCol;
    @FXML private TableColumn<? , ?> inDateCol;
    @FXML private TableColumn<? , ?> sortCol;
    @FXML private TableColumn<? , ?> capaCityCol;
    @FXML private TableColumn<? , ?> tareWeightCol;
    @FXML private TableColumn<? , ?> mgwCol;
    @FXML private TableColumn<? , ?> mfdCol;
    @FXML private TableColumn<? , ?> l2_5YrCol;
    @FXML private TableColumn<? , ?> l5YrCol;
    @FXML private TableColumn<? , ?> lastTestCol;
    
    @FXML private TableColumn<? , ?> pTestCol;
    @FXML private TableColumn<? , ?> remarkCustomerCol;
    @FXML private TableColumn<? , ?> remarkCompanyCol;
    @FXML private TableColumn<? , ?> urgentCol;
    @FXML private TableColumn<? , ?> noCol;
    
    
    @FXML private Button addTank;
    @FXML private Button f5;
    @FXML private Button update;
    
    
    @FXML private MenuItem urgentCleaning;
    @FXML private MenuItem otherCleaning;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //숫자 천단위
       // DecimalFormat df = new DecimalFormat("###,##0");
        //df.format(capacityBox);
       
       // System.out.println(str);
        
        
        //대문자 변환
        tankNoBox.textProperty().addListener((ov, oldValue, newValue) -> {
        tankNoBox.setText(newValue.toUpperCase());
});
        
        
        lastCargoBox.textProperty().addListener((ov, oldValue, newValue) -> {
        lastCargoBox.setText(newValue.toUpperCase());
  });        
        
          String pattern = "yyyy-MM-dd";
        //format in datepicker
        Locale.setDefault(Locale.US);
       // tankInDateBox.setPromptText("dd-mm-yyyy");

       inDateBox.setConverter(new StringConverter<LocalDate>() {
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
       
    // Table생성 입고
       IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
       userIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
       faketankNoCol.setCellValueFactory(new PropertyValueFactory<>("fakeTankNo"));
       tankNoCol.setCellValueFactory(new PropertyValueFactory<>("tankNo"));
       lastCargoCol.setCellValueFactory(new PropertyValueFactory<>("lastcargo"));
       inDateCol.setCellValueFactory(new PropertyValueFactory<>("indate"));
       sortCol.setCellValueFactory(new PropertyValueFactory<>("sort"));
       capaCityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
       tareWeightCol.setCellValueFactory(new PropertyValueFactory<>("tareweight"));
       mgwCol.setCellValueFactory(new PropertyValueFactory<>("mgw"));
       mfdCol.setCellValueFactory(new PropertyValueFactory<>("mfd"));
       l2_5YrCol.setCellValueFactory(new PropertyValueFactory<>("l2_5yr"));
       l5YrCol.setCellValueFactory(new PropertyValueFactory<>("l5yr"));
       lastTestCol.setCellValueFactory(new PropertyValueFactory<>("lasttest"));
       
       pTestCol.setCellValueFactory(new PropertyValueFactory<>("ptest"));
       remarkCustomerCol.setCellValueFactory(new PropertyValueFactory<>("remarkcustomer"));
       remarkCompanyCol.setCellValueFactory(new PropertyValueFactory<>("remarkcompany"));
       urgentCol.setCellValueFactory(new PropertyValueFactory<>("urgent"));
       noCol.setCellValueFactory(new PropertyValueFactory<>("no"));
       
        loadDatabaseData();
        
        
        CustomerComboBox();
       
        AirListComboBox();
        TopListComboBox();
        FrameListComboBox();
        GaugeListComboBox();
        
        WalkwayListComboBox();
        BottomListComboBox();
        DocumentListComboBox();
        spillboxComboBox();
        
        
        
    } 
    
     public void loadDatabaseData() {
        
       
        String query = "select * from Table1";
        //WHERE ([Ext_Date] Is Not Null  AND [Out_Date] Is Null) OR ([Ext_Date] <> ''  AND [Out_Date] ='') ORDER by Ext_Date asc ";
        
        
         
        try{
//            
         
            data.clear();
            inDateBox.setValue(LocalDate.now());
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            
            while(rs.next()){
              
               
                
                data.add(new tankIn(
                        
                       rs.getString("Id"),
                       rs.getString("userId"),
                       rs.getString("tankNo"),
                       rs.getString("tankNo"),
                       rs.getString("lastCargo"),
                       rs.getString("inDate"),        
                       rs.getString("sort"),
                       rs.getString("capacity"),
                       rs.getString("tareWeight"),        
                       rs.getString("mgw"),
                       rs.getString("mfg"),
                       rs.getString("l2_5Yr"),
                       rs.getString("l5Yr"),
                       rs.getString("lastTest"),       
                       rs.getString("pTest"),        
                       rs.getString("remark"),
                       rs.getString("require"),
                       rs.getString("airvv"),
                       rs.getString("topvv"),
                       rs.getString("f_type"),
                       rs.getString("p_gauge"),
                        rs.getString("w_type"),
                        rs.getString("bottomvv"),
                        rs.getString("d_box"),
                        
                        rs.getString("s_cover"),
                        rs.getString("urgent"),
                        rs.getRow()
                        
                        
                        
                        
                        
                        
                ));
                table.setItems(data);
            }
                preparedStatement.close();
                rs.close();
                
                
            
        }
        catch(Exception e){
            
            System.out. println("문제");
            
        }
        
    }
     static  String tempUsername;
   static String tempTankNo;
   static String tempUrgent;
     @FXML
 public void showonClick(){
        
        
 
 try{
    tankIn user = (tankIn)table.getSelectionModel().getSelectedItem();
            
            String query ="SELECT * From Table1";
            preparedStatement=conn.prepareStatement(query);
            tempUsername = user.getId();
           tempTankNo = user.getTankNo();
           tempUrgent = user.getUrgent();
            
            
           tankNoBox.setText(user.getTankNo());
           customerComBoBox.setValue(user.getUserId());
           lastCargoBox.setText(user.getLastcargo());
           airlineComBoBox.setValue(user.getAirvalve());
           sortComBoBox.setValue(user.getSort());
           inDateBox.setValue(LocalDate.parse(user.getIndate()));
           
           
           capacityBox.setText(user.getCapacity());
           tareWeightBox.setText(user.getTareweight());
           mgwBox.setText(user.getMgw());
           mfdBox.setText(user.getMfd());
           l2_5yrBox.setText(user.getL2_5yr());
           l5yrBox.setText(user.getL5yr());
           testComBoBox.setValue(user.getPtest());
           
           airlineComBoBox.setValue(user.getAirvalve());
           topComBoBox.setValue(user.getTopvalve());
           frameComBoBox.setValue(user.getFrame());
           gaugeComBoBox.setValue(user.getGauge());
           walkWayComBoBox.setValue(user.getWalkway());
           bottomComBoBox.setValue(user.getBottomvalve());
           documentComBoBox.setValue(user.getDocument());
           spillBoxComBoBox.setValue(user.getSpillbox());
           
           remarkCustomerBox.setText(user.getRemarkcustomer());
           remarkCompanyBox.setText(user.getRemarkcompany());
           
//           if(user.getUrgent().equals("Urgent")){
//               urgent.setSelected(true);
//               
//           }else{
//               urgent.setSelected(false);
//           }
//            
            
            
                  
         
            //idBox.setText(user.getiD());
            preparedStatement.close(); 
            rs.close( );      
}
 catch(SQLException e){
            System.out.println(e);
}     
 
 
 }
 @FXML
 public void Update_Urgent_Main(){
     if((tempUrgent == null) || (tempUrgent ==  "") || (tempUrgent.equals(""))){
         
         UpdTankInUrgent();
     }else{
         
         UpdTankInUnurgent();
         
     }
 }
 
 public void UpdTankInNomal() throws ParseException{
    
     
    preparedStatement = null;
    
    
    
    
    
     if(tempUsername == null){
         Program.showErrorName("선택 후 수정하세요");
      }else{
        
     try{
         
        String sql = "update table1 set userid = ?, tankno = ? , lastcargo = ? , indate = ?, capacity = ? , tareweight = ? , mgw = ? , mfg= ?"
                + ", l2_5yr = ?, l5yr = ?, lasttest = ? , ptest = ?, airvv = ? , topvv = ? ,f_type =? , p_gauge=?, w_type=? , bottomvv = ?"
                + ",d_box = ? , s_cover = ?, remark = ?, require = ?, urgent = ? where ID = "+ tempUsername +"";
         
         preparedStatement =conn.prepareStatement(sql);
         
        
         preparedStatement.setString(1,customerComBoBox.getValue());
         preparedStatement.setString(2,tankNoBox.getText());
         
         preparedStatement.setString(3,lastCargoBox.getText());
         preparedStatement.setString(4,inDateBox.getEditor().getText());
         preparedStatement.setString(5,capacityBox.getText());
         preparedStatement.setString(6,tareWeightBox.getText());
         preparedStatement.setString(7,mgwBox.getText());
         preparedStatement.setString(8,mfdBox.getText());
         preparedStatement.setString(9,l2_5yrBox.getText());
         preparedStatement.setString(10,l5yrBox.getText());
         preparedStatement.setString(11,"라스트테스트 구하기");
         preparedStatement.setString(12,testComBoBox.getValue());
         preparedStatement.setString(13,airlineComBoBox.getValue());
         preparedStatement.setString(14,topComBoBox.getValue());
         preparedStatement.setString(15,frameComBoBox.getValue());
         
         preparedStatement.setString(16,gaugeComBoBox.getValue());
         preparedStatement.setString(17,walkWayComBoBox.getValue());
         preparedStatement.setString(18,bottomComBoBox.getValue());
         preparedStatement.setString(19,documentComBoBox.getValue());
         preparedStatement.setString(20,spillBoxComBoBox.getValue());
         
         preparedStatement.setString(21,remarkCustomerBox.getText());
         preparedStatement.setString(22,remarkCompanyBox.getText());
         preparedStatement.setString(23,"");
         
        
            
         preparedStatement.executeUpdate();
         preparedStatement.close();
         Program.showInformationAlertBox(tempTankNo + " 수정 되었습니다.");
       
         //System.out.println("완료");
         
         
                
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
         
     }
        
       
        loadDatabaseData();
     }
 }
 
 public void UpdTankInUrgent(){
    preparedStatement = null;
    
     if(tempUsername == null){
         Program.showErrorName("선택 후 수정하세요");
      }else{
        
     try{
         
        String sql = "update table1 set  urgent = ? where ID = "+ tempUsername +"";
         
         preparedStatement =conn.prepareStatement(sql);
         
        
         preparedStatement.setString(1,"Urgent");
         
        
            
         preparedStatement.executeUpdate();
         preparedStatement.close();
         Program.showInformationAlertBox(tempTankNo + " 수정 되었습니다.");
       
         //System.out.println("완료");
         
         
                
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
         
     }
        
       
        loadDatabaseData();
     }
 }
 
 public void UpdTankInUnurgent(){
    preparedStatement = null;
    
     if(tempUsername == null){
         Program.showErrorName("선택 후 수정하세요");
      }else{
        
     try{
         
        String sql = "update table1 set  urgent = ? where ID = "+ tempUsername +"";
         
         preparedStatement =conn.prepareStatement(sql);
         
        
         preparedStatement.setString(1,null);
         
        
            
         preparedStatement.executeUpdate();
         preparedStatement.close();
         Program.showInformationAlertBox(tempTankNo + " 수정 되었습니다.......");
       
         //System.out.println("완료");
         
         
                
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
         
     }
        
       
        loadDatabaseData();
     }
 }
 
//   고객사 리스트
    public void CustomerComboBox(){
         String query = "select * from Customer";
        try{
           
            customerList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            
            while(rs.next()){
                customerList.add(rs.getString("Customer"));
                customerComBoBox.setItems(customerList);
               
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void AirListComboBox(){
         String query = "select * from Air";
        try{
            topList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                airList.add(rs.getString("Air"));
                airlineComBoBox.setItems(airList);
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
      public void FrameListComboBox(){
         String query = "select * from Frame";
        try{
            frameList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                frameList.add(rs.getString("Frame"));
                frameComBoBox.setItems(frameList);
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
     public void GaugeListComboBox(){
         String query = "select * from Gauge";
        try{
            gaugeList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                gaugeList.add(rs.getString("Gauge"));
                gaugeComBoBox.setItems(gaugeList);
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
     
  
//      
        public void WalkwayListComboBox(){
         String query = "select * from Walkway";
        try{
            walkwayList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                walkwayList.add(rs.getString("Walkway"));
                walkWayComBoBox.setItems(walkwayList);
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
//        
         public void BottomListComboBox(){
         String query = "select * from Bottom";
        try{
            bottomList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                bottomList.add(rs.getString("Bottom"));
                bottomComBoBox.setItems(bottomList);
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
      public void DocumentListComboBox(){
         String query = "select * from Document";
        try{
            documentList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                documentList.add(rs.getString("Document"));
                documentComBoBox.setItems(documentList);
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
//         
//         
    public void TopListComboBox(){
         String query = "select * from Top";
        try{
           
           
            topList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            
            while(rs.next()){
                
                topList.add(rs.getString("Top"));
                topComBoBox.setItems(topList);
               
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
     
  public void spillboxComboBox(){
         String query = "select * from spillbox";
        try{
           
            spillboxList.clear();
            preparedStatement=conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();
            
            while(rs.next()){
                
                spillboxList.add(rs.getString("Spillbox"));
                spillBoxComBoBox.setItems(spillboxList);
               
            }
            preparedStatement.close();
                rs.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
  
  @FXML
  public void newTankAdd() {
      try{
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTank.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
       
          stage.setTitle("New Tank In");
          stage.setScene(new Scene(root));
          stage.initModality(Modality.NONE);
          stage.show();
          
          
      }catch(Exception e){
          System.out.println(e);
          
      }
  }
}
