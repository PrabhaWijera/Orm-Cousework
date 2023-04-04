package lk.ijse.prabhash.services.custom;

import lk.ijse.prabhash.dto.CustomDTO;
import lk.ijse.prabhash.services.SuperService;

import java.util.ArrayList;

public interface PendingKeyMoneyService extends SuperService {
    ArrayList<CustomDTO> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception;
    boolean updateReservationUsingId(String id, String status) throws Exception;
}
