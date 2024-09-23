package FinalProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.EnrollBean;

public interface enrollInterface {
	EnrollBean storeClassInfo (HttpServletRequest request, HttpServletResponse response, String query);
}
