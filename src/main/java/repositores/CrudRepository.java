package repositores;

public interface CrudRepository <T> {
    void save(T model);
}
