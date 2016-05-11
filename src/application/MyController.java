package application;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.*;
import java.sql.*;

import com.mysql.jdbc.ResultSetMetaData;

import javafx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyController implements Initializable 
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddBtn;

    @FXML
    private Button DSearchBtn;

    @FXML
    private DatePicker PVisitDate;

    @FXML
    private TextArea PDIDTxt;

    //@FXML
    //private Tab BillTab;

    @FXML
    private TextField OfficeHrsToTxt;

    @FXML
    private TextField VisitStartTxt;

    @FXML
    private TextField VisitEndTxt;
    
   // @FXML
    //private Tab PatientTab;

    @FXML
    private Button PSearchBtn;

    @FXML
    private Button SearchLabBtn;

   // @FXML
   // private Tab RegistrationTab;

  //  @FXML
  //  private Tab DoctorTab;

    @FXML
    private TextArea PNameTxt;

    @FXML
    private TextField PrescriptionPIDTxt;

    @FXML
    private Button FindManufacturerBtn;

    @FXML
    private TextField ageToTxt;

    @FXML
    private ComboBox<String> SpecialisationCombo;
  
    @FXML
    private TextField ageFromTxt;

    @FXML
    private TextArea PDNameTxt;

  //  @FXML
   // private Tab LabTab;

    @FXML
    private TextField MedicineNameTxt;

    @FXML
    private Button SearchInsuranceBtn;

    @FXML
    private TextField BillNoTxt;

    @FXML
    private Button SearchHealthBtn;

   // @FXML
   // private Tab PrescriptionTab;

    @FXML
    private Button SearchBillBtn;

    @FXML
    private TextArea DNameTxt;

    @FXML
    private TextArea DPhoneNoTxt;

    @FXML
    private TextArea PIDTxt;

    @FXML
    private Button MedicineBtn;

    @FXML
    private TextArea PRoomNoTxt;

    @FXML
    private TextArea PPhoneNoTxt;

    @FXML
    private ComboBox<String> TestCombo;

    @FXML
    private TextField OfficeHrsFromTxt;

   // @FXML
   // private Tab PharmacyTab;

    @FXML
    private DatePicker OfficeHrsDate;

    @FXML
    private Button SearchPrescriptionBtn;

    @FXML
    private TextArea DIDTxt;

    


    @FXML
    private TextArea gender;


    @FXML
    private TextArea address;


    @FXML
    private TextArea patientid;

    @FXML
    private TextArea phoneno;


    @FXML
    private TextArea patientname;

    @FXML
    private TextArea age;

 
    
    ObservableList<String> specoptions= FXCollections.observableArrayList();
    
    
/*ObservableList<String> testoptions= FXCollections.observableArrayList(
    	    
        	"X-Ray",
        	"MRI",
        	"Ultrasound",
        	"CTScan"   		
        		
        );
*/    
    
ObservableList<String> testoptions= FXCollections.observableArrayList( );

public MyController() throws ClassNotFoundException, SQLException
{
    
    JDBCconnect j= new JDBCconnect("Select test_description from labtest;");
	ResultSet rs=j.execute();
	
	if(rs==null)
		System.out.println("ahahaha");
	 
	
	while(rs.next())
	{
	      
		   System.out.println(rs.getString("test_description"));
	       testoptions.add(rs.getString("test_description"));
	       
	}
	
	JDBCconnect k= new JDBCconnect("Select specialization from doctor;");
	ResultSet rs1=k.execute();
	
	if(rs1==null)
		System.out.println("ahahaha");
	 
	
	while(rs1.next())
	{
	       System.out.println(rs1.getString("specialization"));
	       specoptions.add(rs1.getString("specialization"));     	       
	}
	
}   
    
    
    
    @FXML
    void AddBtnClicked(ActionEvent AddBtn) throws ClassNotFoundException, SQLException 
    {

    	if((patientid.getText().equals("")==false)&&(patientname.getText().equals("")==false)&&(gender.getText().equals("")==false)&&(age.getText().equals("")==false)&&(phoneno.getText().equals("")==false)&&(address.getText().equals("")==false))
    	{
    		String SQLQuery= new String();
            SQLQuery= "insert into patient values('"+patientid.getText()+"','"+patientname.getText() +"','"+gender.getText() +"',"+ age.getText()+",'"+phoneno.getText() +"','"+address.getText() +"');"; 
    		System.out.println(SQLQuery);
    		
    		JDBCconnect j= new JDBCconnect(SQLQuery);
        	j.executeadd();

    		
        	
        	
    		
    	}
    	
    	
    	
    }

    @FXML
    void DSearchBtnClicked(ActionEvent DSearchBtn) throws SQLException, ClassNotFoundException, ParseException 
    {

       System.out.println("DOCTOR SEARCH BUTTON CLICKED !!!!");		
		
        
       /// Search by personal details
       String SQLQuery1= new String();
        SQLQuery1= "Select doctor_id from doctor"; 
        boolean r1=false,r2=false,r3=false;		
        		
    	if(DIDTxt.getText().equals("")==false)
    	{ r1=true; SQLQuery1=SQLQuery1+" where doctor_id='"+DIDTxt.getText()+"'";}
    	
    	if(DPhoneNoTxt.getText().equals("")==false)
    	{ r2=true; 
    	
    	   if(r1==true)
    	   {  		   
    		   SQLQuery1=SQLQuery1+" and phone_no='"+DPhoneNoTxt.getText()+"'";         		   
    	   }
    	   else
    	   {
    		   SQLQuery1=SQLQuery1+" where phone_no='"+DPhoneNoTxt.getText()+"'";     		   
    	   }
    	}
    	
    	if(DNameTxt.getText().equals("")==false)
    	{ r3=true; 
    	
    	   if((r1||r2)==true)
 	       { 		   
 		     SQLQuery1=SQLQuery1+" and doctor_name='"+DNameTxt.getText()+"'";    		       		   
 	       }
 	       else
 	       {
 		     SQLQuery1=SQLQuery1+" where doctor_name='"+DNameTxt.getText()+"'"; 		   
 	       }
  	    	
    	}
    	
    	//SQLQuery1=SQLQuery1+";";
    	
    	System.out.println("SQLQUERY= "+SQLQuery1);
    	
    	
    	// Search by specialisationa
    	String SQLQuery2= new String();
    	SQLQuery2= "Select doctor_id from doctor"; 
    	
    	if(SpecialisationCombo.getValue()!=null)
			SQLQuery2=SQLQuery2+" where specialization='"+(String) SpecialisationCombo.getValue()+"'"; 
    	
    	
    	//SQLQuery2= SQLQuery2+";"; 
    	System.out.println("SQLQUERY= "+SQLQuery2);
    	
    	// Search by office hours
    	
    	String SQLQuery3= new String();
    	SQLQuery3= "Select doctor_id from doctor";
    	
    	
    	
    	
    	boolean r4=false;
    	if(OfficeHrsDate.getValue()!=null)
     	{  LocalDate d=OfficeHrsDate.getValue();
     	
     	   //LocalDate date = OfficeHrsDate.getValue(); 
    	   Locale locale = Locale.US;
    	   int weekday = d.get(WeekFields.of(locale).dayOfWeek());
    	   String weekname="";
    	   System.out.println("week day = "+weekday);
    	   if(weekday==1)
    	   { 
    		   weekname="sunday";
    	   }
    	   else
    	   if(weekday==2)
           { 
        	   weekname="monday";
           }
    	   if(weekday==3)
    	   { 
    		   weekname="tuesday";
    	   }
    	   if(weekday==4)
    	   { 
    		   weekname="wednesday";
    	   }
    	   if(weekday==5)
    	   { 
    		   weekname="thursday";
    	   }
    	   if(weekday==6)
    	   { 
    		   weekname="friday";
    	   }
    	   if(weekday==7)
    	   { 
    		   weekname="saturday";
    	   }
    	   
    	   if(d!=null)
    	   { r4=true;SQLQuery3=SQLQuery3+" where day='"+weekname+"'";}
    	
    	}
    	if((OfficeHrsFromTxt.getText().equals("")==false)&&(OfficeHrsToTxt.getText().equals("")==false))
    	{
    		
    		
    		if(r4==true)
    		{
    			SQLQuery3=SQLQuery3+" and office_hours_from>='"+OfficeHrsFromTxt.getText()+"' and office_hours_to<='"+OfficeHrsToTxt.getText()+"'";
    		}
    		else
    		{
    			SQLQuery3=SQLQuery3+" where office_hours_from>='"+OfficeHrsFromTxt.getText()+"' and office_hours_to<='"+OfficeHrsToTxt.getText()+"'";
    		}
       	  
    	}
       	else
    	if((OfficeHrsFromTxt.getText().equals("")==true)&&(OfficeHrsToTxt.getText().equals("")==false))
    	{
    		if(r4==true)
    		{
    			SQLQuery3=SQLQuery3 + " and office_hours_to<='"+OfficeHrsToTxt.getText()+"'";
    		}
    		else
    		{
    			SQLQuery3=SQLQuery3 + " where office_hours_to<='"+OfficeHrsToTxt.getText()+"'";
    		}
    		
    	}
    	else
    	if((OfficeHrsFromTxt.getText().equals("")==false)&&(OfficeHrsToTxt.getText().equals("")==true))
    	{
    		if(r4==true)
    		{
    			SQLQuery3=SQLQuery3+" and office_hours_from>='"+OfficeHrsFromTxt.getText()+"'";
    		}
    		else
    		{
    			SQLQuery3=SQLQuery3+" where office_hours_from>='"+OfficeHrsFromTxt.getText()+"'";
    		}
    	}
    	
    	//SQLQuery3= SQLQuery3+";"; 
    	
    	System.out.println("SQLQUERY= "+SQLQuery3);
    	
    	String SQLQuery=new String();
    	//SQLQuery="("+SQLQuery1+") intersect ("+SQLQuery2+") intersect ("+SQLQuery3+");";
    	SQLQuery="select * from doctor where doctor_id IN("+SQLQuery1+") AND doctor_id IN ("+SQLQuery2+") AND doctor_id IN ("+SQLQuery3+");";
    	
    	
    	System.out.println("final SQLQUERY= "+SQLQuery);
    	
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       String doctor_id  = rs.getString("doctor_id");
    	       
//    	       int age = rs.getInt("age");
    	       String doctor_name = rs.getString("doctor_name");
    	       String officefrom = rs.getString("office_hours_from");
    	       String officeto = rs.getString("office_hours_to");
    	       String day = rs.getString("day");

    	       //Display values
    	       System.out.print("doctor_id: " + doctor_id);
//    	       System.out.print(", Age: " + age);
    	       System.out.print(", doctor_name: " + doctor_name);
   	          System.out.print(", office hours from: " + officefrom);
   	          System.out.print(", office hours to: " + officeto);
   	          System.out.print(", day " + day);
	          
    	       System.out.println(" ");
    	}
          
    		
    }

    @FXML
    void PSearchBtnClicked(ActionEvent PSearchBtn) throws ClassNotFoundException, SQLException 
    {
       //Search by personal details
    	
    	
    	System.out.println("PATIENT SEARCH BUTTON CLICKED !!!!");		
		
        
        /// Search by personal details
        String SQLQuery1= new String();
         SQLQuery1= "Select patient_id from patient"; 
         boolean r1=false,r2=false,r3=false;		
         		
     	if(PIDTxt.getText().equals("")==false)
     	{ r1=true; SQLQuery1=SQLQuery1+" where patient_id='"+PIDTxt.getText()+"'";}
     	
     	if(PPhoneNoTxt.getText().equals("")==false)
     	{ r2=true; 
     	
     	   if(r1==true)
     	   {  		   
     		   SQLQuery1=SQLQuery1+" and phone_no='"+PPhoneNoTxt.getText()+"'";         		   
     	   }
     	   else
     	   {
     		   SQLQuery1=SQLQuery1+" where phone_no='"+PPhoneNoTxt.getText()+"'";     		   
     	   }
     	}
     	
     	if(PNameTxt.getText().equals("")==false)
     	{ r3=true; 
     	
     	   if((r1||r2)==true)
  	       { 		   
  		     SQLQuery1=SQLQuery1+" and patient_name='"+PNameTxt.getText()+"'";    		       		   
  	       }
  	       else
  	       {
  		     SQLQuery1=SQLQuery1+" where patient_name='"+PNameTxt.getText()+"'"; 		   
  	       }
   	    	
     	}
     	
     	//SQLQuery1=SQLQuery1+";";
     	
     	System.out.println("SQLQUERY= "+SQLQuery1);
     	
    	
    	//Search by visit hours
     	String SQLQuery2= new String();
    	SQLQuery2= "Select patient_id from patient";
    	
    	/*
    	boolean r4=false;
    	if(PVisitDate!=null)
    	{  LocalDate d=PVisitDate.getValue();
    	
    	
    	     if(d!=null)
    	     { r4=true;SQLQuery2=SQLQuery2+" where Visit.Date='"+d+"'";}
    	
    	}
    	if((VisitStartTxt.getText().equals("")==false)&&(VisitEndTxt.getText().equals("")==false))
    	{
    		if(r4==true)
    		{
    			SQLQuery2=SQLQuery2+"and From='"+VisitStartTxt.getText()+"' and To='"+VisitEndTxt.getText();
    		}
    		else
    		{
    			SQLQuery2=SQLQuery2+" where From='"+VisitStartTxt.getText()+"' and To='"+VisitEndTxt.getText();
    		}
    		
    	}
    		
    	else
    	if((VisitStartTxt.getText().equals("")==true)&&(VisitEndTxt.getText().equals("")==false))
    	{
    		if(r4==true)
    		{
    			SQLQuery2=SQLQuery2+"and To='"+VisitEndTxt.getText()+"'";
    		}
    		else
    		{
    			SQLQuery2=SQLQuery2+" where To='"+VisitEndTxt.getText()+"'";
    		}
    		
    	}
    	else
    	if((VisitStartTxt.getText().equals("")==false)&&(VisitEndTxt.getText().equals("")==true))
    	{
    		if(r4==true)
    		{
    			SQLQuery2=SQLQuery2+"and From='"+VisitStartTxt.getText()+"'";
    		}
    		else
    		{
    			SQLQuery2=SQLQuery2+"where From='"+VisitStartTxt.getText()+"'";
    		}
    	}
    	//SQLQuery2= SQLQuery2+";"; 
    	*/
    	System.out.println("SQLQUERY= "+SQLQuery2);

    	
    	//Search by room no
    	
     	String SQLQuery3= new String();
    	
    	if(PRoomNoTxt.getText().equals("")==false)
    	{
    		SQLQuery3="Select patient_id from inpatient";
        	
    		SQLQuery3=SQLQuery3 + " where room_no='"+PRoomNoTxt.getText()+"'";
    	  
    	}
    	else
    	{
    		SQLQuery3="Select patient_id from patient";
    	}

    	//SQLQuery3=SQLQuery3+";";
    	System.out.println("SQLQuery= "+SQLQuery3);

     	
     	
    	//Search by Doctor details
    	
    	String SQLQuery4= new String();
        SQLQuery4= "Select patient_id from visit natural join doctor"; 
        boolean t1=false,t2=false;		
        		
    	if(PDIDTxt.getText().equals("")==false)
    	{ t1=true; SQLQuery4=SQLQuery4+" where doctor.doctor_id='"+PDIDTxt.getText()+"'";}
    	
    	
    	if(PDNameTxt.getText().equals("")==false)
    	{ t2=true; 
    	
    	   if(t1==true)
 	       { 		   
 		     SQLQuery4=SQLQuery4+" and doctor_name='"+PDNameTxt.getText()+"'";    		       		   
 	       }
 	       else
 	       {
 		     SQLQuery4=SQLQuery4+" where doctor_name='"+PDNameTxt.getText()+"'"; 		   
 	       }
  	    	
    	}
    	
    	//SQLQuery1=SQLQuery1+";";
    	
    	System.out.println("SQLQUERY= "+SQLQuery4);
    	
    	
    	String SQLQuery=new String();
    	SQLQuery="select patient_id,patient_name from patient where patient_id IN("+SQLQuery1+") AND patient_id IN ("+SQLQuery2+") AND patient_id IN ("+SQLQuery3+") AND patient_id IN ("+SQLQuery4+");";
    	
    	
    	System.out.println("final SQLQUERY= "+SQLQuery);

    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       String patient_id  = rs.getString("patient_id");
    	       
//    	       int age = rs.getInt("age");
    	       String patient_name = rs.getString("patient_name");
    	       
    	       System.out.print("patient_id: " + patient_id);
//    	       System.out.print(", Age: " + age);
    	       System.out.print(", patient_name: " + patient_name);
   	          
    	       System.out.println(" ");
    	}

    	
    	
    	
    	
    	
    }

    @FXML
    void MedicineBtnClicked(ActionEvent MedicineBtn) throws ClassNotFoundException, SQLException 
    {
    	
    	System.out.println("MEdicne btn clicked!!!");
    	String SQLQuery= new String();
    	SQLQuery="Select * from medicine";
    	
    	if(MedicineNameTxt.getText().equals("")==false)
    	{
    	  SQLQuery=SQLQuery + " where mname='"+MedicineNameTxt.getText()+"'";
    	  
    	}

    	SQLQuery=SQLQuery+";";
    	System.out.println("SQLQuery= "+SQLQuery);
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       String medicine_id  = rs.getString("medicine_id");
    	       
//    	       int age = rs.getInt("age");
    	       String mname = rs.getString("mname");
    	       String manufacturer_id = rs.getString("manufacturer_id");
    	       String price = rs.getString("price(of 10 capsules/tablets) in Rs");
    	       String quantity = rs.getString("quantity");
    	       
    	       
    	       
    	       
//    	       String last = rs.getString("last");

    	       //Display values
    	       System.out.print("medicine_id: " + medicine_id);
//    	       System.out.print(", Age: " + age);
    	       System.out.print(", mname: " + mname);
//    	       System.out.println(", Last: " + last);
    	       
    	       System.out.print(", manufacturer_id: " + manufacturer_id);
    	       System.out.print(", price(of 10 capsules/tablets) in Rs: " + price);
    	       System.out.print(", quantity: " + quantity);
    	       
    	       System.out.println(" ");
    	       
    	       
    	       
    	    }
          
    	
    	
    	
    	
    	
    	
    }

    @FXML
    void FindManufacturerBtnClicked(ActionEvent FindManufacturerBtn) throws ClassNotFoundException, SQLException 
    {

    	System.out.println("Find mANufacturuer btn clicked !!!");
    	String SQLQuery= new String();
    	SQLQuery="Select manufacturer_name,count(*) "
    			+ "from medicine natural join prescription natural join manufacturer "
    			+ "group by manufacturer_name "
    			+ "order by count(*) desc";
    	
    	
    	SQLQuery=SQLQuery+";";
    	System.out.println("SQLQuery= "+SQLQuery);
    	
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       
//    	       int age = rs.getInt("age");
    	       String manufacturer_name = rs.getString("manufacturer_name");
    	       String count = rs.getString("count(*)");
    	       
    	      
    	       System.out.print("manufacturer_name  " + manufacturer_name);
    	       System.out.print(", count(*) " + count);
    	       
    	       System.out.println(" ");
    	       
    	       
    	       
    	    }
          
    	
    	
    }

    @FXML
    void SearchPrescriptionBtnClicked(ActionEvent SearchPrescriptionBtn) throws ClassNotFoundException, SQLException 
    {

    	System.out.println("Search Prescription Btn Clicked");
    	String SQLQuery= new String();
    	SQLQuery= "Select * from prescription natural join medicine natural join bill natural join visit natural join patient, doctor where doctor.doctor_id=visit.doctor_id"; 
    	
    	if(PrescriptionPIDTxt.getText().equals("")==false)
    	{
    	  SQLQuery=SQLQuery + " and prescription_id='"+PrescriptionPIDTxt.getText()+"'";
    	  
    	}
    	
    	SQLQuery=SQLQuery+";";
    	
    	System.out.println("SQLQuery= "+SQLQuery);
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       String prescription_id = rs.getString("prescription_id");
    	       String patient_name = rs.getString("patient_name");
    	       String doctor_name = rs.getString("doctor_name");
    	       String diagnosistreatment = rs.getString("diagnosis");
    	       String mname = rs.getString("mname");
    	       String amt = rs.getString("amount( in Rs)");
    	       
    	      
    	       System.out.print("prescription_id  " + prescription_id);
    	       System.out.print(", patient_name " + patient_name);
    	       System.out.print(", doctor_name " + doctor_name);
    	       System.out.print(", diagnosis " + diagnosistreatment);
    	       System.out.print(", mname" + mname);
    	       System.out.print(", amount( in Rs)" + amt);
    	       
    	       System.out.println(" ");
    	       
    	       
    	       
    	    }
          
    	
    	
    }

    @FXML
    void SearchHealthBtnClicked(ActionEvent SearchHealthBtn) throws ClassNotFoundException, SQLException 
    {
    	System.out.println("Search Health Btn Clicked");
    	String SQLQuery= new String();
    	
    	SQLQuery="select diagnosis,count(*) from prescription natural join visit natural join patient";
        
    	if((ageFromTxt.getText().equals("")==false)&&(ageToTxt.getText().equals("")==false))
    	{
    		SQLQuery=SQLQuery+" where age>"+ageFromTxt.getText()+" and age<"+ageToTxt.getText();
    	}
    	else
        if((ageFromTxt.getText().equals("")==true)&&(ageToTxt.getText().equals("")==false))
        {
        	SQLQuery=SQLQuery+" where age<"+ageToTxt.getText();
        }
        else
        if((ageFromTxt.getText().equals("")==false)&&(ageToTxt.getText().equals("")==true))
        {
        	SQLQuery=SQLQuery+" where age>"+ageFromTxt.getText();
        }
        
    	SQLQuery=SQLQuery+" group by diagnosis order by count(*) desc;";
    	System.out.println("SQLQuery= "+SQLQuery);
    	
    	
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       String diagnosis = rs.getString("diagnosis");
    	       String count = rs.getString("count(*)");
    	       //String doctor_name = rs.getString("doctor_name");
    	       //String diagnosistreatment = rs.getString("diagnosis");
    	       //String mname = rs.getString("mname");
    	       //String amt = rs.getString("amount( in Rs)");
    	       
    	      
    	       System.out.print("diagnosis  " + diagnosis);
    	       System.out.print(", count(*) " + count);
    	       //System.out.print(", doctor_name " + doctor_name);
    	       //System.out.print(", diagnosis " + diagnosistreatment);
    	       //System.out.print(", mname" + mname);
    	       //System.out.print(", amount( in Rs)" + amt);
    	       
    	       System.out.println(" ");
    	       
    	       
    	       
       }
    	
    }

    @FXML
    void SearchLabBtnClicked(ActionEvent SearchLabBtn) throws ClassNotFoundException, SQLException 
    {

    	System.out.println("Search lab Btn Clicked");
    	System.out.println(" ");
    	String SQLQuery= new String();
    	SQLQuery= "Select lab_room from labtest"; 
    	
    	if(TestCombo.getValue()!=null)
			SQLQuery=SQLQuery+" where test_description='"+(String) TestCombo.getValue()+"'"; 
    	
    	SQLQuery=SQLQuery+";";
    	
    	System.out.println("SQLQuery= "+SQLQuery);
    	
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       
//    	       int age = rs.getInt("age");
    	       String lab_room = rs.getString("lab_room");
    	       //String count = rs.getString("count(*)");
    	       
    	      
    	       System.out.print("lab_room  " + lab_room);
    	      // System.out.print(", count(*) " + count);
    	       
    	       System.out.println("\n");
    	       
    	       
    	       
    	    }
          
    	
    	
    	
    }

    @FXML
    void SearchBillBtnClicked(ActionEvent SearchBillBtn) throws ClassNotFoundException, SQLException 
    {
    	System.out.println("Search BILL btn clicked!!!");
    	System.out.println(" ");
    	String SQLQuery= new String();
    	SQLQuery="Select * from bill";
    	
    	if(BillNoTxt.getText().equals("")==false)
    	{
    	  SQLQuery=SQLQuery + " where bill_no='"+BillNoTxt.getText()+"'";
    	  
    	}

    	SQLQuery=SQLQuery+";";
    	System.out.println("SQLQuery= "+SQLQuery);
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       
//    	       int age = rs.getInt("age");
    	       String bill_no = rs.getString("bill_no");
    	       String amt = rs.getString("amount( in Rs)");
    	       
    	      
    	       System.out.print("bill no  " + bill_no);
    	       System.out.print(", amount( in Rs) " + amt);
    	       
    	       System.out.println("\n");
    	       
    	       
    	       
    	    }
          
    	
    	
    	
    }

    @FXML
    void SearchInsuranceBtnClicked(ActionEvent SearchInsuranceBtn) throws ClassNotFoundException, SQLException 
    {

    	
    	System.out.println("Search Insurance btn clicked !!!");
    	System.out.println(" ");
    	String SQLQuery= new String();
    	SQLQuery="Select company_name,count(*) "
    			+ "from insurance "
    			+ "group by company_name"
    			+ " order by count(*) desc";
    	
    	
    	SQLQuery=SQLQuery+";";
    	System.out.println("SQLQuery= "+SQLQuery);	
    	
    	JDBCconnect j= new JDBCconnect(SQLQuery);
    	ResultSet rs=j.execute();
    	
    	if(rs==null)
    		System.out.println("ahahaha");
    	 
    	
    	while(rs.next())
    	{
    	       //Retrieve by column name
    	       
//    	       int age = rs.getInt("age");
    	       String company_name = rs.getString("company_name");
    	       String count = rs.getString("count(*)");
    	       
    	      
    	       System.out.print("company_name  " + company_name);
    	       System.out.print(", count(*) " + count);
    	       
    	       System.out.println(" ");
    	       
    	       
    	       
    	    }
          
    	
    	
    	
    	
    	
    }

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
    	SpecialisationCombo.setItems(specoptions);
    	TestCombo.setItems(testoptions);
		  
	}
    
    


    
   
}
