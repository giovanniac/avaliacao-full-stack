package com.tokiomarine.financial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.financial.model.Transfer;
import com.tokiomarine.financial.service.transfer.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	TransferService service;
	
	@PostMapping("")
	public ResponseEntity<Transfer> create(@RequestBody Transfer transfer) {
		try {
			service.save(transfer);
			return new ResponseEntity<>(transfer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<Transfer>> getAll() {
		try {
			return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
