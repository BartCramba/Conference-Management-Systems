package sample.repository;
import sample.domain.Payment;
import sample.domain.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class PaymentRepositoryImpl implements BaseRepository<Payment> {

    @PersistenceUnit(unitName = "sample")
    private EntityManager em;

    public PaymentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public PaymentRepositoryImpl() {}

    @Override
    public Payment findById(int id) {
        return em.find(Payment.class, id);
    }
    /*
    @Override
    public List<User> getAll() {
        TypedQuery<User> q = em.createQuery("SELECT user from Users user")
    }
    */

    @Override
    public Payment save(Payment object) {
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
    public void delete(Payment object) {
        if (em.contains(object)) {
            em.remove(object);
        } else {
            em.merge(object);
        }
    }


    public Payment getByUsername(String email){
        List<Payment> result = em.createNamedQuery(Payment.PAYMENT, Payment.class)
                .setParameter(Payment.EMAIL, email)
                .getResultList();
        if(result.isEmpty()){
            return new Payment();
        }
        return result.get(0);
    }
}
