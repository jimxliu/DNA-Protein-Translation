package com.demo.translation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TranslateController {
    
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("translate", new Translate());
        return "index";
    }

    @PostMapping("/")
    public String submitForm(@ModelAttribute Translate translate){
        translate.translate();
        return "index";
    }
}
