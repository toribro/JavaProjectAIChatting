package com.project.aichatting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Client {

	private static Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		
		//canner sc =new Scanner(System.in);
		BufferedReader br =null;
		PrintWriter pw=null;
		
		
		
		
		Socket socket=connectServer();//서버연결
		
		 
		 
		
		try {
			
			// socket= new Socket(serverIp,3000);
			
			if(socket!=null) {
				System.out.println("서버연결성공");
				
				
				
				//로그인 로직을 구현해야한다.
				
				
				
				System.out.println("메뉴를 선택하세요: 자유챗봇 ,맛집챗봇, 구구단챗봇, 역사챗봇 exit:종료");
				while(true) {
					br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					//출력용 스트림
					pw=new PrintWriter(socket.getOutputStream(),true);
					
					
					String sendMessgae=sc.nextLine();
					pw.println(sendMessgae);
					pw.flush();
				
					
					
			        String responseMessage=br.readLine();
					System.out.println(responseMessage.replaceAll("\\*", "\\\n"));
					
					
					//기능에따라 분기
					if(responseMessage.equals("=====채팅방에 입장하셨습니다 , (quit: 나가기)=====")
						||responseMessage.contains("챗봇 응답메세지")) {
					
						System.out.println("메세지를 입력하세요 (quit:채팅 종료)");
						
					}
					
					
					else if(responseMessage.equals("채팅을 종료합니다.")) {
						
						System.out.println("메뉴를 선택하세요: 자유챗봇 ,맛집챗봇, 구구단챗봇, 역사챗봇 exit:종료");
					}
					
					
					
				}
			}
		}catch(SocketException s) {
			System.err.println("종료되었습니다.");
			
		} 
		
		
		catch (UnknownHostException e) {
			System.err.println("호스트를 찾을수 없습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		    
		     try {
		    	pw.close();
				br.close();
				sc.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}
	
	
	
	private static Socket connectServer() {
		
		//Scanner sc =new Scanner(System.in);
		Socket socket=null;
		String serverIp=null;
		
	
			   
		 while(socket==null) {
			 try{
					
				System.out.println("접속할 아이피를 입력하세요:");
				serverIp=sc.nextLine();
				serverIp=serverIp.trim();
				socket= new Socket(serverIp,3000);
				   
			 } catch (UnknownHostException e) {
				System.err.println("호스트를 찾을 수 없습니다");
					
			 } catch (IOException e) {
				System.err.println("에러발생");
			 }
			 
		 }
		 
		
		System.out.println("접속했습니다.");
		 
			
		return socket;
		
		
	}
	

}
