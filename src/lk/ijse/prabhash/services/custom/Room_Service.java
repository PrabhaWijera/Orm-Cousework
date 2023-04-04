package lk.ijse.prabhash.services.custom;

import lk.ijse.prabhash.dto.Room;
import lk.ijse.prabhash.services.SuperService;

import java.util.List;

public interface Room_Service extends SuperService {
    public boolean saveRoom(Room roomDto) throws Exception ;

    public Room findByRoomId(String RoomId) throws Exception;

    boolean updateRoom(Room room);

    boolean deleteRoom(String roomId);

    List<Room> getAllRooms();
}
