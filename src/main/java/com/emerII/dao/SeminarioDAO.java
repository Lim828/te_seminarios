
package com.emerII.dao;
import com.emerII.modelo.Seminario;
import java.util.List;

public interface SeminarioDAO {
    public void insert(Seminario seminario) throws Exception;
    public void update(Seminario seminario) throws Exception;
    public void delete(int id) throws Exception;
    public Seminario getById(int id) throws Exception;
    public List<Seminario> getAll() throws Exception;
}




