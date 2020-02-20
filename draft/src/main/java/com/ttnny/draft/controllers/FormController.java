package com.ttnny.draft.controllers;

import com.ttnny.draft.models.FormObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("attributes", "Test an attribute on GET");
        model.addAttribute("formObject", new FormObject());
        return "form";
    }

    @PostMapping("/form")
    public String postForm(Model model, @ModelAttribute FormObject formObject) {
        model.addAttribute("attributes", "Test an attribute on POST");
        return "form";
    }
}
