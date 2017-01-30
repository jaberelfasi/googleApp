package mmu.elfasij.app.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CourseDAO{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("transactions-optional");
		EntityManager em = emf.createEntityManager();
		//a method that will retrieve all record sets from the datastore and places it in ArrayList of Course.
		//and return the ArrayList of Course
		public List<Course> getAllCourses(){
			//empty ArrayList of Course ready to be returned later
			List<Course> allCourses = new ArrayList<Course>();
			Query query;
			query = em.createQuery("select o from Course o order by o.CourseID");
			allCourses=query.getResultList();
			return allCourses;
		}
		
		//this method compares the string with the course names from the database
		//and returns the possible matching courses.
		public List<Course> getCourse(String searchTerm){
			Query query;
			query = em.createQuery("select o from Course o where o.CourseName like :x");
			query.setParameter("x",searchTerm.toUpperCase()+"%");
			List<Course> foundCourses = new ArrayList <Course>();
			foundCourses= query.getResultList();
			return foundCourses;
		}
		
		//attempts to insert a course entity into the datastore and returns the success result 
		public String insertCourse(Course course){
			String insertResult = "something wrong";
			if(course.getCourseName()!=""&&
					course.getCourseCredits()!=""&&course.getCourseDuration()!=""&&
							course.getCourseTutor()!=""){
				em.getTransaction().begin();
				em.persist(course);
				em.getTransaction().commit();
				insertResult="(1) Course was added successfully";// 1 represents a successful operation/ 0 represents failed operation
				return insertResult;
			}else{
				return insertResult;           
				//"something wrong"
			}
		
		}
		
		//finds the appropriate CourseID number for the new Course entry
		public String getNewID(){
			String id = "";
			Query query;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("transactions-optional");
			EntityManager em = emf.createEntityManager();
			query = em.createQuery("select count(o.CourseID) from Course o");
			long count = (long)query.getSingleResult();
			count++;
			id=String.valueOf(count);
			return id;
		}
			
}

