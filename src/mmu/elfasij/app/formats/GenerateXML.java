package mmu.elfasij.app.formats;

//import java.io.File;
import java.io.StringWriter;
//import java.util.List;




import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import mmu.elfasij.app.model.Courses;

public class GenerateXML {
	public GenerateXML(){
		super();
	}
	
	public String getCourseXml(Courses course){
		String xmlString=null;
		try {
			//course values is just for testing now
		    //course = new Course("1", "2", "3", "4", "5");
			//
			JAXBContext jaxbContext = JAXBContext.newInstance(Courses.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

			//jaxbMarshaller.marshal(course, file);
			//jaxbMarshaller.marshal(course, System.out);
			 java.io.StringWriter sw = new StringWriter();
			 jaxbMarshaller.marshal(course, sw);
			 xmlString=sw.toString();
		      } catch (JAXBException e) {
		    	  e.printStackTrace();
		      }
		return xmlString;
	}
	
	

}
