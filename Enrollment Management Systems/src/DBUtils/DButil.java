package DBUtils;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

public class DButil {
    private String connectionUrl = "jdbc:mysql://database-cuny.c4piq2ndsfvh.us-west-1.rds.amazonaws.com:3306/CUNY_DB";
    private String driver = "com.mysql.cj.jdbc.Driver";	
    //private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    //private String connectionUrl = "jdbc:sqlserver://s16988308.onlinehome-server.com:1433;" 
	// 	+ "databaseName=CUNY_DB;integratedSecurity=false;";
	
	private static Connection connection;
	private ResultSet resultset;
	
	// Open Connection to database
	// Open Connection to database
	public void connectDB(String ID, String password){
		try{
			Class.forName(driver);
			System.out.println("JDBC Driver loaded. Connecting to database....");
			connection = DriverManager.getConnection(connectionUrl, ID,password);
			System.out.println("Database Connected.");
		}catch(ClassNotFoundException | SQLException ex){
			ex.printStackTrace();					
		}
	}

	
	// Run Query to get result set
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(query);
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultset;
	}	

	
	public String getCourses() throws SQLException, ClassNotFoundException {
		String resultList="";
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT  courseID, title, numOfCredits FROM course;");
			while (resultset.next())
			{
				resultList= resultList + "<li>" + resultset.getString(1) + "\t" 
						+ resultset.getString(2) + "\t" + resultset.getString(3) + "</li>\n";			
			}
			
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultList;
	}
	// Insert values into database
	public void updateValues(String table, String query)throws SQLException, ClassNotFoundException {
		
		try{
			//connectDB();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		}catch(SQLException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
	}

	public void deleteEnrollment(String ssn, String courseId) throws SQLException, ClassNotFoundException {
	    try {
	        String query = "DELETE FROM Enrollment WHERE ssn = '" + ssn + "' AND courseId = '" + courseId + "'";
	        Statement statement = connection.createStatement();
	        statement.executeUpdate(query);
	    } catch (SQLException ex) {
	        ex.getMessage();
	        ex.printStackTrace();
	    }
	}

	

	
	// Closes database connection
	// Closes database connection
	public void closeConn() throws SQLException {
	    if (connection != null) {
	        connection.close();
	    }
	}

}