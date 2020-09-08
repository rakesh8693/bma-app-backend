package com.company.bma.controller.Impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.bma.controller.GroupSwaggerDoc;
import com.company.bma.model.Card;
import com.company.bma.model.Group;
import com.company.bma.model.GroupRequest;

@RestController
public class GroupController implements GroupSwaggerDoc {

	@PostMapping("/group")
	public ResponseEntity<Void> createGroup(@RequestBody GroupRequest groupRequest) {
		return null;
	}

	@GetMapping("/group")
	public ResponseEntity<List<Group>> retrieveGroup(@RequestParam Integer groupBy) {
		return null;
	}
	
	@GetMapping("/group/{groupby}/export/{groupname}/card")
	public ResponseEntity<HttpServletResponse> exportCards(@PathVariable Integer groupBy,@PathVariable String groupName){
		return null;
	}
	
	@PostMapping("/group/{groupby}/import/{groupname}/card")
	public ResponseEntity<Void> importCards(@PathVariable Integer groupBy,@PathVariable String groupName,@RequestParam MultipartFile file){
		return null;
	}
	
	@GetMapping("/group/{groupby}/validate/{groupname}/card")
	public ResponseEntity<List<Card>> changesToValidate(@PathVariable Integer groupBy,@PathVariable String groupName){
		return null;
	}
}
