package com.example.demo.service;

import java.util.List;

import com.example.demo.model.carSearchModel;
import com.example.demo.repository.core.CorePrimaryRepository;
import com.example.demo.repository.core.SqlParams;
import com.example.demo.utils.CoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LprService {

	@Autowired
	private CorePrimaryRepository corePrimaryRepository;

	public void reciverLPR(String plateNo){
		
		String[] plate = plateNo.split("\\r?\\n");
		// StringBuilder sql = new StringBuilder();
		// sql.append("	SELECT 		lc.lp_id 	,lc.lp_no	,lc.lp_date		,lc.lp_time");
		// sql.append(" 	FROM		lpf_camera lc  							");
		// sql.append(" 	WHERE 		1=1										");

		if(plate.length > 0){
			String plateNoFinal = plate[0].replaceAll(" ", "").replaceAll("|", "").replaceAll("@", "").replaceAll("'", "")
									.replaceAll("#", "").replaceAll("%", "").replaceAll("$", "");

				StringBuilder sqlInsert = new StringBuilder();
				SqlParams paramsInsert = SqlParams.create();
				sqlInsert.append(" INSERT INTO  lpf_camera (lp_no) VALUES (:plateNo) ");
				paramsInsert.add("plateNo", plateNoFinal);
				corePrimaryRepository.update(sqlInsert.toString(), paramsInsert);

		}
		
	}


	public List<carSearchModel> search(String keyword){
		StringBuilder sql = new StringBuilder();
		SqlParams params = SqlParams.create();
		sql.append("	SELECT 		lc.lp_id 	,lc.lp_no	,lc.lp_date		,lc.lp_time");
		sql.append(" 	FROM		lpf_camera lc  							");
		sql.append(" 	WHERE 		1=1										");

		if(CoreUtils.isNotEmpty(keyword)){
			sql.append("	AND lc.lp_no like '%'|| :keyword || '%'			");
			params.add("keyword", keyword);
		}
		sql.append(" 	order by lc.lp_date desc, lc.lp_time desc  		");

	    List<carSearchModel> a = corePrimaryRepository.getDataList(sql.toString(),params,carSearchModel.class);
		return a;

	}
	
	public List<carSearchModel> searchOut(String keyword){
		StringBuilder sql = new StringBuilder();
		SqlParams params = SqlParams.create();
		sql.append("	SELECT 		lc.lp_id 	,lc.lp_no	,lc.lp_date		,lc.lp_time");
		sql.append(" 	FROM		lpf_camera_out lc  							");
		sql.append(" 	WHERE 		1=1										");

		if(CoreUtils.isNotEmpty(keyword)){
			sql.append("	AND lc.lp_no like '%'|| :keyword || '%'			");
			params.add("keyword", keyword);
		}
		sql.append(" 	order by lc.lp_date desc, lc.lp_time desc  		");

	    List<carSearchModel> a = corePrimaryRepository.getDataList(sql.toString(),params,carSearchModel.class);
		return a;

	}



}

