package sample.repository;

import sample.domain.Edition;

import javax.persistence.EntityManager;

public class EditionRepositoryImpl implements BaseRepository<Edition> {
    
    private EntityManager em;
    
    public EditionRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public Edition findById(int id) {
        return em.find(Edition.class, id);
    }

    @Override
    public Edition save(Edition object) {
        if((Integer) object.getEditionId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Edition object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
    
}
