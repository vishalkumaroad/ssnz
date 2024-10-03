package com.n2n.ssnz.controller;

import com.n2n.ssnz.entities.Admin;
import com.n2n.ssnz.service.AdminService;
import com.n2n.ssnz.service.FunderService;
import com.n2n.ssnz.service.ProjectService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private FunderService funderSerivce;
    
    @Autowired
    private ProjectService ProjectService;

    @RequestMapping({"/", "/login"})
    public ModelAndView loginView(ModelAndView model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            model.setViewName("redirect:/dashboard");
        } else {
            model.addObject("title", "Login");
            model.setViewName("login");
        }
        return model;
    }

    @RequestMapping(path = "/login-handler", method = RequestMethod.POST)
    public ModelAndView loginHandler(@RequestParam("email") String email, @RequestParam("password") String password, ModelAndView model, HttpSession session) {
        Admin admin = this.adminService.getAdminByEmailAndPassword(email, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            model.setViewName("redirect:/dashboard");
        } else {
            model.setViewName("redirect:/login");
        }
        return model;
    }
    
    @RequestMapping("/logout")
    public String logoutHandler(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin!=null){
            session.removeAttribute("admin");
        }
        return "redirect:/";
    }

    @RequestMapping("/dashboard")
    public ModelAndView dashboardView(ModelAndView model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            model.addObject("title", "Dashboard");
            model.addObject("funderCount", this.funderSerivce.getAll().size());
            model.addObject("projectCount", this.ProjectService.getAll().size());
            model.setViewName("dashboard");
        } else {
            model.setViewName("redirect:/");
        }
        return model;
    }
}
