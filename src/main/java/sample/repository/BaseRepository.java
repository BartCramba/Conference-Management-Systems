package sample.repository;


import java.util.List;

public interface BaseRepository<T>{

    T findById(int id);
    //List<T> getAll();
    T save(T object);
    void delete(T object);
}
