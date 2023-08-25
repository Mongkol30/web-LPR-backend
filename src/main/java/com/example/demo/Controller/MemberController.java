package com.example.demo.Controller;

import com.example.demo.model.memberDetailModel;
import com.example.demo.service.MemberService;
import com.example.demo.utils.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService MemberService;



	@PostMapping("/searchEmp")
	public List<memberDetailModel>searchEmp(@RequestBody memberDetailModel model) {
		return MemberService.searchEmp(model.getEmp_Name());
	}



	@PostMapping("/save")
	public Response save(@RequestBody memberDetailModel model) {
		return MemberService.save(model);

	}

	@PostMapping("/searchDetail")
	public memberDetailModel sesearchDetail(@RequestBody memberDetailModel model){
		return MemberService.searchDetail(model);
	}

	@PostMapping("/edit")
	public Response edit(@RequestBody memberDetailModel model) {
		System.out.println(model);
		return MemberService.edit(model);

	}

	@PostMapping("/delete")
	public Response delete(@RequestBody memberDetailModel model) {
		System.out.println(model);
		return MemberService.delete(model);

	}






}