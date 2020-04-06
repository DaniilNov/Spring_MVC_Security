package mvc_hiber.web.controller;


import mvc_hiber.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)

    public ModelAndView printWelcome() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

//    public String printWelcome(ModelMap model) {
//
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = user.getUsername();
//        String password = user.getPassword();
//
//        model.addAttribute("mess", "Hello!");
//        model.addAttribute("name", "username");
//        model.addAttribute("pass", "password");
//        return "hello";
//    }


}
