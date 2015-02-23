package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="/")
    public ModelAndView listUsers(ModelAndView model) throws IOException {
        List<User> listUsers = userDAO.list();
        model.addObject("listUsers", listUsers);
        model.setViewName("home");

        return model;
    }

//    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
//    public ModelAndView newUser(ModelAndView model) {
//        User user = new User();
//        model.addObject("user", user);
//        model.setViewName("UserForm");
//        return model;
//    }

//    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
//    public ModelAndView saveUser(@ModelAttribute User user) {
//        userDAO.saveOrUpdate(user);
//        return new ModelAndView("redirect:/");
//    }

    @RequestMapping(value = "/addrej", method = RequestMethod.POST)
    public ModelAndView addUserRej(@ModelAttribute User user) {
        userDAO.saveOrUpdate(user);
        return new ModelAndView("redirect:/rejestracja");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        userDAO.delete(id);
        return new ModelAndView("redirect:/rejestracja");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        User user = userDAO.get(id);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);

        return model;
    }

    @RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        List<User> listUsers = userDAO.list();

        model.addObject("user", user);
        model.addObject("listUsers", listUsers);
        model.setViewName("rejestracja");
        return model;
    }

    @RequestMapping(value = "/logowanie", method = RequestMethod.GET)
    public ModelAndView Logowanie(ModelAndView model) {
        User user = new User();
        List<User> listUsers = userDAO.list();

        model.addObject("user", user);
        model.addObject("listUsers", listUsers);
        model.setViewName("logowanie");
        return model;
    }

    @RequestMapping(value = "/addlog", method = RequestMethod.POST)
    public ModelAndView UserLog(@ModelAttribute User user) {
        String passwordFromDB;

        passwordFromDB= userDAO.getPassword(user);
        if(passwordFromDB.equals(user.getHaslo())) {
            ModelAndView model = new ModelAndView("main_page");
            model.addObject("user", user);
            return model;
        }
        else{
            ModelAndView model = new ModelAndView("logowanie");
            return model;

        }
    }


}

