package mvc_hiber.web.controller;


import mvc_hiber.model.User;
import mvc_hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView ListUsers() {
        List<User> users = userService.listUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("listUsers", users);
        return modelAndView;
    }


    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.updateUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.addUser(user);
        return modelAndView;
    }

    //    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public ModelAndView registrationPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ModelAndView registrationUser(@ModelAttribute("user") User user, BindingResult result) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/hello");
//        userService.addUser(user);
//        return modelAndView;
//    }

//    @RequestMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") int id, Model model ){
//
//        model.addAttribute("user",userService.getUserById(id));
//        model.addAttribute("listUsers",userService.listUsers());
//        return "users";
//    }
//@RequestMapping(value = "/users/add", method = RequestMethod.POST)
//public String addUser(@ModelAttribute("user") User user) {
//    if (user.getId() == 0) {
//        userService.addUser(user);
//    } else {
//        userService.updateUser(user);
//    }
//    return "redirect:/users";
//}


}
