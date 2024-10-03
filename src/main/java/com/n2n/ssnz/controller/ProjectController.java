/**
 *@author Vishal Kumar
 * @Description To handle all API's related to project
 */
package com.n2n.ssnz.controller;

import com.n2n.ssnz.entities.Admin;
import com.n2n.ssnz.entities.Funder;
import com.n2n.ssnz.entities.Project;
import com.n2n.ssnz.service.FunderService;
import com.n2n.ssnz.service.ProjectService;
import com.n2n.ssnz.util.DateFormatter;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private FunderService funderService;

    @RequestMapping("/new-project")
    public String newProjectView(HttpSession session, Model model) {
        String view = "redirect:/";
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            model.addAttribute("title", "New Project");
            List<Funder> allFunders = this.funderService.getAll();
            model.addAttribute("allFunders", allFunders);
            view = "new_project";
        }
        return view;
    }

    @RequestMapping(path = "/add-project", method = RequestMethod.POST)
    public String addProjectHandler(@ModelAttribute Project project, BindingResult br, HttpSession session) {
        if (!br.hasErrors()) {
            this.projectService.save(project);
        } else {
            return "new_project";
        }
        return "all_projects";
    }

    @RequestMapping("/view-all")
    public ModelAndView viewAllProjects(ModelAndView model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        List<Project> projects = null;
        if (admin != null) {
            model.addObject("title", "All Projects");
            projects = this.projectService.getAll();
            model.addObject("projects", projects);
            model.setViewName("view_all_projects");
        } else {
            model.setViewName("redirect:/");
        }
        return model;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        // Custom editor for String -> trim empty strings to null
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text != null && text.trim().isEmpty()) {
                    setValue(null);
                } else {
                    setValue(text);
                }
            }
        });

        binder.registerCustomEditor(int.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text != null && !text.trim().isEmpty()) {
                    try {
                        setValue(Integer.parseInt(text));
                    } catch (NumberFormatException e) {
                        setValue(0);  // Default value if not parsable
                    }
                } else {
                    setValue(0);
                }
            }
        });

        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text != null && !text.trim().isEmpty()) {
                    try {
                        setValue(DateFormatter.getSqlDateFromStr(text));
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid date format. Please use dd-MM-yyyy");
                    }
                } else {
                    setValue(null);
                }
            }
        });
    }
}
