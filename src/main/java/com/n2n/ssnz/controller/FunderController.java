/**
 *@author Vishal Kumar
 *@Description To handle all API's related to funder
 */
package com.n2n.ssnz.controller;

import com.n2n.ssnz.entities.Admin;
import com.n2n.ssnz.entities.Funder;
import com.n2n.ssnz.service.FunderService;
import com.n2n.ssnz.util.Message;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funder")
public class FunderController {

    @Autowired
    private FunderService funderService;

    @RequestMapping("/new-funder")
    public ModelAndView newFunderView(HttpSession session, ModelAndView model) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            model.addObject("title", "New Funder");
            model.setViewName("new_funder");
        } else {
            model.setViewName("redirect:/");
        }
        return model;
    }

    @RequestMapping(path = "/add-funder-handler", method = RequestMethod.POST)
    public String addFunderHanlder(@ModelAttribute Funder funder, BindingResult br, HttpSession session) {
        if (funder != null) {
            this.funderService.save(funder);
            Message m = new Message("New funder added successfully!", "success");
            session.setAttribute("message", m);
            return "redirect:/funder/view-all";
        } else {
            return "redirect:/new-funder";
        }
    }

    @RequestMapping("/view-all")
    public ModelAndView viewAllFunder(ModelAndView model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        List<Funder> funders = null;
        if (admin != null) {
            model.addObject("title", "All Funders");
            funders = this.funderService.getAll();
            model.addObject("funders", funders);
            model.setViewName("view_all_funders");
        } else {
            model.setViewName("redirect:/");
        }
        return model;
    }
}
