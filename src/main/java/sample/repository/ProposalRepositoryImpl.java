package sample.repository;

import sample.domain.Proposal;

import javax.persistence.EntityManager;

public class ProposalRepositoryImpl implements BaseRepository<Proposal>{
    
    private EntityManager em;
    
    public ProposalRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public Proposal findById(int id) {
        return em.find(Proposal.class, id);
    }

    @Override
    public Proposal save(Proposal object) {
        if((Integer) object.getProposalId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Proposal object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
}
