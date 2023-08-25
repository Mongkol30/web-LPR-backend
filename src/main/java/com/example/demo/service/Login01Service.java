package com.example.demo.service;

import java.util.List;

import com.example.demo.model.LoginModel;
import com.example.demo.repository.core.CorePrimaryRepository;
import com.example.demo.repository.core.Data;
import com.example.demo.repository.core.GridData;
import com.example.demo.repository.core.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login01Service {

	@Autowired
	private CorePrimaryRepository corePrimaryRepository;

	public List<LoginModel> login(LoginModel model){
		
		SqlParams params = SqlParams.create();
		StringBuilder sql = new StringBuilder();
		params.add("keyword", model.getUserName());
		

		sql.append("	select e.username ,e.pass   	");
		sql.append(" 	from employee e 			    ");
		sql.append(" 	where 1=1		");
		

		
			
		List<LoginModel> data = corePrimaryRepository.getDataList(sql.toString(), params,LoginModel.class);
		return data;
	}



}

