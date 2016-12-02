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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



/**
 *
 * @author BS-PARK
 */
public class tankIn {
   private  String Id; 
   private  String userId; 
   private  String fakeTankNo; 
   private  String tankNo; 
   private  String lastcargo; 
   private  String indate; 
   private  String sort; 
   private  String capacity; 
   private  String tareweight; 
   private  String mgw; 
   private  String mfd; 
   private  String l2_5yr; 
   private  String l5yr; 
   private  String lasttest; 
   
   private  String ptest; 
   private  String remarkcustomer; 
   private  String remarkcompany; 
   private  String airvalve; 
   
   private  String topvalve; 
   private  String frame; 
   private  String gauge; 
   private  String walkway; 
   private  String bottomvalve; 
   private  String document; 
   private  String spillbox; 
   private  String urgent; 
   private  int no; 
   
   

    public tankIn(String Id, String userId, String fakeTankNo, String tankNo, String lastcargo, String indate, String sort, String capacity, String tareweight, String mgw, String mfd, String l2_5yr, String l5yr, String lasttest, String ptest, String remarkcustomer, String remarkcompany, String airvalve, String topvalve, String frame, String gauge, String walkway, String bottomvalve, String document, String spillbox, String urgent, int no) {
        this.Id = Id;
        this.userId = userId;
        this.fakeTankNo = fakeTankNo;
        this.tankNo = tankNo;
        this.lastcargo = lastcargo;
        this.indate = indate;
        this.sort = sort;
        this.capacity = capacity;
        this.tareweight = tareweight;
        this.mgw = mgw;
        this.mfd = mfd;
        this.l2_5yr = l2_5yr;
        this.l5yr = l5yr;
        this.lasttest = lasttest;
        this.ptest = ptest;
        this.remarkcustomer = remarkcustomer;
        this.remarkcompany = remarkcompany;
        this.airvalve = airvalve;
        this.topvalve = topvalve;
        this.frame = frame;
        this.gauge = gauge;
        this.walkway = walkway;
        this.bottomvalve = bottomvalve;
        this.document = document;
        this.spillbox = spillbox;
        this.urgent = urgent;
        this.no = no;
    }
   
   
   

  
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Text getFakeTankNo() {
         Text text = new Text(fakeTankNo);
      if( "Urgent".equals(urgent)){
        Text t = new Text();
        //t.setEffect(ds);
        t.setCache(true);
        t.setX(10.0);
        t.setY(270.0);
        t.setFill(Color.RED);
        t.setText(fakeTankNo);
        t.setFont(Font.font(null, FontWeight.BOLD, 12));
    
        return  t;
    }
    else{
        return text;
    }
    }

    
    public void setFakeTankNo(String fakeTankNo) {
        this.fakeTankNo = fakeTankNo;
    }
 
    public String getTankNo() {
      //Text text = new Text(tankNo);
      //if(urgent != null){
//        Text t = new Text();
//        //t.setEffect(ds);
//        t.setCache(true);
//        t.setX(10.0);
//        t.setY(270.0);
//        t.setFill(Color.RED);
//        t.setText(tankNo);
//        t.setFont(Font.font(null, FontWeight.BOLD, 12));
    
        //return  tankNo
    //}
    //else{
      
        return  tankNo;
    }
    //}

    public void setTankNo(String tankNo) {
        this.tankNo = tankNo;
    }

    public String getLastcargo() {
        return lastcargo;
    }

    public void setLastcargo(String lastcargo) {
        this.lastcargo = lastcargo;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTareweight() {
        return tareweight;
    }

    public void setTareweight(String tareweight) {
        this.tareweight = tareweight;
    }

    public String getMgw() {
        return mgw;
    }

    public void setMgw(String mgw) {
        this.mgw = mgw;
    }

    public String getMfd() {
        return mfd;
    }

    public void setMfd(String mfd) {
        this.mfd = mfd;
    }

    public String getL2_5yr() {
        return l2_5yr;
    }

    public void setL2_5yr(String l2_5yr) {
        this.l2_5yr = l2_5yr;
    }

    public String getL5yr() {
        return l5yr;
    }

    public void setL5yr(String l5yr) {
        this.l5yr = l5yr;
    }

    public String getLasttest() {
        return lasttest;
    }

    public void setLasttest(String lasttest) {
        this.lasttest = lasttest;
    }

    public String getPtest() {
        return ptest;
    }

    public void setPtest(String ptest) {
        this.ptest = ptest;
    }

    public String getRemarkcustomer() {
        return remarkcustomer;
    }

    public void setRemarkcustomer(String remarkcustomer) {
        this.remarkcustomer = remarkcustomer;
    }

    public String getRemarkcompany() {
        return remarkcompany;
    }

    public void setRemarkcompany(String remarkcompany) {
        this.remarkcompany = remarkcompany;
    }

    public String getAirvalve() {
        return airvalve;
    }

    public void setAirvalve(String airvalve) {
        this.airvalve = airvalve;
    }

    public String getTopvalve() {
        return topvalve;
    }

    public void setTopvalve(String topvalve) {
        this.topvalve = topvalve;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getGauge() {
        return gauge;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public String getWalkway() {
        return walkway;
    }

    public void setWalkway(String walkway) {
        this.walkway = walkway;
    }

    public String getBottomvalve() {
        return bottomvalve;
    }

    public void setBottomvalve(String bottomvalve) {
        this.bottomvalve = bottomvalve;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSpillbox() {
        return spillbox;
    }

    public void setSpillbox(String spillbox) {
        this.spillbox = spillbox;
    }

    public String getUrgent() {
        
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    
    
    public int getNo() {
        
        return no ;
    }
    public void setNo(int no) {
        this.no = no;
    }

 

     
}
