package com.project.aichatting.view;

import java.util.Scanner;

import com.project.aichatting.Model.ClientInformation;
import com.project.aichatting.controller.chat.AssistantKind;
import com.project.aichatting.controller.chat.ChatController;

public class ChatView  {
	
	
	private ChatController c;
	private ClientInformation ci;
	
	public ChatView(ClientInformation ci) {
		
		this.ci=ci;
		c=new ChatController(this.ci);
		
	}
	
//	public String mainView() {
//		//System.out.println("챗봇응답메세지: "+this.Chat());
//		return this.Chat();
//		
//	}
//	
	
	public StringBuffer ChatwithChatBot(String sendMessage) {
		
//		Scanner sc =new Scanner(System.in);
//		System.out.print("보낼 메세지를 입력하세요: ");
//		String sendMessage=sc.nextLine();
		
		return c.ChatWithChatBot(sendMessage);
		
	}
	
	public StringBuffer setAssistant(AssistantKind p) {
	    return c.setAssistant(p);	
	}
	
	public void deleteChat() {
		c.deleteMessage();
	}
	
	
	public void store(ClientInformation client) {
		
		this.c.store(client);
		
	}
	
	

}
