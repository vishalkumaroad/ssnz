package com.n2n.ssnz.service;

import com.n2n.ssnz.dao.FunderDao;
import com.n2n.ssnz.entities.Funder;
import com.n2n.ssnz.util.ValidatorUtil;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunderService {

    private static final Logger LOG = Logger.getLogger(FunderService.class.getName());

    @Autowired
    private FunderDao funderDao;

    public void save(Funder funder) {
        try {
            if (funder != null) {
                this.funderDao.save(funder);
            }
        } catch (Exception e) {
            LOG.info("Exception inside FunderService.save()");
            e.printStackTrace();
        }
    }

    public List<Funder> getAll() {
        List<Funder> funders = null;
        try {
            funders = this.funderDao.getAll();
        } catch (Exception e) {
            LOG.info("Exception inside FunderService.getAll()");
            e.printStackTrace();
        }
        return funders;
    }

    public Funder get(int id) {
        Funder funder = null;
        try {
            if (ValidatorUtil.isNumberPositive(id)) {
                funder = this.funderDao.get(id);
            }
        } catch (Exception e) {
            LOG.info("Exception inside FunderService.get()");
            e.printStackTrace();
        }
        return funder;
    }
}
