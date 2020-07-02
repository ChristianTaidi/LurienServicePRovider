package com.christian.lurien.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public interface RegisterRequestController {

    ModelAndView getClaim(String userIdentifier, Model model);
}
