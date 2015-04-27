package com.medical;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
	super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	String employeeName = request.getParameter("employeename");
	String surname = request.getParameter("employeesurname");
	String Personaladdress = request.getParameter("personaladdress");
	String Sex = request.getParameter("sex");
	String City = request.getParameter("City");
	String empid = request.getParameter("employeeid");
	int Empid = Integer.parseInt(empid);
	String department = request.getParameter("department");
	String Designation = request.getParameter("designation");
	String District = request.getParameter("District");
	String State = request.getParameter("State");
	String PinCode = request.getParameter("pincode");
	int pincode = Integer.parseInt(PinCode);
	String EmailId = request.getParameter("emailid");
	String DOB = request.getParameter("dob");
	String password = request.getParameter("password");
	String MobileNo = request.getParameter("mobileno");
	double mobileNo = Double.parseDouble(MobileNo);
	try {
	    DBUtil db = new DBUtil();
	    db.insertgovtempdetails(employeeName, surname, Personaladdress,
		    Sex, City, Empid, department, Designation, District, State,
		    pincode, EmailId, DOB, mobileNo, password);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	out.println("<html> <body>  Successfully Registered as Govvernment employee </br>");
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
	String officername = request.getParameter("officername");
	String password = request.getParameter("password");
	String hospitalname = request.getParameter("hospitalname");

	try {
	    DBUtil db = new DBUtil();
	    ResultSet rs = db.retrievepatientdetails(officername, password,
		    hospitalname);
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    if(rs!=null)
	    {	    
	    out.println("<html> <body>  <table border='1'> <tr> <td> Hospital Name </td> <td> Patient Name </td> <td> Disease </td> <td> Treated </td>  <td> If No Reason </td></tr>");
	    while (rs.next()) {
		out.println("<tr>");
		out.println("<td>" + rs.getString(1) + "</td>");
		out.println("<td>" + rs.getString(3) + "</td>");
		out.println("<td>" + rs.getString(4) + "</td>");
		out.println("<td>" + rs.getString(6) + "</td>");
		out.println("<td>" + rs.getString(7) + "</td>");
		out.println("</tr>");
	    }	    
	    out.println("</table></body></html>");
	    out.println("Get More Patient Details of other  <A href='DisplayReport.html'> Hospitals</A></br>");
	    out.println("Go back to <a href='index.html'>Home Page</a>");
	    }
		else
		    out.println("No access rights user is not registered or password is incorrect"); 
	} catch (Exception e) {
	    e.printStackTrace();
	}
	

    }
}
