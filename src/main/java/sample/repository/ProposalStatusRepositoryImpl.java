package sample.repository;

import sample.domain.ProposalStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

public class ProposalStatusRepositoryImpl implements BaseRepository<ProposalStatus> {
    @PersistenceUnit(unitName = "sample")
    private EntityManager em;

    public ProposalStatusRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public ProposalStatusRepositoryImpl() {}

    @Override
    public ProposalStatus findById(int id) {
        return null;
    }

    @Override
    public ProposalStatus save(ProposalStatus object) {
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
    public void delete(ProposalStatus object) {

    }
}
