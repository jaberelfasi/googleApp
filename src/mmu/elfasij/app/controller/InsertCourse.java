package mmu.elfasij.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mmu.elfasij.app.model.Course;
import mmu.elfasij.app.model.CourseDAO;


public class InsertCourse extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String outputpage="/WEB-INF/results/insertionResult.jsp";
				CourseDAO dao = new CourseDAO();
				
				Course course = new Course();
				course.setCourseName(request.getParameter("CourseName").toUpperCase());
				course.setCourseCredits(request.getParameter("CourseCredits"));
				course.setCourseDuration( request.getParameter("CourseDuration"));
				course.setCourseTutor(request.getParameter("CourseTutor"));
				course.setCourseID(dao.getNewID());
				
				String insertResult=dao.insertCourse(course);
				
				
				response.setContentType("text/plain");
				request.setAttribute("insertResult", insertResult);
		        out.println(insertResult);
		        try {
					request.getRequestDispatcher(outputpage).include(request, response);
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	}
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            		throws ServletException, IOException {
					doGet(request, response);
			}
	
}
