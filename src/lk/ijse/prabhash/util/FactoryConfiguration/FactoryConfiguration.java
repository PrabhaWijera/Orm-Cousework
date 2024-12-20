package lk.ijse.prabhash.util.FactoryConfiguration;

import lk.ijse.prabhash.entity.Reservation;
import lk.ijse.prabhash.entity.Room;
import lk.ijse.prabhash.entity.Student;
import lk.ijse.prabhash.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration config = new Configuration().
                addAnnotatedClass(User.class).
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Reservation.class).
                addAnnotatedClass(Room.class);
        sessionFactory = config.buildSessionFactory();

    }
    public static FactoryConfiguration getInstance(){
        return factoryConfiguration==null?factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
