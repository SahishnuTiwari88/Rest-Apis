package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.dao.TokenRepository;
import com.model.Customer;
import com.model.Desk;
import com.model.Token;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;
  

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
        
    }
    
    public Optional<Token> getTokenById(Long tokenId) {
        return tokenRepository.findById(tokenId);
    }

    public List<Token> getTokensByCustomerId(Long customerId) {
        return tokenRepository.findByCustomerId(customerId);
    }

    public List<Token> getTokensByDeskId(Long deskId) {
        return tokenRepository.findByDeskId(deskId);
    }

    public Token acceptToken(Token token) {
        token.setAcceptRejectStatus("Accepted");
        return tokenRepository.save(token);
    }

    public Token rejectToken(Token token) {
        token.setAcceptRejectStatus("Rejected");
        return tokenRepository.save(token);
    }

	public Token generateToken(Customer customer, Desk desk) {
		// TODO Auto-generated method stub
		Token token = new Token();
		token.setCustomer(customer);
		token.setDesk(desk);
		token.setDateTime(LocalDateTime.now());
		token.setAcceptRejectStatus("In process");
		token.setRequestCount(desk.getCapacity());
		String tokenNumber = generateTokenNumber();
		token.setTokenNumber(tokenNumber);
		return tokenRepository.save(token);
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
//   public Token generateToken(Customer customer, Desk desk, LocalDateTime dateTime) {
//        Token token = new Token();
//        token.setCustomer(customer);
//        token.setDesk(desk);
//        token.setDateTime(dateTime);
//        token.setTokenNumber(token.getTokenNumber());
//        token.setAcceptRejectStatus(token.getAcceptRejectStatus());
//        // Set any other fields as required
//        return tokenRepository.save(token);
//    }

    // Other methods for token-related operations
}