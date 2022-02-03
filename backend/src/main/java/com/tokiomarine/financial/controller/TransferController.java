package com.tokiomarine.financial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.financial.exception.InvalidInputException;
import com.tokiomarine.financial.mapper.TransferMapper;
import com.tokiomarine.financial.service.transfer.TransferService;
import com.tokiomarine.financial.vo.transfer.SaveTransferVO;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	TransferService service;
	
	@Autowired
	TransferMapper transferMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SaveTransferVO transfer) {
		try {
			service.save(transferMapper.fromSendTransferVO(transfer), transfer.getOperationType());
			return new ResponseEntity<>(transfer, HttpStatus.CREATED);
		} catch (InvalidInputException e) {
			return new ResponseEntity<>(e.getCustomMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/cotate")
	public ResponseEntity<?> getCotation(@RequestBody SaveTransferVO transfer) {
		try {
			return new ResponseEntity<>(service.cotate(transferMapper.fromSendTransferVO(transfer)), HttpStatus.OK);
		} catch (InvalidInputException e) {
			return new ResponseEntity<>(e.getCustomMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
