package lk.ijse.prabhash.dao.custom;


import lk.ijse.prabhash.dao.CrudDAO;
import lk.ijse.prabhash.entity.Reservation;

public interface RegistrationDAO extends CrudDAO<Reservation,String> {
    boolean updateUsingId(String id,String status) throws Exception;
}
