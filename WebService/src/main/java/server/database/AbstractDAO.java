package server.database;


import java.util.List;

public interface AbstractDAO<T> {
    void create(T data);
    List<String> getRoot();
    List<String> getChildren(T object);



}
