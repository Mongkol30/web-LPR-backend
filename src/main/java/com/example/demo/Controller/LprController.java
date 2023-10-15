package com.example.demo.Controller;

import com.example.demo.model.carSearchModel;
import com.example.demo.service.LprService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/lpr")
public class LprController {
	@Autowired
	private LprService LprService;


	@GetMapping("/lpr")
	public void reciverLPR(String plateNo) {
		System.out.println(plateNo);
		LprService.reciverLPR(plateNo);
	}

	@GetMapping("/lprout")
	public void reciverLPRout(String plateNo) {
		System.out.println(plateNo);
		LprService.reciverLPRout(plateNo);
	}

	
	@PostMapping("/search")
	public List<carSearchModel>search(@RequestBody carSearchModel model) {
		return LprService.search(model.getLpNo());
	}

	@PostMapping("/searchOut")
	public List<carSearchModel>searchOut(@RequestBody carSearchModel model) {
		return LprService.searchOut(model.getLpNo());
	}



}