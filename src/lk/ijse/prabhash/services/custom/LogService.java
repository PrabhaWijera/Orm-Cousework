package lk.ijse.prabhash.services.custom;

import lk.ijse.prabhash.dto.UserDTO;
import lk.ijse.prabhash.services.SuperService;

import java.util.List;

public interface LogService extends SuperService {
    List<UserDTO> getUserDetails(String userName, String pwd) throws Exception;
}
