package com.springapp.mvc;

import com.springapp.mvc.model.Gps;
import com.springapp.mvc.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by loki on 3/31/15.
 */
@Controller
@RequestMapping("/gpss")
public class GpsController {
    private GpsService gpsService;

    @Autowired(required = true)
    @Qualifier(value = "gpsService")
    public void setGpsService(GpsService gs){this.gpsService = gs;}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listGpss(Model model){
        model.addAttribute("gps", new Gps());
        model.addAttribute("listGpss",this.gpsService.listGpss());
        return "gps";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGps(@ModelAttribute("gps") Gps g){
       if(g.getId() == 0) {
           this.gpsService.addGps(g);
       }else {
           this.gpsService.updateGps(g);
       }
        return "redirect:/gpss/";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeGps(@PathVariable("id") int id){
        this.gpsService.removeGps(id);
        return "redirect:/gsss/";
    }

    @RequestMapping("/edit/{id}")
    public String editGps(@PathVariable("id") int id, Model model){
        model.addAttribute("gps", this.gpsService.getGpsById((id)));
        model.addAttribute("listGpss", this.gpsService.listGpss());
        return "gps";
    }
}
