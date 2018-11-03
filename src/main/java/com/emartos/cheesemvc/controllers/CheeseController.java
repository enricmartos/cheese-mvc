package com.emartos.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
//Every method below will be routed after this root path (prefix)
@RequestMapping("cheese")
public class CheeseController {

    //static make the list accessible for all methods of these class
    static ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model) {
        //The model object is used to pass data to the
        //template

        //Attribute: key-value pair
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        //Just give the template name without extension
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        //RequestParam: Spring looks to a param that has the same name
        //as the argument (cheeseName) and if it finds it inserts there
        //Matches the key value of the name attr of the input tag
        cheeses.add(cheeseName);
        //Redirect to /cheese
        return "redirect:";
    }
}
