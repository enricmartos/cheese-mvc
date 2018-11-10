package com.emartos.cheesemvc.controllers;

import com.emartos.cheesemvc.models.Cheese;
import com.emartos.cheesemvc.models.Category;
import com.emartos.cheesemvc.models.data.CategoryDao;
import com.emartos.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
//Every method below will be routed after this root path (prefix)
@RequestMapping("cheese")
public class CheeseController {
    //MVC Pattern rule
    //The controller should not be responsible for managing model objects
    //static make the list accessible for all methods of these class

    //The framework will instantiate this class for us and injects
    //into the controller
    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    CategoryDao categoryDao;

    //Request path: /cheese
    @RequestMapping(value="")
    public String index(Model model) {
        //The model object is used to pass data to the
        //template

        //Attribute: key-value pair
        //Return all the cheeses
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");

        //Just give the template name without extension
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        //The properties of the objects will be used to
        //render the form showing the constraints if they are
        //violated
        //model.addAttribute("cheese", new Cheese());
        //The above and below lines are equivalent
        //The default attribute name will be the name of the class
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }
//
//    @RequestMapping(value="add", method = RequestMethod.POST)
//    public String processAddCheeseForm(@RequestParam String cheeseName,
//                                       @RequestParam String cheeseDescription ) {
//        //RequestParam: Spring looks to a param that has the same name
//        //as the argument (cheeseName) and if it finds it inserts there
//        //Matches the key value of the name attr of the input tag
//        Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
//        CheeseData.add(newCheese);
//        //Redirect to /cheese
//        return "redirect:";
//    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    //When spring sees the @Valid annotation will validate the
    //object according to the constraints on the model class
    //and put all the error inside the object errors
    //The input parameter category will corresponed the a value to the post request
    //(to this controller) to know the category of the new cheese we are creating
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                        Errors errors, @RequestParam int categoryId,
                                        Model model) {
        //We collect the name and description fields from the view
        //and Spring will add them to the model attribute->
        //Bound model object
        /* BEHIND THE SCENES
        Cheese newCheese = new Cheese();
        newCheese.setName(Request.getParameter("name"));
        newCheese.setDescription(Request.getParameter("description"));
         */
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("categories", categoryDao.findAll());
            return "cheese/add";
        }

        Optional<Category> optionalCategory = categoryDao.findById(categoryId);
        Category cat = optionalCategory.get();
        newCheese.setCategory(cat);
        cheeseDao.save(newCheese);
        //Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";

    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] ids) {

        for (int id: ids) {
            cheeseDao.deleteById(id);
        }
        return "redirect:";
    }

    @RequestMapping(value="category", method= RequestMethod.GET)
    public String category(Model model, @RequestParam int id) {

        Optional<Category> optionalCategory = categoryDao.findById(id);
        Category cat = optionalCategory.get();
        List<Cheese> cheeses = cat.getCheeses();
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheeses in Category:" + cat.getName());
        return "cheese/index";
    }




}
