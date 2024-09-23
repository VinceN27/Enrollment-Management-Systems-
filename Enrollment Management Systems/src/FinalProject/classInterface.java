package FinalProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface classInterface {
	void enrollCLass(HttpServletRequest request, HttpServletResponse response, String query);
	void dropClass(String ssn , String courseId);
}
