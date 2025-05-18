package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dao.DeskRepository;
import com.model.Desk;

@Service
public class DeskService {
    private final DeskRepository deskRepository;

    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }

    public Optional<Desk> getDeskById(Long deskId) {
        return deskRepository.findById(deskId);
    }

    // Other methods for desk-related operations
}