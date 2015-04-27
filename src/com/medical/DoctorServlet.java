package com.medical;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoctorServlet
 */
public class DoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String DoctorName = request.getParameter("doctorname");
	String password = request.getParameter("password");
	String fathername = request.getParameter("fathername");
	String hospaddress = request.getParameter("hospitaladdress");
	String personaladdress = request.getParameter("personaladdress");
	String sex = request.getParameter("sex");
	String City = request.getParameter("City");
	String feild = request.getParameter("feild");
	String Practice = request.getParameter("Practice");
	String District = request.getParameter("District");
	String State = request.getParameter("State");
	String Pincode = request.getParameter("pincode");
	int pincode = Integer.parseInt(Pincode);
	String emailid = request.getParameter("emailid");
	String dob = request.getParameter("dob");
	String MobileNo = request.getParameter("mobileno");
	Double mobileNo = Double.parseDouble(MobileNo);

	DBUtil db;
	try {
	    db = new DBUtil();
	    db.insertdoctordetails(DoctorName, password, fathername,
		    hospaddress, personaladdress, sex, City, feild, Practice,
		    District, State, pincode, emailid, dob, mobileNo);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	out.println("<html> <body>  Successfully Registered as Doctor </br>");
	out.println("Go back to <a href='index.html'>Home Page</a>");
	out.println("</table></body></html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String hospname = request.getParameter("hospname");
	String password = request.getParameter("textname2");
	String patientname = request.getParameter("patientname");
	String diseasename = request.getParameter("diseasename");
	String diseasecode = request.getParameter("diseasecode");
	String Treatment = request.getParameter("Treatment");
	String No = request.getParameter("No");
	String gender = request.getParameter("gender");
	String location = request.getParameter("location");
	String age = request.getParameter("age");
	String DoctorName= request.getParameter("docname");
	String a =null;

	DBUtil db;
	try {
	    db = new DBUtil();
	    a = db.insertpatientdetails(hospname, password, patientname,
		    diseasename, diseasecode, Treatment, No, gender, location,
		    age,DoctorName);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	PrintWriter out = response.getWriter();
	if(a == "correctpassword")
	{
	response.setContentType("text/html");
	out.println("<html> <body>  Successfully Entered Details </BR>");
	out.println("Enter More  <A href='PatientDetailsForm.html'>Patient Details</A>");
	out.println("Go back to <A href='index.html'>Home Page</A>");
	out.println("</table></body></html>");
	}
	else
	    out.println("No access rights user is not registered or password is incorrect");
    }
}
