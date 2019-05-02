package sample.repository;

import sample.domain.ProposalStatus;

import javax.persistence.EntityManager;

public class ProposalStatusRepositoryImpl implements BaseRepository<ProposalStatus>{
    
    private EntityManager em;
    
    public ProposalStatusRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public ProposalStatus findById(int id) {
        return em.find(ProposalStatus.class, id);
    }

    @Override
    public ProposalStatus save(ProposalStatus object) {
        if((Integer) object.getProposalStatusId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(ProposalStatus object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
    
}
