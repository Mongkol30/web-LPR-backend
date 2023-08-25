package com.example.demo.service;

import java.util.List;
import com.example.demo.model.memberDetailModel;
import com.example.demo.repository.core.CorePrimaryRepository;
import com.example.demo.repository.core.SqlParams;
import com.example.demo.utils.CoreUtils;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private CorePrimaryRepository corePrimaryRepository;

	
	public List<memberDetailModel> searchEmp(String keyword){
		StringBuilder sql = new StringBuilder();
		SqlParams params = SqlParams.create();

		sql.append("	select      e.emp_code, 	e.emp_name, 	e.emp_last_name, 	e.emp_phone, 	e.emp_job_title,	e.username,	e.pass ");
		sql.append("	,c.car_licenseplate,		c.car_brand,	c.car_model,		c.car_color,	c.cd_id	");
		sql.append(" 	FROM		employee e 		inner join 		cardetail c 		on 		c.emp_code = e.emp_code						");
		sql.append(" 	WHERE 		1=1										");
		sql.append("	");
		if(CoreUtils.isNotEmpty(keyword)){
			sql.append("	AND e.emp_code like '%'|| :keyword ||'%' 	or 		e.emp_name like '%'||:keyword||'%' 			or		 e.emp_last_name  like '%'||:keyword||'%'		");
			sql.append("	or e.emp_phone  like '%'||:keyword||'%' 	or 		e.emp_job_title  like '%'||:keyword||'%'	or 		 c.car_licenseplate like '%'||:keyword||'%' ");
			sql.append("	or c.car_brand like '%'||:keyword||'%'      or 		c.car_model like '%'||:keyword||'%'   		or		 c.car_color like '%'||:keyword||'%'	");
			params.add("keyword", keyword);
		}
		sql.append("order by e.emp_code");

	    List<memberDetailModel> a = corePrimaryRepository.getDataList(sql.toString(),params,memberDetailModel.class);

		return a;

	}

	public Response save(memberDetailModel model){
		StringBuilder sql = new StringBuilder();
		SqlParams params = SqlParams.create();

		params.add("emp_code", model.getEmp_Code());
		params.add("emp_name", model.getEmp_Name());
		params.add("emp_phone", model.getEmp_Phone());
		params.add("emp_last_name", model.getEmp_last_Name());
		params.add("emp_job_title", model.getEmp_job_Title());
		params.add("car_licenseplate", model.getCar_Licenseplate());
		params.add("car_brand", model.getCar_Brand());
		params.add("car_model", model.getCar_Model());
		params.add("car_color", model.getCar_Color());
		params.add("username", model.getUsername());
		params.add("pass", model.getPass());
		sql.append(" INSERT INTO  employee  ( emp_code , emp_name  ,  emp_last_name  ,  emp_phone  ,  emp_job_title , username ,pass )  VALUES (:emp_code,:emp_name,:emp_last_name,:emp_phone,:emp_job_title,:username,:pass);  ");
		sql.append("INSERT INTO  cardetail  (emp_code , car_licenseplate  ,  car_brand  ,  car_model  ,  car_color )  VALUES (:emp_code,:car_licenseplate,:car_brand,:car_model,:car_color)");

		corePrimaryRepository.update(sql.toString(), params);


		return Response.success();

	}

	public memberDetailModel searchDetail(memberDetailModel model){
		memberDetailModel a = new memberDetailModel();
		SqlParams params = SqlParams.create();
		StringBuilder sql = new StringBuilder();

		sql.append("	select      e.emp_code, 	e.emp_name, 	e.emp_last_name, 	e.emp_phone, 	e.emp_job_title,		e.username,		e.pass	");
		sql.append("	,c.car_licenseplate,		c.car_brand,	c.car_model,		c.car_color,	c.cd_id	");
		sql.append(" 	FROM		employee e 		inner join 		cardetail c 	on 	c.emp_code = e.emp_code						");
		sql.append(" 	WHERE 		1=1										");
		if(CoreUtils.isNotEmpty(model.getCar_Licenseplate())){
			sql.append("	AND c.car_licenseplate like '%'||:keyword||'%' ");
			params.add("keyword", model.getCar_Licenseplate());
		}

		a = corePrimaryRepository.getData(sql.toString(),params,memberDetailModel.class);

		return a;
	}

	public Response edit(memberDetailModel model){
		StringBuilder sql = new StringBuilder();
		SqlParams params = SqlParams.create();

		params.add("emp_code", model.getEmp_Code());
		params.add("emp_name", model.getEmp_Name());
		params.add("emp_phone", model.getEmp_Phone());
		params.add("emp_last_name", model.getEmp_last_Name());
		params.add("emp_job_title", model.getEmp_job_Title());
		params.add("car_licenseplate", model.getCar_Licenseplate());
		params.add("car_brand", model.getCar_Brand());
		params.add("car_model", model.getCar_Model());
		params.add("car_color", model.getCar_Color());
		params.add("cd_id", model.getCd_Id());
		params.add("username", model.getUsername());
		params.add("pass", model.getPass());

		sql.append("	UPDATE		employee 	SET		emp_name=:emp_name,  emp_last_name=:emp_last_name,  emp_phone=:emp_phone,  emp_job_title =:emp_job_title,	username=:username,		pass=:pass ");
		sql.append("	WHERE 		emp_code=:emp_code::varchar ;");
		sql.append("	UPDATE  	cardetail 	SET 	car_licenseplate=:car_licenseplate,  car_brand=:car_brand,   car_model=:car_model,     car_color =:car_color ");
		sql.append("WHERE cd_id=:cd_id::int  ");

		corePrimaryRepository.update(sql.toString(), params);

		return Response.success();
	}

	public Response delete(memberDetailModel model){
		StringBuilder sqlDelet = new StringBuilder();
		SqlParams paramsInsert = SqlParams.create();

		sqlDelet.append("		delete   FROM  employee  WHERE emp_code=:emp_code::varchar  ;");
		sqlDelet.append("		delete   FROM  cardetail  WHERE cd_id=:cd_id::int");
		paramsInsert.add("cd_id", model.getCd_Id());
		paramsInsert.add("emp_code", model.getEmp_Code());

		corePrimaryRepository.update(sqlDelet.toString(), paramsInsert);

		return Response.success();

	}



}

