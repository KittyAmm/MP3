package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, path = "/foot")
    public String home(ModelMap model) {
        model.addAttribute("home", "home");
        model.addAttribute("foot", "foot");
        return "index";
    }

}