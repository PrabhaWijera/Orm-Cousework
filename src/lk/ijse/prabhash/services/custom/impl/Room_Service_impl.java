package lk.ijse.prabhash.services.custom.impl;

import lk.ijse.prabhash.dto.Room;
import lk.ijse.prabhash.services.custom.Room_Service;

import java.util.List;

public class Room_Service_impl implements Room_Service {



    @Override
    public boolean saveRoom(Room roomDto) {
        return false;
    }



    @Override
    public Room findByRoomId(String RoomId) {
        return null;
    }

    @Override
    public boolean updateRoom(Room room) {
        return false;
    }

    @Override
    public boolean deleteRoom(String roomId) {
        return false;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }
}
