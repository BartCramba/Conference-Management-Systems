package sample.repository;

import sample.domain.Schedule;

import javax.persistence.EntityManager;

public class ScheduleRepositoryImpl implements BaseRepository<Schedule>{

    private EntityManager em;

    public ScheduleRepositoryImpl(EntityManager e){
        this.em = e;
    }

    @Override
    public Schedule findById(int id) {
        return em.find(Schedule.class, id);
    }

    @Override
    public Schedule save(Schedule object) {
        if((Integer) object.getScheduleId() == null){
            em.persist(object);
        }
        else{
            em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(Schedule object) {
        if(em.contains(object)){
            em.remove(object);
        }
        else{
            em.merge(object);
        }
    }
}
