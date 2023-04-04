package lk.ijse.prabhash.dao;


import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <Entity,ID>extends SuperDAO{
    boolean save(Entity entity) throws Exception;

    boolean update(Entity entity) throws Exception;

    boolean delete(ID id) throws Exception;

    List<Entity> getAll() throws IOException;

    String generateId() throws Exception;


}
