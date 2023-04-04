package lk.ijse.prabhash.services.custom;

import javafx.collections.ObservableList;
import lk.ijse.prabhash.dto.Room;
import lk.ijse.prabhash.dto.Student;
import lk.ijse.prabhash.services.SuperService;
import lk.ijse.prabhash.view.tm.CartTM;

import java.io.IOException;
import java.util.List;

public interface Registation_Service extends SuperService {
    void Register(ObservableList<CartTM> list, String studentId, String lblId)throws Exception;
    List<Student> getAllStudents() throws IOException;
    List<Room> getAllRooms() throws IOException;
    List<Room> getRoomDetailUsingId(String id) throws Exception;
    List<Student> getStudentDetailUsingId(String id) throws Exception;
    String generateRegistrationId()throws Exception;
}
