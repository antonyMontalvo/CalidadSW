package unmsm.edu.pe.calidadsw.dao;

/**
 * IGlobal
 */
public interface IGlobal<T, K> {
    boolean create(T t);

    boolean delete(K id);
    
    T read();
    
    T read(K id);
    
    boolean update(T t);
}