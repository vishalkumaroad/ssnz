package com.n2n.ssnz.service;

import com.n2n.ssnz.dao.ProjectDao;
import com.n2n.ssnz.entities.Funder;
import com.n2n.ssnz.entities.Project;
import com.n2n.ssnz.util.ValidatorUtil;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private static final Logger LOG = Logger.getLogger(ProjectService.class.getName());

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private FunderService funderService;

    public void save(Project project) {
        try {
            if (project != null) {
                if (ValidatorUtil.isNumberPositive(project.getFunder().getFunderId())) {
                    Funder funder = this.funderService.get(project.getFunder().getFunderId());
                    if (funder != null) {
                        project.setFunder(funder);
                    }
                }
                this.projectDao.save(project);
            }
        } catch (Exception e) {
            LOG.info("Exception inside ProjectService.save()");
            e.printStackTrace();
        }
    }

    public List<Project> getAll() {
        List<Project> projects = null;
        try {
            projects = this.projectDao.getAll();
        } catch (Exception e) {
            LOG.info("Exception inside ProjectService.getAll()");
            e.printStackTrace();
        }
        return projects;
    }
}
