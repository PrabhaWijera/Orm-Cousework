package lk.ijse.prabhash.dao.custom.impl;

import com.sun.xml.fastinfoset.util.StringArray;
import lk.ijse.prabhash.dao.custom.StudentDAO;
import lk.ijse.prabhash.entity.Student;
import lk.ijse.prabhash.util.FactoryConfiguration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        System.out.println("save");
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Student student) throws Exception {
     Session session=FactoryConfiguration.getInstance().getSession();
     Transaction transaction=session.beginTransaction();
     session.update(student);
     transaction.commit();
     session.close();
     return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
    Session session=FactoryConfiguration.getInstance().getSession();
    Transaction transaction=session.beginTransaction();
    session.detach(id);
    transaction.commit();
    session.close();
        return true;
    }

    @Override
    public String generateId() throws Exception {
      Session session=FactoryConfiguration.getInstance().getSession();
      Transaction transaction=session.beginTransaction();
      List result =session.createSQLQuery("SELECT * FROM student ORDER BY  student_id DESC  LIMIT 1").addEntity(Student.class).getResultList();
      transaction.commit();
      session.close();
      return result.size()==0?"S000":((Student)result.get(0)).getStudent_id();
    }

    @Override
    public List<Student> getAll() throws IOException {
    return null;
    }

    @Override
    public List<Student> getStudentDetailsUsingId(String id) throws Exception {
       return null;
    }
}
