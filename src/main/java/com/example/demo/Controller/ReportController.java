package com.example.demo.Controller;

import com.example.demo.model.ReprotModel;
import com.example.demo.service.ReportService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private ReportService ReportService;


	@PostMapping("/searchReport")
	public List<ReprotModel> searchReport(@RequestBody ReprotModel model) {
		System.out.println(model);
		return ReportService.searchReport(model);
	}

	@PostMapping("/searchReportOut")
	public List<ReprotModel> searchReportOut(@RequestBody ReprotModel model) {
		return ReportService.searchReportOut(model);
	}

	

}