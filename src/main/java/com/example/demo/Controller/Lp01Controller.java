package com.example.demo.Controller;

import com.example.demo.entity.Lp01;
import com.example.demo.entity.employeedetail;
import com.example.demo.model.lp01SearchModel;
import com.example.demo.model.Lp02employeedetailModel;
import com.example.demo.service.Lp01Servicepaht;
import com.example.demo.utils.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/lp01")
public class Lp01Controller {
	@Autowired
	private Lp01Servicepaht Lp01Servicepaht;


	@GetMapping("/lpr")
	public void reciverLPR(String plateNo) {
		Lp01Servicepaht.reciverLPR(plateNo);
	}

	
	@PostMapping("/search")
	public List<Lp01>search(@RequestBody lp01SearchModel model) {
		return Lp01Servicepaht.search(model.getLpNo());
	}


	@PostMapping("/searchEmp")
	public List<employeedetail>searchEmp(@RequestBody Lp02employeedetailModel model) {
		return Lp01Servicepaht.searchEmp(model.getKey());
	}



	@PostMapping("/save")
	public Response save(@RequestBody Lp02employeedetailModel model) {
		return Lp01Servicepaht.save(model);

	}

	@PostMapping("/sesearchDetail")
	public Lp02employeedetailModel sesearchDetail(@RequestBody Lp02employeedetailModel model){
		return Lp01Servicepaht.sesearchDetail(model);
	}

	@PostMapping("/edit")
	public Response edit(@RequestBody Lp02employeedetailModel model) {
		return Lp01Servicepaht.edit(model);

	}

	@PostMapping("/delete")
	public Response delete(@RequestBody Lp02employeedetailModel model) {
		return Lp01Servicepaht.delete(model);

	}






}