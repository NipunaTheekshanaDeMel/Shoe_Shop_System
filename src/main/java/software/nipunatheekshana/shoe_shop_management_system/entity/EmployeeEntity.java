package software.nipunatheekshana.shoe_shop_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Gender;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Role;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
@Entity
public class EmployeeEntity implements SuperEntity{
    @Id
    private String employeeId;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String civilState;
    private String designation;
    private Date dob;
    private Date joinedDate;
    private String address;
    private String contact;
    private String email;
    private String guardian;
    private String emergencyContact;
    @Enumerated(EnumType.STRING)
    private Role accessRole;
}