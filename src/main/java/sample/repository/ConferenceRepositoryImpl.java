package sample.repository;

import sample.domain.Conference;

import javax.persistence.EntityManager;

public class ConferenceRepositoryImpl implements BaseRepository<Conference> {
    
    private EntityManager em;
    
    public ConferenceRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public Conference findById(int id) {
        return em.find(Conference.class, id);
    }

    @Override
    public Conference save(Conference object) {
        if((Integer) object.getConferenceId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Conference object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
}

