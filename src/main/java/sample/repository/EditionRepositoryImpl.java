package sample.repository;


import sample.domain.Edition;
import sample.domain.Payment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class EditionRepositoryImpl implements BaseRepository<Edition> {

    @PersistenceUnit(unitName = "sample")
    private EntityManager em;

    public EditionRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public EditionRepositoryImpl() {}

    @Override
    public Edition findById(int id) {
        return em.find(Edition.class, id);
    }
    /*
    @Override
    public List<User> getAll() {
        TypedQuery<User> q = em.createQuery("SELECT user from Users user")
    }
    */

    @Override
    public Edition save(Edition object) {
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }finally{
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return object;
    }

    @Override
    public void delete(Edition object) {
        if (em.contains(object)) {
            em.remove(object);
        } else {
            em.merge(object);
        }
    }


    public Edition getByUsername(String email){
        List<Edition> result = em.createNamedQuery(Edition.EDITION, Edition.class)
                .setParameter(Edition.EMAIL, email)
                .getResultList();
        if(result.isEmpty()){
            return new Edition();
        }
        return result.get(0);
    }
}
