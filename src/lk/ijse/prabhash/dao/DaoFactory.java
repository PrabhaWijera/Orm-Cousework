package lk.ijse.prabhash.dao;


import lk.ijse.prabhash.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.prabhash.dao.custom.impl.RoomDAOImpl;
import lk.ijse.prabhash.dao.custom.impl.StudentDAOImpl;
import lk.ijse.prabhash.dao.custom.impl.UserDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getInstance(){
        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }

    public SuperDAO getDAO(DaoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case REGISTRATION:
                return  new RegistrationDAOImpl();
            case QUERYDAO:
            /*    return new QueryDAOImpl();*/
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
