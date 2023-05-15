package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Lp03SearchModel;
import com.example.demo.repository.core.CorePrimaryRepository;
import com.example.demo.repository.core.SqlParams;
import com.example.demo.utils.CoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lp03Service {

	@Autowired
	private CorePrimaryRepository corePrimaryRepository;


	public List<Lp03SearchModel> searchReport(Lp03SearchModel model){

		SqlParams params = SqlParams.create();
		StringBuilder sql = new StringBuilder();
		params.add("keyword", model.getLpNo());
		params.add("startDate", model.getStartDate());
		params.add("endDate", model.getEndDate());

		sql.append("	select c.lp_id ,c.lp_no, c.lp_time ,c.lp_date  	");
		sql.append(" 	from lpf_camera c					");
		sql.append(" 	WHERE	1=1						");
		sql.append(" 	 and c.lp_no like '%'||:keyword||'%' 					");

		if(CoreUtils.isNotEmpty(model.getStartDate())){
			sql.append(" 	and  ( c.lp_date between :startDate::date and :endDate::date )	");
			params.add("keyword", model.getLpNo());
		}
		sql.append(" 	order by c.lp_date desc, c.lp_time desc  	");
			
		List<Lp03SearchModel> a = corePrimaryRepository.getDataList(sql.toString(),params,Lp03SearchModel.class);
		return a;
	}



}

