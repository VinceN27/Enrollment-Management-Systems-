package FinalProject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.EnrollBean;
import DBUtils.DButil;

@WebServlet("/dropClass")
public class dropClass extends HttpServlet implements classInterface, enrollInterface{
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		
    	HttpSession session = request.getSession();
    	String ssn = (String) session.getAttribute("ssn");
    	String selectedCourse = (String) session.getAttribute("selectedCourse");

    	dropClass(ssn,selectedCourse);
    	
    	String qry1 = (String) session.getAttribute("qry1");
    	storeClassInfo(request,response, qry1);
      
    	
    }


	@Override
	public void enrollCLass(HttpServletRequest request, HttpServletResponse response, String query) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dropClass(String ssn, String courseId) {
		DButil db = new DButil();
		db.connectDB("cst4713", "password1");
		
		
		try {
			db.deleteEnrollment(ssn, courseId);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


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
	 	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/Exit");
	 	    	try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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

	