package lk.ijse.prabhash.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;
}
