package com.project.aichatting.Repository;

import com.project.aichatting.Model.ClientInformation;

public interface Repository {

	
	void insert(ClientInformation c);//데이터 저장
	
	ClientInformation select(ClientInformation c);//데이터 조회
	
	void delete(ClientInformation c);//데이터 삭제
	
	void update(ClientInformation c);//데이터 수정
}
