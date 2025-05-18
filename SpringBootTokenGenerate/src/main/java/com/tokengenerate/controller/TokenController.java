package com.tokengenerate.controller;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;


//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.tokengenerate.dao.CustomerRepository;
import com.tokengenerate.dao.DeskRepository;
import com.tokengenerate.dao.TokenRepository;


//import com.tokengenerate.entity.Token;
import com.tokengenerate.entity.Desk;
import com.tokengenerate.entity.Token;
import com.tokengenerate.service.DeskService;
//import com.tokengenerate.service.TokenService;

@RestController
@RequestMapping("/tokens")
public class TokenController {
	private final DeskRepository deskRep;
	private final TokenRepository tokenRep;

	public TokenController(DeskRepository deskRep, TokenRepository tokenRep) {
		this.deskRep = deskRep;
		this.tokenRep = tokenRep;
	}

	@PostMapping("/generate")
	public ResponseEntity<?> generateToken(@RequestParam String customerMobileNo) {

		List<Desk> desks = deskRep.findAll();
		    // Find the desk with the minimum numPersonsBefore

		    Desk deskWithMinPersonsBefore = desks.stream()
		            .min(Comparator.comparingInt(desk ->
		                    tokenRep.countByDeskNoAndTimestampBefore(desk.getDeskNo(), LocalDateTime.now())))

		            .orElse(null);
		    if (deskWithMinPersonsBefore == null) {

		        return ResponseEntity.status(HttpStatus.NOT_FOUND)

		                .body("No available desks to generate tokens."); // No desks available

		    }
		    // Check the capacity of the selected desk

		    int tokensCount = tokenRep.countByDeskNoAndTimestampBefore(deskWithMinPersonsBefore.getDeskNo(), LocalDateTime.now());
		    if (tokensCount >= 10) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                .body(null); // Selected desk is already at capacity
		    }
		String primaryAccount = PrimaryAccount();
// Generate the token
		Token token = new Token();
		token.setTokenNumber(generateTokenNumber());
		token.setDeskNumber(deskWithMinPersonsBefore.getDeskNo());
		token.setCustomerMobileNumber(customerMobileNo);
		token.setPrimaryAccount(primaryAccount);
		token.setNumberOfPersonsBefore(tokensCount);
		token.setDateTime(LocalDateTime.now());
		token.setRequestAccepted("In Process");

// Save the token details
		Token savedToken = tokenRep.save(token);
	
		return ResponseEntity.ok(savedToken);
	}
		 
	private static String PrimaryAccount() {
		StringBuilder sb = new StringBuilder();
		sb.append("SAV-");
		sb.append(AlphaNumericAccountNumber());
		return sb.toString();
	}
	private static String AlphaNumericAccountNumber() {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i=0;i<10;i++) {
			int option = random.nextInt(3);
			if(option==0) {
				char uppercase = (char)(random.nextInt(26)+'A');
				sb.append(uppercase);
			}
			if(option==1) {
				char lowercase = (char)(random.nextInt(26)+'a');
				sb.append(lowercase);
			}
			else {
				int digit = random.nextInt(10);
				sb.append(digit);
			}
		}
		return sb.toString();
	}
		
		
	
	// working of token management controller
	@PutMapping("/{tokenid}")
	public ResponseEntity<?> updateTokenStatus(@PathVariable("tokenid") Long id, @RequestParam String decision) {
Map<String,Object>JsonOutput = new LinkedHashMap<>();
		Optional<Token> optiontoken = tokenRep.findById(id);
		if (optiontoken.isPresent()) {
			Token token = optiontoken.get();
			if (decision.equalsIgnoreCase("accept")) {
				token.setRequestAccepted("Accepted");
			} else if (decision.equalsIgnoreCase("reject")) {
				token.setRequestAccepted("Rejected");

			} else {
				JsonOutput.put("status", 0);
				JsonOutput.put("message", "Specify valid decision as 'accept' or 'reject' only");
				return new ResponseEntity<>(JsonOutput, HttpStatus.BAD_REQUEST);
			}
			tokenRep.save(token);
			JsonOutput.put("status", 1);
			JsonOutput.put("data", token);
			return new ResponseEntity<>(JsonOutput, HttpStatus.OK);
		} else {
			JsonOutput.put("status", -1);
			JsonOutput.put("message", "No information is available");
			return new ResponseEntity<>(JsonOutput, HttpStatus.NOT_FOUND);
		}

	}

	private String generateTokenNumber() {

		int length = 2;
		String chracter = "0123456789";
		Random random = new Random();
		StringBuilder token = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int ind = random.nextInt(chracter.length());
			char randchar = chracter.charAt(ind);
			token.append(randchar);
		}
		return token.toString();
	}

}
