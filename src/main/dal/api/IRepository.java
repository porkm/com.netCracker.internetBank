package main.dal.api;
import java.sql.SQLException;
import java.util.List;


public interface IRepository<T>  {
    List<T> getAll() throws SQLException; //список всего
    T get(int id) throws SQLException; //модель по id
    void create(T item) throws SQLException; //создать модель
    void update(T item) throws SQLException; //изменить модель
    void delete(int id) throws SQLException; //удалить модель
    List<T> getForById(int id) throws SQLException; //Получить список для конкретного Клиента

}
