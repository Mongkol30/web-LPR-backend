package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ReprotModel;
import com.example.demo.repository.core.CorePrimaryRepository;
import com.example.demo.repository.core.SqlParams;
import com.example.demo.utils.CoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	private CorePrimaryRepository corePrimaryRepository;


	public List<ReprotModel> searchReport(ReprotModel model){

		SqlParams params = SqlParams.create();
		StringBuilder sql = new StringBuilder();
		params.add("keyword", model.getLpNo());
		params.add("startDate", model.getStartDate());
		params.add("endDate", model.getEndDate());

		sql.append("	select c.lp_no, c.lp_time ,c.lp_date ,cd.car_brand ,cd.car_model, cd.car_color ,e.emp_name ,e.emp_last_name ,e.emp_phone  	");
		sql.append(" 	from lpf_camera c FULL OUTER JOIN cardetail cd on c.lp_no  = cd.car_licenseplate  FULL OUTER JOIN employee e on cd.emp_code = e.emp_code			");
		sql.append(" 	WHERE	1=1						");
		sql.append(" 	 and c.lp_no like '%'||:keyword||'%' 					");

		if(CoreUtils.isNotEmpty(model.getStartDate())){
			sql.append(" 	and  ( c.lp_date between :startDate::date and :endDate::date )	");
			
		}
		sql.append(" 	order by c.lp_date desc, c.lp_time desc  	");
			
		List<ReprotModel> a = corePrimaryRepository.getDataList(sql.toString(),params,ReprotModel.class);
		return a;
	}

	public List<ReprotModel> searchReportOut(ReprotModel model){
		StringBuilder sql = new StringBuilder();
		SqlParams params = SqlParams.create();
		params.add("keyword", model.getLpNo());
		params.add("startDate", model.getStartDate());
		params.add("endDate", model.getEndDate());

		sql.append("	SELECT 		c.lp_no, c.lp_time ,c.lp_date ,cd.car_brand ,cd.car_model, cd.car_color ,e.emp_name ,e.emp_last_name ,e.emp_phone ");
		sql.append(" 	FROM		lpf_camera_out  c FULL OUTER JOIN cardetail cd on c.lp_no  = cd.car_licenseplate  FULL OUTER JOIN employee e on cd.emp_code = e.emp_code ");
		sql.append(" 	WHERE 		1=1										");
		sql.append(" 	 and c.lp_no like '%'||:keyword||'%' 					");

		if(CoreUtils.isNotEmpty(model.getStartDate())){
			sql.append(" 	and  ( c.lp_date between :startDate::date and :endDate::date )	");
			
		}
		sql.append(" 	order by c.lp_date desc, c.lp_time desc  	");

	    List<ReprotModel> a = corePrimaryRepository.getDataList(sql.toString(),params,ReprotModel.class);
		return a;

	}



}

