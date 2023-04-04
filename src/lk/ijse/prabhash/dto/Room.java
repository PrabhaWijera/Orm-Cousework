package lk.ijse.prabhash.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;
}
