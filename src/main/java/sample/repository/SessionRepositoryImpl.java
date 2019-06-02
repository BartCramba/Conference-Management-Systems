package sample.repository;

import sample.domain.Edition;
import sample.domain.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class SessionRepositoryImpl  implements BaseRepository<Session> {

    @PersistenceUnit(unitName = "sample")
    private EntityManager em;

    public SessionRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public SessionRepositoryImpl() {}

    @Override
    public Session findById(int id) {
        return em.find(Session.class, id);
    }
    /*
    @Override
    public List<User> getAll() {
        TypedQuery<User> q = em.createQuery("SELECT user from Users user")
    }
    */

    @Override
    public Session save(Session object) {
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
    public void delete(Session object) {
        if (em.contains(object)) {
            em.remove(object);
        } else {
            em.merge(object);
        }
    }


//    public Session getByUsername(String email){
//        List<Edition> result = em.createNamedQuery(Session.EDITION, Session.class)
//                .setParameter(Session.EMAIL, email)
//                .getResultList();
//        if(result.isEmpty()){
//            return new Edition();
//        }
//        return result.get(0);
//    }
}