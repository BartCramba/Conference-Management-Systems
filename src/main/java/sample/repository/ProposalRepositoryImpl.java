package sample.repository;


import sample.domain.Proposal;
import sample.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

public class ProposalRepositoryImpl implements BaseRepository<Proposal> {

    @PersistenceUnit(unitName = "sample")
    private EntityManager em;

    public ProposalRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public ProposalRepositoryImpl() {}

    @Override
    public Proposal findById(int id) {
        return em.find(Proposal.class, id);
    }
    /*
    @Override
    public List<User> getAll() {
        TypedQuery<User> q = em.createQuery("SELECT user from Users user")
    }
    */

    @Override
    public Proposal save(Proposal object) {
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
    public void delete(Proposal object) {
        if (em.contains(object)) {
            em.remove(object);
        } else {
            em.merge(object);
        }
    }


    public List<Proposal> getByUser(User userid){
        List<Proposal> result = em.createNamedQuery(Proposal.PROPOSAL, Proposal.class)
                .setParameter(Proposal.USER, userid)
                .getResultList();
        if(result.isEmpty()){
            return new ArrayList<>();
        }
        return result;
    }

    public List<Proposal> findBidings (){
        List<Proposal> result = em.createNamedQuery(Proposal.PROPOSAL_BID, Proposal.class)
                .getResultList();
        if(result.isEmpty()){
            return new ArrayList<>();
        }
        return result;
    }

    public Proposal getByUserOne(User userid){
        List<Proposal> result = em.createNamedQuery(Proposal.PROPOSAL, Proposal.class)
                .setParameter(Proposal.USER, userid)
                .getResultList();
        if(result.isEmpty()){
            return new Proposal();
        }
        return result.get(0);
    }
}

