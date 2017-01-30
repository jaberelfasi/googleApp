package mmu.elfasij.app.controller;
//this java bean is part of the CONTROLLER in the context of MVC
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mmu.elfasij.app.model.Course;
import mmu.elfasij.app.model.CourseDAO;


public class QueryCourses extends HttpServlet {
	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
				throws ServletException, IOException{
		
		
		String searchTerm = request.getParameter("coursename");
		String format = request.getParameter("format");
		
		List<Course> allCourses = new ArrayList <Course>();
		CourseDAO dao = new CourseDAO();
		
		if(searchTerm == null){
			//this bit of code retrieves all the courses in the database
			allCourses=dao.getAllCourses();
			request.setAttribute("allCourses", allCourses);	
		}else{
			//this bit of code retrieves the search matches for the looked up course
			allCourses=dao.getCourse(searchTerm);
			request.setAttribute("allCourses", allCourses);	
		}		
			
		
		String outputpage;
		if("xml".equals(format)){
			response.setContentType("text/xml");
			outputpage="/WEB-INF/results/allCoursesXml.jsp";
		}else if("json".equals(format)){
			response.setContentType("text/javascript");
			outputpage="/WEB-INF/results/allCoursesJson.jsp";
		}else{
			response.setContentType("text/plain");
			outputpage="/WEB-INF/results/allCoursesPlain.jsp";
		}
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(outputpage);
		try {
			dispatcher.include(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            		throws ServletException, IOException {
					doGet(request, response);
			}
}
