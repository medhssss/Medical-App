package com.medical;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    Connection con = null;

    DBUtil() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	String DBURL = "jdbc:mysql://localhost:3306/medicalapp";
	con = DriverManager.getConnection(DBURL, "root", "root");
    }

    public void insertgovtempdetails(String employeeName, String surName,
	    String personaladdress, String sex, String city, int empid,
	    String department, String designation, String district,
	    String state, int pincode, String emailId, String dob,
	    double mobileNo, String password) {
	String query = "insert into govtempdetails values('" + employeeName
		+ "','" + surName + "','" + personaladdress + "','" + sex
		+ "','" + city + "'," + empid + ",'" + department + "','"
		+ designation + "','" + district + "','" + state + "',"
		+ pincode + ",'" + emailId + "','" + dob + "'," + mobileNo
		+ ",'" + password + "');";
	Statement st;
	try {
	    st = con.createStatement();
	    st.executeUpdate(query);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void insertdoctordetails(String doctorName, String password,
	    String fathername, String hospaddress, String personaladdress,
	    String sex, String city, String feild, String practice,
	    String district, String state, int pincode, String emailid,
	    String dob, double mobileNo) {
	// TODO Auto-generated method stub
	String query = "insert into doctordetails values('" + doctorName
		+ "','" + fathername + "','" + hospaddress + "','"
		+ personaladdress + "','" + sex + "','" + city + "','" + feild
		+ "','" + practice + "','" + district + "','" + state + "','"
		+ emailid + "','" + dob + "'," + mobileNo + ",'" + password
		+ "'," + pincode + ");";
	Statement st;
	try {
	    st = con.createStatement();
	    st.executeUpdate(query);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public String insertpatientdetails(String hospname, String password,
	    String patientname, String diseasename, String diseasecode,
	    String treatment, String no, String gender, String location,
	    String age, String DoctorName) throws SQLException {
	// TODO Auto-generated method stub
	ResultSet rs1 = null;
	String query1 = "select * from doctordetails where doctorname='"
		+ DoctorName + "';";
	Statement st1 = con.createStatement();
	rs1 = st1.executeQuery(query1);
	if (!rs1.next()) {
	    return "wrongpassword";
	}
	if ((rs1.getString(14)).equals(password)) {
	    String query = "insert into patientdetails values('" + hospname
		    + "','" + password + "','" + patientname + "','"
		    + diseasename + "','" + diseasecode + "','" + treatment
		    + "','" + no + "','" + gender + "','" + location + "','"
		    + age + "');";
	    Statement st;
	    try {
		st = con.createStatement();
		st.executeUpdate(query);
		
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    return "correctpassword";
	} else {	    
	    return "wrongpassword";
	}
    }

    public ResultSet retrievepatientdetails(String officername,
	    String password, String hospitalname) throws SQLException {
	// TODO Auto-generated method stub
	ResultSet rs = null;
	ResultSet rs1 = null;
	String query1 = "select * from govtempdetails where employeename='"
		+ officername + "';";
	Statement st1 = con.createStatement();
	rs1 = st1.executeQuery(query1);
	if (!rs1.next()) {
	    return null;
	}
	if ((rs1.getString(15)).equals(password)) {
	    String query = "select * from patientdetails where hospname='"
		    + hospitalname + "';";
	    Statement st = con.createStatement();
	    rs = st.executeQuery(query);
	    return rs;
	} else {
	    System.out.println("1" + rs1.getString(15));
	    System.out.println("2" + password);
	    return null;
	}
    }
}
