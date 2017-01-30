package mmu.elfasij.app.formats;


import mmu.elfasij.app.model.Courses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class GenerateJSON {
	
	public String getCourseJson(Courses courses){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString= gson.toJson(courses);
		return jsonString;
	}

}
