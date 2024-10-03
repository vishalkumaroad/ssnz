package com.n2n.ssnz.dao;

import com.n2n.ssnz.entities.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProjectDao {

    @Autowired
    private HibernateTemplate template;

    @Transactional
    public void save(Project project) {
        this.template.save(project);
    }
    
    @Transactional
    public List<Project> getAll(){
        List<Project> projects = null;
        projects = this.template.loadAll(Project.class);
        return projects;
    }
}
