package com.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Desk;
import com.service.DeskService;

@RestController
@RequestMapping("/desks")
public class DeskController {
    private final DeskService deskService;

    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @GetMapping
    public ResponseEntity<List<Desk>> getAllDesks() {
        List<Desk> desks = deskService.getAllDesks();
        return ResponseEntity.ok(desks);
    }

    // Other API endpoints for desk operations
}