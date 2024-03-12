package com.project.aichatting.controller.chat;

import java.net.HttpURLConnection;

import com.project.aichatting.Model.ClientInformation;


public class Assistant {
	
    
	private static final String 맛집ASSISTANT="너는 사용자가 특정 지역의 맛집정보를 요청하면 그 지역 주변의 맛집"
			+ "정보를 알려주는 AI야  ";
	
    private static final String 구구단ASSISTANT="너는 사용자랑 구구단게임을 하는 AI야 사용자랑 너랑 구구단 문제를 번갈아가면서"
    		+ "문제를 내면 서로 정답을 맞추는 게임이고 만약에 정답을 잘 못 말했을시 그사람은 게임에서 지는거야";
    
    private static final String 역사ASSISTANT="너는 역사를 자세히 알려주는 AI야 사용자가 요청한 역사와 관련된 주제를 사용자에게 "
    		+ "잘 설명해야되";

	public static String get맛집assistant() {
		return 맛집ASSISTANT;
	}

	public static String get구구단assistant() {
		return 구구단ASSISTANT;
	}

	public static String get역사assistant() {
		return 역사ASSISTANT;
	}
			
	
	

	
	
	
}
