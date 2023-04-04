package lk.ijse.prabhash.services.custom;

import lk.ijse.prabhash.dto.UserDTO;
import lk.ijse.prabhash.services.SuperService;

import java.io.IOException;
import java.util.List;

public interface User_Service extends SuperService {
    List<UserDTO> getAllUsers() throws IOException;

    String generateUserId() throws IOException;

    boolean saveUser(UserDTO userDTO) throws IOException;

    boolean updateUser(UserDTO userDTO) throws IOException;

    boolean deleteUser(String userId) throws IOException;
}
