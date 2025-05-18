package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.Desk;
import com.model.GenerateTokenRequestDTO;
import com.model.Token;
import com.service.CustomerService;
import com.service.DeskService;
import com.service.TokenService;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    private final TokenService tokenService;
    
    private final CustomerService customerService;
    private final DeskService deskService;

    public TokenController(TokenService tokenService, CustomerService customerService, DeskService deskService) {
        this.tokenService = tokenService;
        this.customerService = customerService;
        this.deskService = deskService;
    }


    @PostMapping
    public ResponseEntity<Token> generateToken(@RequestBody GenerateTokenRequestDTO requestDTO) {
        Long customerId = requestDTO.getCustomerId();
        Long deskId = requestDTO.getDeskId();

        Optional<Customer> customer = customerService.getCustomerById(customerId);
        Optional<Desk> desk = deskService.getDeskById(deskId);

        if (customer.isPresent() && desk.isPresent()) {
            Token token = tokenService.generateToken(customer.get(), desk.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(token);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{tokenId}")
    public ResponseEntity<Token> getTokenById(@PathVariable Long tokenId) {
        Optional<Token> token = tokenService.getTokenById(tokenId);
        return token.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Token>> getTokensByCustomerId(@PathVariable Long customerId) {
        List<Token> tokens = tokenService.getTokensByCustomerId(customerId);
        return ResponseEntity.ok(tokens);
    }

    @GetMapping("/desk/{deskId}")
    public ResponseEntity<List<Token>> getTokensByDeskId(@PathVariable Long deskId) {
        List<Token> tokens = tokenService.getTokensByDeskId(deskId);
        return ResponseEntity.ok(tokens);
    }

    @PutMapping("/{tokenId}/accept")
    public ResponseEntity<Token> acceptToken(@PathVariable Long tokenId) {
        Optional<Token> token = tokenService.getTokenById(tokenId);
        if (token.isPresent()) {
            Token acceptedToken = tokenService.acceptToken(token.get());
            return ResponseEntity.ok(acceptedToken);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tokenId}/reject")
    public ResponseEntity<Token> rejectToken(@PathVariable Long tokenId) {
        Optional<Token> token = tokenService.getTokenById(tokenId);
        if (token.isPresent()) {
            Token rejectedToken = tokenService.rejectToken(token.get());
            return ResponseEntity.ok(rejectedToken);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
}