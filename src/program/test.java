/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import com.sun.javafx.css.Stylesheet;
import java.awt.SystemColor;
import static java.awt.SystemColor.text;
import java.text.AttributedCharacterIterator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



/**
 *
 * @author BS-PARK
 */
public class test {
   private  int testno; 
   private  String testId; 
   private  String testowner; 
   private  String testuserId; 
   
   private  String testtankNo; 
   private  String testlastcargo; 
   private  String testindate; 
   private  String testsort; 
   
   private  String testmfd; 
   private  String testl2_5yr; 
   private  String testl5yr; 
   private  String testlasttest; 
   private  String testptest; 
   private  String testCompany; 
   
   private  String testEstDate; 
   private  String testEstApp; 
   
   private  String testExtDate; 
   private  String testTestCom; 
   private  String testAirTestCom; 
   private  String testCleaningCom; 
   private  String testRepairCom; 
   
   
   private  String testremarkcustomer; 
   private  String testremarkcompany; 
   
   private  String test2_5testCom; 
   private  String testHydrotestCom; 

    public test(int testno, String testId, String testowner, String testuserId, String testtankNo, String testlastcargo, String testindate, String testsort, String testmfd, String testl2_5yr, String testl5yr, String testlasttest, String testptest, String testCompany, String testEstDate, String testEstApp, String testExtDate, String testTestCom, String testAirTestCom, String testCleaningCom, String testRepairCom, String testremarkcustomer, String testremarkcompany, String test2_5testCom, String testHydrotestCom) {
        this.testno = testno;
        this.testId = testId;
        this.testowner = testowner;
        this.testuserId = testuserId;
        this.testtankNo = testtankNo;
        this.testlastcargo = testlastcargo;
        this.testindate = testindate;
        this.testsort = testsort;
        this.testmfd = testmfd;
        this.testl2_5yr = testl2_5yr;
        this.testl5yr = testl5yr;
        this.testlasttest = testlasttest;
        this.testptest = testptest;
        this.testCompany = testCompany;
        this.testEstDate = testEstDate;
        this.testEstApp = testEstApp;
        this.testExtDate = testExtDate;
        this.testTestCom = testTestCom;
        this.testAirTestCom = testAirTestCom;
        this.testCleaningCom = testCleaningCom;
        this.testRepairCom = testRepairCom;
        this.testremarkcustomer = testremarkcustomer;
        this.testremarkcompany = testremarkcompany;
        this.test2_5testCom = test2_5testCom;
        this.testHydrotestCom = testHydrotestCom;
    }
   

    

    public int getTestno() {
        return testno;
    }

    public void setTestno(int testno) {
        this.testno = testno;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestowner() {
        return testowner;
    }

    public void setTestowner(String testowner) {
        this.testowner = testowner;
    }

    public String getTestuserId() {
        return testuserId;
    }

    public void setTestuserId(String testuserId) {
        this.testuserId = testuserId;
    }

    public String getTesttankNo() {
        return testtankNo;
    }

    public void setTesttankNo(String testtankNo) {
        this.testtankNo = testtankNo;
    }

    public String getTestlastcargo() {
        return testlastcargo;
    }

    public void setTestlastcargo(String testlastcargo) {
        this.testlastcargo = testlastcargo;
    }

    public String getTestindate() {
        return testindate;
    }

    public void setTestindate(String testindate) {
        this.testindate = testindate;
    }

    public String getTestsort() {
        return testsort;
    }

    public void setTestsort(String testsort) {
        this.testsort = testsort;
    }

    public String getTestmfd() {
        return testmfd;
    }

    public void setTestmfd(String testmfd) {
        this.testmfd = testmfd;
    }

    public String getTestl2_5yr() {
        return testl2_5yr;
    }

    public void setTestl2_5yr(String testl2_5yr) {
        this.testl2_5yr = testl2_5yr;
    }

    public String getTestl5yr() {
        return testl5yr;
    }

    public void setTestl5yr(String testl5yr) {
        this.testl5yr = testl5yr;
    }

    public String getTestlasttest() {
        return testlasttest;
    }

    public void setTestlasttest(String testlasttest) {
        this.testlasttest = testlasttest;
    }

    public String getTestptest() {
        return testptest;
    }

    public void setTestptest(String testptest) {
        this.testptest = testptest;
    }

    public String getTestCompany() {
        return testCompany;
    }

    public void setTestCompany(String testCompany) {
        this.testCompany = testCompany;
    }

    public String getTestEstDate() {
        return testEstDate;
    }

    public void setTestEstDate(String testEstDate) {
        this.testEstDate = testEstDate;
    }

    public String getTestEstApp() {
        return testEstApp;
    }

    public void setTestEstApp(String testEstApp) {
        this.testEstApp = testEstApp;
    }

    public String getTestExtDate() {
        return testExtDate;
    }

    public void setTestExtDate(String testExtDate) {
        this.testExtDate = testExtDate;
    }

    public String getTestTestCom() throws ParseException{
        
       
        
        if(test2_5testCom!= null) {
            testTestCom = test2_5testCom;
              
        }else if(testHydrotestCom!= null){
                 testTestCom = testHydrotestCom;
                 return testTestCom;
            
        } 
        return testTestCom;
                
                
            
        } 
        
    
        
        
        
        
    

    public void setTestTestCom(String testTestCom) {
        this.testTestCom = testTestCom;
    }

    public String getTestAirTestCom() {
        return testAirTestCom;
    }

    public void setTestAirTestCom(String testAirTestCom) {
        this.testAirTestCom = testAirTestCom;
    }

    public String getTestCleaningCom() {
        return testCleaningCom;
    }

    public void setTestCleaningCom(String testCleaningCom) {
        this.testCleaningCom = testCleaningCom;
    }

    public String getTestRepairCom() {
        return testRepairCom;
    }

    public void setTestRepairCom(String testRepairCom) {
        this.testRepairCom = testRepairCom;
    }

    public String getTestremarkcustomer() {
        return testremarkcustomer;
    }

    public void setTestremarkcustomer(String testremarkcustomer) {
        this.testremarkcustomer = testremarkcustomer;
    }

    public String getTestremarkcompany() {
        return testremarkcompany;
    }

    public void setTestremarkcompany(String testremarkcompany) {
        this.testremarkcompany = testremarkcompany;
    }

    public String getTest2_5testCom() {
        return test2_5testCom;
    }

    public void setTest2_5testCom(String test2_5testCom) {
        this.test2_5testCom = test2_5testCom;
    }

    public String getTestHydrotestCom() {
        return testHydrotestCom;
    }

    public void setTestHydrotestCom(String testHydrotestCom) {
        this.testHydrotestCom = testHydrotestCom;
    }

    
//public void dateformatter(String df){
//    String pattern = "yyyy-MM-dd";
//    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
//    
//}

    
}
