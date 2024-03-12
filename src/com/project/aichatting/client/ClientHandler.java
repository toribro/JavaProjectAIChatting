package com.project.aichatting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import com.project.aichatting.Model.ClientInformation;
import com.project.aichatting.controller.chat.AssistantKind;
import com.project.aichatting.view.ChatView;

public class ClientHandler implements Runnable {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private ClientInformation ci;
	//private ChatController c;
	
	private ChatView view;
	private String chatCheck;
	

	public ClientHandler(Socket socket) {
		
		this.socket = socket;
		try {
			this.in = new BufferedReader(new InputStreamReader( this.socket.getInputStream()));
			this.out = new PrintWriter(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ci=new ClientInformation(this.socket);
		this.view=new ChatView(this.ci);
		//this.c=new ChatController(this.ci);
		this.chatCheck="자유";
	}
	
	
	
	
	
	private void chatting() {
		
	
		String message=null;
		//Socket clientSocket=this.socket;
		
		System.out.println(this.socket+"님이 "+this.chatCheck+"채팅방에 입장하셨습니다.");
		try{
			
			
			while((message=this.in.readLine())!=null) {
				
				if(message.equals("quit")) {
					System.out.println(this.socket+"님이 채팅을 종료했습니다.");
					
					//채팅기록 저장
					
					//임시 채팅기록 삭제
					this.view.deleteChat();
					this.out.println("채팅을 종료합니다.");
					this.out.flush();
					return;
				}
				
				
				System.out.println("클라이언트"+this.socket+"님이 보낸메세지:"+message);
				StringBuffer responseMessage=this.view.ChatwithChatBot(message);
				System.out.println("클라이언트"+this.socket+"님이 받은메세지:"+responseMessage);
				System.out.println();
				this.out.println("챗봇 응답메세지:"+responseMessage);
				this.out.flush();
				
			}
		}catch(SocketException s) {
			System.out.println(this.socket+"님이 채팅방에서 나가셨습니다.");
		} 
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void assistantChatting() {
		
		String message=null;
		//Socket clientSocket=this.socket;
		
		System.out.println(this.socket+"님이 "+this.chatCheck+"채팅방에 입장하셨습니다.");
		
		
		try{
			
			
			while((message=this.in.readLine())!=null) {
				
				
				if(message.equals("quit")) {
					System.out.println(this.socket+"님이 채팅을 종료했습니다.");
					this.view.deleteChat();
					this.out.println("채팅을 종료합니다.");
					this.out.flush();
					return;
				}
				
				
				System.out.println("클라이언트"+this.socket+"님이 보낸메세지:"+message);
				StringBuffer responseMessage=this.view.ChatwithChatBot(message);
				System.out.println("클라이언트"+this.socket+"님이 받은메세지:"+ responseMessage);
				System.out.println();
				this.out.println(this.chatCheck +"챗봇 응답메세지:"+responseMessage);
				this.out.flush();
				
			}
		}catch(SocketException s) {
			System.out.println(this.socket+"님이 채팅방에서 나가셨습니다.");
		} 
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void run() {
		
		try {
			
			String message=null;
			 StringBuffer assistant;
			while((message=this.in.readLine())!=null) {
				
				if(message.equals("exit")) {
					
					this.out.println("프로그램을 종료합니다.");
					this.out.flush();
				    break;					
				}
				else if(message.equals("자유챗봇")) {
					this.out.println("=====채팅방에 입장하셨습니다 , (quit: 나가기)=====");
					this.out.flush();
					this.chatting();
					
				}
				else if(message.equals("맛집챗봇")) {
					
				    assistant=this.view.setAssistant(AssistantKind.맛집);
				    this.chatCheck="맛집";
					this.out.println("=====맛집채팅방에 입장하셨습니다 , (quit: 나가기)===== ||"+"주제:"+assistant);
					this.out.flush();
					
					//System.out.println("서버 프롬포트 응답메세지:"+prompt);
				    this.assistantChatting();
					
				}
				
				else if(message.equals("구구단챗봇")) {
					
				    assistant=this.view.setAssistant(AssistantKind.구구단);
				    this.chatCheck="구구단";
					this.out.println("=====구구단채팅방에 입장하셨습니다 , (quit: 나가기)===== ||"+"주제:"+assistant);
					this.out.flush();
					
					//System.out.println("서버 프롬포트 응답메세지:"+prompt);
				    this.assistantChatting();
					
				}
				
				else if(message.equals("역사챗봇")) {
					
				    assistant=this.view.setAssistant(AssistantKind.역사);
				    this.chatCheck="역사";
					this.out.println("=====역사채팅방에 입장하셨습니다 , (quit: 나가기)===== ||"+"주제:"+assistant);
					this.out.flush();
					
					//System.out.println("서버 프롬포트 응답메세지:"+prompt);
				    this.assistantChatting();
					
				}
				
				
				
				else {
					this.out.println("다시입력해보세요 ");
					this.out.flush();
					
				}
				
				
				
			}
			
			System.out.println(this.socket+"님이 서버에서 나가셨습니다.");
		
			
		}catch(SocketException s) {
			System.err.println(this.socket+"님이 서버에서 나가셨습니다..");
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			 
		     try {
		    	this.out.close();
				this.in.close();
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	  
	}
	

}
