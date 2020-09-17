package com.company.bma.controller.Impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.bma.controller.GroupSwaggerDoc;
import com.company.bma.model.Card;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.GroupRequest;
import com.company.bma.service.GroupService;
import com.company.bma.utils.CsvUtils;

@RestController
@CrossOrigin(origins = "*")
public class GroupController implements GroupSwaggerDoc {
	
	@Autowired
	private GroupService groupService;

	@PostMapping("/group")
	public ResponseEntity<Void> createGroup(@RequestBody GroupRequest groupRequest) {
		groupService.createGroup(groupRequest);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/group/{groupCategory}/card/{groupName}")
	public ResponseEntity<List<Card>> retrieveCardByGroup(@PathVariable GroupCategory groupCategory,@PathVariable String groupName) {
		return new ResponseEntity<List<Card>>(groupService.retrieveCardsOfGroup(groupCategory, groupName),HttpStatus.OK);
	}
	
	@GetMapping("/group/{groupCategory}/export/{groupName}/card")
	public void exportCards(@PathVariable GroupCategory groupCategory,@PathVariable String groupName,HttpServletResponse response){
		response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=cards.csv");
		try {
			CsvUtils.downloadCardCsv(response.getWriter(),groupService.retrieveCardsOfGroup(groupCategory, groupName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/group/{groupCategory}/import/{groupName}/card")
	public ResponseEntity<Void> importCards(@PathVariable GroupCategory groupCategory,@PathVariable String groupName,@RequestParam MultipartFile file){
		return null;
	}
	
	
	@PostMapping("/group/{id}")
	public ResponseEntity<Void> addCardToGroup(@PathVariable Integer id,@RequestBody GroupRequest groupRequest) {
		groupService.addCardToGroup(id, groupRequest);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/groupNames/{groupCategory}")
	public ResponseEntity<List<String>> retrieveGroupName(@PathVariable GroupCategory groupCategory) {
		return new ResponseEntity<List<String>>(groupService.retrieveGroupName(groupCategory),HttpStatus.OK);
	}
	
}
