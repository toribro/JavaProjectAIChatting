package com.project.aichatting.controller.chat;


import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.project.aichatting.Model.ChatRoom;
import com.project.aichatting.Model.ClientInformation;
import com.project.aichatting.Repository.ClientRepository;
import com.project.aichatting.Repository.Repository;

public class ChatController {
	
	
	//DB라 가정
	private static ConcurrentHashMap<Long,ClientInformation> cM=new ConcurrentHashMap<>();;
	private static Long Sequence=0L;
	
	
	private Repository clientRepository;
	
	private  ClientInformation clientInformation;
	private  ChatBotHandler chatbotHandler;
	
	
	
	//private static ArrayList<Messages> messages;//챗봇이 채팅내용 기억하게 하기

	public ChatController(ClientInformation clientInformation) {

		this.clientInformation=clientInformation;
		this.chatbotHandler=new ChatBotHandler();
		this.clientRepository=new ClientRepository();
	
	 }
	
	
	 //유저 저장
	 public void store(ClientInformation client) {
		 
		 this.clientInformation.storeMessages(this.chatbotHandler.getMessages());//메세지 저장
		 this.clientRepository.insert(this.clientInformation);//db저장
		 
	 }
	 
	 //메세지 조회
	 public ClientInformation selectMessage(ClientInformation client) {
		 
		  return this.clientRepository.select(client);
		 
	 }
	

	
	public StringBuffer ChatWithChatBot(String userMessage) {//채팅 내용 반환
		
		
		 if(userMessage.contains("\"")) {
			 
			 userMessage=userMessage.replace("\""," ");		
		 }
		
			
		
		// openai에 요청해더 전송
	     HttpURLConnection connection=this.chatbotHandler.requestHeader();
	     String requestBody = this.chatbotHandler.requestBody(userMessage);
	     //System.out.println(requestBody);
	     
	     /////////////////////////////
	     
        //요청헤더를 openai에게 보낸다.
	     this.chatbotHandler.sendToChatBot(connection,requestBody);
	       
			
        //openai로부터 응답을 받아온다. json형태로 응답이 들어온다.
	     
	     StringBuffer response=  new StringBuffer(this.chatbotHandler.recevieFromChatBot(connection));
	     
	     
	     ///////////////
	    	
	     //json형태의 메세지에서 챗봇 응답부분만 추출
	  
	     StringBuffer chatbotResponse=  new StringBuffer(this.chatbotHandler.convertMessageToString(response));
	       
	
	     
	        
		 return chatbotResponse;
		
		
		
	}
	
	public StringBuffer  setAssistant(AssistantKind p) {
		
		// openai에 요청해더 전송
	     HttpURLConnection connection=this.chatbotHandler.requestHeader();
	     String requestBody = this.chatbotHandler.requestBody(p);
	     //System.out.println(requestBody);
	     
	     /////////////////////////////
	     
	     
	     
       //요청헤더를 openai에게 보낸다.
	     this.chatbotHandler.sendToChatBot(connection,requestBody);
	       
			
       //openai로부터 응답을 받아온다. json형태로 응답이 들어온다.
	     
	     StringBuffer response=  new StringBuffer(this.chatbotHandler.recevieFromChatBot(connection));
	     
	     
	     ///////////////
	    	
	     //json형태의 메세지에서 챗봇 응답부분만 추출
	  
	     StringBuffer chatbotResponse= new StringBuffer(this.chatbotHandler.convertMessageToString(response));
	       
	     
	  
	     
	        
		 return chatbotResponse;
		
	}
	
	public void deleteMessage() {
		
		this.chatbotHandler.deleteMessage();
	}
	
	
	
	
	public String chatWithUser() {
		
		
	   ChatRoom chatroom =new ChatRoom();
		
		
		return null;
		
	}
	
	
	
	
	//채팅 내용 조회 넣기
	
	
	
	
	
	
	
	//프롬포트 설정 (주제 설정)
	
	
	

	

}
