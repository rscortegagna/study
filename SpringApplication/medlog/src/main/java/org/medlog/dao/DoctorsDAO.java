package org.medlog.dao;

import org.medlog.models.Doctors;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DoctorsDAO {
    @PersistenceContext
    private EntityManager manager;

    public void save(Doctors doctors) {
        manager.persist(doctors);
    }

    public List<Doctors> list() {
        return manager.createQuery("select d from Doctors d", Doctors.class).getResultList();
    }

    public Doctors find(Integer id) {
        return manager.createQuery("select distinct(d) from Doctors d join fetch " +
                "d.appointmentPriceList appointmentPriceList where d.id = :id", Doctors.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
