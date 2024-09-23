package Beans;

public class EnrollBean {
	final private String courseID;
	private String title;
	private final String grade;
	
	public EnrollBean(String courseID, String title, String grade)
	{
		this.courseID = courseID;
		this.title = title;
		this.grade = grade;
	}
	
	public String getCourseID() {
		return courseID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGrade() {
		return grade;
	}

	
}