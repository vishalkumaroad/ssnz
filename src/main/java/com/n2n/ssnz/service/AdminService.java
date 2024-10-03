package com.n2n.ssnz.service;

import com.n2n.ssnz.dao.AdminDao;
import com.n2n.ssnz.entities.Admin;
import com.n2n.ssnz.util.StringUtil;
import com.n2n.ssnz.util.ValidatorUtil;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    private static final Logger LOG = Logger.getLogger(AdminService.class.getName());

    public void save(Admin admin) {
        try {
            if (admin != null) {
                admin.setPassword(StringUtil.encodeToMd5(admin.getPassword()));
                this.adminDao.save(admin);
            }
        } catch (Exception e) {
            LOG.info("Exception inside AdminService.save()");
            e.printStackTrace();
        }
    }

    public Admin get(int id) {
        Admin admin = null;
        try {
            if (ValidatorUtil.isNumberPositive(id)) {
                admin = this.adminDao.get(id);
            }
        } catch (Exception e) {
            LOG.info("Exception inside AdminService.get()");
            e.printStackTrace();
        }
        return admin;
    }

    public Admin getAdminByEmailAndPassword(String email, String password) {
        Admin admin = null;
        try {
            admin = this.adminDao.getAdminByEmailAndPassword(email, StringUtil.encodeToMd5(password));
        } catch (Exception e) {
            LOG.info("Exception inside AdminService.getAdminByEmailAndPassword()");
            e.printStackTrace();
        }
        return admin;
    }

}
