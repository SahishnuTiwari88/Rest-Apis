package com.Assignment4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarksController {

    @GetMapping("/")
    public String showForm() {
        return "marksForm";
    }

    @PostMapping("/calculate")
    public ModelAndView calculateTotalMarks(
            @RequestParam("scienceMarks") int scienceMarks,
            @RequestParam("mathsMarks") int mathsMarks,
            @RequestParam("englishMarks") int englishMarks) {

        int totalMarks = scienceMarks + mathsMarks + englishMarks;

        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("totalMarks", totalMarks);

        return modelAndView;
    }
}
