package lk.ijse.prabhash.services.custom.impl;

import lk.ijse.prabhash.dao.DaoFactory;
import lk.ijse.prabhash.dao.DaoTypes;
import lk.ijse.prabhash.dao.custom.UserDAO;
import lk.ijse.prabhash.dto.UserDTO;
import lk.ijse.prabhash.entity.User;
import lk.ijse.prabhash.services.custom.LogService;

import java.util.ArrayList;
import java.util.List;

public class LogServiceimpl implements LogService {
    private final UserDAO userDAO= (UserDAO) DaoFactory.getInstance().getDAO(DaoTypes.USER);
    @Override
    public List<UserDTO> getUserDetails(String userName, String pwd) throws Exception {
        List<User>list=userDAO.getUserDetails(userName,pwd);
        List<UserDTO>userDTOS=new ArrayList<>();
        for (User user:list){
            userDTOS.add(new UserDTO(user.getUserId(),user.getUserName(),user.getTelNo(),user.getEmail(),user.getUserName(),user.getPassword()));
        }
        return userDTOS;
    }
}
