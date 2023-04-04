package lk.ijse.prabhash.services.custom;

import lk.ijse.prabhash.dto.Student;
import lk.ijse.prabhash.services.SuperService;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Student_Service extends SuperService {

        List<Student> getAllStudents() throws IOException;

        String generateStudentId() throws Exception;

        boolean saveStudent(Student student) throws IOException, Exception;

        boolean updateStudent(Student student) throws Exception;

        boolean deleteStudent(String studentId) throws Exception;
}
