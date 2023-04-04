package lk.ijse.prabhash.dao.custom;


import lk.ijse.prabhash.dao.CrudDAO;
import lk.ijse.prabhash.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    List<Student> getStudentDetailsUsingId(String id) throws Exception;
}
