package com.n2n.ssnz.dao;

import com.n2n.ssnz.entities.Funder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FunderDao {

    @Autowired
    private HibernateTemplate template;

    @Transactional
    public void save(Funder funder) {
        this.template.save(funder);
    }
    
    @Transactional
    public List<Funder> getAll(){
        List<Funder> funders = null;
        funders = this.template.loadAll(Funder.class);
        return funders;
    }
    
    
    public Funder get(int id){
        Funder funder = null;
        funder = this.template.get(Funder.class, id);
        return funder;
    }
}
