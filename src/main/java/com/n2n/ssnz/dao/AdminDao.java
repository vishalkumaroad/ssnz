/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.n2n.ssnz.dao;

import com.n2n.ssnz.entities.Admin;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDao {

    @Autowired
    private HibernateTemplate template;

    @Transactional
    public void save(Admin admin) {
        this.template.save(admin);
    }

    public Admin get(int id) {
        return this.template.get(Admin.class, id);
    }

    @Transactional
    public Admin getAdminByEmailAndPassword(String email, String password) {
        Admin admin = null;
        Session session = this.template.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Admin.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        admin = (Admin) criteria.uniqueResult();
        return admin;
    }
}
