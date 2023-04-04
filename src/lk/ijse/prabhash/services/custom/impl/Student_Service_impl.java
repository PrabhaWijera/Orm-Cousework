package lk.ijse.prabhash.services.custom.impl;



import lk.ijse.prabhash.dao.DaoFactory;
import lk.ijse.prabhash.dao.DaoTypes;
import lk.ijse.prabhash.dao.custom.StudentDAO;
import lk.ijse.prabhash.dto.Student;
import lk.ijse.prabhash.services.custom.Student_Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Student_Service_impl implements Student_Service {

    private final StudentDAO studentDAO= (StudentDAO) DaoFactory.getInstance().getDAO(DaoTypes.STUDENT);

    @Override
    public List<Student> getAllStudents() throws IOException {
        return null;
    }

    @Override
    public String generateStudentId() throws Exception {
         String id=studentDAO.generateId();
         return id;
    }

    @Override
    public boolean saveStudent(Student student) throws Exception {
        return studentDAO.save(new lk.ijse.prabhash.entity.Student(student.getStudent_id(),student.getName(),student.getAddress(),student.getContact_no(),student.getDob(),student.getGender()));
    }


    @Override
    public boolean updateStudent(Student student) throws Exception {
        return studentDAO.update(new lk.ijse.prabhash.entity.Student(student.getStudent_id(),student.getName(),student.getAddress(),student.getContact_no(),student.getDob(),student.getGender()));

    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

}
