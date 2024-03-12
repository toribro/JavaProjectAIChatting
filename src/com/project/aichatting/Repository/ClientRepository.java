package com.project.aichatting.Repository;

import java.util.concurrent.ConcurrentHashMap;

import com.project.aichatting.Model.ClientInformation;

public class ClientRepository implements Repository {

	
	private static ConcurrentHashMap<Long,ClientInformation> cM=new ConcurrentHashMap<>();
	private static Long Sequence=0L;
	
      

	@Override
	public void insert(ClientInformation c) {
		 cM.put(++Sequence, c);
	}


	@Override
	public ClientInformation select(ClientInformation c) {
		
		 for(Long id : cM.keySet()) {
			 if(cM.get(id).equals(c)) {
				 return cM.get(id);
			 }
		 }
	    
		 return null;
		
	}


	@Override
	public void delete(ClientInformation c) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(ClientInformation c) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
}
