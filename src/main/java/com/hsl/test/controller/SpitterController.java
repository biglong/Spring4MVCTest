package com.hsl.test.controller;

import com.hsl.test.model.Spitter;
import com.hsl.test.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by huangshaolong on 2017/9/7.
 *
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    public static final String REGISTER_FORM = "registerForm";
    public static final String PROFILE = "profile";
    private SpitterRepository repository;

    @Autowired
    public SpitterController(SpitterRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(){
        return REGISTER_FORM;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        repository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,Model model){
        Spitter spitter = repository.findByUsername(username);
        model.addAttribute(spitter);
        return PROFILE;
    }


}
