package sample.repository;
import sample.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl implements BaseRepository<User> {

    @PersistenceContext
    private EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public UserRepositoryImpl() {}

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }
    /*
    @Override
    public List<User> getAll() {
        TypedQuery<User> q = em.createQuery("SELECT user from Users user")
    }
    */

    @Override
    public User save(User object) {
        if ((Integer) object.getId() == null) {
            em.persist(object);
        } else {
            object = em.merge(object);
        }
        return object;
    }

    @Override
    public void delete(User object) {
        if (em.contains(object)) {
            em.remove(object);
        } else {
            em.merge(object);
        }
    }
}
