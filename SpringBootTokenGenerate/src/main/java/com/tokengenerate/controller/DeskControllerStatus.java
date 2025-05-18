package com.tokengenerate.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokengenerate.dao.DeskRepository;
import com.tokengenerate.dao.TokenRepository;
import com.tokengenerate.entity.Desk;
import com.tokengenerate.entity.Desk_Status;

@RestController

public class DeskControllerStatus {
	//@Autowired
	
	

	
	

		private final DeskRepository deskRepository;
		private final TokenRepository tokenRepository;

		public DeskControllerStatus(DeskRepository deskRepository, TokenRepository tokenRepository) {

			this.deskRepository = deskRepository;
			this.tokenRepository = tokenRepository;

		}

		@GetMapping
		public ResponseEntity<List<Desk_Status>> getDeskStatus() {

			List<Desk> desks = deskRepository.findAll();

			List<Desk_Status> deskStatusList = new ArrayList<>();

			for (Desk desk : desks) {

				Desk_Status deskStatus = new Desk_Status();

				deskStatus.setDeskNumber(desk.getDeskNo());

				if (!desk.isStatus()) {

					deskStatus.setDeskStatus("OFF");

				} else {

					// Check if the desk is busy handling a customer issue

					int tokensCount = tokenRepository.countByDeskNoAndTimestampBefore(desk.getDeskNo(), LocalDateTime.now());

					if (tokensCount >= 10) {

						deskStatus.setDeskStatus("BUSY");

					} else {

						deskStatus.setDeskStatus("FREE");

					}

				}

				deskStatusList.add(deskStatus);

			}

			return ResponseEntity.ok(deskStatusList);

		}
		@ExceptionHandler
		public ResponseEntity<String> handleException(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

