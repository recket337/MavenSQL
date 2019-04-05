package Crud;

import java.sql.Connection;

public interface Body<T> {
    void create(T obj, Connection connection);

    T read(int id, Connection connection);

    void update(T obj, Connection connection);

    void delete(int id, Connection connection);
}
