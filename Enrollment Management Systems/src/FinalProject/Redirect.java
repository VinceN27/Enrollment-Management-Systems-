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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Redirect")
public class Redirect extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//CHECK IF CLASS ALREADY EXIST IN THE ARRAYLIST SESSION OBJECT
    	Boolean classExist = classExistValidator(request,response);
    	
    	//IDENTIFY WHICH BUTTON IS CLICKED DROP OR ENROLL
    	String action = request.getParameter("action");
    	
    	//Check if class exist in the student records
    	if("drop".equals(action))
    	{
    		if(classExist==true){ //Class already exist
       			RequestDispatcher dispatcher = request.getRequestDispatcher("/dropClass");
    			dispatcher.forward(request, response);
    		}
    		else if(classExist==false){ // Class does not exist
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enrollDropError.jsp");
    			dispatcher.forward(request, response);
    		}
    		
    		
    		
    	}
    	else if("enroll".equals(action))
    	{
    		if(classExist==true){ //Class already exist
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enrollRegisterError.jsp");
    			dispatcher.forward(request, response);
    		}
    		else if(classExist==false){
       			RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterClass");
    			dispatcher.forward(request, response);
    		}
    		
    	}
    	
    }	
    
   
    public Boolean classExistValidator(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user information from selected input

        String selectedCourse = request.getParameter("course");
        String selectedGrade = request.getParameter("grade");
        HttpSession session = request.getSession();
        session.setAttribute("selectedCourse", selectedCourse);
        session.setAttribute("selectedGrade", selectedGrade);

        // Check if course exist in the enrollment session attribute
        ArrayList<EnrollBean> enrInfo = (ArrayList<EnrollBean>) session.getAttribute("enrInfo");

        // Check if the chosen course already exists in the enrollment information
        boolean courseExists = false;
        for (EnrollBean enrollment : enrInfo) {
            if (enrollment.getCourseID().equals(selectedCourse)) {
                courseExists = true;
                break;
            }
        }

        return courseExists;
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }
}