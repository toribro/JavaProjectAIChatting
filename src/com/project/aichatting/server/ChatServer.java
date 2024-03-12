package com.project.aichatting.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.project.aichatting.client.ClientHandler;




public class ChatServer {

	
	
	 public void serverStart(){
		 

		 int port=3000;
		 ServerSocket server=null;
		 
		 try {
			 server=new ServerSocket(port);
	         System.out.println("클라이언트의 요청을 기다립니다.");
	         
	             while(true) {
	            	 Socket socket=server.accept();
					 
				     System.out.println("요청클라이언트:"+socket.getInetAddress().getHostAddress());
			
				     
				     
				     
				     
				     
				    
				     ClientHandler client = new  ClientHandler(socket);
					 Thread t1=new Thread(client);
					 t1.start();
				    
				     
		       }
		        	 
	    }catch(SocketException s) {
			System.err.println("서버 연결 끊김");
			s.printStackTrace();
			
		}
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {}
	 }
	 
}
