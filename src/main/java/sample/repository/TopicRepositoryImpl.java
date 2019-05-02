package sample.repository;

import sample.domain.Topic;

import javax.persistence.EntityManager;

public class TopicRepositoryImpl implements BaseRepository<Topic> {
    private EntityManager em;


    public TopicRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Topic findById(int id) {
        return em.find(Topic.class, id);
    }

    @Override
    public Topic save(Topic object) {
        if((Integer) object.getTopicId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Topic object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
}
