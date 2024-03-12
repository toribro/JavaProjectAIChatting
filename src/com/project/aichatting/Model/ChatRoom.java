package com.project.aichatting.Model;

import java.util.Set;

public class ChatRoom {
	
	private static Set<ClientInformation>client;

	public ChatRoom() {
		
		System.out.println("채팅방 개설을 했습니다.");
		
	}
	
	public void chatWithUser(ClientInformation c) {
		
		
		boolean join=client.add(c);	
		if(!join) {
			System.out.println("이미참여했습니다..");
		}
		else {
			System.out.println("채팅방에 참여했습니다.");
		}
		
		
	}
	
	
	
	
	
}
