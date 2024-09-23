package FinalProject;

import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.EnrollBean;
import Beans.Student;
import DBUtils.DButil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/validateLogin")
public class validateLogin extends HttpServlet implements studentInterface, enrollInterface{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String ssn = request.getParameter("ssn");
        HttpSession session = request.getSession();
        session.setAttribute("ssn", ssn);
        
        String qry1 = "SELECT Enrollment.courseID, Course.title, Enrollment.grade FROM Enrollment "
        		+ "JOIN Course ON Enrollment.courseID = Course.courseID "
        		+ "WHERE Enrollment.ssn=" + ssn + ";";
    	
        session.setAttribute("qry1", qry1);
    	
        
        storeClassInfo(request, response, qry1);
    	//session.setAttribute("showEnrInfo", storeClassInfo(request, response, qry1));
    	
    	
    	
    	
    	String qry = "SELECT * FROM Students WHERE ssn = " + ssn + ";";
    	session.setAttribute("qry", qry);
    	
    	storeStudentInfo(request, response, qry);
    	session.setAttribute("showStuInfo",storeStudentInfo(request, response, qry));
    	
    	
    	ArrayList<Student> std = (ArrayList<Student>) session.getAttribute("stuInfo");
    	
    	if (!(std == null || std.isEmpty()))
    	{
    		 // Forward to myRegist page to show student records : SSN FOUND
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
            dispatcher.forward(request, response);
    	}
    	else
    	{
            // Forward to error page: SSN not found
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginError.jsp");
            dispatcher.forward(request, response);
    	}
    	
    	
     
    	

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("exit".equals(action)) {
            // Redirect to myRegist.jsp without any additional processing
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/myRegist.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //Redirect to myRegist.jsp with additional processing

    }

    

	@Override
	public Student storeStudentInfo(HttpServletRequest request, HttpServletResponse response, String query) {
		
		ArrayList<Student> std = new ArrayList<>();
		
		DButil db = new DButil();
		db.connectDB("cst4713", "password1");
		
        HttpSession session = request.getSession();
        
        try {
        	ResultSet rs = db.getQuery(query);
        	 while (rs.next()) {
 	            Student student = new Student(
 	                rs.getString("ssn"),
 	                rs.getString("firstName"),
 	                rs.getString("mi"),
 	                rs.getString("lastName"),
 	                rs.getString("birthDate"),
 	                rs.getString("street"),
 	                rs.getString("phone"),
 	                rs.getString("zipcode"),
 	                rs.getString("deptId")
 	            );
 	            std.add(student);
 		    }
 		    
 		    rs.close();
 		    db.closeConn();

 		    session.setAttribute("stuInfo", std);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EnrollBean storeClassInfo(HttpServletRequest request, HttpServletResponse response, String query) {
		ArrayList<EnrollBean> enr = new ArrayList<>();
		
		DButil db = new DButil();
		db.connectDB("cst4713", "password1");		
		
		 HttpSession session = request.getSession();
		 try {
	        	ResultSet rs = db.getQuery(query);
	        	 while (rs.next()) {
	 	            EnrollBean enrollment = new EnrollBean(
	 	                rs.getString("courseID"),
	 	                rs.getString("title"),
	 	                rs.getString("grade")
	 	            );
	 	            enr.add(enrollment);
	 		    }
	 		    
	 		    rs.close();
	 		    db.closeConn();

	 		    session.setAttribute("enrInfo", enr);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}



}

	
	
