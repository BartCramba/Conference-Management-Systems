package sample.repository;

import sample.domain.Session;

import javax.persistence.EntityManager;

public class SessionRepositoryImpl implements BaseRepository<Session> {

    private EntityManager em;
    public SessionRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public Session findById(int id) {
        return em.find(Session.class, id);
    }

    @Override
    public Session save(Session object) {
        if((Integer) object.getSessionId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Session object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
}
