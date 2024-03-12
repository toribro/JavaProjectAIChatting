package com.project.aichatting.Model;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

import com.project.aichatting.controller.chat.Messages;

public class ClientInformation {

	private String username;
	private String password;
	private ArrayList<String> messages;
	private Socket socket;


	
	public ClientInformation(String username,String password,Socket socket) {
		super();
		this.username=username;
		this.password=password;
		this.socket = socket;
		this.messages=null;
	}
	
	
	public ClientInformation(Socket socket) {
		super();
		this.username=null;
		this.socket = socket;
		this.messages=null;
	
	}
	
	
	public ArrayList<String> getMessages() {
		return messages;
	}
	
	public void storeMessages(ArrayList<Messages> messages) {
		
		for(Messages message:messages) {
			this.messages.add(message.getMessage());
		}
		
	}

    @Override
	public int hashCode() {
		return Objects.hash(password, username);
	}


    
    @Override
	public boolean equals(Object obj) {
    	
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientInformation other = (ClientInformation) obj;
		return Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

    
    


    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	
	
	
}
