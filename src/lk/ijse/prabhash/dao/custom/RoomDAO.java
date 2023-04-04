package lk.ijse.prabhash.dao.custom;



import lk.ijse.prabhash.dao.CrudDAO;
import lk.ijse.prabhash.entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room,String> {
    List<Room> getRoomDetailUsingId(String id) throws Exception;
}
