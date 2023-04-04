package lk.ijse.prabhash.dao.custom;


import lk.ijse.prabhash.dao.CrudDAO;
import lk.ijse.prabhash.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User> getUserDetails(String userName, String pwd) throws Exception;
}
