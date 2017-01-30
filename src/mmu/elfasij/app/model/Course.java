package mmu.elfasij.app.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



import com.google.appengine.api.datastore.Key;

//this is the Course java bean, which is the setters/getters/construct
//this java bean is part of the MODEL in the context of MVC
@Entity
@XmlRootElement
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	@Basic
	private String CourseID = null;
	@Basic
	private String CourseName = null;
	@Basic
	private String CourseCredits = null;
	@Basic
	private String CourseDuration = null;
	@Basic
	private String CourseTutor=null;
	
	public Key getKey() {
        return key;
    }

	public String getCourseID() {
		return CourseID;
	}
	
	@XmlElement
	public void setCourseID(String courseID) {
		this.CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}
	
	@XmlElement
	public void setCourseName(String courseName) {
		this.CourseName = courseName;
	}

	public String getCourseCredits() {
		return CourseCredits;
	}
	
	@XmlElement
	public void setCourseCredits(String courseCredits) {
		this.CourseCredits = courseCredits;
	}

	public String getCourseDuration() {
		return CourseDuration;
	}

	@XmlElement
	public void setCourseDuration(String courseDuration) {
		this.CourseDuration = courseDuration;
	}

	public String getCourseTutor() {
		return CourseTutor;
	}

	@XmlElement
	public void setCourseTutor(String courseTutor) {
		this.CourseTutor = courseTutor;
	}
}
