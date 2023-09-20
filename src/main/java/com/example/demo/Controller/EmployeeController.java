package com.example.demo.Controller;

import com.example.demo.model.ReprotModel;
import com.example.demo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService EmployeeService;


	@PostMapping("/searchReport")
	public List<ReprotModel> searchReport(@RequestBody ReprotModel model) {
		System.out.println(model);
		return EmployeeService.searchReport(model);
	}

	@PostMapping("/searchReportOut")
	public List<ReprotModel> searchReportOut(@RequestBody ReprotModel model) {
		return EmployeeService.searchReportOut(model);
	}

	

}