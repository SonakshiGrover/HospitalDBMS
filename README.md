# HospitalDBMS

DEVELOPMENT OF A HOSPITAL RECORD DATABASE SYSTEM    

Project description:   
We have implemented a database application which will provide some basic functions of a hospital,

1) Patients are admitted to the hospital, and discharged once their treatment is completed.
2) Patients are treated by doctors.
3) Doctors may recommend tests for each patient. Each test conducted would show results.
4) Departmental information for doctors including their respective specializations, etc. 
    
Test data:   
We’ll load the data of patients and doctors , labs and test that is conducted in each lab, the tests conducted on patients, into the database.   

Features:   
We’ll generate forms through which the admin can:  
1)  Patient can be searched by his personal details, visit hours(out-patient), room number(if inpatient), his doctor,etc. 
2) A doctor can be searched by his details, his specialisation and his office hours.
3) Find details about a medicine, search a bill and in which lab a test is conducted.
4) Find the most prevalent health issue in any age group 
5) The manufacturer whose medicines are most prescribed by doctors. These are subject to changes…...         

The relational schema will look like as follows:  
Doctor (doctor_id,….)
Patient (patient_id,…)
Labtest (patient_id,labtest_id,…)
Visit (doctor_id, patient_id,….)
Prescription (prescription_id ,medicine_id…)
Bill(bill_no,.....)
Insurance(insurance_no,bill_no,...)
manufacturer(manufacturer_id,...) 

Some screenshots of the app are:

![alt tag](https://github.com/SonakshiGrover/HospitalDBMS/blob/master/Screenshot%201.png)

![alt tag](https://github.com/SonakshiGrover/HospitalDBMS/blob/master/Screenshot%202.png)

![alt tag](https://github.com/SonakshiGrover/HospitalDBMS/blob/master/Screenshot%203.png)
   
Extensions:  
If time permits then We’ll include these functions also:  
1)   Adding of patients and doctors into the database.   ---> which is now completed!!! 
2)   Graphical analysis by RJDBC   

Assumptions:  
1) Each patient will have exactly 1 prescription. 
2) “Dr.” ,”Mrs.”, and “ Mr.”  initials are not included in the names of patients/doctors in the database.
3) We assume that the entries for all the relations have already been inserted into the database.  
