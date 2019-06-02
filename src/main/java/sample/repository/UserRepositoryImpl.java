package sample.repository;
import sample.domain.Payment;
import sample.domain.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements BaseRepository<User> {

    @PersistenceUnit(unitName = "sample")
    private EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public UserRepositoryImpl() {}

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }
    /*
    @Override
    public List<User> getAll() {
        TypedQuery<User> q = em.createQuery("SELECT user from Users user")
    }
    */

    @Override
    public User save(User object) {
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
    public void delete(User object) {
        if (em.contains(object)) {
            em.remove(object);
        } else {
            em.merge(object);
        }
    }

    public User getByUsername(String email, String password){
        List<User> result = em.createNamedQuery(User.USER_LOGIN, User.class)
                .setParameter(User.EMAIL, email)
                .setParameter(User.PASSWORD,password)
                .getResultList();
        if(result.isEmpty()){
            return new User();
        }
        return result.get(0);
    }

    public User getByEmail(String email){
        List<User> result = em.createNamedQuery(User.USER_EMAIL, User.class)
                .setParameter(User.EMAIL, email)
                .getResultList();
        if(result.isEmpty()){
            return new User();
        }
        return result.get(0);
    }


}
