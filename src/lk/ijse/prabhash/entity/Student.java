package lk.ijse.prabhash.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String student_id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contact_no;

    @Column
    private String gender;




    public Student(String student_id, String name, String address, String contact_no,  String gender) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;

        this.gender = gender;
    }



    @OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL)
    private List<Reservation>reservationList=new ArrayList<>();



}
