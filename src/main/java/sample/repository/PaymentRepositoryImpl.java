package sample.repository;

import sample.domain.Payment;

import javax.persistence.EntityManager;

public class PaymentRepositoryImpl implements BaseRepository<Payment> {
    
    private EntityManager em;
    
    public PaymentRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public Payment findById(int id) {
        return em.find(Payment.class, id);
    }

    @Override
    public Payment save(Payment object) {
        if((Integer) object.getPaymentId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Payment object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
}
