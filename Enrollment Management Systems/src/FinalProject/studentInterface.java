package FinalProject;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Student;

public interface studentInterface {
    Student storeStudentInfo(HttpServletRequest request, HttpServletResponse response, String query);
}
