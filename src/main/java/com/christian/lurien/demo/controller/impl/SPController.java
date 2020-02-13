package com.christian.lurien.demo.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SPController {

    @GetMapping("/home")
    public ModelAndView showIndex(Model model) {
        ModelAndView mav = new  ModelAndView("index");
        //model.addAttribute("qrcode",null);
        return mav;
    }

    @GetMapping("/error")
    public ModelAndView showError(Model model) {
        ModelAndView newModel = new ModelAndView("error");
        return newModel;
    }

}
