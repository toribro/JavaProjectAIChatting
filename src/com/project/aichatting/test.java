package com.project.aichatting;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class Messages{
	

	
	public String a() {
		return "1";
	}
	
	@Override
	public String toString() {
		
	
		return String.format("{\"role\": \"user\", \"content\": \"%s\"}\"", "content");
	}
	
	
}


public class test {
	
	

	public static void main(String[] args) {
		ArrayList<Messages> m =new ArrayList<Messages>();
	
		    m.add(new Messages());
		    m.add(new Messages());
		    m.add(new Messages());
		    
		   
		   
	}

}
