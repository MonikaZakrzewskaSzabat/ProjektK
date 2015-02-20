package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "index"; //ZMIENIAC W RAZIE KONIECZNOSCI PRZEJSCIA NA INNA STRONE POKI BRAKUJE PRZEJSC
    }

    @RequestMapping(value = "/addrej", method = RequestMethod.POST)
    public String addUserRej(@ModelAttribute("user") User user, BindingResult result) {

        userRepository.save(user);

        return "redirect:/rejestracja";
    }

    @RequestMapping("/deleterej/{userId}")
    public String deleteUserRej(@PathVariable("userId") Long userId) {

        userRepository.delete(userRepository.findOne(userId));

        return "redirect:/rejestracja";
    }

    @RequestMapping(value = "/addlog", method = RequestMethod.POST)
    public String addUserLog(@ModelAttribute("user") User user, BindingResult result) {

        userRepository.save(user);

        return "redirect:/logowanie";
    }

    @RequestMapping("/deletelog/{userId}")
    public String deleteUserLog(@PathVariable("userId") Long userId) {

        userRepository.delete(userRepository.findOne(userId));

        return "redirect:/logowanie";
    }

    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public String Rejestracja(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "rejestracja";
    }

    @RequestMapping(value = "/logowanie", method = RequestMethod.GET)
    public String Logowanie(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "logowanie";
    }
}