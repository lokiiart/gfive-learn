package com.springapp.mvc;

import com.springapp.mvc.model.Person;
import com.springapp.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by loki on 3/31/15.
 */
@Controller
@RequestMapping("/persons")
public class PersonController {
    private PersonService personService;

    @Autowired(required=true)
    //TODO 这些注解的意思理解透
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
/*    @ResponseBody
    public List<Person> listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return this.personService.listPersons();
    }*/


    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    @ResponseBody
    public Person addPerson(HttpServletRequest request){
        Map<String, String> fuck = new HashMap<String, String>();
         fuck = (Map<String, String>) request.getAttribute("mydate");
        Person p = new Person();
        p.setModel(fuck.get("model"));
        p.setDevice(fuck.get("device"));
        p.setImei(fuck.get("imei"));
        p.setLongitude(fuck.get("longitude"));
        p.setLatitude(fuck.get("latitude"));



        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }else{
            //existing person, call update
            this.personService.updatePerson(p);
        }


        return p;





        //return req;
    }
//    public String addPerson(@ModelAttribute("person") Person p){
//
//        if(p.getId() == 0){
//            //new person, add it
//            this.personService.addPerson(p);
//        }else{
//            //existing person, call update
//            this.personService.updatePerson(p);
//        }
//
//        return "redirect:/persons/";
//
//    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "redirect:/persons/";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

}
