package com.example.demo.Controller;

import com.example.demo.model.Lp03SearchModel;
import com.example.demo.service.Lp03Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/lp03")
public class Lp03Controller {
	@Autowired
	private Lp03Service Lp03Service;

	@PostMapping("/searchReport")
	public  List<Lp03SearchModel> searchReport(@RequestBody Lp03SearchModel model){
		return Lp03Service.searchReport(model);
	}

}